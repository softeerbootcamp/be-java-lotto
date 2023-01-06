package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.Utility.InputHandler;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility.Utility;

public interface LottoGenerator {
    public void autoGenerate(UserLotto userLotto);

    public void manualGenerate(UserLotto userLotto) throws CustomException;

    public void lottoGenerate(UserLotto userLotto) throws CustomException;
}
