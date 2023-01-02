package kr.codesquad.InputService;

import java.util.ArrayList;

public interface InputService {
    void inputMoney();
    void printLottoCount();

    void inputWinningNumber();

    ArrayList<Integer> getWinningNumberList();
    long getLottoCount();
}
