package kr.codesquad;

import kr.codesquad.sequence.LottosGenerator;
import kr.codesquad.sequence.ShuffleSequenceGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoProcedure {
    final static int LEAST_MATCH = 3;  // 로또 상금 수령을 위한 동일해야하는 최소 숫자의 개수

    final static int LOTTO_LENGTH = 6;  // 로또 번호 조합의 길이

    static int[] matches = new int[7];  // 몇 개의 로또 번호가 일치하는지. matches[3] -> 3개의 번호가 일치하는 경우를 셈
    static final int[] PRICES = new int[] {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private Lotto actualSequence;
    private List<Lotto> createdSequence;

    private LottosGenerator generator = new ShuffleSequenceGenerator();

    private Money money;
    private int bonus;

    public LottoProcedure(LottosGenerator sequenceGenerator) {  // TODO: LottoGenerator 주입받기, 아래 method 흐름 template method
        this.generator = sequenceGenerator;
    }

    public void run() {
        takeMoney();  // 구매 금액 입력

        createdSequence = generator.generate(money);  // 로또 번호 생성, generator는 위임

        for (Lotto lotto : createdSequence) {  // 생성된 로또 번호 출력
            System.out.println(lotto.toString());
        }  // TODO: 메서드로 만들기

        takeInput();  // 로또 번호, 보너스 번호 입력

        matchLottoSequences(createdSequence, actualSequence);

        printStatistics();
    }

    public void takeMoney() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");

        int m = sc.nextInt();
        this.money = new Money(m);

        System.out.println(money.numOfTickets + " 개를 구매했습니다.\n");
    }
    public void takeInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        sc.next();
        // TODO: game의 입력, parsing 부분으로
        String str = sc.nextLine();

        // 당첨 번호처리, 반환
        this.actualSequence = new ActualLottoSequence(Stream.of(str.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()), bonus);
        System.out.println("보너스 볼을 입력해 주세요.");

        this.bonus = sc.nextInt();


    }

    int[] matchLottoSequences(List<Lotto> created, Lotto actual) {
        // TODO: game의 함수로
        for(Lotto lotto: created) {
            int cnt = matchLotto(actual, lotto);  // 실제 당첨번호와 생성된 로또 번호 1대1 매칭 통해 대응되는 수의 쌍 개수 반환
            matches[cnt] += 1;
        }

        return matches;
    }

    int matchLotto (Lotto actual, Lotto predicted) {
        int cnt = 0;

        // 정렬된 로또 번호 기준으로, 실제 로또 번호와 비교
        for(Integer num : predicted.getLotto()) {
            cnt += actual.contains(num) ? 1:0;
        }

        return cnt;
    }

    void printStatistics() {  // TODO: 게임의 함수로
        int prizeTotal = 0;
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (int i = LEAST_MATCH; i <= LOTTO_LENGTH; ++i) {  // 최소 3개 이상, 6개 이하 매치
            // TODO: PRICES -> Enumeration으로 대치
            prizeTotal += (long) PRICES[i] * matches[i]; // 상금 총액
            System.out.println(i + "개 일치 (" + PRICES[i] + "원)- " + matches[i] + "개");
        }

        double returnRate = money.returnRate(prizeTotal);
        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "%입니다.)");
    }
}
