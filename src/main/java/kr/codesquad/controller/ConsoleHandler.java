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
        userConsole = new UserConsole(user);
    }

    public int enterPurchasePrice(){
        int price = 0;
        try{
            price = userConsole.enterPurchasePrice();}
        catch (InputFormatException e){
            e.getMessage();
            enterPurchasePrice();}
        catch (InputRangeException e){
            e.getMessage();
            enterPurchasePrice();}
        return price;
    }

    public int enterSudongLottoNumber(){
        int lottoNum = 0;
        try{
            lottoNum = userConsole.enterSudongLottoNumber();}
        catch (InputFormatException e){
            e.getMessage();
            enterSudongLottoNumber();}
        catch (InputRangeException e){
            e.getMessage();
            enterSudongLottoNumber();}
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
        String lottoStr = userConsole.enterSudongLottoList();
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
            e.getMessage();
            enterSudongLottoNumber();}
        catch (InputRangeException e){
            e.getMessage();
            enterSudongLottoNumber();}
        return bonusNum;
    }
}
