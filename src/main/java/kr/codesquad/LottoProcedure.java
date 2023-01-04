package kr.codesquad;

import kr.codesquad.sequence.LottosGenerator;
import kr.codesquad.sequence.ShuffleSequenceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoProcedure {
    final static int LEAST_MATCH = 3;  // 로또 상금 수령을 위한 동일해야하는 최소 숫자의 개수
    final static int LOTTO_LENGTH = 6;  // 로또 번호 조합의 길이
    final static Scanner sc = new Scanner(System.in);

    static boolean matchBonus = false;  // 보너스 번호 존재하는지

    static int[] matches = new int[7];  // 몇 개의 로또 번호가 일치하는지. matches[3] -> 3개 이상의 번호가 일치하는 경우를 셈

    private Lotto actualSequence;  // 실제 로또 번호
    private List<Lotto> createdSequence;  // 자동으로 생성된 로또 번호
    private List<Lotto> manualSequence = new ArrayList<>();  // 수동으로 입력된 로또 번호

    private LottosGenerator generator = new ShuffleSequenceGenerator();

    private Money money;
    private int bonus;
    private int manualCnt;  // 수동으로 구매할 로또 번호의 수
    private int shuffleCnt;  // 자동으로 구매할 로또 번호의 수
    private int ticketsLeftToGenerate;

    public LottoProcedure(LottosGenerator sequenceGenerator) {
        this.generator = sequenceGenerator;
    }

    public void run() {
        try {
            // 구매 금액 입력
            takeMoney();
            this.ticketsLeftToGenerate = money.numOfTickets;

            takeManualInput();  // 수동 로또 번호 입력

            // 로또 번호 생성
            this.createdSequence = generator.generate(ticketsLeftToGenerate);

            printLottoSequence();

            // ---------------------------------------------------------- TODO: 로직 입력부, 계산부로 분리

            takeActualInput();  // 로또 번호, 보너스 번호 입력
            // TODO: 입력 로또번호 parameter로 주입받는 method로 분리하기

            matchLottoSequences(createdSequence, actualSequence);
            matchLottoSequences(manualSequence, actualSequence);

            printStatistics();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void takeMoney() {

        // 구입 금액 입려
        System.out.println("구입금액을 입력해 주세요.");
        int m = sc.nextInt();  // 구입금액 입력

        this.money = new Money(m);
    }

    public void printLottoSequence() {
        System.out.println("\n수동으로 " + this.manualCnt + "장, 자동으로 " + this.shuffleCnt + " 개를 구매했습니다.");

        // 구매한 로또 번호 출력
        Lotto.printSequence(manualSequence);
        Lotto.printSequence(createdSequence);
    }

    public void takeActualInput() {

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String str = sc.nextLine();  // 당첨번호 입력

        // 당첨 번호처리, 반환
        this.actualSequence = new ActualLottoSequence(parseCommaSeparatedLineInput(str), bonus);

        System.out.println("보너스 볼을 입력해 주세요.");
        this.bonus = sc.nextInt();  // 보너스 번호 입력
    }

    public void takeManualInput() {
        // 수동으로 구매할 로또 처리
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        this.manualCnt = sc.nextInt();  // 수동으로 구매할 로또 번호 수 입력
        sc.nextLine();

        if(ticketsLeftToGenerate < manualCnt)
            throw new IllegalArgumentException("구매할 수 있는 로또보다 구매하고자 하는 로또가 더 많습니다");

        this.ticketsLeftToGenerate -= manualCnt;  // 수동으로 구매한 로또 만큼 적게 자동 생성
        this.shuffleCnt = ticketsLeftToGenerate;  // 수동으로 구매한 로또 만큼 적게 자동 생성

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for(int i=0;i<this.manualCnt;++i) {
            String str = sc.nextLine();
            List<Integer> numbers = parseCommaSeparatedLineInput(str);  // 구매한 로또 번호

            this.manualSequence.add(new Lotto(numbers));
        }
    }

    public List<Integer> parseCommaSeparatedLineInput(String str) {
        return Stream.of(str.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    void matchLottoSequences(List<Lotto> created, final Lotto actual) {
        for(Lotto lotto: created) {
            int cnt = matchLotto(actual, lotto);  // 실제 당첨번호와 생성된 로또 번호 1대1 매칭 통해 대응되는 수의 쌍 개수 반환
            matches[cnt] += 1;
        }
    }

    int matchLotto (Lotto actual, Lotto created) {  // 실제 당첨번호(입력), 생성된 번호
        // TODO: 로또 매칭 담당하는 클래스로 분리
        int cnt = 0;
        matchBonus = false;

        // 정렬된 로또 번호 기준으로, 실제 로또 번호와 비교
        for(Integer num : created.getLotto()) {  // TODO: Lotto의 getter가 필요한가
            cnt += actual.contains(num) ? 1:0;
        }

        // 보너스 조건 - 5개가 맞고 보너스 번호도 맞을 때
        if(cnt == 5 && created.contains(bonus)) {
            // 보너스이면 -> 2등
            matchBonus = true;
        }

        return cnt;  // 동일한 번호의 갯수
    }

    void printStatistics() {
        // TODO: 로또 매칭 담당하는 클래스로 분리
        long prizeTotal = 0;

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        // TODO: 이해 쉽게
        for (int i = LEAST_MATCH; i <= LOTTO_LENGTH; ++i) {  // 최소 3개 이상, 6개 이하 매치
            Prize prize = Prize.valueOf(matches[i] > 0?i:0, matchBonus);
            prizeTotal += prize.calculatePrize(matches[i]); // 상금 총액

            System.out.println(i + "개 일치 (" + prize.getWinningMoney() + "원)- " + matches[i] + "개");
            // TODO: Prize가 Miss인 경우 WinningMoney = 0 반환되는 에러 해걸
        }

        double returnRate = money.returnRate(prizeTotal);

        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "%입니다.)");
    }
}
