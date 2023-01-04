package kr.codesquad;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App application = new App();
        application.play();
    }
}

enum LottoStatus{
    // 등수별 해당 등수가 되기 위한 정보 문자열과, 당첨 금액 정보를 담고 있는 열거체
    Fifth("3개 일치", 5000),
    Fourth("4개 일치", 50000),
    Third("5개 일치", 1500000),
    Second("5개 일치, 보너스 볼 일치", 30000000),
    First("6개 일치", 2000000000);

    LottoStatus(String val1, int val2)
    {
        setStatusString(val1);
        setWinningAmout(val2);
    }

    private String StatusString; // 상태메시지
    private int WinningAmout; // 당첨금액

    public String getStatusString() {
        return StatusString;
    }

    public void setStatusString(String statusString) {
        StatusString = statusString;
    }

    public int getWinningAmout() {
        return WinningAmout;
    }

    public void setWinningAmout(int winningAmout) {
        WinningAmout = winningAmout;
    }
}