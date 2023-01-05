package kr.codesquad;


import kr.codesquad.LottoManager.LottoGenerator;
import kr.codesquad.LottoManager.LottoJackpotManager;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;

import static kr.codesquad.Enum.Lotto_Info.LOTTO_PRICE;

public class Main {
    public static int money, cnt;

    // todo list 1
    public static int retLottoCnt(int money) {
        return money / LOTTO_PRICE.getValue();
    }

    public static void buyLottoByMoney() throws CustomException {
        InputHandler inputHandler = new InputHandler();
        System.out.println("구입 금액을 입력해 주세요.");
        money = inputHandler.getIntegerInput();
        if (money % 1000 != 0) {
            throw new CustomException("천원 단위로 입력해 주세요!!");
        }
        cnt = retLottoCnt(money);
        System.out.printf("%d개를 구매했습니다.\n", cnt);
    }

    public static void main(String[] args) throws CustomException {
        //Jackpot_Handler jh = new Jackpot_Handler();
        Utility ut = new Utility();
//        //1. 로또를 구매한다.
//        buyLottoByMoney();
//        //2. 로또를 돈만큼 구매하고, 수동 자동을 입력한다.
//        GenerateMyLottoByCount gm = new GenerateMyLottoByCount(cnt);
//        gm.generateMyself();
//        gm.generateAuto();
//        //3. 당첨 번호와 보너스 번호를 입력한다.
//        jh.setJackpotNum();
//        jh.setBonusNum();
//        //4. 당첨을 확인한다.
//        jh.searchJackpotsInMyLottoList(gm);
//        ut.printProfit(jh.PRIZE_CNT, money)
        UserInput userInput = new UserInput();
        UserLotto userLotto = new UserLotto(userInput.userHowManyLotto());

        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.manualGenerate(userLotto);
        lottoGenerator.autoGenerate(userLotto);

        LottoJackpotManager lottoJackpotManager = new LottoJackpotManager();
        lottoJackpotManager.setJACKPOT_NUM();
        lottoJackpotManager.setBONUS_NUM();
        lottoJackpotManager.checkAllUserLottoPrize(userLotto);

        ut.printProfit(userLotto.getPrizeResults(),userLotto.getUserAllLottoCount()*1000);
    }
}
