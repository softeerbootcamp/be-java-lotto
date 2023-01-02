package kr.codesquad;

import java.util.*;

public class Main {
    private static final int LOTTO_PRICE = 1000;
    private static int total_price;
    private static int amount;
    private static ArrayList<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();

    public static void main(String[] args) {

        requestInput();
        setAmount();
        generateLottos();

    }

    public static void requestInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        total_price = sc.nextInt();
    }

    public static void setAmount() {
        amount = total_price / LOTTO_PRICE;
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void generateLottos() {
        for(int i = 0; i < amount; i++) {
            LottoNumber lotto = generateRandomLotto();
            lottoNumbers.add(lotto);
            System.out.println(lotto.getLotto().toString());
        }
    }
    public static LottoNumber generateRandomLotto() {
        LottoNumber lotto = new LottoNumber();
        return lotto;
    }

}