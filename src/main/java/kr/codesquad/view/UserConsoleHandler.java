package kr.codesquad.view;

import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputFormatException;
import kr.codesquad.exception.InputRangeException;
import kr.codesquad.model.UserInfo;
import kr.codesquad.view.UserConsole;

import java.util.ArrayList;

import static kr.codesquad.utils.Util.stringToUniqueArrayList;

/**
 * LottoController와 UserConsole을 연결하는 Handler
 */
public class UserConsoleHandler {

    private UserConsole userConsole;

    public UserConsoleHandler(UserInfo user){
        user = user;
        userConsole = new UserConsole(user);
    }

    //구매 금액 입력
    public int enterPurchasePrice(){
        int price = 0;
        try{
            price = userConsole.enterPurchasePrice();}
        catch (InputFormatException e){  //문자열로 입력할 시
            System.out.println(e.getMessage());
            return enterPurchasePrice();}
        catch (InputRangeException e){  //1000 미만의 값을 입력할 시
            System.out.println(e.getMessage());
            return enterPurchasePrice();}
        return price;
    }

    //수동 로또 구매 개수 입력
    public int enterSudongLottoNumber(int purchasedNum){
        int lottoNum = 0;
        try{
            lottoNum = userConsole.enterSudongLottoNumber();
            if(lottoNum > purchasedNum)  //구매 금액을 초과하여 수동 구매 시
                throw new InputRangeException("구매 금액을 초과하였습니다.");}
        catch (InputFormatException e){  //문자열로 입력 시
            System.out.println(e.getMessage());
            return enterSudongLottoNumber(purchasedNum);}
        catch (InputRangeException e){  //음수를 입력할 시
            System.out.println(e.getMessage());
            return enterSudongLottoNumber(purchasedNum);}
        return lottoNum;
    }


    public ArrayList<Integer> enterLottoList(int type) throws InputCountException, InputFormatException{
        String lottoStr = "";
        if (type == 1)  //수동 로또 입력
            lottoStr =  userConsole.enterSudongLottoList();
        if (type == 2)  //당첨 번호 입력
            lottoStr = userConsole.enterResultList();
        ArrayList<Integer> lottoLists = stringToUniqueArrayList(lottoStr);
        return lottoLists;
    }

    //보너스볼 입력 시
    public int enterBonusNum(){
        int bonusNum = 0;
        try{
            bonusNum = userConsole.enterBonusNum();}
        catch (InputFormatException e){  //문자열을 입력할 경우
            System.out.println(e.getMessage());
            return enterBonusNum();}
        catch (InputRangeException e){   //1-45이외의 숫자를 입력할 경우
            System.out.println(e.getMessage());
            return enterBonusNum();}
        return bonusNum;
    }
}
