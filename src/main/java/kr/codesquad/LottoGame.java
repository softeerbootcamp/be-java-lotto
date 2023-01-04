package kr.codesquad;

import java.util.List;

public interface LottoGame {
    public boolean isBonusInLotto(List<Integer> lotto, int bonusBall);
    public void updateRankMap(Rank rank);
    public void getMatchCount(List<Integer> lotto, List<Integer> input,Integer bonusBall);
    public int calcMatchCount(List<Integer> list, Integer num, int resMatchCnt);
    public void calcRate(int lottoCnt);
    public void printResult(int lottoCnt);
}
