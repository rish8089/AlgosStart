package com.algo.rishabh.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndNoteBooksMain {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);

        ChefAndNoteBooks chefAndNoteBooks=new ChefAndNoteBooks(br);
        int T=Integer.parseInt(br.readLine());
        while(T>0)
        {

            chefAndNoteBooks.processInput();
            System.out.println(chefAndNoteBooks.isChefLucky()?"LuckyChef":"UnluckyChef");
            T--;
        }
    }

}
