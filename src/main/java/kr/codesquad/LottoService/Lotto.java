package kr.codesquad.LottoService;

import kr.codesquad.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    Rank getMatchRank(Set<Integer> wonNumberList, int bonusNumber) {
        int matchNumberCount =  (int)numbers.stream().filter(wonNumberList::contains).count();
        if (matchNumberCount == Rank.FIRST.getCountOfMatch())
            return Rank.FIRST;
        if (matchNumberCount == Rank.SECOND.getCountOfMatch() || matchNumberCount == Rank.THIRD.getCountOfMatch())
            return numbers.contains(bonusNumber) ? Rank.SECOND : Rank.THIRD;
        if (matchNumberCount == Rank.FOURTH.getCountOfMatch())
            return Rank.FOURTH;
        if (matchNumberCount == Rank.FIFTH.getCountOfMatch())
            return Rank.FIFTH;
        return Rank.ETC;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
