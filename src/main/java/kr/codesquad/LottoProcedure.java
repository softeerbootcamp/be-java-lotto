package kr.codesquad;

import kr.codesquad.sequence.LottosGenerator;
import kr.codesquad.sequence.ShuffleSequenceGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoProcedure {

    final static Scanner sc = new Scanner(System.in);

    private Lotto winningLotto;  // 실제 로또 번호

    private List<Lotto> lottos;

    private Money money;

    private LottosGenerator generator = new ShuffleSequenceGenerator();

    private int bonus;
    private int manualCnt;  // 수동으로 구매할 로또 번호의 수
    private int shuffleCnt;  // 자동으로 구매할 로또 번호의 수
    private int ticketsLeftToGenerate;

    public LottoProcedure(LottosGenerator sequenceGenerator) {
        this.generator = sequenceGenerator;
        this.lottos = new ArrayList<>();
    }

    public void run() {
        // 구매 금액 입력
        takeMoney();
        this.ticketsLeftToGenerate = money.numOfTickets;

        takeManualInput();  // 수동 로또 번호 입력

        // 로또 번호 생성
        this.lottos.addAll(generator.generate(ticketsLeftToGenerate));

        printLottoSequence();

        takeActualInput();  // 로또 번호, 보너스 번호 입력

        LottoResult result = new LottoResult(this);
        result.showResults();
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
        // TODO: 이 클래스의 메서드로
        for(Lotto lotto : this.lottos) {
            System.out.println(lotto);
        }
    }

    public void takeActualInput() {

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String str = sc.nextLine();  // 당첨번호 입력

        // 당첨 번호처리, 반환
        this.winningLotto = new WinningLotto(parseCommaSeparatedLineInput(str), bonus);

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

            this.lottos.add(new Lotto(numbers));
        }
    }

    public List<Integer> parseCommaSeparatedLineInput(String str) {
        return Stream.of(str.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Money getMoney() {
        return money;
    }
}
