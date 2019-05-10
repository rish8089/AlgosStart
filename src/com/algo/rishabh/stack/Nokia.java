package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;

public class Nokia {

    private int n;
    private int l;
    private BufferedReader br;

    Nokia(BufferedReader br)
    {
        this.br=br;
    }


    public void processInput() throws IOException {
        String nl[]=br.readLine().split(" ");
        n=Integer.parseInt(nl[0]);
        l=Integer.parseInt(nl[1]);


    }

    public int getMinimumLengthOfUnusedWire()
    {
        int maxLengthOfWireUsed=n+n*(n+1)/2;
        int minLengthOfWireUsed=recurse(n+1);

        if(l>=maxLengthOfWireUsed)
            return l-maxLengthOfWireUsed;
        else if(l>=minLengthOfWireUsed && l<=maxLengthOfWireUsed)
            return 0;
        else
            return -1;


    }

    private int recurse(int n)
    {
        if(n==1)
            return 0;

        return n/2+(n-n/2)+recurse(n/2)+recurse(n-n/2);

    }

}
