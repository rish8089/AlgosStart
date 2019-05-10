package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ONPMain {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(bufferedReader.readLine());
        ONP onp=new ONP(bufferedReader);

        while(T>0)
        {
            onp.processInput();
            System.out.println(onp.getRPNNotation());
            T--;
        }
    }

}
