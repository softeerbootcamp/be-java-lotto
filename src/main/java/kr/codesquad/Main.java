package kr.codesquad;

import kr.codesquad.sequence.LottosGenerator;
import kr.codesquad.sequence.ShuffleSequenceGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int amount;

    final static int TICKET_PRICE = 1000;
    final static int LEAST_MATCH = 3;  // 로또 상금 수령을 위한 동일해야하는 최소 숫자의 개수

    final static int LOTTO_LENGTH = 6;  // 로또 번호 조합의 길이

    static List<Integer> range_1_to_45 = IntStream.range(1,45).boxed().collect(Collectors.toList());  // 1 ~ N 까지 랜덤 번호 생성
    static List<Integer> range_1_to_10 = IntStream.range(1,10).boxed().collect(Collectors.toList());
    static List<Integer> range_1_to_20 = IntStream.range(1,20).boxed().collect(Collectors.toList());
    static List<Integer> range_1_to_25 = IntStream.range(1,25).boxed().collect(Collectors.toList());

    // TODO: WinningPrize Enum으로 바꾸기
    static final int[] PRICES = new int[] {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    static int[] matches = new int[7];  // 몇 개의 로또 번호가 일치하는지. matches[3] -> 3개의 번호가 일치하는 경우를 셈

    static List<Integer> randomlyChoose_N_Numbers(List<Integer> range, int n) {
        // 45개 섞기
        Collections.shuffle(range);

        // 상위 n개 선택
        return range.stream().limit(n).collect(Collectors.toList());
    }

    static int matchLotto (List<Integer> actual, List<Integer> predicted) {
        int cnt = 0;
        Collections.sort(actual);  // 실제 로또 번호 정렬
        Collections.sort(predicted);  // 구매한 로또 번호 정렬

        // 정렬된 로또 번호 기준으로, 실제 로또 번호와 비교
        for(Integer num : predicted) {
            cnt += actual.contains(num) ? 1:0;
        }

        return cnt;
    }

    static int matchLotto (Lotto actual, Lotto predicted) {
        int cnt = 0;

        // 정렬된 로또 번호 기준으로, 실제 로또 번호와 비교
        for(Integer num : predicted.getLotto()) {
            cnt += actual.contains(num) ? 1:0;
        }

        return cnt;
    }

    static double returnRate(long prizeTotal) {
        double priceReturn = (prizeTotal/ (double) amount) * 100;

        if(prizeTotal != 0 && prizeTotal < amount) {
            priceReturn = 100d - priceReturn;
            priceReturn *= -1;
        }
        return priceReturn;
    }

    static void printStatistics(int[] matches) {  // TODO: 게임의 함수로
        long prizeTotal = 0;
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for(int i=LEAST_MATCH;i<=LOTTO_LENGTH;++i) {  // 최소 3개 이상, 6개 이하 매치
            prizeTotal += (long) PRICES[i] * matches[i]; // 상금 총액
            System.out.println(i + "개 일치 (" + PRICES[i] + "원)- " + matches[i] + "개");
        }

        double returnRate = returnRate(prizeTotal);
        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "%입니다.)");
    }

    static List<List<Integer>> generateRandomLottoSequences(int numOfTickets) {
        List<List<Integer>> generatedSequences = new ArrayList<>();

        for(int i=0;i<numOfTickets;++i) {
            List<Integer> lottoNumbers = randomlyChoose_N_Numbers(range_1_to_45, LOTTO_LENGTH);  // 랜덤하게 6개 숫자 뽑기
            generatedSequences.add(lottoNumbers);
        }
        return generatedSequences;
    }

    static int[] matchLottoSequences(List<List<Integer>> generatedSequences, List<Integer> actual) {
        // TODO: game의 함수로
        for(List<Integer> generatedSequence: generatedSequences) {
            int cnt = matchLotto(actual, generatedSequence);  // 실제 당첨번호와 생성된 로또 번호 1대1 매칭 통해 대응되는 수의 쌍 개수 반환
            matches[cnt] += 1;
        }

        return matches;
    }

    static int[] matchLottoSequences(List<Lotto> lottos, Lotto actual) {
        // TODO: game의 함수로
        for(Lotto lotto: lottos) {
            int cnt = matchLotto(actual, lotto);  // 실제 당첨번호와 생성된 로또 번호 1대1 매칭 통해 대응되는 수의 쌍 개수 반환
            matches[cnt] += 1;
        }

        return matches;
    }

    static void printSequences(List<List<Integer>> sequences) {
        for (List<Integer> sequence : sequences) {
            System.out.println(sequence);
        }
    }

    static void printSequences(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    static int takePurchasedPrice() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");

        amount = sc.nextInt();
        return amount;
    }

    static List<Integer> takeAndParseLottoSequences() {
        // TODO: game 메서드로
        Scanner sc = new Scanner(System.in);

        sc.nextLine();
        String str = sc.nextLine();

        // 당첨 번호처리, 반환
        return Stream.of(str.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        takePurchasedPrice();

        int numOfTickets = amount / TICKET_PRICE;

        System.out.println(numOfTickets + " 개를 구매했습니다.");

        // 랜덤 로또 번호 생성
        LottosGenerator generator = new ShuffleSequenceGenerator();
        // List<List<Integer>> generatedSequences = generateRandomLottoSequences(numOfTickets);

        List<Lotto> generatedSequences = generator.generate(new Money(amount));

        /*List<List<Integer>> generatedSequences = new ArrayList<>();
        generatedSequences.add(new ArrayList<>(Arrays.asList(1, 3, 5, 14, 22, 45)));*/

        printSequences(generatedSequences);

        System.out.println("\n당첨 번호를 입력해 주세요.");

        // TODO: game의 입력, parsing 부분으로
        List<Integer> actual = takeAndParseLottoSequences(); // 실제 로또 번호

        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = sc.nextInt();

        Lotto actualLotto = new ActualLottoSequence(actual, bonus);

        matches = matchLottoSequences(generatedSequences, actualLotto);  // 실제 로또 번호와 생성된 로또 번호 비교

        printStatistics(matches);
    }
}