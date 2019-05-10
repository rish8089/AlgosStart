package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestRectangleInAHistogramMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        LargestRectangleInAHistogram largestRectangleInAHistogram=new LargestRectangleInAHistogram(br);
        String str=br.readLine();

        while(!str.equals("0"))
        {
            largestRectangleInAHistogram.processInput(str);
            System.out.println(largestRectangleInAHistogram.getLargestArea());
            str=br.readLine();
        }
    }


}
