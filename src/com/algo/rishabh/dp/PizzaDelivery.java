package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class PizzaDelivery {

    private BufferedReader br;
    int n;
    int h[];
    int k[];
    int lim=500;
    int dp[];

    PizzaDelivery(BufferedReader br)
    {
        this.br=br;
        h=new int[lim];
        k=new int[lim];
        dp=new int[2*lim+1];

    }

    public void processInput() throws IOException {
        n=Integer.parseInt(br.readLine());

        String hStr[]=br.readLine().split(" ");
        String kStr[]=br.readLine().split(" ");

        for(int i=0;i<hStr.length;i++)
            h[i]=Integer.parseInt(hStr[i]);

        for(int i=0;i<kStr.length;i++)
            k[i]=Integer.parseInt(kStr[i]);
    }

    public int getMinimumNoOfTimesTankShouldBeFilled()
    {
        int maxH=0;
        for(int i=0;i<n;i++)
        {
            if(maxH<h[i])
                maxH=h[i];
        }

        Arrays.sort(k,0,n);

        for(int i=1;i<=2*maxH;i++)
        {
            int min=-1;
            for(int j=0;j<n && k[j]<=i;j++)
            {
                if(min==-1 || dp[i-k[j]]!=-1 && min>1+dp[i-k[j]])
                    min=1+dp[i-k[j]];
            }

            dp[i]=min;
        }

        for (int i = 1; i <= 2 * maxH; i++) {
            System.out.println("i = "+i+" ,no of fuel stations = "+dp[i]);
        }

        int ans=0;

        for(int i=0;i<n;i++)
        {
            ans=ans+dp[2*h[i]];
        }

        return ans;

    }

}
