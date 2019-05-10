package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LockFreeStack {

    private BufferedReader br;
    private int n;
    private List<List<Integer>> list;
    private int path[];
    int lim=1000000;
    int pathLength;

    LockFreeStack(BufferedReader br)
    {
        this.br=br;
        list=new ArrayList<>();
        path=new int[lim];

    }

    public void processInput() throws IOException {

        list.clear();

        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++)
        {
            String str[]=br.readLine().split(" ");
            List<Integer> subList=new ArrayList<>();
            for(int j=1;j<str.length;j++)
                subList.add(Integer.parseInt(str[j]));

            list.add(subList);
        }

        String str[]=br.readLine().split(" ");
        pathLength=str.length;
        for(int i=0;i<str.length;i++)
            path[i]=Integer.parseInt(str[i]);

    }


    public boolean isPathValid()
    {
        int ends[]=new int[n];

        for(int i=0;i<n;i++)
            ends[i]=list.get(i).size()-1;

        return recurse(ends,0);

    }

    private boolean recurse(int []ends,int idx)
    {
        if(idx==pathLength)
            return true;

        for(int i=0;i<n;i++)//traversing all ends and finding the valid
        {
            if(ends[i]>=0) {
                if (list.get(i).get(ends[i]) == path[idx]) {
                    ends[i]--;
                    boolean ret = recurse(ends, idx + 1);
                    ends[i]++;
                    if (ret)
                        return true;
                }
            }
        }

        return false;
    }





}
