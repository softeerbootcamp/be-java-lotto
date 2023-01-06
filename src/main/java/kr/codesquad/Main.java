package kr.codesquad;


import kr.codesquad.lottoManager.LottoGenerator;
import kr.codesquad.lottoManager.LottoGeneratorImpl;
import kr.codesquad.lottoManager.LottoJackpotManager;
import kr.codesquad.lottoManager.LottoJackpotManagerImpl;
import kr.codesquad.user.UserInput;
import kr.codesquad.user.UserLotto;
import kr.codesquad.utility.Utility;

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
