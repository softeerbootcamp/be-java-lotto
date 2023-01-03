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

  private List<List<Integer>> lottos;
  private ArrayList<Integer> inputs;
  private int lottoCnt;
  private int bonusBall;
  List<Integer> numList;

  Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
  int match3;
  int match4;
  int match5;

  int secondWin;
  int match6;

  public void initialMap(){
    Rank[] ranks = Rank.values();
    for(Rank rank : ranks){
      rankMap.put(rank,0);
    }
  }

  public void printMap(){
    for(Rank key : rankMap.keySet()){
      Integer value = rankMap.get(key);
      System.out.println(key + ": "+value);
    }
  }

  public Lotto() {
    lottos = new ArrayList<>();
    inputs = new ArrayList<>();
    numList = new ArrayList<>();
    for(int j=1;j<46;j++) numList.add(j);
    initialMap();
    match3=0;
    match4=0;
    match5=0;
    secondWin=0;
    match6=0;
  }

  public void start(){
    //1. 당첨 금액 입력 받기
    Integer amountOfMoney = getAmountOfMoney();
    //2. 전체 복권 개수 계산해서 변수에 저장
    getLottoCount(amountOfMoney);
    //3. 셔플로 복권 만들기
    getLottos();
    //4. 사용자로부터 복권 입력 - 지난 주 당첨 번호- 받기
    getLottoInput();
    //5. 보너스 볼 입력 받기
    this.bonusBall = getBonusLottoInput();
    System.out.println(this.bonusBall);
    System.out.println(inputs);
    //5. 비교
    compareLottos(lottos,inputs);
    printMap();
    //6. 결과 출력
    printResult();
  }

  public Integer getAmountOfMoney(){
    System.out.println("구입금액을 입력해주세요. ");
    Scanner sc = new Scanner(System.in);
    int amountOfMoney = sc.nextInt();
    return amountOfMoney;
  }

  public void getLottoCount(int amountOfMoney){
    lottoCnt = amountOfMoney/1000; // 총 로또 개수
    System.out.println("총"+lottoCnt+"개를 구매했습니다.");
  }


  public void getLottos(){
    for(int i=0;i<lottoCnt;i++){
      getLottoByShuffle();
    }
    System.out.println(lottos);
  }

  public void getLottoByShuffle(){
    Collections.shuffle(numList); //1에서 46까지를 셔플
    List<Integer> shuffledNumList =  new ArrayList<>(numList.subList(0,6));
    Collections.sort(shuffledNumList);
    lottos.add(shuffledNumList);
  }

  public void getLottoInput(){
    System.out.println("당첨 번호를 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    String inputNumbers = sc.nextLine();
    for(String input : inputNumbers.split(", ")){
      inputs.add(Integer.valueOf(input));
    }
  }

  public Integer getBonusLottoInput() {
    System.out.println("보너스 볼을 입력해주세요. ");
    Scanner sc = new Scanner(System.in);
    int bonusBall = sc.nextInt();
    //inputs.add(bonusBall);
    return bonusBall;
  }

  public void compareLottos(List<List<Integer>> lottoLists, List<Integer> inputList){
    for(int i=0;i<lottoCnt;i++){
      System.out.println(lottoLists.get(i));
      getMatchCount(lottoLists.get(i), inputList);//각 로또마다 매치 개수 구하기
    }
  }

  public boolean isBonusInLotto(List<Integer> lotto){
    if(lotto.contains(bonusBall)) return true;
    return false;
  }

  public void updateRankMap(Rank rank){
    int oldVal = this.rankMap.get(rank);
    rankMap.put(rank,oldVal++);
  }

  public void getMatchCount(List<Integer> lotto, List<Integer> input){
    int matchCnt = 0;
    boolean isBonus = isBonusInLotto(lotto);
    for(int num : input) matchCnt = calcMatchCount(lotto,num,matchCnt);//하나의 로또에 대해 사용자의 각 숫자 중 몇 개가 일치되는 것인지 카운트
    System.out.println(matchCnt);
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
  public void printResult(){
    System.out.println("당첨 통계");
    System.out.println("-----");
    System.out.println("3개 일치 (5000원) - " + match3);
    System.out.println("4개 일치 (50000원) - " + match4);
    System.out.println("5개 일치 (1500000원) - " + match5);
    System.out.println("5개 일치, 보너스 볼 일치 (30000000원) - " + secondWin);
    System.out.println("6개 일치 (2000000000원) - " + match6);
    double sumOfWin = match3 * 5000 + match4 * 50000 + match5 * 1500000 + match6 * 2000000000;
    double cost = lottoCnt*1000;
    System.out.println(String.format("%.2f",((sumOfWin - cost) / cost) * 100)+"%");
  }

}

public abstract class Main {

  public static void main(String[] args) {
    Lotto lotto = new Lotto();
    lotto.start();
  }

}