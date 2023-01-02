package kr.codesquad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Utility {

    public static ArrayList generateRandomSixNumbers(){
        ArrayList<Integer> lotteryNumbers = new ArrayList<Integer>();
        Random random = new Random();
        while(lotteryNumbers.size() != 6){
            int temp = random.nextInt() % 45 + 1;
            if (!lotteryNumbers.contains(temp)){
                lotteryNumbers.add(temp);
            }
        }
        return lotteryNumbers;
    }

    public static int generateBonusNumber(ArrayList<Integer> random6Number){
        Random random = new Random();
        int temp = random.nextInt()%45 + 1;
        while(random6Number.contains(temp)){
            temp = random.nextInt()%45 + 1;
        }
        return temp;
    }
}
