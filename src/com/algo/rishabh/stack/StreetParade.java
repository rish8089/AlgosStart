package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class StreetParade {

    private int lim = 1000;
    private BufferedReader br;
    private int A[], N;

    StreetParade(BufferedReader br) {
        this.br = br;
        A = new int[lim];

    }

    public void processInput(int N) throws IOException {
        this.N=N;
        String str[] = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
    }

    public boolean canBeSentInOrder() {
        boolean flag = true;
        int nextTruckInApproachStreet = 1;
        Stack<Integer> sideStreet = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(A[i]==nextTruckInApproachStreet)
            {
                nextTruckInApproachStreet+=1;
            }
            else
            {
                if(sideStreet.isEmpty())
                    sideStreet.push(A[i]);
                else
                {
                    if (A[i] < sideStreet.peek()) {
                        sideStreet.push(A[i]);
                    }
                    else
                    {
                        while(!sideStreet.isEmpty() && sideStreet.peek()==nextTruckInApproachStreet) {
                            sideStreet.pop();
                            nextTruckInApproachStreet += 1;
                        }
                        if(sideStreet.isEmpty())
                            sideStreet.push(A[i]);
                        else if(A[i]<sideStreet.peek())
                            sideStreet.push(A[i]);
                        else
                        {
                            flag=false;
                            break;
                        }
                    }
                }

            }
        }
        return flag;
    }

}
