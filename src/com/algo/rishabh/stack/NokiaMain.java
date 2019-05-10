package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NokiaMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Nokia nokia=new Nokia(br);
        int T=Integer.parseInt(br.readLine());

        while(T>0)
        {
            nokia.processInput();
            System.out.println(nokia.getMinimumLengthOfUnusedWire());
            T--;
        }
    }

}
