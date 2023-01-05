package kr.codesquad;

import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;
import kr.codesquad.utils.Utility;

import java.util.*;


public class UserLotto extends BaseLotto{

    private int bonusBall; //보너스 볼
    private UserConsole userConsole;

    public UserLotto(UserConsole userConsole) {
        this.lottoList=new ArrayList<>();
        this.userConsole = userConsole;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        for(int i=0;i<this.lottoCnt;i++){
            ArrayList<Integer> manualLotto = getManualLotto();
            this.lottoList.add(manualLotto);
        }
        return this.lottoList;
    }

    @Override
    public Integer getLottoCnt(int amountOfMoney, int manualLottoCount) {
        System.out.print("수동으로 구매할 로또 수를 입력해 주세요. ");
        this.lottoCnt = userConsole.enterInteger();
        if(this.lottoCnt*1000 > amountOfMoney) throw new CustomException(ErrorCode.MONEY_NOT_ENOUGH);
        return this.lottoCnt;
    }

    public ArrayList<Integer> getManualLotto(){
        String inputNumbers = userConsole.enter6NumbersByString();
        ArrayList<Integer> manualLotto = Utility.getListFromInputBySplit(inputNumbers);
        return manualLotto;
    }

    public Integer getBonusLottoInput() {
        System.out.println("보너스 볼을 입력해주세요. ");
        this.bonusBall = userConsole.enterInteger();
        return bonusBall;
    }


}
