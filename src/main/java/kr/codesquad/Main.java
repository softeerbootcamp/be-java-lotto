package kr.codesquad;

import java.util.*;

public class Main {
    private static final int LOTTO_PRICE = 1000;
    private static int total_price;
    private static int amount;
    private static ArrayList<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();

    public static void main(String[] args) {

        requestInput();

    }

    public static void requestInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        total_price = sc.nextInt();
    }

}