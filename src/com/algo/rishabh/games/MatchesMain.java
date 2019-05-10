package com.algo.rishabh.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchesMain {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(bufferedReader.readLine());
        Matches matches=new Matches(bufferedReader);

        while(t>0)
        {
            matches.processInput();
            System.out.println(matches.getWinner());
            t--;
        }
    }

}
