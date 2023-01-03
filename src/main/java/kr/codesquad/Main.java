package kr.codesquad;


import java.util.*;

import static kr.codesquad.Calculator.*;
import static kr.codesquad.Jackpot_Handler.*;
import static kr.codesquad.Lotto_Info.LOTTO_PRICE;

class My_lotto{
    private int lotto_cnt;
    private ArrayList<One_lotto> my_lottos;
    private ArrayList<Integer> all_lotto_num;
    public My_lotto(int lotto_cnt) {
        setLotto_cnt(lotto_cnt);
        setAll_lotto_num();
        this.my_lottos = setMy_lottos(this.lotto_cnt);
    }
    public ArrayList<One_lotto> getMy_lottos(){
        return this.my_lottos;
    }
    public void setLotto_cnt(int lotto_cnt) {
        this.lotto_cnt = lotto_cnt;
    }

    public void setAll_lotto_num() {
        this.all_lotto_num = new ArrayList<>();
        for(int i=1;i <= 45;i++){
            this.all_lotto_num.add(i);
        }
    }

    public ArrayList<Integer> retRand_lotto_num() {
        Collections.shuffle(this.all_lotto_num);
        ArrayList<Integer> lottoNums = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            lottoNums.add(this.all_lotto_num.get(i));
        }
        return lottoNums;
    }

    public ArrayList<One_lotto> setMy_lottos(int lotto_cnt) {
        my_lottos = new ArrayList<>(lotto_cnt);
        for (int j=0;j<lotto_cnt;j++) {
            One_lotto tmplotto = new One_lotto(retRand_lotto_num());
            my_lottos.add(tmplotto);
            tmplotto.printNumbers();
        }

        return my_lottos;
    }
}
class One_lotto{
    private ArrayList<Integer> numbers;
    public One_lotto(ArrayList<Integer> numbers) {
        setNumbers(numbers);
    }
    public ArrayList<Integer> getNumbers(){return this.numbers;}
    public void setNumbers(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    public void printNumbers(){
        System.out.println(this.numbers);
    }
}
public class Main {
    // todo list 1
    public static int ret_lotto_cnt(int money){
        return money/LOTTO_PRICE.getValue();
    }

    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int cnt = ret_lotto_cnt(money);
        System.out.printf("%d개를 구매했습니다.\n",cnt);
        My_lotto myLotto = new My_lotto(cnt);
        setJackpotNum();
        finding_jackpot(myLotto,JACKPOT_NUM);
        Calculator.print_and_calculation(JACKPOT_CNT,money);
    }
}
