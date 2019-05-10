package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;

public class Compiler {

    private String str;
    private BufferedReader br;

    Compiler(BufferedReader br)
    {
        this.br=br;
    }

    public void processInput() throws IOException {
        this.str=br.readLine();
    }

    public int getLengthOfTheLongestPrefix()
    {
        int open=0;
        int close=0;
        int ans=0;

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='<')
                open=open+1;
            else
                close=close+1;

            if(open==close)
            {
                ans=close;
            }
            else if(close>open)
                break;
        }

        return ans*2;
    }



    

}
