package kr.codesquad.lottoManager;

import kr.codesquad.user.UserLotto;

import java.util.List;

public interface LottoJackpotManager {


    boolean checkNumberIsContained(List<Integer> userOneLotto, int number);

    int addIndexIfChecked(List<Integer> userOneLotto, int number, int index);

    void checkAllUserLottoPrize(UserLotto userLotto);

    void checkEachLottoPrize(List<Integer> userOneLotto, UserLotto userLotto);

}
