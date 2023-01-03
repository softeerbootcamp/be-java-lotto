package kr.codesquad;
import java.util.*;
import java.math.*;

class Lotto{
    private static int bonus = -1;
    Integer[] num = new Integer[6];
    Lotto(int[] lottoNum){
        for (int i=0; i<6; i++)
            num[i] = lottoNum[i];
        Arrays.sort(num);
    }

    public static int getBonus() {
        return bonus;
    }

    public static void setBonus(int bonus) {
        Lotto.bonus = bonus;
    }

    public void print() {
        System.out.print("[");
        for (int i=0; i<5; i++){
            System.out.print(num[i] + ", ");
        }
        System.out.println(num[5]+"]");
    }
}
public class LottoService {
    private static BigInteger money;   //구입한 가격
    private static BigDecimal earn = new BigDecimal("-100");    //수익
    private static int lotto_amount;   //구입한 로또 갯수
    private static int[] sameNumber = new int[7];    //당첨 통계 (일치 갯수)
    private static final double[] price = {0,0,0,5000,50000,1500000,2000000000};
    static List<Lotto> lottoList = new ArrayList<>();   //구입한 로또 저장소
    static List<Integer> lottoNum = new ArrayList<>();  //로또 번호 1~45
    static List<Integer> winNum = new ArrayList<>();    //로또 당첨 번호
    public static void start(){
        initLottoNum();
        setMoney();
        buyLotto();
        setWinNum();
        calcResult();
        printResult();
    }
    public static void initLottoNum(){
        for (int i=1; i<=45; i++)
            lottoNum.add(i);
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
        winNum.clear();
        String winStr = sc.nextLine();
        String[] winStrArr = winStr.split(",");
        for (int i=0; i<6; i++){
            int num = Integer.parseInt(winStrArr[i].trim());
            winNum.add(num);
        }
        setBonusNum();
    }
    private static void setBonusNum(){
        System.out.println("\n보너스 볼을 입력해 주세요.");    //, 처리 필요 -> string 활용
        Scanner sc = new Scanner(System.in);
        int bonus = sc.nextInt();
        Lotto.setBonus(bonus);  //보너스 번호 할당
    }
    private static void calcResult(){
        for (Lotto lotto : lottoList) {
            List<Integer> lottoNum = new ArrayList<Integer>(Arrays.asList(lotto.num));
            lottoNum.retainAll(winNum);
            int same = lottoNum.size();
            sameNumber[same]++;
            earn = earn.add(new BigDecimal((price[same]/money.intValue())*100));
        }
    }

    private static void printResult(){
        System.out.println("\n당첨 통계\n---------");
        for (int i=3; i<=6; i++)
            System.out.println(i+"개 일치 ("+(int)price[i]+")- "+sameNumber[i]+"개");
        System.out.println("총 수익률은 "+earn.setScale(2,RoundingMode.FLOOR)+"%입니다.");
    }
}

/*
100원으로 500원 만들면 수익률 500%? 400%?
 */