package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class ONP {

    private BufferedReader br;
    private String algebraicExpression;

    ONP(BufferedReader br)
    {
        this.br=br;
    }

    public void processInput() throws IOException {
        algebraicExpression=br.readLine();
    }

    public String getRPNNotation()
    {
        Stack<String> stack=new Stack<>();

        for(int i=0;i<algebraicExpression.length();i++)
        {
            if(algebraicExpression.charAt(i)==')')
            {
                String res[]=new String[3];
                int idx=2;
                while(!stack.isEmpty())
                {
                    String val=stack.pop();
                    if(val.equals("(")) {
                        break;
                    }
                    else
                    {
                        res[idx--]=val;
                    }
                }

                stack.push(""+res[0]+res[2]+res[1]);
            }
            else
                stack.push(""+algebraicExpression.charAt(i));
        }

        return stack.peek();
    }



}
