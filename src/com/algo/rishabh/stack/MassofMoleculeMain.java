package com.algo.rishabh.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MassofMoleculeMain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MassofMolecule massofMolecule = new MassofMolecule(br);
        massofMolecule.processInput();
        System.out.println(massofMolecule.getMassOfMolecule());

    }

}
