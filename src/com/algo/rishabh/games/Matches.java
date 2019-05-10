package com.algo.rishabh.games;

import java.io.BufferedReader;
import java.io.IOException;

public class Matches {

    private BufferedReader br;
    private long a;
    private long b;
    private static final String RICH ="Rich";
    private static final String ARI ="Ari";

    Matches(BufferedReader br) {
        this.br = br;
    }

    public void processInput() throws IOException {
        String ab[] = br.readLine().split(" ");
        a = Long.parseLong(ab[0]);
        b = Long.parseLong(ab[1]);
    }

    public String getWinner() {

        return recurse(a,b)==1?RICH:ARI;

    }

    private int recurse(long a, long b) {
        long cnt;
        int ret;

        if (a % b == 0 || b % a == 0) {
            return 0;
        }

        if (a >= b) {
            cnt = a / b;
            ret=recurse(a-b*cnt,b);//a-b*cnt for a%b , as a%b is heavy operation
        }
        else
        {
            cnt=b/a;
            ret=recurse(a,b-a*cnt); //b-a*cnt for b%a ,as b%a is heavy operation
        }

        if(ret==0)
        {
            if(cnt>1)
                return 0;
            else
                return 1;
        }
        else
            return 0;
    }


}
