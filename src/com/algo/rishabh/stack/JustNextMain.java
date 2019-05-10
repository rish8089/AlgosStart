package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JustNextMain {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        JustNext justNext = new JustNext(br);
        int T = Integer.parseInt(br.readLine());
        while(T>0)
        {
            justNext.processInput();
            System.out.println(justNext.getNextGreatest());
            T--;
        }


    }

}
