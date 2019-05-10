package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class CopsAndTheThiefDevu {

    int lim=100;
    private BufferedReader br;
    int M,X,Y;
    int houses[];

    CopsAndTheThiefDevu(BufferedReader br)
    {
        this.br=br;
    }

    public void processInput() throws IOException {

        String mxy[]=br.readLine().split(" ");

        M=Integer.parseInt(mxy[0]);
        X=Integer.parseInt(mxy[1]);
        Y=Integer.parseInt(mxy[2]);

        houses=new int[M];

        String str[]=br.readLine().split(" ");
        for(int i=0;i<M;i++)
            houses[i]=Integer.parseInt(str[i]);

    }

    public int getNoOfSafeHouses()
    {
        Arrays.sort(houses,0,M);

        int prevHouseOccupiedByCops=0; //0th house
        int cnt=0;
        int prod=X*Y;

        for(int houseNo:houses)
        {

            //suppose houseNo is 3 , prod is 2 (3,2,1) will be covered(3-2-1-0)=0
            if(houseNo-prod-prevHouseOccupiedByCops-1>0)
                cnt+=houseNo-prod-prevHouseOccupiedByCops-1;

            prevHouseOccupiedByCops=houseNo+prod;
            if(prevHouseOccupiedByCops>lim)
                prevHouseOccupiedByCops=lim;


        }

        if(prevHouseOccupiedByCops<lim)
            cnt+=lim-prevHouseOccupiedByCops;


        return cnt;

    }

}
