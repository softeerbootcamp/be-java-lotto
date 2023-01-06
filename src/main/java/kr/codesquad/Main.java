package kr.codesquad;


import kr.codesquad.LottoManager.LottoGenerator;
import kr.codesquad.LottoManager.LottoGeneratorImpl;
import kr.codesquad.LottoManager.LottoJackpotManager;
import kr.codesquad.LottoManager.LottoJackpotManagerImpl;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility.Utility;

public class Main {

    public static void main(String[] args) {
        Utility ut = new Utility();
        UserLotto userLotto = new UserLotto(UserInput.USERINPUT.userHowManyLotto());

        LottoGenerator lottoGenerator = new LottoGeneratorImpl();
        lottoGenerator.lottoGenerate(userLotto);

        LottoJackpotManager lottoJackpotManager = new LottoJackpotManagerImpl(
                UserInput.USERINPUT.userInputJackpotNum(),
                UserInput.USERINPUT.userSetBonusNum());
        lottoJackpotManager.checkAllUserLottoPrize(userLotto);

        ut.printProfit(userLotto.getPrizeResults(), userLotto.getUserAllLottoCount() * ut.getLottoPrice());
    }
}
