package kr.codesquad.view;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IOManagerImpl implements IOManager {
    private static final int HUNDRED = 100;
    private final Scanner sc;

    public IOManagerImpl() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            return Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
    }

    @Override
    public int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        try{
            int manualLottoCount = Integer.parseInt(sc.nextLine());
            if (manualLottoCount < 0)
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            return manualLottoCount;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
    }

    @Override
    public String inputWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    @Override
    public String inputManualNumber() {
        return sc.nextLine();
    }

    @Override
    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try{
            return Integer.parseInt(sc.nextLine());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
    }

    @Override
    public void printLottoCount(int lottoAutoCount, int lottoManualCount) {
        System.out.println("\n수동으로 "+lottoAutoCount + "장, 자동으로 " + lottoManualCount + "개를 구매했습니다.");
    }

    @Override
    public void printEarningRate(double earningRate) {
        System.out.printf("\n총 수익률은 %.2f%%입니다.", Math.ceil(earningRate * HUNDRED * HUNDRED)/HUNDRED);
    }

    @Override
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printMatchResult(Map<Rank, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()){
            if (rank == Rank.MISS) continue;
            System.out.print(rank.getCountOfMatch() + "개 일치");
            if (rank == Rank.SECOND) System.out.print(", 보너스 볼 일치");
            System.out.printf(" (%d원)- %d개\n",rank.getWinningMoney(), result.get(rank));
        }
    }


}
