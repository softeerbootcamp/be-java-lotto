package kr.codesquad.model.lottoImpl;

import kr.codesquad.templates.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ResultLotto extends Lotto {

    private int bonusNum;

    public int getBonusNum(){
        return bonusNum;
    }
    public void setBonusNum(int bonusNum) {this.bonusNum = bonusNum;}
}
