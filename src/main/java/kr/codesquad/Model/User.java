package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class User {
    private int price;
    private int count;
    private List<List<Integer>> lottoBuyList = new ArrayList<>(); // 로또 구매 목록
    private List<Integer> lottoBuy = new ArrayList<>(); // 로또 구매 1장
    private List<Integer> numberList = new ArrayList<Integer>(); // 1 ~ 45로 이루어진 리스트

    public User(){
        // 로또 번호 1 ~ 45를 저장할 리스트 생성
        for(int n = 1;n<=45;n++){
            numberList.add(n);
        }
    }

    public void setPriceAndCount(int p){
        price = p;
        count = p/1000;
    }
    public int getPrice(){ return price; }
    public int getCount(){ return count; }

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

    public List<List<Integer>> getLottoBuyList() {
        return lottoBuyList;
    }
}
