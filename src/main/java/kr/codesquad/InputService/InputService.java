package kr.codesquad.InputService;

import java.util.ArrayList;
import java.util.List;

public interface InputService {
    void getInputMoney();
    void printLottoCount();

    void getWonNumber();

    ArrayList<Integer> getWonNumberList();
    long getLottoCount();
}
