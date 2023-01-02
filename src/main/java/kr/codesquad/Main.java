package kr.codesquad;


import java.util.ArrayList;


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
