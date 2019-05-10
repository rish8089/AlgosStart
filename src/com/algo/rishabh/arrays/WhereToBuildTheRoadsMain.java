package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhereToBuildTheRoadsMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        WhereToBuildTheRoads whereToBuildTheRoads=new WhereToBuildTheRoads(br);
        int t=Integer.parseInt(br.readLine());

        while(t>0)
        {
            whereToBuildTheRoads.processInput();
            System.out.println(whereToBuildTheRoads.getMinimumDistance());
            //System.out.println();
            t--;
        }
    }

}
