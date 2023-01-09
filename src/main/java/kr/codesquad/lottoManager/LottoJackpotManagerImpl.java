package kr.codesquad.lottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.user.UserLotto;

import java.util.List;

public class LottoJackpotManagerImpl implements LottoJackpotManager {
    private final List<Integer> JACKPOT_NUM;
    private final int BONUS_NUM;
    CustomException customException = new CustomException();
    public LottoJackpotManagerImpl(List<Integer> jackpotNum,int bonusNum){
        JACKPOT_NUM = jackpotNum;
        BONUS_NUM = bonusNum;
        customException.checkBonusNumIsDuplicate(bonusNum,jackpotNum);
    }


    @Override
    public boolean checkNumberIsContained(List<Integer> userOneLotto, int number) {
        if (userOneLotto.contains(number)) {
            return true;
        } return false;
    }

    @Override
    public int addIndexIfChecked(List<Integer> userOneLotto, int number, int index) {
        if (checkNumberIsContained(userOneLotto, number)) {
            return ++index;
        } return index;
    }

    @Override
    public void checkAllUserLottoPrize(UserLotto userLotto) {
        for (LottoPaper eachLotto : userLotto.getUserLottoList()) {
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
