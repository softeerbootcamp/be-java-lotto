package kr.codesquad;

import java.util.*;


class UserInput {

    private Scanner scan;
    private UserInfo user;

    public UserInput(UserInfo user){
        this.user = user;
        scan = new Scanner(System.in);
    }

    //구매 금액 입력
    public void enterPurchasePrice(){
        System.out.println("구입 금액을 입력해 주세요.");
        int purchasedPrice = scan.nextInt();
        int numOfLotto = purchasedPrice / 1000;
        scan.nextLine();
        user.setPurchasedPrice(purchasedPrice);
        user.setNumOfLotto(numOfLotto);
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }


    //당첨 번호 입력현
    public ArrayList<Integer> enterResultNumbers(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numStr = scan.nextLine();
        List<String> split = Arrays.asList(numStr.split(","));
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if(split.size() != 6)
            throw new RuntimeException("올바르지 않은 입력입니다");
        split.forEach(item->tempList.add(Integer.parseInt(item)));
        return tempList;
    }

    //보너스 번호 입력
    public void enterBonusNum(){
        System.out.println("보너스볼을 입력해 주세요.");
        int bonusNum = scan.nextInt();
        user.setBonus(bonusNum);
    }

}

public class Main {

    //initial method
    private static void initMethod(){

        UserInfo user = new UserInfo();
        UserInput userInput = new UserInput(user);
        Lotto randomLotto = new Lotto();
        Lotto myLotto = new Lotto();
        CalculateMatch calculateMatch = new CalculateMatch();

        //구매 금액 입력
        userInput.enterPurchasePrice();
        //로또 번호 생성 (랜덤)
        for(int i = 0 ; i < user.getNumOfLotto(); i++)
            randomLotto.addRandomLotto();
        //당첨 번호 입력
        myLotto.addLotto(userInput.enterResultNumbers());
        //보너스 번호 입력
        userInput.enterBonusNum();

        //당첨 여부 확인
        calculateMatch.startCalculate(randomLotto, myLotto, user.getNumOfLotto(), user.getBonus());
        //결과 출력
        calculateMatch.printResult(user.getPurchasedPrice());

    }

    public static void main(String[] args) {
        initMethod();
    }



}