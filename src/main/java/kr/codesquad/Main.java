package kr.codesquad;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class My_lotto{
    private int lotto_cnt;
    private ArrayList<One_lotto> my_lottos;

    public My_lotto(ArrayList<One_lotto> my_lottos,int lotto_cnt) {
        setLotto_cnt(lotto_cnt);
        this.my_lottos = setMy_lottos(this.lotto_cnt);
    }

    public void setLotto_cnt(int lotto_cnt) {
        this.lotto_cnt = lotto_cnt;
    }

    public ArrayList<One_lotto> setMy_lottos(int lotto_cnt) {
        my_lottos = new ArrayList<>(lotto_cnt);
        List<Integer> numList = new ArrayList<>();
        for(int i=1;i <= 45;i++){
            numList.add(i);
        }
        for (One_lotto e_lotto:my_lottos
             ) {
            Collections.shuffle(numList);
            int[] lottoNums = new int[6];
            for (int i = 0; i < 6; i++) {
                lottoNums[i] = numList.get(i);
            }
            e_lotto.setNumbers(lottoNums);
        }
        return my_lottos;
    }
}
class One_lotto{
    private int[] numbers;
    public One_lotto(int[] numbers) {
        setNumbers(numbers);
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public static final int LOTTO_PRICE = 1000;

    // todo list 1
    public static int ret_lotto_cnt(int money){
        return money%LOTTO_PRICE;
    }

}
