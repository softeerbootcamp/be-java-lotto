package kr.codesquad;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        LottoSystem ls = new LottoSystem();
        ls.getMoney();
        ls.getLottos();
        ls.getWin();
        ls.getResult();
        ls.printResult();
    }

}