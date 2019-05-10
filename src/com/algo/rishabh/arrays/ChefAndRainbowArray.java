package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;

public class ChefAndRainbowArray {

    int lim=7;
    int N,arr[];

    BufferedReader br;

    ChefAndRainbowArray(BufferedReader br)
    {
        this.br=br;

    }

    public void processInput() throws IOException {
        N=Integer.parseInt(br.readLine());

        String str[]=br.readLine().split(" ");

        arr=new int[N+1];
        for(int i=1;i<=N;i++)
            arr[i]=Integer.parseInt(str[i-1]);


    }

    public boolean checkIfRainbowArray()
    {

        if(N>=13) {
            int j=1;
            int k=N;
            for (int i = 1; i <= lim-1; i++) {

                int cnt1=0,cnt2=0;

                while(j<=N && arr[j]==i)
                {
                    cnt1++;
                    j++;
                }

                while(k>=1 && k>j && arr[k]==i)
                {
                    cnt2++;
                    k--;
                }

                if(cnt1!=cnt2 || cnt1==0 || cnt2==0)
                    return false;

                if(i<lim-1) {
                    if (!(k > j && (k - j + 1 )>=((lim - 1 - i) * 2 + 1)))
                        return false;
                }


            }

            if(k>=j)
            {
                while(j<=k && arr[j]==lim)
                {
                    j++;
                }

                if(j==k+1)
                    return true;
                else
                    return false;

            }
            else
                return false;
        }
        else
            return false;
    }

}
