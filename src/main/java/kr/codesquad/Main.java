package kr.codesquad;

import java.util.*;


public class Main {

    private static ArrayList<Integer> allNums;
    private static HashMap<Integer, Integer> hitNums;
    private static Integer[] fee = {5000, 50000, 1500000, 2000000000};
    private static int hitPrice = 0;
    private static int purchasedPrice = 0;
    private static int numOfLotto = 0;
    private static Scanner scan;

    //initial method
    private static void initMethod(){
        hitNums = new HashMap<>();
        allNums = new ArrayList<>();
        scan = new Scanner(System.in);
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    //generate random numbers of lotto
    private static ArrayList<Integer> lottoGenerate() {
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
        return tempList;
    }

    //print result of all lotteries
    private static void printResult(int purchasedPrice) {
        for(int i = 3; i < 7; i++){
            int hitNum = hitNums.getOrDefault(i, 0);
            System.out.printf("%d개 일치 (%d원) - %d개\n", i, fee[i-3], hitNum);
            hitPrice = hitNum * fee[i-3];
        }
        int profit = hitPrice - purchasedPrice;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (float)profit/purchasedPrice*100);
    }


    //check the result of each lottery
    private static int containNum(int target, ArrayList<Integer> tempList){
        if (tempList.contains(target))
            return 1;
        return 0;
    }


    //count each rank of each result
    private static void getHitStatistics(ArrayList<Integer> resultNums, ArrayList<Integer> tempList) {
            int hitNum = 0;
            for(int i = 0; i < 6; i++)
                hitNum += containNum(resultNums.get(i), tempList);
            hitNums.put(hitNum, hitNums.getOrDefault(hitNum, 0) + 1);
    }


    //enter the total price of purchasing
    private static int enterPurchasePrice(){
        System.out.println("구입 금액을 입력해 주세요.");
        purchasedPrice = scan.nextInt();
        scan.nextLine();
        numOfLotto = purchasedPrice / 1000;
        System.out.println(numOfLotto + "개를 구매했습니다.");
        return numOfLotto;
    }

    //enter numbers of result
    private static ArrayList<Integer> enterResultNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numStr = scan.nextLine();
        List<String> split = Arrays.asList(numStr.split(","));
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if(split.size() != 6)
            throw new RuntimeException("올바르지 않은 입력입니다");
        split.forEach(item->tempList.add(Integer.parseInt(item)));
        return tempList;
    }

    public static void main(String[] args) {
        initMethod();
        enterPurchasePrice();

        Lotto randomLotto = new Lotto();
        Lotto myLotto = new Lotto();

        for(int i = 0 ; i < numOfLotto; i++){
            randomLotto.addLotto(lottoGenerate());
        }

        myLotto.addLotto(enterResultNumbers());

        for(int i = 0; i < numOfLotto; i++)
            getHitStatistics(myLotto.getLottoList().get(0), randomLotto.getLottoList().get(i));
        printResult(purchasedPrice);
    }



}