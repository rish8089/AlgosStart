package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitSquaresInTriangleMain {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);


        FitSquaresInTriangle fitSquaresInTriangle=new FitSquaresInTriangle(br);
        int T=Integer.parseInt(br.readLine());

        while(T>0)
        {
            fitSquaresInTriangle.processInput();
            System.out.println(fitSquaresInTriangle.getNoOfSquaresWhichCanFitInTriangle());
            T--;
        }

    }

}
