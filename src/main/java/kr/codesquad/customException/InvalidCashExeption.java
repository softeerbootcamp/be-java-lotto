package kr.codesquad.customException;

import java.lang.RuntimeException;
public class InvalidCashExeption extends NumberFormatException{

    public InvalidCashExeption(){}

    public InvalidCashExeption(String msg)
    {
        super(msg);
    }
}
