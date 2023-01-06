package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;

import java.util.List;

public interface LottoJackpotManager {
    void setJACKPOT_NUM() throws CustomException;

    void setBONUS_NUM() throws CustomException;

    boolean checkNumberIsContained(List<Integer> userOneLotto, int number);

    int addIndexIfChecked(List<Integer> userOneLotto, int number, int index);

    void checkAllUserLottoPrize(UserLotto userLotto);

    void checkEachLottoPrize(List<Integer> userOneLotto, UserLotto userLotto);

    void runJackpot(UserLotto userLotto) throws CustomException;
}
