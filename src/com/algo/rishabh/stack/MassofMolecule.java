package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;

public class MassofMolecule {

    private BufferedReader br;
    private String str;

    MassofMolecule(BufferedReader br) {
        this.br = br;
    }

    public void processInput() throws IOException {
        this.str = br.readLine();
    }

    public int getMassOfMolecule() {

        int res = 0, val;

        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'C' || ch == 'H' || ch == 'O') {

                if (ch == 'C') {
                    val = 12;
                } else if (ch == 'H') {
                    val = 1;
                } else {
                    val = 16;
                }

                if(i+1<str.length()) {
                    char nextCh = str.charAt(i + 1);

                    if (nextCh >= '2' && nextCh <= '9') {
                        stack.push(new Node(val, nextCh - '0'));
                        i += 1;
                    }
                    else {
                        stack.push(new Node(val, 1));
                    }
                }else {
                    stack.push(new Node(val, 1));
                }
            } else if (ch == '(') {
                stack.push(new Node(ch, 1));
            } else {
                int ans = 0;
                while (stack.peek().val != '(') {
                    Node node = stack.pop();
                    ans += node.val * node.power;

                }

                stack.pop();


                if(i+1<str.length()) {

                    char nextCh = str.charAt(i + 1);
                    if (nextCh >= '2' && nextCh <= '9') {
                        stack.push(new Node(ans, nextCh - '0'));
                        i += 1;
                    } else {
                        stack.push(new Node(ans, 1));
                    }
                }
                else
                {
                    stack.push(new Node(ans, 1));
                }


            }

        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res=res+node.val*node.power;
        }

        return res;
    }

    class Node {

        int val;
        int power;

        public Node(int val, int power) {
            this.val = val;
            this.power = power;
        }
    }
}
