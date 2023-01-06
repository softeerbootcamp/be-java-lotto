package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility.Utility;

public class LottoGeneratorImpl implements LottoGenerator {
    private Utility utility;

    @Override
    public void autoGenerate(UserLotto userLotto) {
        utility = new Utility();
        for (int i = 0; i < userLotto.getUserAllLottoCount() - userLotto.getUserManualLottoCount(); i++) {
            LottoPaper emptyLotto = new LottoPaper(utility.retRandLottoNum());
            userLotto.getUserLottoList().add(emptyLotto);
        }
    }

    public void manualGenerate(UserLotto userLotto) {
        userLotto.setUserManualLottoCount();
        UserInput.USERINPUT.userInputManual(userLotto);
    }

    @Override
    public void lottoGenerate(UserLotto userLotto) {
        manualGenerate(userLotto);
        autoGenerate(userLotto);
        userLotto.printUserLotto();
    }
}
