package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;

import java.util.List;

public class LottoJackpotManager extends UserInput {
    private static List<Integer> JACKPOT_NUM;
    private static int BONUS_NUM;

    public void setJACKPOT_NUM(List<Integer> JACKPOT_NUM) throws CustomException {
        this.JACKPOT_NUM = userInputJackpotNum();
    }

    public void setBONUS_NUM() throws CustomException {
        this.BONUS_NUM = userSetBonusNum(this.JACKPOT_NUM);
    }

    public boolean checkNumberIsContained(List<Integer> userOneLotto, int number) {
        if (userOneLotto.contains(number)) {
            return true;
        } else return false;
    }
    public int addIndexIfchecked(List<Integer> userOneLotto,int number,int index){
        if(checkNumberIsContained(userOneLotto,number)){
            return index++;
        }else return index;
    }
    public void checkAllUserLottoPrize(UserLotto userLotto){
        for (EmptyLotto eachLotto:userLotto.getUserLottoList()) {
            checkEachLottoPrize(eachLotto.getNumbers(),userLotto);
        }
    }
    // prize 가 user lotto 내부에 있어서 어쩔수 없이 매개변수 2개 사용됬는데, 개선하고 싶음.
    public void checkEachLottoPrize(List<Integer> userOneLotto,UserLotto userLotto) {
        int index = 0;
        for (int oneNumber : userOneLotto) {
            index=addIndexIfchecked(userOneLotto,oneNumber,index);
        }
        if(index==6){
            userLotto.addPrizeResultsByIndex(index-2);
        }else if(index==5 && checkNumberIsContained(userOneLotto,BONUS_NUM)){
            userLotto.addPrizeResultsByIndex(index-2);
        } else if (index>=3) {
            userLotto.addPrizeResultsByIndex(index-3);
        }
    }
}
