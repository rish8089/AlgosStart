package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreetParadeMain {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        StreetParade streetParade=new StreetParade(br);
        int N=Integer.parseInt(br.readLine());
        while(N!=0)
        {
            streetParade.processInput(N);
            System.out.println(streetParade.canBeSentInOrder()?"yes":"no");
            N=Integer.parseInt(br.readLine());
        }

    }

}
