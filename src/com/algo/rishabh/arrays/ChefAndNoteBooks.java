package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;

public class ChefAndNoteBooks {

    BufferedReader br;
    int X,Y,K,N;
    Notebook notebooks[];
    int lim=100000;

    ChefAndNoteBooks(BufferedReader br)
    {
        this.br=br;
        notebooks=new Notebook[lim];

    }

    public void processInput() throws IOException {
        String xykn[]=br.readLine().split(" ");

        X=Integer.parseInt(xykn[0]);
        Y=Integer.parseInt(xykn[1]);
        K=Integer.parseInt(xykn[2]);
        N=Integer.parseInt(xykn[3]);

        for(int i=0;i<N;i++)
        {
            notebooks[i]=new Notebook();
            String pc[]=br.readLine().split(" ");
            notebooks[i].pages=Integer.parseInt(pc[0]);
            notebooks[i].price=Integer.parseInt(pc[1]);
        }
    }

    public boolean isChefLucky()
    {
        int requiredPages=X-Y;
        for(int i=0;i<N;i++)
        {
            if(requiredPages<=notebooks[i].pages && notebooks[i].price<=K)
                return true;
        }

        return false;
    }



    class Notebook
    {
        int pages;
        int price;
    }

}