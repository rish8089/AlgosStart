package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;

public class AlternatingSubarrayPrefix {

    private BufferedReader br;
    private int n;
    private int arr[];
    private int lim=100000;

    AlternatingSubarrayPrefix(BufferedReader br)
    {
        this.br=br;
        arr=new int[lim+1];
    }

    public void processInput() throws IOException {
        n=Integer.parseInt(br.readLine());

        String str[]=br.readLine().split(" ");
        for(int i=0;i<str.length;i++)
            arr[i]=Integer.parseInt(str[i]);

    }

    public void printLengthOfAlternatingPrefix()
    {
        int j;

        for(int i=0;i<n;)
        {
            int cnt=1;
            j=i+1;
            while(j<n && ((arr[j-1]>0 && arr[j]<0) || (arr[j-1]<0 && arr[j]>0)))
            {
                cnt+=1;
                j=j+1;
            }

            for(int k=i;k<j;k++)
            {
                System.out.print(cnt+" ");
                cnt-=1;
            }

            i+=j-i;
        }

        System.out.println();
    }

}
