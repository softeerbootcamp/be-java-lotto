package kr.codesquad.View;

import kr.codesquad.LottoService.Lotto;
import kr.codesquad.Rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class Console {
    private long lottoCount;

    private List<Integer> winningNumberList;

    private static final int LOTTO_PRICE=1000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int bonusNumber;

    public void inputMoney() throws Exception {
        System.out.println("구입금액을 입력해 주세요.");
        //들어온 값이 1000원 이하이면 에러 출력하기
        long input = Long.parseLong(br.readLine());
        if (input < 1000 || input % 1000 != 0) {
            throw new IllegalArgumentException("적절하지 않은 구입금액입니다.");
        }
        lottoCount = Long.parseLong(br.readLine()) / LOTTO_PRICE;
    }

    public int inputManualLottoCount() throws IOException {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(br.readLine());
    }

    public void inputManualLottoNumber(int manualLottoCount) throws IOException {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLottoCount; i++) {
            splitInputString(br.readLine());
        }
    }

    public List<Integer> splitInputString(String line) {
        List<Integer> ret = Arrays.stream(line.split(",")).map(Integer::valueOf).sorted().collect(Collectors.toList());
        if (ret.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (ret.get(0) < 1 || ret.get(ret.size() - 1) > 45) {
            throw new IllegalArgumentException();
        }
        return ret;
    }

    public void printLottoCount() {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList)
            System.out.println(lotto);
    }

    public void inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String wonNumbers = sc.nextLine().replaceAll(" ", "");
        winningNumberList = Arrays.stream(wonNumbers.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public void inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        bonusNumber = sc.nextInt();
    }

    public void printWinningLottoMap(Map<Rank, Integer> winningLottoMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()){
            if (rank == Rank.ETC) continue;
            System.out.printf("%d개 일치", rank.getCountOfMatch());
            if (rank == Rank.SECOND) System.out.print(", 보너스 볼 일치");
            System.out.printf(" (%d원)- %d개\n",rank.getWinningMoney(), winningLottoMap.get(rank));
        }
    }

    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public long getLottoCount() {
        return lottoCount;
    }

}
