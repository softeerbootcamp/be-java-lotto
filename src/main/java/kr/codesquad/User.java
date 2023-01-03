package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class User {
    int price;
    int count;
    List<List<Integer>> lottoBuyList = new ArrayList<>(); // 로또 구매 목록
    List<Integer> lottoBuy = new ArrayList<>(); // 로또 구매 1장
    List<Integer> numberList = new ArrayList<Integer>(); // 1 ~ 45로 이루어진 리스트

    User(){
        // 로또 번호 1 ~ 45를 저장할 리스트 생성
        for(int n = 1;n<=45;n++){
            numberList.add(n);
        }
    }

    public void inputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        price = sc.nextInt();
        count = price/1000;
        // 구입 개수 출력
        System.out.println(count + "개를 구매했습니다.");
    }

    // 자동 생성 로또
    public void createLottoNumber(){
        for(int i = 0;i<count;i++){
            // 번호 섞기
            Collections.shuffle(numberList);
            lottoBuy = new ArrayList<>(numberList.subList(0,6));

            // 번호 정렬
            Collections.sort(lottoBuy);

            // 로또 구매 리스트에 추가
            lottoBuyList.add(lottoBuy);
        }
        // 구매한 로또 번호 출력
        printLottoBuyList();

    }

    public void printLottoBuyList(){
        for(int i = 0;i<lottoBuyList.size();i++){
            // 출력
            System.out.println(lottoBuyList.get(i));
        }
    }



}
