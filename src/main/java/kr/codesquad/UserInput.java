package kr.codesquad;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {
    private final BufferedReader br;

    public UserInput() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
}
