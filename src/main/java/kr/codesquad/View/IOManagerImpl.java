package kr.codesquad.View;

import kr.codesquad.LottoService.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.spec.ECField;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            return Integer.parseInt(sc.nextLine());
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
    public void printEarningRate(float earningRate) {
        System.out.printf("\n총 수익률은 %.2f%%입니다.", Math.ceil(earningRate * HUNDRED * HUNDRED)/HUNDRED);
    }

    @Override
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
