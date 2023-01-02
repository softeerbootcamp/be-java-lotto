package kr.codesquad;


/**
 * 메소드의 indent(인덴트, 들여쓰기) depth를 1단계로 구현한다.
 *
 * if문을 사용하는 경우 depth가 1단계 증가한다. if문 안에 while문을 사용한다면 depth는 2단계가 된다.
 *
 * else를 사용하지 마라.
 *
 * 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
 *
 * method가 한 가지 일만 하도록 최대한 작게 만들어라.
 *
 * ArrayList를 사용해서 구현한다.
 */

/**
 * 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
 *
 * Collections.sort() 메소드를 활용해 정렬 가능하다.
 *
 * ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
 */

import java.util.*;

/**
 * 1. 로또 자동 생성하고 전역 변수로 저장 -> 2. 당첨 번호 입력 받기 -> 3. 전역 변수와 비교해서 3개,4,개,5개, 6개 일치되는지 확인
 * -> 4. 수익률 계산
 */

class Lotto{

    private List<List<Integer>> lottoes;
    private ArrayList<Integer> inputs;

    private int cnt;

    int match3=0;
    int match4=0;
    int match5=0;
    int match6=0;

    public Lotto() {
        lottoes = new ArrayList<>();
        inputs= new ArrayList<>();
        //inputs= new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
    }

    public void make_shuffle(){
        List<Integer> numList = new ArrayList<>();
        for(int j=1;j<46;j++) numList.add(j);
        Collections.shuffle(numList); //1에서 46까지를 셔플
        numList = numList.subList(0,6); //6개만
        Collections.sort(numList);
        //System.out.println(numList);
        lottoes.add(numList);
    }

    /**
     * 구입한 로또 후보들
     * @param cost
     */
    public void make_auto_lotto(int cost) {
        cnt = cost/1000; // 총 로또 개수
        System.out.println("총"+cnt+"개를 구매했습니다.");
        for(int i=0;i<cnt;i++){
            make_shuffle();
        }
        get_input();

        get_same_cnt();
    }

    /**
     * 당첨 번호 입력 받기
     */
    public void get_input(){
        System.out.println("당첨 번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<6;i++){
            int num = sc.nextInt();
            inputs.add(num);
        }
        Collections.sort(inputs);
        //System.out.println(inputs);
    }

    public int is_same(List<Integer> lotto, int num, int res){
        if(lotto.contains(num)) res++;

        return res;
    }

    /**
     * 비교 과정 구현
     * @param
     * @return
     */
    public void cmp_for_cnt(List<Integer> lotto){
        int res =0;
        for(int i=0;i<6;i++){
            res=is_same(lotto,inputs.get(i),res);
        }

        //System.out.println(res);
        if(res <3) return;

        if(res==3) match3++;
        else if(res ==4) match4++;
        else if(res ==5) match5++;
        else if(res ==6) match6++;

    }

    /**
     * 최종 비교 결과 얻기
     */

    public void get_same_cnt(){

        for(int i=0;i<cnt;i++){
            //System.out.println(lottoes.get(i));
            cmp_for_cnt(lottoes.get(i));
        }

//        System.out.println(match3);
//        System.out.println(match4);
//        System.out.println(match5);
//        System.out.println(match6);

    }
}

public abstract class Main {

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        System.out.println("구입금액을 입력해주세요. ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        lotto.make_auto_lotto(num);
    }


}