package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;

public class FitSquaresInTriangle {

    private int n;
    private BufferedReader br;

    FitSquaresInTriangle(BufferedReader br)
    {
        this.br=br;
    }

    public void processInput() throws IOException {
        n=Integer.parseInt(br.readLine());
    }

    public int getNoOfSquaresWhichCanFitInTriangle()
    {
        if(n%2==0)
            return n*(n-2)/8;
        else
            return (n-1)*(n-3)/8;
    }

}
