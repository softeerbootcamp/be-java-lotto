package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    ArrayList<ArrayList<Integer>> lottoBuyList = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> lottoBuy;
    ArrayList<Integer> numberList = new ArrayList<Integer>();

    Lotto(){
        // 로또 번호 1 ~ 45를 저장할 리스트 생성
        for(int n = 1;n<=45;n++){
            numberList.add(n);
        }
    }
    public void createLottoNumber(int count){
        for(int i = 0;i<count;i++){
            // 번호 섞기
            Collections.shuffle(numberList);
            lottoBuy = new ArrayList<>(numberList.subList(0,6));

            // 번호 정렬
            Collections.sort(lottoBuy);

            // 로또 구매 리스트에 추가
            lottoBuyList.add(lottoBuy);
        }
    }

    public void printLottoBuyList(){
        for(int i = 0;i<lottoBuyList.size();i++){
            // 출력
            System.out.println(lottoBuyList.get(i));
        }
    }



}
