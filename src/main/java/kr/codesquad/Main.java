package kr.codesquad;

import kr.codesquad.controller.LottoController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.start();
    }
}