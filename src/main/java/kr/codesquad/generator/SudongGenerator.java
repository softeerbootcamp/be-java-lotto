package kr.codesquad.generator;

import kr.codesquad.view.UserConsoleHandler;
import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputFormatException;

import java.util.ArrayList;

public class SudongGenerator implements LottoGenerator {

    private UserConsoleHandler userConsoleHandler;
    private int type;

    public SudongGenerator(UserConsoleHandler userConsoleHandler){
        this.userConsoleHandler = userConsoleHandler;
    }

    public void setType(int type){
        this.type = type;
    }

    @Override
    public ArrayList<Integer> generateLotto() {
        ArrayList<Integer> sudongLottoList = new ArrayList<>();
        try{
            sudongLottoList = userConsoleHandler.enterLottoList(this.type);}
        catch(InputCountException e){
            System.out.println(e.getMessage());
            return generateLotto();}
        catch (InputFormatException e){
            System.out.println(e.getMessage());
            return generateLotto();}
        return sudongLottoList;
    }
}
