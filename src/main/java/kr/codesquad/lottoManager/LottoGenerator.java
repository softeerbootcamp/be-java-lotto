package kr.codesquad.lottoManager;

import kr.codesquad.user.UserLotto;

public interface LottoGenerator {
    public void autoGenerate(UserLotto userLotto);

    public void manualGenerate(UserLotto userLotto);

    public void lottoGenerate(UserLotto userLotto);
}
