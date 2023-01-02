package kr.codesquad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static List<Integer> lottoNumbers = new ArrayList<>();

    public static List<Lotto> createLottos(int lottoCount) {
        createLottoNumbers();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(createLotto(lottoNumbers));
        }

        return lottos;
    }

    private static Lotto createLotto(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        List<Integer> numbers = lottoNumbers.subList(0, 6);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }

    private static void createLottoNumbers() {
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }
}
