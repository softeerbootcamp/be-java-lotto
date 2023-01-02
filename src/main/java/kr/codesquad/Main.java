package kr.codesquad;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class My_lotto{
    private int lotto_cnt;
    private ArrayList<One_lotto> my_lottos;

    public My_lotto(int lotto_cnt) {
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
        for (int j=0;j<lotto_cnt;j++) {
            Collections.shuffle(numList);
            int[] lottoNums = new int[6];
            for (int i = 0; i < 6; i++) {
                lottoNums[i] = numList.get(i);
            }
            One_lotto tmplotto = new One_lotto(lottoNums);
            my_lottos.add(tmplotto);
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

    public static final int LOTTO_PRICE = 1000;

    // todo list 1
    public static int ret_lotto_cnt(int money){
        return money/LOTTO_PRICE;
    }
    public static void main(String[] args) {
        int money,cnt;
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        cnt = ret_lotto_cnt(money);
        System.out.printf("%d개를 구매했습니다.\n",cnt);
        My_lotto myLotto = new My_lotto(cnt);
        System.out.printf("");


    }
}
