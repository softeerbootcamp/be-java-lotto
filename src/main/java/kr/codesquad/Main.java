package kr.codesquad;


import kr.codesquad.Enum.Lotto_Info;
import kr.codesquad.LottoManager.LottoGenerator;
import kr.codesquad.LottoManager.LottoJackpotManager;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility.Utility;

public class Main {

    public static void main(String[] args) throws CustomException {
        Utility ut = new Utility();
        UserInput userInput = new UserInput();
        UserLotto userLotto = new UserLotto(userInput.userHowManyLotto());

        LottoGenerator lottoGenerator = new LottoGenerator();
        lottoGenerator.manualGenerate(userLotto);
        lottoGenerator.autoGenerate(userLotto);
        userLotto.printUserLotto();

        LottoJackpotManager lottoJackpotManager = new LottoJackpotManager();
        lottoJackpotManager.setJACKPOT_NUM();
        lottoJackpotManager.setBONUS_NUM();
        lottoJackpotManager.checkAllUserLottoPrize(userLotto);
        ut.printProfit(userLotto.getPrizeResults(), userLotto.getUserAllLottoCount() * Lotto_Info.LOTTO_PRICE.getValue());
    }
}
