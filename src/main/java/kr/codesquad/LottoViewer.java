package kr.codesquad;

import kr.codesquad.domain.*;
import kr.codesquad.exception.ManualLottoCntException;

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
        Money.checkInputValid(totalMoney);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCnt = Integer.parseInt(br.readLine());

        return new Money(totalMoney, manualCnt);
    }

    public Lotto inputLotto(Money money) throws IOException {
        Lotto lotto = new Lotto(money);

        if (money.countOfManualRows() > 0) {
            addManualRows(money, lotto);
        }
        lottoController.addAutoRowsToLotto(lotto, money.countOfAutoRows());
        return lotto;
    }

    private void addManualRows(Money money, Lotto lotto) throws IOException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < money.countOfManualRows(); i++) {
            String manualRowString = br.readLine();
            lottoController.addManualRowsToLotto(lotto, money.countOfManualRows(), manualRowString);
        }
    }

    public WinningNumbers inputWinningNumbers() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*** 추가 개선 가능??***/
        List<LottoNumber> answerList = new ArrayList<>();
        for (int i = 0; i < Row.COLUMN; i++) {
            answerList.add(new LottoNumber(st.nextToken()));
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber bonusNumber = new LottoNumber(br.readLine());

        return new WinningNumbers(Row.createRow(answerList), bonusNumber);
    }

    public void result(Lotto lotto, WinningNumbers winningNumbers) {
        lotto.compareLotto(winningNumbers);

        Statistic statistic = lottoController.createStatistics(lotto);
        statistic.printStatistics();
    }
}
