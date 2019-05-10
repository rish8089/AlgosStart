package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompilerMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        Compiler compiler=new Compiler(br);
        int T=Integer.parseInt(br.readLine());

        while(T>0)
        {
            compiler.processInput();
            System.out.println(compiler.getLengthOfTheLongestPrefix());
            T--;
        }

    }

}
