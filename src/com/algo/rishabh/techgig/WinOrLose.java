package com.algo.rishabh.techgig;

import java.io.*;
import java.util.*;

public class WinOrLose {
    public static void main(String args[] ) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        //int villanStrengthsInt[]=new int[1000];
        //int playerStrengthsInt[]=new int[1000];

        while(T>0)
        {
            int N=Integer.parseInt(br.readLine());
            String villanStrengths[]=br.readLine().split(" ");
            String playerStrengths[]=br.readLine().split(" ");



            Arrays.sort(villanStrengths, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    int a=Integer.parseInt(s1);
                    int b=Integer.parseInt(s2);
                    if(a<b)
                        return -1;
                    else if(a>b)
                        return 1;
                    else
                        return 0;
                }
            });
            Arrays.sort(playerStrengths);

            int i=0;
            while(i<N)
            {
                if(Integer.parseInt(villanStrengths[i])>=Integer.parseInt(playerStrengths[i]))
                {
                    break;
                }

                i++;

            }

            if(i==N)
                System.out.println("WIN");
            else
                System.out.println("LOSE");

            T--;
        }

    }
}


