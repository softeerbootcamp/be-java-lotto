package kr.codesquad.Lotto;

import java.util.List;

public class WinLotto extends Lotto{
    private int bonusNo;

    public WinLotto(List<Integer> initWinningNumbers, int initBonusNumber){
        super(initWinningNumbers);
        this.bonusNo = initBonusNumber;
    }

    public int getBonusNo(){
        return bonusNo;
    }
}
