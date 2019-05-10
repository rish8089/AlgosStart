package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingSubarrayPrefixMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        AlternatingSubarrayPrefix alternatingSubarrayPrefix=new AlternatingSubarrayPrefix(br);
        int T=Integer.parseInt(br.readLine());

        while(T>0)
        {
            alternatingSubarrayPrefix.processInput();
            alternatingSubarrayPrefix.printLengthOfAlternatingPrefix();
            T--;
        }
    }

}
