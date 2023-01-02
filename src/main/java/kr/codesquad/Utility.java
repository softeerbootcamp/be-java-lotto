package kr.codesquad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Utility {

    public static ArrayList generateRandomSixNumbers(){
        ArrayList<Integer> lotteryNumbers = new ArrayList<int>();
        Random random = new Random();
        while(lotteryNumbers.size() != 6){
            int temp = random.nextInt() % 45 + 1;
            if (!lotteryNumbers.contains(temp)){
                lotteryNumbers.add(temp);
            }
        }
        return lotteryNumbers;
    }

}
