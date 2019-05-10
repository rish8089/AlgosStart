package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LockFreeStackMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());
        LockFreeStack lockFreeStack=new LockFreeStack(br);
        while(t>0)
        {
            lockFreeStack.processInput();
            System.out.println(lockFreeStack.isPathValid()?"Yes":"No");

            t--;
        }
    }

}
