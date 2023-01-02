package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private static final int LOTTO_LIMIT = 6;

    public static void main(String[] args) throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        //로또 구입 금액을 입력하면
        int num = input / SINGLE_PRICE;
        System.out.println(num + "개를 구매했습니다.");

        //구입 금액에 해당하는 로또를 발급해야 한다.
        List<Integer>[] lists = new List[num];
        for (List<Integer> list : lists) {
            list = new ArrayList<>();
            recevieRandomLotto(list);
        }
    }

    //로또 6은 1 ~ 45의 숫자중에 6개
    public static void recevieRandomLotto(List<Integer> list) {
        int min = 1;
        int max = 45;
        for (int i = 0; i < LOTTO_LIMIT; i++) {
            int random = (int) ((Math.random() * (max - min)) + min);
            list.add(random);
        }
        Collections.shuffle(list);

        System.out.print("[ ");
        for (int i = 0; i < LOTTO_LIMIT; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("]");
    }
}