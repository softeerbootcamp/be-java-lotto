package kr.codesquad;

import kr.codesquad.sequence.LottosGenerator;
import kr.codesquad.sequence.ShuffleSequenceGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        LottoProcedure procedure = new LottoProcedure(new ShuffleSequenceGenerator());

        procedure.run();
    }
}