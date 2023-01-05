package kr.codesquad.service;

import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputFormatException;
import kr.codesquad.exception.InputRangeException;
import kr.codesquad.model.UserInfo;
import kr.codesquad.view.UserConsole;

import java.util.ArrayList;
import java.util.Set;

import static kr.codesquad.utils.Util.parseString;

/**
 * LottoController와 UserConsole을 연결하는 Handler
 */
public class UserConsoleService {

    private UserConsole userConsole;

    public UserConsoleService(UserInfo user){
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
            enterPurchasePrice();}
        catch (InputRangeException e){  //1000 미만의 값을 입력할 시
            System.out.println(e.getMessage());
            enterPurchasePrice();}
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
            enterSudongLottoNumber(purchasedNum);}
        catch (InputRangeException e){  //음수를 입력할 시
            System.out.println(e.getMessage());
            enterSudongLottoNumber(purchasedNum);}
        return lottoNum;
    }

    //수동으로 로또 번호를 입력할 시
    public ArrayList<Integer> enterSudongLottoList(){
        Set<Integer> lottoLists;
        try {
            String lottoStr = userConsole.enterSudongLottoList();
            lottoLists = parseString(lottoStr);}
        catch (NumberFormatException e){  //문자를 입력할 시
            throw new InputCountException("숫자형으로 입력해주세요");}
        if(lottoLists.size() != 6)   //로또 번호의 개수가 6개가 아닐 때
            throw new InputCountException("올바르지 않은 입력입니다");
        ArrayList<Integer> givenResult = new ArrayList<>(lottoLists);
        return givenResult;
    }

    //지난 주 당첨 번호 입력 시
    public ArrayList<Integer> enterResultList(){
        Set<Integer> lottoLists;
        try {
            String lottoStr = userConsole.enterSudongLottoList();
            lottoLists = parseString(lottoStr);}
        catch (NumberFormatException e){  //문자를 입력할 시
            throw new InputCountException("숫자형으로 입력해주세요");}
        if(lottoLists.size() != 6)   //로또 번호의 개수가 6개가 아닐 때
            throw new InputCountException("올바르지 않은 입력입니다");
        ArrayList<Integer> givenResult = new ArrayList<>(lottoLists);
        return givenResult;
    }


    //보너스볼 입력 시
    public int enterBonusNum(){
        int bonusNum = 0;
        try{
            bonusNum = userConsole.enterBonusNum();}
        catch (InputFormatException e){  //문자열을 입력할 경우
            System.out.println(e.getMessage());
            enterBonusNum();}
        catch (InputRangeException e){   //1-45이외의 숫자를 입력할 경우
            System.out.println(e.getMessage());
            enterBonusNum();}
        return bonusNum;
    }
}
