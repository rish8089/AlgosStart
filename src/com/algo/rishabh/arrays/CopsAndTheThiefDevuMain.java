package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopsAndTheThiefDevuMain {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        int T=Integer.parseInt(br.readLine());
        CopsAndTheThiefDevu copsAndTheThiefDevu=new CopsAndTheThiefDevu(br);
        while(T>0)
        {
            copsAndTheThiefDevu.processInput();
            System.out.println(copsAndTheThiefDevu.getNoOfSafeHouses());

            T--;
        }
    }

}
