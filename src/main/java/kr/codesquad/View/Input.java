package kr.codesquad.View;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);
    public static int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }
}
