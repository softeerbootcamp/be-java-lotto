package kr.codesquad.controller;

import kr.codesquad.generator.AutoGenerator;
import kr.codesquad.generator.SudongGenerator;
import kr.codesquad.exception.InputRangeException;
import kr.codesquad.model.UserInfo;
import kr.codesquad.model.lottos.ResultLotto;
import kr.codesquad.model.lottos.Lotto;
import kr.codesquad.view.UserConsoleHandler;

public class LottoController {

    private UserInfo user;
    private AutoGenerator autoGenerator;
    private SudongGenerator sudongGenerator;
    private UserConsoleHandler userConsoleHandler;
    private Lotto randomLotto = new Lotto();
    private Lotto myLotto = new Lotto();
    private ResultLotto resultLotto = new ResultLotto();
    private MatchController matchController = new MatchController();


    public LottoController(UserInfo userInfo) {
        this.user = userInfo;
        this.userConsoleHandler = new UserConsoleHandler(user);
        this.sudongGenerator = new SudongGenerator(userConsoleHandler);
        this.autoGenerator = new AutoGenerator();
    }

    public void start(){
        //로또 구매
        purchaseLotto();
        //로또 번호 생성
        generateLottos();
        //결과 번호 생성
        generateResults();
        //당첨 여부 조회
        calculateMatch();
        //결과 출력
        printResult();
    }

    //로또 구매 로직 (구매 금액 + 수동 구매 로또 개수 입력)
    public void purchaseLotto(){
        int purchasedPrice = userConsoleHandler.enterPurchasePrice();
        int numOfLottoSudong = buyByHand(purchasedPrice);
        int numOfLottoAuto = (purchasedPrice / 1000) - numOfLottoSudong;
        user.insertInfos(purchasedPrice, numOfLottoAuto, numOfLottoSudong);
    }

    //수동 로또 구매 개수 입력 로직
    public int buyByHand(int purchasedPrice){
        int numOfLottoSudong = 0;
        try{
            numOfLottoSudong = userConsoleHandler.enterSudongLottoNumber(purchasedPrice / 1000);
        }catch (InputRangeException e){
            System.out.println(e.getMessage());
            return buyByHand(purchasedPrice);
        }
        return numOfLottoSudong;
    }


    //로또 생성 로직 (자동 + 수동)
    public void generateLottos(){
        int sudong = user.getNumOfLottoSudong();
        int jadong = user.getNumOfLottoAuto();
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다\n", jadong, sudong);
        //자동 로또 생성
        for(int i = 0 ; i < jadong; i++)
            randomLotto.addLotto(autoGenerator.generateLotto());
        //수동 로또 생성
        sudongGenerator.setType(1);  //generator를 수동으로 변경
        for(int i = 0; i < sudong; i++)
            myLotto.addLotto(sudongGenerator.generateLotto());
    }

    //당첨 번호 생성
    public void generateResults(){
        sudongGenerator.setType(2);   //generator를 자동으로 변경
        resultLotto.addLotto(sudongGenerator.generateLotto());
        resultLotto.setBonusNum(userConsoleHandler.enterBonusNum());
    }

    //당첨 여부 조회
    public void calculateMatch(){
        matchController.startCalculate(randomLotto, myLotto, resultLotto);
    }

    //결과 출력
    public void printResult(){
        matchController.printResult(user.getPurchasedPrice());
    }
}
