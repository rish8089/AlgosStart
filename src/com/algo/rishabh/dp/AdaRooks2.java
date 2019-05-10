package com.algo.rishabh.dp;

import java.util.Arrays;

public class AdaRooks2 {

    int N =4;
    char A[][];
    private char str[] = {'O', '.'};

    AdaRooks2() {
        A = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(A[i], '.');
        }
    }

    public void printDistribution() {
        boolean ret = recurse(0, 0, 0);
        if (ret) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(A[i][j]);
                }

                System.out.println();
            }
        }
    }

    private boolean recurse(int i, int j, int cnt) {

        System.out.println(i+" "+j+" "+cnt);
        for (int k = 0; k < str.length; k++) {
            //we have to check its validity

            if (str[k] == 'O') {

                boolean flag = false;
                for (int l = 0; l < i; l++) {
                    if (A[l][j] == 'O') {
                        for (int p = 0; p < j; p++) {
                            if (A[l][p] == 'O' && A[i][p] == 'O') {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            break;
                        }
                        flag=true;
                    }
                }

                if (!flag) //rectangle not formed
                {
                    A[i][j] = 'O';

                    if (cnt + 1 == 8 * N) {
                        return true;
                    } else if (i == N - 1 && j == N - 1) {
                        return false;
                    } else {
                        boolean ret;
                        if (j == N - 1) {
                            ret = recurse(i + 1, 0, cnt + 1);
                        } else {
                            ret = recurse(i, j + 1, cnt + 1);
                        }

                        if (ret) {
                            return true;
                        } else {
                            A[i][j] = '.';
                        }
                    }
                }

            } else {



                if(i==N-1 && j==N-1)
                    return false;
                else
                {
                    boolean ret;
                    if(j==N-1)
                        ret=recurse(i+1,0,cnt);
                    else
                        ret=recurse(i,j+1,cnt);


                    if(ret)
                        return true;
                }


            }

            //System.out.println(i+" "+j+" "+cnt +  Arrays.toString(str));
        }

        return false;

//        boolean flag = false;
//        for (int l = 0; l < i; l++) {
//            if (A[l][j] == 'O') {
//                for (int p = 0; p < j; p++) {
//                    if (A[l][p] == 'O' && A[i][p] == 'O') {
//                        flag = true;
//                        break;
//                    }
//                }
//                if (flag) {
//                    break;
//                }
//                flag = true;
//            }
//        }
//
//        if (!flag) //rectangle not formed
//        {
//            A[i][j] = 'O';
//
//            if (cnt + 1 == 8 * N) {
//                return true;
//            } else if (i == N - 1 && j == N - 1) {
//                return false;
//            } else {
//                boolean ret;
//                if (j == N - 1) {
//                    ret = recurse(i + 1, 0, cnt + 1);
//                } else {
//                    ret = recurse(i, j + 1, cnt + 1);
//                }
//
//                if (ret) {
//                    return true;
//                } else {
//                    A[i][j] = '.';
//                }
//            }
//        }

    }
}
