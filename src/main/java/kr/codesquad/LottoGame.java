package kr.codesquad;

import java.util.*;

public class LottoGame {

    private final static int LOTTO_PRICE = 1000;
    private final static int LOTTO_NUMBER_COUNT = 6;

    private static ArrayList<Integer> result;

    public List<Integer> lottoNumbers;

    public LottoGame() {
        result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }

    public void confirmLotto(Lotto purchasedLotto, Lotto winningLotto, int bonusBall) {

        int matchNum = 0;
        for (int num : purchasedLotto.getNumbers()) {
            matchNum = setMatchNum(winningLotto, matchNum, num);
        }
        if (matchNum == 5) {
            if (purchasedLotto.getNumbers().contains(bonusBall)) {
                result.set(0, result.get(7) + 1);
                result.set(matchNum, result.get(7) - 1);
            }
        }
        result.set(matchNum, result.get(matchNum) + 1);
    }

    public int setMatchNum(Lotto winningLotto, int matchNum, int num) {
        if (winningLotto.getNumbers().contains(num)) {
            matchNum += 1;
        }
        return matchNum;
    }

    public void printResult(int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("-----");
        System.out.println("3개 일치 (5000원) - " + result.get(LottoMatchType.THREE_MATCH.getMatchCount()));
        System.out.println("4개 일치 (50000원) - " + result.get(LottoMatchType.FOUR_MATCH.getMatchCount()));
        System.out.println("5개 일치 (1500000원) - " + result.get(LottoMatchType.FIVE_MATCH.getMatchCount()));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + result.get(0));
        System.out.println("6개 일치 (2000000000원) - " + result.get(LottoMatchType.SIX_MATCH.getMatchCount()));
        double output = result.get(LottoMatchType.THREE_MATCH.getMatchCount()) * LottoMatchType.THREE_MATCH.getMoney()
                + result.get(LottoMatchType.FOUR_MATCH.getMatchCount()) * LottoMatchType.FOUR_MATCH.getMoney()
                + result.get(LottoMatchType.FIVE_MATCH.getMatchCount()) * LottoMatchType.FIVE_MATCH.getMoney()
                + result.get(LottoMatchType.SIX_MATCH.getMatchCount()) * LottoMatchType.SIX_MATCH.getMoney()
                + result.get(LottoMatchType.BONUS_MATCH.getMatchCount()) * LottoMatchType.BONUS_MATCH.getMoney();
        double input = purchaseAmount * LOTTO_PRICE;

        System.out.println(String.format("%.2f", ((output - input) / input) * 100) + "%");
    }

    public void checkMyLotto(List<Lotto> purchasedLottoList, Lotto winningLotto, int bonusBall) {
        for (Lotto lotto : purchasedLottoList) {
            System.out.println(lotto);
            confirmLotto(lotto, winningLotto, bonusBall);
        }
        printResult(purchasedLottoList.size());
    }

    public Lotto getNewLotto() {
        Collections.shuffle(lottoNumbers);
        List<Integer> newLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT));
        Collections.sort(newLottoNumbers);
        return Lotto.newOne(newLottoNumbers);
    }

    public int getPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int getLottoCount(int purchaseAmount) {
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구입하였습니다.");
        return lottoCount;
    }

    public ArrayList<Lotto> purchaseLottoList() {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = getLottoCount(purchaseAmount);

        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(getNewLotto());
            System.out.println(lottoList.get(i));
        }

        return lottoList;
    }

    public int getBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Lotto createWinningLottery() {
        System.out.println("당첨 번호를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        for (String number : numbers.split(", ")) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        return Lotto.newOne(lottoNumbers);
    }
}
