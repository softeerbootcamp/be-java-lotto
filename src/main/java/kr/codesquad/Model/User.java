package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class User {
    private int price;
    private int count;
    private List<Lotto> lottoBuyList = new ArrayList<>(); // 로또 구매 목록
    private List<Integer> lottoBuy = new ArrayList<>(); // 로또 구매 1장

    public User(){

    }

    public List<Lotto> getLottoBuyList(){
        return lottoBuyList;
    }

    public void setPriceAndCount(int p){
        price = p;
        count = p/1000;
    }
    public int getPrice(){ return price; }
    public int getCount(){ return count; }
    public void addLottoBuyList(Lotto lotto) {
        lotto.sortNumbers();
        lottoBuyList.add(lotto);
    }
}
