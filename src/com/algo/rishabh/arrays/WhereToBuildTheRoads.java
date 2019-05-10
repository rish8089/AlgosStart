package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WhereToBuildTheRoads {

    private BufferedReader br;
    private int n;
    private Point restaurents[];
    private int lim=10000;


    WhereToBuildTheRoads(BufferedReader br)
    {
        this.br=br;
        restaurents=new Point[lim];
        for(int i=0;i<lim;i++)
            restaurents[i]=new Point(0,0);
    }

    public void processInput() throws IOException {
        n=Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++)
        {
            String xy[]=br.readLine().split(" ");
            restaurents[i].x=Integer.parseInt(xy[0]);
            restaurents[i].y=Integer.parseInt(xy[1]);

        }
    }

    public double getMinimumDistance()
    {
        HashSet<Integer> hashSet=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            if(!hashSet.contains(restaurents[i].y-restaurents[i].x))
                hashSet.add(restaurents[i].y-restaurents[i].x);
            else
                return 0;
        }

        List<Integer> list=new ArrayList<>(hashSet);
        Collections.sort(list);

        int min=-1;

        for(int i=0;i<list.size()-1;i++)
        {
            if(min==-1)
                min=list.get(i+1)-list.get(i);
            else if(min>list.get(i+1)-list.get(i))
                min=list.get(i+1)-list.get(i);
        }

        return min/2.0;

    }




    class Point
    {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



}
