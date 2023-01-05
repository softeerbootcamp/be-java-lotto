package kr.codesquad;

import kr.codesquad.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LottoViewer {

    private final LottoController lottoController;
    private final BufferedReader br;

    public LottoViewer() {
        this.lottoController = new LottoController();
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Lotto home() throws IOException {
        Money money = inputMoney();
        Lotto lotto = inputLotto(money);

        money.printStatus();
        lotto.printTotalLotto();

        return lotto;
    }

    public Money inputMoney() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        int totalMoney = Integer.parseInt(br.readLine());

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCnt = Integer.parseInt(br.readLine());
        if (manualCnt < 0) {
            throw new IllegalArgumentException("수동 로또 수 0이상이어야 함.");
        }
        return new Money(totalMoney, manualCnt);
    }

    public Lotto inputLotto(Money money) throws IOException {
        Lotto lotto = new Lotto(money);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < money.countOfManualRows(); i++) {
            String manualRowString = br.readLine();
            lottoController.addManualRowsToLotto(lotto, money.countOfManualRows(), manualRowString);
        }
        lottoController.addAutoRowsToLotto(lotto, money.countOfAutoRows());
        return lotto;
    }

    public WinningNumbers inputWinningNumbers() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < Row.COLUMN; i++) {
            answerList.add(Integer.parseInt(st.nextToken()));
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(br.readLine());

        List<LottoNumber> lottoNumbers = LottoNumber.convertIntegersToLottoNumbers(answerList);

        return new WinningNumbers(Row.createRow(lottoNumbers), bonusNumber);
    }

    /**
     * Controlling Compare & create Statistics
     *
     * @param lotto
     * @param winningNumbers
     */
    public void result(Lotto lotto, WinningNumbers winningNumbers) {
        lotto.compareLotto(winningNumbers);

        Statistic statistic = lottoController.createStatistics(lotto);
        statistic.printStatistics();
    }
}
