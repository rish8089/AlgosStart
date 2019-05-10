package com.algo.rishabh.arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EatingSoup {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        String nm[]=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);

        if(m==0)
            System.out.println(1);
        else
        {
            System.out.println(m<=n/2?m:n-m);
        }

    }
}
