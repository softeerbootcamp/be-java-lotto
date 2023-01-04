package kr.codesquad.lotto.io;

import kr.codesquad.lotto.LottoNumber;
import kr.codesquad.lotto.LottoResult;
import kr.codesquad.lotto.Rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LottoIOManagerImpl implements LottoIOManager {

    private final BufferedReader br;

    public LottoIOManagerImpl() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public int readPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("금액은 숫자만 입력해야합니다.");
        }
    }

    @Override
    public int readLottoCount(String message) {
        print(message);
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    @Override
    public Set<LottoNumber> readLottoNumberSet(String message) {
        if (message.length() != 0) print(message);
        try {
            Set<LottoNumber> numberSet = new HashSet<>(6);
            String[] numbersOfString = br.readLine().replaceAll(" ", "").split(",");
            for (String numberOfString: numbersOfString) {
                LottoNumber lottoNumber = new LottoNumber(Integer.parseInt(numberOfString));
                numberSet.add(lottoNumber);
            }
            return numberSet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LottoNumber readLottoNumber(String message) {
        print(message);
        try {
            int lottoNumber = Integer.parseInt(br.readLine());
            return new LottoNumber(lottoNumber);
        } catch (IOException e) {
            throw new RuntimeException("숫자만 입력 가능합니다.");
        }
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printLottoResult(LottoResult lottoResult) {
        for (Rank rank: Rank.values()) {
            String stringOfBonus = rank == Rank.SECOND  ? ", 보너스 볼 일치" : "";
            System.out.println(rank.getCountOfMatch() + "개 일치" + stringOfBonus + "(" + rank.getWinningMoney() + "원) - " + lottoResult.getRankStatus().get(rank) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", lottoResult.getRate()) + "%입니다.");
    }
}
