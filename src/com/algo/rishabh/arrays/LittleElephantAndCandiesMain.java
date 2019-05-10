package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleElephantAndCandiesMain {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        LittleElephantAndCandies littleElephantAndCandies=new LittleElephantAndCandies(br);
        int T=Integer.parseInt(br.readLine());
        while(T>0)
        {

            littleElephantAndCandies.processInput();
            System.out.println(littleElephantAndCandies.areAllElephantsHappy()?"Yes":"No");
            T--;
        }

    }

}
