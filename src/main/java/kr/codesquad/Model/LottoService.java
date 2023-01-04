package kr.codesquad.Model;

import java.util.*;
import java.math.*;

public class LottoService { //로또 자판기 클래스
    private BigInteger money;   //구입한 가격
    public BigDecimal earn = new BigDecimal("-100");    //수익
    private int lottoAmount;   //구입한 로또 갯수

    public Map<Price, Integer> winnerCount = new HashMap<>();
    List<Lotto> lottoList = new ArrayList<>();   //구입한 로또 저장소
    List<Integer> lottoNum = new ArrayList<>();  //로또 번호 1~45
    Lotto winLotto;

    public LottoService(BigInteger money) {
        this.money = money;
    }

    public void init(){
        for (int i=1; i<=45; i++)
            lottoNum.add(i);
        for (Price price:Price.values()){
            winnerCount.put(price,0);
        }
    }

    public int buyLotto(){
        lottoAmount = money.divide(new BigInteger("1000")).intValue();
        for (int i=0; i<lottoAmount; i++){
            Collections.shuffle(lottoNum);
            int[] lottoNumArr = setLottoNum(lottoNum);
            Lotto lotto = new Lotto(lottoNumArr);
            lotto.print();
            lottoList.add(lotto);
        }
        return lottoAmount;
    }

    private int[] setLottoNum(List<Integer> lottoNum) {
        int[] number = new int[6];
        for (int i=0; i<6; i++)
            number[i] = lottoNum.get(i);
        return number;
    }

    public void setWinNum(String winStr){
        int[] winNum = new int[6];
        String[] winStrArr = winStr.split(",");
        for (int i=0; i<6; i++)
            winNum[i] = Integer.parseInt(winStrArr[i].trim());
        winLotto  = new Lotto(winNum);
        setBonusNum();
    }
    private static void setBonusNum(){
        System.out.println("\n보너스 볼을 입력해 주세요.");    //, 처리 필요 -> string 활용
        Scanner sc = new Scanner(System.in);
        int bonus = sc.nextInt();
        Lotto.setBonus(bonus);  //보너스 번호 할당
    }
    void updateWinnerCount(Price price){
        int value = winnerCount.get(price)+1;
        winnerCount.put(price, value);
    }

    void updateEarn(Price price){
        earn = earn.add(new BigDecimal((price.getWinningMoney()/money.intValue())*100));
    }
    public void calcResult(){
        List<Integer> winList = Arrays.asList(winLotto.num);
        for (Lotto lotto : lottoList) {
            List<Integer> lottoNum = new ArrayList<Integer>(Arrays.asList(lotto.num));
            lottoNum.retainAll(winList);
            int countOfMatch = lottoNum.size(); //일치 갯수
            Price price = Price.valueOf(countOfMatch, lotto.bonusMatch());
            if (price == null) continue;
            updateWinnerCount(price);
            updateEarn(price);
        }
    }
}