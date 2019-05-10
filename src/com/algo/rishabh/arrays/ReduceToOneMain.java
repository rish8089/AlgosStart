package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReduceToOneMain {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        ReduceToOne reduceToOne=new ReduceToOne(bufferedReader);

        int t=Integer.parseInt(bufferedReader.readLine());
        while(t>0)
        {
            reduceToOne.processInput();
            System.out.println(reduceToOne.getMaxiumPossibleValue());
            t--;
        }

    }

}
