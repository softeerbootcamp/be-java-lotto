package kr.codesquad;


import java.util.*;

import static kr.codesquad.Calculator.calculate_profit;

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

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_CNT = 6;
    public static final int[] JACKPOT_CNT = {0,0,0,0};
    public static ArrayList<Integer> JACKPOT_NUM;
    // todo list 1
    public static int ret_lotto_cnt(int money){
        return money/LOTTO_PRICE;
    }
    public static int plus_if_contains(int i, ArrayList<Integer> my, ArrayList<Integer> jk){
        if(my.contains(jk.get(i))){
            return 1;
        }else{
            return 0;
        }
    }
    public static void ret_jackpot_cnts(ArrayList<Integer> my, ArrayList<Integer> jk){
        int cnt=0;
        for (int i=0;i<LOTTO_CNT;i++) {
            cnt+=plus_if_contains(i,my,jk);
        }
        if(cnt>=3) JACKPOT_CNT[cnt-3]++;
    }

    public static void finding_jackpot(My_lotto myLotto, ArrayList<Integer> jackpot_num){
        for (One_lotto o:myLotto.getMy_lottos()
             ) {
            ArrayList<Integer> my_lotto_one = o.getNumbers();
            ret_jackpot_cnts(my_lotto_one,jackpot_num);
        }
    }




    public static void setJackpotNum(){
        System.out.printf("당첨 번호를 입력해 주세요.\n");
        Scanner s2 = new Scanner(System.in);
        String str = s2.nextLine();
        String[] strArr= str.split(",");
        JACKPOT_NUM = new ArrayList<>(LOTTO_CNT);
        for(int i=0;i<LOTTO_CNT;i++){
            JACKPOT_NUM.add(Integer.parseInt(strArr[i]));
        }
        Collections.sort(JACKPOT_NUM);
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
        System.out.printf("총 수익률은 : %f%%입니다\n",Calculator.calculate_profit(JACKPOT_CNT,money)*100);

    }
}
