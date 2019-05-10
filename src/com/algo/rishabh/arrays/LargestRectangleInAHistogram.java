package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.util.Stack;

public class LargestRectangleInAHistogram {

    private BufferedReader br;
    int n;
    int arr[];
    int lim=100000;

    LargestRectangleInAHistogram(BufferedReader br)
    {
        this.br=br;
        arr=new int[lim];
    }

    public void processInput(String str)
    {
        String strArr[]=str.split(" ");
        n=Integer.parseInt(strArr[0]);
        for(int i=1;i<strArr.length;i++)
            arr[i-1]=Integer.parseInt(strArr[i]);
    }

    public long getLargestArea()
    {

        int []noOfRectanglesCoveredInRight=new int[n];
        int []noOfRectanglesCoveredInLeft=new int[n];

        Stack<Integer> rightRectangles=new Stack<>();
        Stack<Integer> leftRectangles=new Stack<>();

        noOfRectanglesCoveredInRight[n-1]=1;
        rightRectangles.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            noOfRectanglesCoveredInRight[i]=1;
            while(!rightRectangles.isEmpty() && arr[rightRectangles.peek()]>=arr[i])
            {
                int top=rightRectangles.pop();
                noOfRectanglesCoveredInRight[i]+=noOfRectanglesCoveredInRight[top];
            }
            rightRectangles.push(i);
        }


        noOfRectanglesCoveredInLeft[0]=1;
        leftRectangles.push(0);

        for(int i=1;i<n;i++)
        {
            noOfRectanglesCoveredInLeft[i]=1;
            while(!leftRectangles.isEmpty() && arr[leftRectangles.peek()]>=arr[i])
            {
                int top=leftRectangles.pop();
                noOfRectanglesCoveredInLeft[i]+=noOfRectanglesCoveredInLeft[top];
            }

            leftRectangles.push(i);
        }

        long ans=0;

        for(int i=0;i<n;i++)
        {
            if(ans<((long)(noOfRectanglesCoveredInLeft[i]+noOfRectanglesCoveredInRight[i]-1))*arr[i])
            {
                ans=((long)(noOfRectanglesCoveredInLeft[i]+noOfRectanglesCoveredInRight[i]-1))*arr[i];
            }
        }


        return ans;
    }
}
