package kr.codesquad.view;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Money;
import kr.codesquad.enums.ExceptionMessage;
import kr.codesquad.exception.DefaultException;
import kr.codesquad.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public InputView() {
    }

    public String inputMoney() throws IOException {
        String input = br.readLine();
        Validator.checkMoneyBoundary(input);
        return input;
    }

    public int inputBonusNumber() throws IOException {
        String input = br.readLine();
        Validator.checkTransformabilityToNumber(input);
        Validator.checkLottoNumBoundary(Integer.parseInt(input));
        return Integer.parseInt(input);
    }

    public Lotto inputWinningLotto() throws IOException {
        String[] input = br.readLine().split(", ");
        Validator.checkLottoNumbers(input);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        return Lotto.of(list);
    }

    public int inputCountOfManualLotto(Money money) throws IOException {
        String input = br.readLine();
        Validator.checkManualLottoCount(input, money);
        return Integer.parseInt(input);
    }

    public static String[] inputManualLotto(){
        try {
            String[] input = br.readLine().split(", ");
            Validator.checkLottoNumbers(input);
            return input;
        } catch (IOException e) {
            throw new DefaultException(e.getMessage());
        }
    }
}
