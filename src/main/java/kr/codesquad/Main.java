package kr.codesquad;

import java.util.*;


public class Main {

    private static ArrayList<Integer> allNums;
    private static int purchasedPrice = 0;
    private static int numOfLotto = 0;
    private static Scanner scan;
    private static int bonus = 0;

    //initial method
    private static void initMethod(){
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

    private static void enterBonusNum(){
        System.out.println("보너스볼을 입력해 주세요.");
        bonus = scan.nextInt();
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
        enterBonusNum();

        ArrayList<ArrayList<Integer>> randomLottoList = randomLotto.getLottoList();
        ArrayList<Integer> myLottoList = myLotto.getLottoList().get(0);
        CalculateMatch calculateMatch = new CalculateMatch(randomLottoList, myLottoList, bonus);

        calculateMatch.startCalculate(numOfLotto);
        calculateMatch.printResult(purchasedPrice);
    }



}