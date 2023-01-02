package kr.codesquad;

import java.util.*;


public class Main {

    private static ArrayList<ArrayList<Integer>> lottoList;
    private static ArrayList<Integer> allNums;
    private static ArrayList<String> resultNums;
    private static HashMap<Integer, Integer> hitNums;
    private static Integer[] fee = {5000, 50000, 1500000, 2000000000};
    private static int hitPrice = 0;
    private static int purchasedPrice = 0;
    private static int numOfLotto = 0;
    private static Scanner scan;

    //initial method
    private static void initMethod(){
        lottoList = new ArrayList<ArrayList<Integer>>();
        hitNums = new HashMap<>();
        resultNums = new ArrayList<>();
        allNums = new ArrayList<>();
        scan = new Scanner(System.in);
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    //generate random numbers of lotto
    private static void lottoGenerate() {
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
        lottoList.add(tempList);
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
    private static Integer containNum(ArrayList<Integer> tempList){
        int hitNum = 0;
        for(int j = 0 ; j < 6 ; j++){
            if(tempList.contains(Integer.parseInt(resultNums.get(j))))
                hitNum++;
        }
        return hitNum;
    }


    //count each rank of result
    private static void getHitStatistics(ArrayList<Integer> tempList) {
            int hitNum = containNum(tempList);
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
    private static void enterResultNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numStr = scan.nextLine();
        List<String> split = Arrays.asList(numStr.split(","));
        if(split.size() != 6)
            throw new RuntimeException("올바르지 않은 입력입니다");
        resultNums.addAll(split);
    }

    public static void main(String[] args) {
        initMethod();
        enterPurchasePrice();
        for(int i = 0 ; i < numOfLotto; i++){
            lottoGenerate();
        }
        try{
            enterResultNumbers();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        for(int i = 0; i < numOfLotto; i++)
            getHitStatistics(lottoList.get(i));
        printResult(purchasedPrice);
    }



}