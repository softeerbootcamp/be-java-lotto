package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private BufferedReader br;

    InputView() {
         br = new BufferedReader(new InputStreamReader(System.in));
    }
    public long inputMoney() throws IOException {
        long money = Long.parseLong(br.readLine());
        return money;
    }
}
