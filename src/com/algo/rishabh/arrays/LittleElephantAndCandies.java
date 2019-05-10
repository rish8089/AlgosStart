package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;

public class LittleElephantAndCandies {

    private BufferedReader br;
    int N,C;
    int A[];
    int lim=100;

    public LittleElephantAndCandies(BufferedReader br) {
        this.br=br;
        A=new int[lim];
    }

    public void processInput() throws IOException {
        String nc[]=br.readLine().split(" ");

        N=Integer.parseInt(nc[0]);
        C=Integer.parseInt(nc[1]);

        String arr[]=br.readLine().split(" ");

        for(int i=0;i<arr.length;i++)
            A[i]=Integer.parseInt(arr[i]);



    }

    public boolean areAllElephantsHappy()
    {
        int totalCandiesRequired=0;

        for(int i=0;i<N;i++)
        {
            totalCandiesRequired+=A[i];
        }

        if(totalCandiesRequired<=C)
            return true;
        else
            return false;
    }
}
