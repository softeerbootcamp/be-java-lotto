package kr.codesquad;

import java.util.List;

public interface LottoGame {
    boolean isBonusInLotto(List<Integer> lotto, int bonusBall);
    void updateRankMap(Rank rank);
    void checkRankForUpdate(Rank rank,int matchCnt);
    void updateRankByMatchCnt(int matchCnt);
    void getMatchCount(List<Integer> lotto, List<Integer> input,Integer bonusBall);
    int calcMatchCount(List<Integer> list, Integer num, int resMatchCnt);
    void calcRate(int lottoCnt);
    void printResult(int lottoCnt);
}
