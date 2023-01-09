package kr.codesquad;

import java.util.List;

public class CustomException {
    public CustomException() {

    }
    public void numberCountSix(String[] userInputString){
        if (userInputString.length !=6){
            throw new RuntimeException("당첨 번호는 6개입니다! 6개를 입력해주세요");
        }
    }
    public void checkBonusNumIsDuplicate(int bonusNum, List<Integer> jackpotNum){
        if (jackpotNum.contains(bonusNum)) {
            throw new RuntimeException("보너스 번호는 원래 번호들과 중복돠어선 안됩니다.");
        }
    }
}
