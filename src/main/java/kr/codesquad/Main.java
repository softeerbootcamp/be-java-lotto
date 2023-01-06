package kr.codesquad;


import kr.codesquad.LottoManager.LottoGenerator;
import kr.codesquad.LottoManager.LottoJackpotManager;
import kr.codesquad.LottoManager.LottoJackpotManagerImpl;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility.Utility;

public class Main {
    public static void lottoGenerate(UserLotto userLotto) throws CustomException {
        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.manualGenerate(userLotto);
        lottoGenerator.autoGenerate(userLotto);
        userLotto.printUserLotto();
    }


    // throws 하려면 new throw 받아주는거 있어야됨. main에는 없는게 맞다.
    public static void main(String[] args) throws CustomException {
        Utility ut = new Utility();
        UserInput userInput = new UserInput();
        UserLotto userLotto = new UserLotto(userInput.userHowManyLotto());

        Main.lottoGenerate(userLotto);

        LottoJackpotManager lottoJackpotManager = new LottoJackpotManagerImpl();
        lottoJackpotManager.runJackpot(userLotto);

        ut.printProfit(userLotto.getPrizeResults(), userLotto.getUserAllLottoCount() * ut.getLottoPrice());
    }
}
