package kr.codesquad.View;

import kr.codesquad.Model.LottoService;
import kr.codesquad.Model.Price;

import java.math.RoundingMode;

public class LottoPrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
