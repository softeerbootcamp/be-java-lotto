package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;

import java.util.List;

public class LottoJackpotManagerImpl implements LottoJackpotManager {
    static List<Integer> JACKPOT_NUM;
    static int BONUS_NUM;

    @Override
    public void setJACKPOT_NUM() throws CustomException {
        this.JACKPOT_NUM = UserInput.USERINPUT.userInputJackpotNum();
    }

    @Override
    public void setBONUS_NUM() throws CustomException {
        this.BONUS_NUM = UserInput.USERINPUT.userSetBonusNum(this.JACKPOT_NUM);
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

    @Override
    public void runJackpot(UserLotto userLotto) throws CustomException {
        LottoJackpotManager lottoJackpotManager = new LottoJackpotManagerImpl();
        lottoJackpotManager.setJACKPOT_NUM();
        lottoJackpotManager.setBONUS_NUM();
        lottoJackpotManager.checkAllUserLottoPrize(userLotto);
    }
}
