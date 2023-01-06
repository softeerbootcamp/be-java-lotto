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
            EmptyLotto emptyLotto = new EmptyLotto(utility.retRandLottoNum());
            userLotto.getUserLottoList().add(emptyLotto);
        }
    }

    public void manualGenerate(UserLotto userLotto) throws CustomException {
        userLotto.setUserManualLottoCount();
        UserInput.USERINPUT.userInputManual(userLotto);
    }

    @Override
    public void lottoGenerate(UserLotto userLotto) throws CustomException {
        manualGenerate(userLotto);
        autoGenerate(userLotto);
        userLotto.printUserLotto();
    }
}
