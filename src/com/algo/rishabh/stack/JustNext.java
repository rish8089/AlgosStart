package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class JustNext {

    private int N;
    private int A[];
    private int lim = 1000000;

    private BufferedReader br;

    JustNext(BufferedReader br) {
        this.br = br;
        A = new int[lim];
    }

    public void processInput() throws IOException {
        N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
    }

    public StringBuilder getNextGreatest() {
        Stack<Integer> decreasingStack = new Stack<>();
        Stack<Integer> increasingStack = new Stack<>();
        decreasingStack.push(A[N - 1]);
        int stopIdx = -1, candidate = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (A[i] >= decreasingStack.peek()) {
                decreasingStack.add(A[i]);
            } else {
                //logic starts from now
                stopIdx = i;
                while (!decreasingStack.empty() && decreasingStack.peek() > A[i]) {
                    candidate = decreasingStack.pop();
                    increasingStack.add(candidate);
                }

                increasingStack.pop();
                increasingStack.add(A[i]);


                while (!decreasingStack.isEmpty()) {
                    increasingStack.add(decreasingStack.peek());
                    decreasingStack.pop();
                }


                break;
            }
        }

        if (candidate == -1) {
            return new StringBuilder("-1");
        } else {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < stopIdx; i++) {
                ans.append(A[i]);
            }
            ans.append(candidate);

            while (!increasingStack.isEmpty()) {
                ans.append(increasingStack.pop());
            }
            return ans;
        }
    }


}
