package kr.codesquad.lottoStatistic;

import kr.codesquad.Rank;

import java.util.Map;

public interface Statistic {
    double countProfit(int money, Map<Rank, Integer> result);
}
