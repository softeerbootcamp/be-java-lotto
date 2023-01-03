package kr.codesquad;

import kr.codesquad.LottoService.Lotto;
import kr.codesquad.LottoService.LottoStore;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {
    private long lottoCount;

    private List<Integer> winningNumberList;

    private static final int LOTTO_PRICE =1000;

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int bonusNumber;

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        lottoCount = Long.parseLong(sc.next()) / LOTTO_PRICE;
    }

    public void printLottoCount() {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos)
            System.out.println(lotto);
    }

    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String wonNumbers = sc.nextLine().replaceAll(" ", "");
        winningNumberList = Arrays.stream(wonNumbers.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public void inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        bonusNumber = sc.nextInt();
    }

    public void printWinningLottos(Map<String, Integer> winningLottos) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()){
            if (rank.toString().equals("ETC")) continue;
            System.out.printf("%d개 일치 (%d원)- %d개", rank.getCountOfMatch(),
                    rank.getWinningMoney(), winningLottos.get(rank.toString()));
            System.out.println();
        }
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
