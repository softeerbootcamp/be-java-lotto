package kr.codesquad.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputImpl implements Input{
    private BufferedReader br;

    private InputImpl(){}

    @Override
    public void MoneyInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void ManualLottoCountInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void ManualLottoNumbersInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void JackpotNumberInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
}
