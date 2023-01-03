package kr.codesquad;

import java.util.*;

enum Rank{

  FIRST(6,2000000000),
  SECOND(5,30000000),
  THIRD(5,1500000),
  FOURTH(4,50000),
  FIFTH(3,500);

  private int countOfMatch;
  private int winningMoney;

  private Rank(int countOfMatch, int winningMoney){
    this.countOfMatch = countOfMatch;
    this.winningMoney= winningMoney;
  }

  public int getCountOfMatch(){
    return countOfMatch;
  }

  public int getWinningMoney(){
    return winningMoney;
  }

}

class Lotto{

  User user;
  LottoMachine machine;
  Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);

  public void initialMap(){
    Rank[] ranks = Rank.values();
    for(Rank rank : ranks){
      rankMap.put(rank,0);
    }
  }

  public Lotto(LottoMachine machine, User user) {
    this.machine = machine;
    this.user = user;
    initialMap();
  }

  public void start(){
    //1. 당첨 금액 입력 받기
    Integer amountOfMoney = machine.getAmountOfMoney();
    //2. 전체 복권 개수 계산해서 변수에 저장
    Integer lottoCnt = machine.getLottoCount(amountOfMoney);
    //3. 셔플로 복권 만들기
    List<List<Integer>> lottos = machine.getLottos();
    //4. 사용자로부터 복권 입력 - 지난 주 당첨 번호- 받기
    List<Integer> inputs = user.getLottoInput();
    //5. 보너스 볼 입력 받기
    Integer bonusBall = user.getBonusLottoInput();
    //5. 비교
    compareLottos(lottoCnt,lottos,inputs,bonusBall);
    //6. 결과 출력
    printResult(lottoCnt);
  }


  public void compareLottos(int lottoCnt, List<List<Integer>> lottoLists, List<Integer> inputList,int bonusBall){
    for(int i=0;i<lottoCnt;i++){
      getMatchCount(lottoLists.get(i), inputList,bonusBall);//각 로또마다 매치 개수 구하기
    }
  }

  public boolean isBonusInLotto(List<Integer> lotto,int bonusBall){
    if(lotto.contains(bonusBall)) return true;
    return false;
  }

  public void updateRankMap(Rank rank){
    int oldVal = rankMap.get(rank);
    rankMap.put(rank,++oldVal);
  }

  public void getMatchCount(List<Integer> lotto, List<Integer> input,Integer bonusBall){
    int matchCnt = 0;
    boolean isBonus = isBonusInLotto(lotto,bonusBall);
    for(int num : input) matchCnt = calcMatchCount(lotto,num,matchCnt);//하나의 로또에 대해 사용자의 각 숫자 중 몇 개가 일치되는 것인지 카운트
    if(matchCnt == 3) updateRankMap(Rank.FIFTH);
    else if(matchCnt ==4) updateRankMap(Rank.FOURTH);
    else if(matchCnt ==5 && isBonus) updateRankMap(Rank.SECOND);
    else if(matchCnt == 5) updateRankMap(Rank.THIRD);
    else if(matchCnt ==6) updateRankMap(Rank.FIRST);
  }

  public int calcMatchCount(List<Integer> list, Integer num, int resMatchCnt){
    if(list.contains(num)) resMatchCnt++;
    return resMatchCnt;
  }

  public void calcRate(int lottoCnt){
    double sumOfWin = rankMap.get(Rank.FIFTH) * Rank.FIFTH.getWinningMoney() + rankMap.get(Rank.FOURTH) * Rank.FOURTH.getWinningMoney()
                    + rankMap.get(Rank.THIRD) * Rank.THIRD.getWinningMoney() + rankMap.get(Rank.SECOND) * Rank.SECOND.getWinningMoney()
                    + rankMap.get(Rank.FIRST) * Rank.FIRST.getWinningMoney();
    double cost = lottoCnt*1000;
    System.out.println("총 수익률은 "+String.format("%.2f",((sumOfWin - cost) / cost) * 100)+"% 입니다");
  }

  public void printResult(int lottoCnt){
    System.out.println("당첨 통계");
    System.out.println("-----");
    System.out.println("3개 일치 (5000원) - " + rankMap.get(Rank.FIFTH));
    System.out.println("4개 일치 (50000원) - " + rankMap.get(Rank.FOURTH));
    System.out.println("5개 일치 (1500000원) - " + rankMap.get(Rank.THIRD));
    System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + rankMap.get(Rank.SECOND));
    System.out.println("6개 일치 (2000000000원) - " + rankMap.get(Rank.FIRST));
    calcRate(lottoCnt);
  }

}

public abstract class Main {

  public static void main(String[] args) {
    LottoMachine machine = new LottoMachine();
    User user = new User();
    Lotto lotto = new Lotto(machine,user);
    lotto.start();
  }
}