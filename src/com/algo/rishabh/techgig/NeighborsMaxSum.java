package com.algo.rishabh.techgig;

import java.io.*;
import java.util.*;

public class NeighborsMaxSum {
    public static void main(String args[] ) throws Exception {

        //Write code here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int arr[]=new int[10000];
        int dp[]=new int[10000];
        int pos[]=new int[10000];

        while(T>0)
        {

            int maxSum=0;
            int idx=-1;

            int N=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            for(int i=0;i<str.length;i++)
                arr[i]=Integer.parseInt(str[i]);



            for(int i=0;i<N;i++)
            {
                if(arr[i]<0)
                {
                    if((i-2)>=0) {
                        dp[i] = dp[i - 2];
                        pos[i] = i - 2;
                    }
                    else {
                        dp[i] = 0;
                        pos[i]=-1;
                    }
                }
                else
                {
                    if((i-2)>=0) {
                        dp[i] = arr[i] + dp[i - 2];
                        pos[i] = i - 2;
                    }
                    else {
                        dp[i] = arr[i];
                        pos[i] = -1;
                    }
                }

                if(maxSum<dp[i])
                {
                    maxSum=dp[i];
                    idx=i;
                }


            }



            System.out.println(maxSum+" "+idx);



            T--;
        }

    }
}
