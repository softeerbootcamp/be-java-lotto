package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;

import java.util.List;

public class LottoJackpotManagerImpl implements LottoJackpotManager {
    private final List<Integer> JACKPOT_NUM;
    private final int BONUS_NUM;

    public LottoJackpotManagerImpl(List<Integer> jackpotNum,int bonusNum) throws CustomException {
        JACKPOT_NUM = jackpotNum;
        BONUS_NUM = bonusNum;
        if (JACKPOT_NUM.contains(bonusNum)) {
            throw new CustomException("보너스 번호는 원래 번호들과 중복돠어선 안된다.");
        }
    }


    @Override
    public boolean checkNumberIsContained(List<Integer> userOneLotto, int number) {
        if (userOneLotto.contains(number)) {
            return true;
        } else return false;
    }

    @Override
    public int addIndexIfChecked(List<Integer> userOneLotto, int number, int index) {
        if (checkNumberIsContained(userOneLotto, number)) {
            return ++index;
        } else return index;
    }

    @Override
    public void checkAllUserLottoPrize(UserLotto userLotto) {
        for (EmptyLotto eachLotto : userLotto.getUserLottoList()) {
            checkEachLottoPrize(eachLotto.getNumbers(), userLotto);
        }
    }

    @Override
    public void checkEachLottoPrize(List<Integer> userOneLotto, UserLotto userLotto) {
        int index = 0;
        for (int oneNumber : JACKPOT_NUM) {
            index = addIndexIfChecked(userOneLotto, oneNumber, index);
        }
        if (index == 6) {
            userLotto.addPrizeResultsByIndex(index - 2);
        } else if (index == 5 && checkNumberIsContained(userOneLotto, BONUS_NUM)) {
            userLotto.addPrizeResultsByIndex(index - 2);
        } else if (index >= 3) {
            userLotto.addPrizeResultsByIndex(index - 3);
        }
    }

}
