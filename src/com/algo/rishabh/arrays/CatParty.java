package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatParty {


    public static void main(String[] args) throws IOException {

        int lim=100000;

        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        int n=Integer.parseInt(br.readLine());
        String str[]=br.readLine().split(" ");

        int a[]=new int[lim+1];
        int hash[]=new int[11];

        for(int i=1;i<=n;i++)
            a[i]=Integer.parseInt(str[i-1]);

        int largestX=1;
        hash[a[1]]++;
        int max=1;
        int maxElement=a[1];
        int minElement=-1;
        int min;

        for(int i=2;i<=n;i++)
        {

            hash[a[i]]++;

            if(max<hash[a[i]]) {
                max = hash[a[i]];
                maxElement = a[i];
            }

            min=-1;
            for(int j=1;j<=10;j++)
            {
                if(hash[j]!=0)
                {
                    if(min==-1 || min>hash[j])
                    {
                        min=hash[j];
                        minElement=j;
                    }
                }
            }

            boolean flag1=true;

            for(int j=1;j<=10;j++) //removing single instance of max and checking if others are equal to max-1
            {
                if(hash[j]!=0)
                {
                    if(maxElement!=j && hash[j]!=max-1)
                    {
                        flag1=false;
                        break;
                    }
                }
            }

            boolean flag2=true;
            int candidate=-1;

            if(min==1) //min can be removed completely
            {
                for(int j=1;j<=10;j++) //checking if all others are repeating equally
                {
                    if(hash[j]!=0)
                    {
                        if(minElement!=j)
                        {
                            if(candidate==-1)
                                candidate=j;
                            else if(hash[j]!=hash[candidate])
                            {
                                flag2=false;
                                break;
                            }
                        }
                    }
                }
            }
            else
            {
                flag2=false;
            }



            if(flag1 || flag2)
                largestX=i;
        }

        System.out.println(largestX);

    }

}
