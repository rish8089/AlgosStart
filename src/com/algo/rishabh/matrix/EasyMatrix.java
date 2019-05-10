package com.algo.rishabh.matrix;

import java.io.BufferedReader;
import java.io.IOException;

public class EasyMatrix {

    char A[][];
    int limR = 1000;
    int limC = 1000;
    int m, n;

    private BufferedReader br;

    EasyMatrix(BufferedReader br) {
        A = new char[limR][limC];
        this.br = br;
    }

    public void processInput() throws IOException {

        String mn[] = br.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);

        for (int i = 0; i < m; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                A[i][j] = str[j].charAt(0);
            }
        }
    }

    public String getLexographicallySmallestString() {
        String dp[][] = new String[limR][limC];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i - 1) >= 0 && (j - 1) >= 0) {
                    if (dp[i - 1][j].compareTo(dp[i][j - 1]) <= 0) {
                        dp[i][j] = fitCharacterIntoTheSortedString(dp[i - 1][j], A[i][j]);
                    } else {
                        dp[i][j] = fitCharacterIntoTheSortedString(dp[i][j - 1], A[i][j]);
                    }
                } else if (i - 1 >= 0) {
                    dp[i][j] = fitCharacterIntoTheSortedString(dp[i - 1][j], A[i][j]);
                } else if (j - 1 >= 0) {
                    dp[i][j] = fitCharacterIntoTheSortedString(dp[i][j - 1], A[i][j]);
                } else {
                    dp[i][j] = String.valueOf(A[i][j]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }


    private String fitCharacterIntoTheSortedString(String str, char ch) {

        StringBuilder stringBuilder = new StringBuilder("");

        int resIdx = binarySearch(str, ch);

        if (resIdx < 0) {
            return stringBuilder.append(ch).append(str).toString();
        } else {
            return stringBuilder.append(str.substring(0, resIdx + 1)).append(ch)
                .append(str.substring(resIdx + 1)).toString();
        }
    }

    private int binarySearch(String str, char ch) {
        int u = 0;
        int v = str.length() - 1;
        int resIdx = -1;

        while (u <= v) {
            int mid = (u + v) / 2;

            if (str.charAt(mid) >= ch) {
                v = mid - 1;
            } else {
                resIdx = mid;
                u = mid + 1;
            }
        }

        return resIdx;
    }

}
