package kr.codesquad;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {
    @Test
    void 로또생성기_테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> list = numberGenerator.numberGenerate();
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
    @Test
    void 반복_생성_테스트() {
        for (int i = 0; i < 5; i++) {
            로또생성기_테스트();
            System.out.println();
        }
    }
}