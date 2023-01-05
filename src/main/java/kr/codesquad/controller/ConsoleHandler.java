package kr.codesquad.controller;

import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputFormatException;
import kr.codesquad.exception.InputRangeException;
import kr.codesquad.model.UserInfo;
import kr.codesquad.view.UserConsole;

import java.util.ArrayList;
import java.util.Set;

import static kr.codesquad.utils.Util.parseString;

public class ConsoleHandler {

    private UserConsole userConsole;

    public ConsoleHandler(UserInfo user){
        user = user;
        userConsole = new UserConsole(user);
    }

    public int enterPurchasePrice(){
        int price = 0;
        try{
            price = userConsole.enterPurchasePrice();}
        catch (InputFormatException e){
            System.out.println(e.getMessage());
            enterPurchasePrice();}
        catch (InputRangeException e){
            System.out.println(e.getMessage());
            enterPurchasePrice();}
        return price;
    }

    public int enterSudongLottoNumber(int purchasedNum){
        int lottoNum = 0;
        try{
            lottoNum = userConsole.enterSudongLottoNumber();
            if(lottoNum > purchasedNum)
                throw new InputRangeException("구매 금액을 초과하였습니다.");}
        catch (InputFormatException e){
            System.out.println(e.getMessage());
            enterSudongLottoNumber(purchasedNum);}
        catch (InputRangeException e){
            System.out.println(e.getMessage());
            enterSudongLottoNumber(purchasedNum);}
        return lottoNum;
    }

    public ArrayList<Integer> enterSudongLottoList(){
        String lottoStr = userConsole.enterSudongLottoList();
        Set<Integer> lottoLists = parseString(lottoStr);
        if(lottoLists.size() != 6)
            throw new InputCountException("올바르지 않은 입력입니다");
        ArrayList<Integer> givenResult = new ArrayList<>(lottoLists);
        return givenResult;
    }

    public ArrayList<Integer> enterResultList(){
        String lottoStr = userConsole.enterResultList();
        Set<Integer> lottoLists = parseString(lottoStr);
        if(lottoLists.size() != 6)
            throw new InputCountException("올바르지 않은 입력입니다");
        ArrayList<Integer> givenResult = new ArrayList<>(lottoLists);
        return givenResult;
    }

    public int enterBonusNum(){
        int bonusNum = 0;
        try{
            bonusNum = userConsole.enterBonusNum();}
        catch (InputFormatException e){
            System.out.println(e.getMessage());
            enterBonusNum();}
        catch (InputRangeException e){
            System.out.println(e.getMessage());
            enterBonusNum();}
        return bonusNum;
    }
}
