package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DelishMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Delish delish=new Delish(br);
        int T=Integer.parseInt(br.readLine());

        while(T>0)
        {
            delish.processInput();
            System.out.println(delish.getMaxDiff());
            T--;
        }
    }

}
