package kr.codesquad.lotto.issue;

import kr.codesquad.lotto.Lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class ManualLottoIssueStrategy implements LottoIssueStrategy {

    private final BufferedReader br;

    public ManualLottoIssueStrategy(BufferedReader br) {
        this.br = br;
    }

    @Override
    public List<Lotto> issue(int cnt) throws IOException {
        List<Lotto> lottoList = new ArrayList<>(cnt);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int lottoCnt = getIssueLottoCnt();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int idx = 0; idx < lottoCnt; idx++) {
            Set<Integer> lottoNumberSet = getLottoNumberSet();
            lottoList.add(new Lotto(lottoNumberSet));
        }
        return lottoList;
    }

    private int getIssueLottoCnt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private Set<Integer> getLottoNumberSet() throws IOException {
        Set<Integer> numberSet = new HashSet<>(6);
        String[] numbersOfString = br.readLine().replaceAll(" ", "").split(",");
        for (String numberOfString: numbersOfString) {
            numberSet.add(Integer.parseInt(numberOfString));
        }

        return numberSet;
    }
}
