package kr.codesquad;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGameImpl implements LottoGame{

    private User user;
    private LottoMachine machine;
    private LastLotto lastLotto;
    private Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);

    public void initialMap(){
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks){
            rankMap.put(rank,0);
        }
    }

    public LottoGameImpl(LottoMachine machine, User user,LastLotto lastLotto) {
        this.machine = machine;
        this.user = user;
        this.lastLotto = lastLotto;
        initialMap();
    }

    public void start(){
        //1. 구입 금액 입력 받기
        Integer amountOfMoney = machine.getAmountOfMoney();
        //2. 수동으로 구매할 로또 수 입력받기
        int manualLottoCnt = user.getLottoCnt(amountOfMoney,0);
        //2-1. 자동으로 구매할 로또 수 계산해서 저장
        Integer lottoCnt = machine.getLottoCnt(amountOfMoney,manualLottoCnt);
        int totalCnt = manualLottoCnt+lottoCnt;
        //3. 최종 로또들 출력
        //3-1.수동으로 구매한 로또반환
        ArrayList<ArrayList<Integer>> manualLottos =user.getLottoList();
        //3-2.자동으로 구매한 로또 리스트 반환하기
        ArrayList<ArrayList<Integer>> lottos = machine.getLottoList();
        lottos.addAll(manualLottos);
        System.out.println("수동으로 "+manualLottoCnt+"장, 자동으로 "+lottoCnt+"개를 구매했습니다. ");
        printLottos(lottos,totalCnt);
        //4.지난 주 당첨 번호 입력 받기
        List<Integer> inputs = lastLotto.getLastLotto();
        //5. 보너스 볼 입력 받기
        Integer bonusBall = user.getBonusLottoInput();
        //6. 비교
        compareLottos(totalCnt,lottos,inputs,bonusBall);
        //7. 결과 출력
        printResult(lottoCnt);
    }

    public void printLottos(ArrayList<ArrayList<Integer>> list, int totalCnt){
        for(int i=0;i<totalCnt;i++){
            System.out.println(list.get(i));
        }
    }

    public void compareLottos(int lottoCnt, ArrayList<ArrayList<Integer>> lottoLists, List<Integer> inputList,int bonusBall){
        for(int i=0;i<lottoCnt;i++){
            System.out.println(lottoLists.get(i));
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

    public void checkRankForUpdate(Rank rank,int matchCnt){
        if(rank.getCountOfMatch() == matchCnt){
            updateRankMap(rank);
        }
    }

    public void updateRankByMatchCnt(int matchCnt){
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks){
            checkRankForUpdate(rank, matchCnt);
        }
    }

    public void getMatchCount(List<Integer> lotto, List<Integer> input,Integer bonusBall){
        int matchCnt = 0;
        boolean isBonus = isBonusInLotto(lotto,bonusBall);
        for(int num : input) matchCnt = calcMatchCount(lotto,num,matchCnt);//하나의 로또에 대해 사용자의 각 숫자 중 몇 개가 일치되는 것인지 카운트
        System.out.println(matchCnt);
        if(matchCnt != 5 && matchCnt >=3) updateRankByMatchCnt(matchCnt);
        else if(matchCnt ==5 && isBonus) updateRankMap(Rank.SECOND);
        else if(matchCnt == 5) updateRankMap(Rank.THIRD);

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
