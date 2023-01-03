package kr.codesquad;
import java.util.*;
import java.math.*;
import java.util.function.Consumer;
import java.util.function.Function;

class Lotto{
    private static int bonus = -1;
    Integer[] num = new Integer[6];
    boolean winLotto = false;
    Lotto(int[] lottoNum){
        for (int i=0; i<6; i++)
            num[i] = lottoNum[i];
        Arrays.sort(num);
    }

    Lotto(int[] lottoNum, boolean winLotto){
        this(lottoNum);
        this.winLotto = winLotto;
    }
    public boolean bonusMatch(){
        return Arrays.asList(num).contains(bonus);
    }

    public static void setBonus(int bonus) {
        if (bonus <= 0 || bonus > 45){
            System.out.println("Wrong Bonus Number");
            System.exit(1);
        }
        Lotto.bonus = bonus;
    }

    public void print() {
        System.out.print("[");
        for (int i=0; i<5; i++)
            System.out.print(num[i] + ", ");
        System.out.println(num[5]+"]");
    }
}
public class LottoService {
    private static BigInteger money;   //구입한 가격
    private static BigDecimal earn = new BigDecimal("-100");    //수익
    private static int lotto_amount;   //구입한 로또 갯수
    public enum Price{
        FOURTH(3, 5000),
        THIRD(4, 50000),
        SECOND(5, 1500000),
        BONUS(5, 30000000),
        FIRST(6, 2000000000);
        private int countOfMatch;   //일치 개수
        private double winningMoney;   //상금
        public int getCountOfMatch() {
            return countOfMatch;
        }

        public double getWinningMoney() {
            return winningMoney;
        }

        Price(int countOfMatch, double winningMoney){
            this.countOfMatch = countOfMatch;
            this.winningMoney = winningMoney;
        }

        //if문 없애야함.. indent 제한..
        public static Price valueOf(int countOfMatch, boolean matchBonus){
            Price[] prices = values();
            Price rtnPrice = null;
            for (Price price: prices)
                rtnPrice = calcPrice(rtnPrice, price, countOfMatch, matchBonus);
            return rtnPrice;
        }

        private static Price calcPrice(Price rtnPrice, Price price, int countOfMatch, boolean matchBonus){
            if (rtnPrice != null) return rtnPrice;
            if (countOfMatch == SECOND.countOfMatch)   //2등 or 보너스
                rtnPrice = matchBonus?BONUS:SECOND;
            if (price.countOfMatch == countOfMatch)
                rtnPrice = price;
            return rtnPrice;
        }
    }
    static Map<Price, Integer> winnerCount = new HashMap<>();
    static List<Lotto> lottoList = new ArrayList<>();   //구입한 로또 저장소
    static List<Integer> lottoNum = new ArrayList<>();  //로또 번호 1~45
    static Lotto winLotto;
    public static void start(){
        init();
        setMoney();
        buyLotto();
        setWinNum();
        calcResult();
        printResult();
    }
    public static void init(){
        for (int i=1; i<=45; i++)
            lottoNum.add(i);
        for (Price price:Price.values()){
            winnerCount.put(price,0);
        }
    }

    public static void setMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            Scanner sc = new Scanner(System.in);
            BigInteger money = sc.nextBigInteger();
            LottoService.money = money;
        } catch (Exception e){
            System.out.println("error");
        }
    }

    public static void buyLotto() {
        LottoService.lotto_amount = money.divide(new BigInteger("1000")).intValue();
        System.out.println(lotto_amount+"개를 구매했습니다.");
        for (int i=0; i<lotto_amount; i++){
            Collections.shuffle(lottoNum);
            int[] lottoNumArr = setLottoNum(lottoNum);
            Lotto lotto = new Lotto(lottoNumArr);
            lotto.print();
            lottoList.add(lotto);
        }
    }

    private static int[] setLottoNum(List<Integer> lottoNum) {
        int[] number = new int[6];
        for (int i=0; i<6; i++)
            number[i] = lottoNum.get(i);
        return number;
    }

    private static void setWinNum(){
        System.out.println("\n당첨 번호를 입력해 주세요.");    //, 처리 필요 -> string 활용
        Scanner sc = new Scanner(System.in);
        int[] winNum = new int[6];
        String winStr = sc.nextLine();
        String[] winStrArr = winStr.split(",");
        for (int i=0; i<6; i++)
            winNum[i] = Integer.parseInt(winStrArr[i].trim());
        winLotto  = new Lotto(winNum, true);
        setBonusNum();
    }
    private static void setBonusNum(){
        System.out.println("\n보너스 볼을 입력해 주세요.");    //, 처리 필요 -> string 활용
        Scanner sc = new Scanner(System.in);
        int bonus = sc.nextInt();
        Lotto.setBonus(bonus);  //보너스 번호 할당
    }
    static void updateWinnerCount(Price price){
        int value = winnerCount.get(price)+1;
        winnerCount.put(price, value);
    }

    static void updateEarn(Price price){
        earn = earn.add(new BigDecimal((price.getWinningMoney()/money.intValue())*100));
    }
    private static void calcResult(){
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

    static void bonusPrint(Price price){
        if (price == Price.BONUS)
            System.out.print(", 보너스 볼 일치");
    }
    private static void printResult(){
        System.out.println("\n당첨 통계\n---------");
        //보너스를 어떻게 표시하지? indent depth 1로
        for (Price price:Price.values()){
            System.out.print(price.getCountOfMatch()+"개 일치");
            bonusPrint(price);
            System.out.println(" ("+(int)price.getWinningMoney()+")- "+winnerCount.get(price)+"개");
        }
        System.out.println("총 수익률은 "+earn.setScale(2,RoundingMode.FLOOR)+"%입니다.");
    }
}