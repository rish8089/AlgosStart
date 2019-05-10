package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndRainbowArrayMain {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        int T=Integer.parseInt(br.readLine());
        ChefAndRainbowArray chefAndRainbowArray=new ChefAndRainbowArray(br);
        while(T>0)
        {
            chefAndRainbowArray.processInput();
            System.out.println((chefAndRainbowArray.checkIfRainbowArray()?"yes":"no"));

            T--;
        }
    }
}
