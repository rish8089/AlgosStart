package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaDeliveryMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        PizzaDelivery pizzaDelivery=new PizzaDelivery(br);
        int T=Integer.parseInt(br.readLine());
        while(T>0)
        {
            pizzaDelivery.processInput();
            System.out.println(pizzaDelivery.getMinimumNoOfTimesTankShouldBeFilled());
            T--;
        }
    }

}
