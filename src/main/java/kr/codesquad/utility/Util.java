package kr.codesquad.utility;

import kr.codesquad.IO.Console;
import kr.codesquad.customException.AlreadyHasSameNumberException;
import kr.codesquad.customException.InvalidInputException;
import kr.codesquad.customException.LottoMustHas6NumbersException;
import kr.codesquad.customException.OutOfRangeException;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static ArrayList<Integer> splitTo6Integers(String beforeSplited)
    {
        String splitedNums[] = beforeSplited.split(", ");
        if(splitedNums.length != 6)
            throw new LottoMustHas6NumbersException("6개로 쪼갤 수 있는 입력이어야 합니다.\n입력 형식은 다음과 같습니다 ex) 1, 2, 3, 4, 5, 6\n다시입력하세요");

        ArrayList<Integer> afterSplited = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++)
        {
            afterSplited.add(toInt(splitedNums[i], Console.ScanContext.MANUALBALL));
            checkBallIsInRange(afterSplited.get(i));
            checkAlreadySelected(afterSplited.subList(0, i), afterSplited.get(i));
        }
        return afterSplited;
    }
    public static void checkAlreadySelected(String LottoNums, int ball)
    {
        ArrayList<Integer> afterSplit = new ArrayList<Integer>();
        String splitNum[] = LottoNums.split(", ");

        for(int i = 0; i < splitNum.length; i++) afterSplit.add(Integer.parseInt(splitNum[i]));

        if(afterSplit.contains(ball))
            throw new AlreadyHasSameNumberException("이미 같은 수의 공이 뽑혔습니다. 다른 번호를 입력하세요");
    }
    public static void checkAlreadySelected(List<Integer> LottoNums, int ball)
    {
        if(LottoNums.contains(ball))
            throw new AlreadyHasSameNumberException("같은 수를 두개 이상 적을 수 없습니다. 다른 번호를 입력하세요");
    }

    public static void checkBallIsInRange(int ball)
    {
        if(ball < 1 || ball > 45)
            throw new OutOfRangeException("1 ~ 45 범위를 넘어가는 입력입니다. 다시 입력하세요.");
    }


    public static int toInt(String str, Console.ScanContext context) throws NumberFormatException
    {
        int ret = Integer.parseInt(str);
        if(context == Console.ScanContext.CASH  && (ret <= 0 || ret % 1000 != 0))
            throw new InvalidInputException("유효한 숫자 입력이 아닙니다. 1000원 단위의 금액을 입력하세요");
        return ret;
    }

    public static int toInt(String str, Console.ScanContext context, int userCash) throws NumberFormatException
    {
        int ret = Integer.parseInt(str);
        if(context == Console.ScanContext.MANUAL&& (ret < 0 || ret > userCash/1000))
            throw new InvalidInputException("음수개를 구매하거나, 구매 가능 개수를 초과하여 구매할 수 없습니다. 올바른 값으로 다시 입력하세요.");
        if(context == Console.ScanContext.BONUS && (ret < 1 || ret > 45))
            throw new OutOfRangeException("로또 범위 내(1 ~ 45)에 있는 숫자를 입력하세요");
        return ret;
    }
}
