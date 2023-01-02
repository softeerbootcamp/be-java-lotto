package kr.codesquad;

import java.util.*;

public class Main {
    public static int compareValue(int value1, int value2){
        if(value1 == value2) return 1;
        return 0;
    }
    public static int getScore(ArrayList<Integer> lottoNumList, ArrayList<Integer> winLottoNum){
        int score = 0;
        for(int i = 0;i<6;i++){
            score += compareValue(lottoNumList.get(i), winLottoNum.get(i));
        }
        return score;
    }

    public static void addScoreList(int scoreList[], int score) {
        if (score == 3) scoreList[3]++;
        if (score == 4) scoreList[4]++;
        if (score == 5) scoreList[5]++;
        if (score == 6) scoreList[6]++;
    }

    public static void printScore(int scoreList[]){
        System.out.println("3개 일치 (5000원) - " + scoreList[3] + "개");
        System.out.println("4개 일치 (50000원) - " + scoreList[4] + "개");
        System.out.println("5개 일치 (1500000원) - " + scoreList[5] + "개");
        System.out.println("6개 일치 (2000000000원) - " + scoreList[6] + "개");
    }

    public static void printRate(int scoreList[], int price){
        int totalWinPrice = scoreList[3] * 5000 + scoreList[4] * 50000 +
                scoreList[5] * 1500000 + scoreList[6] * 2000000000;
        // 수익률 계산 = 딴 돈 / 낸 돈  백분율
        double winRate = (double)totalWinPrice / price * 100;
        // 손해일 경우 - 100
        // 기존의 30퍼센트 = -70퍼센트
        if(totalWinPrice < price) winRate -= 100.0;

        System.out.println("총 수익률은 " + String.format("%.2f",winRate) + "%입니다.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price;
        System.out.println("구입금액을 입력해 주세요.");
        price = sc.nextInt();

        int count;
        count = price/1000;
        System.out.println(count + "개를 구매했습니다.");

        // 로또 번호 1 ~ 45를 저장할 리스트 생성
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for(int n = 1;n<=45;n++){
            numberList.add(n);
        }

        // count 만큼의 로또 번호 생성
        ArrayList<ArrayList<Integer>> lottoBuyList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> lottoBuy;
        for(int i = 0;i<count;i++){
            // 번호 섞기
            Collections.shuffle(numberList);
            lottoBuy = new ArrayList<>(numberList.subList(0,6));

            // 번호 정렬
            Collections.sort(lottoBuy);

            // 로또 구매 리스트에 추가
            lottoBuyList.add(lottoBuy);
        }

        for(int i = 0;i<lottoBuyList.size();i++){
            // 출력
            System.out.println(lottoBuyList.get(i));
        }

        // 입력 버퍼 비우기
        sc.nextLine();

        System.out.println("\n당첨 번호를 입력해 주세요");
        String[] winLottoNumString = sc.nextLine().split(", ");
        ArrayList<Integer> winLottoNum = new ArrayList<Integer>();
        for(int i = 0;i<6;i++){
            winLottoNum.add(Integer.parseInt(winLottoNumString[i]));
        }

        //System.out.println(winLottoNum);

        // 당첨 통계
        System.out.println("\n당첨 통계\n----------");
        int scoreList[] = {0, 0, 0, 0, 0, 0, 0};
        for(int i = 0;i<lottoBuyList.size();i++){
            int score = getScore(lottoBuyList.get(i), winLottoNum);
            addScoreList(scoreList, score);
        }

        printScore(scoreList);
        printRate(scoreList, price);


    }
}