package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    private List<Integer> lottoNumbers;
    int bonusBall;
    public Lotto(){
        lottoNumbers = new ArrayList<>();
        bonusBall = 0;
    }

    public Lotto(List<Integer> lottoNumList){
        bonusBall = 0;
        lottoNumbers = lottoNumList;
    }
    public void setLottoNumbers(List<Integer> ln){
        lottoNumbers = ln;
    }
    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void sortNumbers(){
        Collections.sort(lottoNumbers);
    }

    public void addLottoNum(int num){
        lottoNumbers.add(num);
    }

    public void setBonusBall(int b){
        bonusBall = b;
    }

    public int getBonusBall(){
        return bonusBall;
    }
}
