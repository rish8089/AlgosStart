package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;

public class ReduceToOne {

    private BufferedReader br;
    private int n;
    private long a[];
    private int lim=1000000;
    private int mod=1000000007;

    ReduceToOne(BufferedReader br)
    {
        this.br=br;
        a=new long[lim+1];
        init();
    }

    private void init()
    {
        a[1]=1;
        a[2]=5;

        for(int i=3;i<=lim;i++)
        {
            a[i]=(a[i-1]*i+a[i-1]+i)%mod;
        }
    }

    public void processInput() throws IOException {
        n=Integer.parseInt(br.readLine());
    }

    public long getMaxiumPossibleValue()
    {
        return a[n];
    }

}
