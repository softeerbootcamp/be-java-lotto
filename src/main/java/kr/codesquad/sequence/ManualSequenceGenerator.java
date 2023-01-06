package kr.codesquad.sequence;

import kr.codesquad.Lotto;
import kr.codesquad.LottoProcedure;
import kr.codesquad.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static kr.codesquad.LottoProcedure.parseCommaSeparatedLineInput;

public class ManualSequenceGenerator implements LottosGenerator {

    @Override
    public List<Lotto> generate(final int ticketsToGenerate) {
        Scanner sc = new Scanner(System.in);
        List<Lotto> lottos = new ArrayList<>();

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

        for(int i=0;i<ticketsToGenerate;++i) {
            String str = sc.nextLine();
            List<Integer> numbers = parseCommaSeparatedLineInput(str);  // 구매한 로또 번호

            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

}
