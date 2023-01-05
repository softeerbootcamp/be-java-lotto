package kr.codesquad.view;

import kr.codesquad.domain.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputMoney() throws IOException {
        return br.readLine();
    }

    public int inputBonusNumber() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public Lotto inputWinningLotto() throws IOException {
        String[] input = br.readLine().split(", ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(Integer.parseInt(input[i]));
        }
        return Lotto.of(list);
    }
}
