package com.algo.rishabh.matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyMatrixMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        EasyMatrix easyMatrix=new EasyMatrix(br);

        easyMatrix.processInput();
        System.out.println(easyMatrix.getLexographicallySmallestString());
    }

}
