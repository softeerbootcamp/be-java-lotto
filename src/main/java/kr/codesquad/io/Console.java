package kr.codesquad.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.domain.earningRate.EarningRate;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.winningLotto.WinningResult;

public class Console {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public int inputPurchaseMoney() {
    System.out.println("구입 금액을 입력해 주세요");
    return Integer.parseInt(commandLineInput());
  }

  public List<Integer> inputWinningNumbers() {
    System.out.println("당첨 번호를 입력해 주세요");
    return inputLottoNumbers();
  }

  private List<Integer> inputLottoNumbers() {
    String s = commandLineInput();
    System.out.println();
    String[] split = s.split(", ");

    return Arrays.stream(split)
                 .mapToInt(Integer::parseInt)
                 .boxed()
                 .collect(Collectors.toList());
  }

  public void printWinningResult(WinningResult result) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    System.out.println(result.getStatistics());
  }

  public void printEarningRate(EarningRate earningRate) {
    System.out.println("총 수익률은 " + earningRate.toString() + "입니다");
  }

  public int inputBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요");
    return Integer.parseInt(commandLineInput());
  }

  private String commandLineInput() {
    try {
      return br.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
