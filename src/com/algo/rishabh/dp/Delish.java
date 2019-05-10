package com.algo.rishabh.dp;

import java.io.BufferedReader;
import java.io.IOException;

public class Delish {

    private BufferedReader br;
    private int A[];
    private int lim = 10000;
    private int n;

    Delish(BufferedReader br) {
        this.br = br;
        A = new int[lim];

    }

    public void processInput() throws IOException {
        n = Integer.parseInt(br.readLine());

        String str[] = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            A[i] = Integer.parseInt(str[i]);
        }
    }

    public long getMaxDiff() {

        long[] minFromLeftWithIndexIncluded = new long[n];
        long[] maxFromRight = new long[n];

        minFromLeftWithIndexIncluded[0] = A[0];

        for (int i = 1; i < n; i++) {
            if (A[i] < A[i] + minFromLeftWithIndexIncluded[i - 1]) {
                minFromLeftWithIndexIncluded[i] = A[i];
            } else {
                minFromLeftWithIndexIncluded[i] = A[i] + minFromLeftWithIndexIncluded[i - 1];
            }
        }

        maxFromRight[n - 1] = A[n - 1];

        long largestNegativeSum = A[n - 1] < 0 ? A[n - 1] : 1;
        long tempSum = A[n - 1];
        long largestPositiveSum = A[n - 1] >= 0 ? A[n - 1] : -1;

        for (int i = n - 2; i >= 0; i--) {
            /*if(A[i]<0)
            {
                if(largestNegative==1 || largestNegative<A[i])
                    largestNegative=A[i];
            }*/

            if (tempSum + A[i] < 0) {
                //still negative
                if (A[i] >= 0) {
                    //we are on correct path
                    if (A[i] <= largestPositiveSum) {
                        maxFromRight[i] = largestPositiveSum;
                    } else {
                        largestPositiveSum = A[i];
                        maxFromRight[i] = A[i];
                    }

                    if (largestNegativeSum == 1 || largestNegativeSum < tempSum + A[i]) {
                        largestNegativeSum = tempSum + A[i];
                    }

                    tempSum = A[i];

                } else {

                    if (largestPositiveSum != -1) {
                        maxFromRight[i] = largestPositiveSum;
                        if (tempSum < 0) {
                            tempSum = A[i];
                        } else {
                            if (largestNegativeSum == 1 || largestNegativeSum < tempSum + A[i]) {
                                largestNegativeSum = tempSum + A[i];
                            }
                            tempSum = tempSum + A[i];
                        }
                    } else {

                        if (A[i] <= tempSum) {
                            if (largestNegativeSum == 1 || largestNegativeSum < tempSum) {
                                largestNegativeSum = tempSum;
                                maxFromRight[i] = tempSum;
                            } else {
                                maxFromRight[i] = largestNegativeSum;
                            }
                        } else {
                            if (largestNegativeSum == 1 || largestNegativeSum < A[i]) {
                                largestNegativeSum = A[i];
                                maxFromRight[i] = A[i];
                            } else {
                                maxFromRight[i] = largestNegativeSum;
                            }
                        }

                        tempSum = A[i];
                    }

                }

            } else {
                if (tempSum < 0) {
                    //means A[i] is positive
                    if (A[i] <= largestPositiveSum) {
                        maxFromRight[i] = largestPositiveSum;
                    } else {
                        largestPositiveSum = A[i];
                        maxFromRight[i] = A[i];
                    }

                    tempSum = A[i];
                } else {
                    if (A[i] >= 0) {
                        if (A[i] + tempSum <= largestPositiveSum) {
                            maxFromRight[i] = largestPositiveSum;
                        } else {
                            largestPositiveSum = A[i] + tempSum;
                            maxFromRight[i] = A[i] + tempSum;
                        }


                    } else {
                        if (largestNegativeSum == 1 || largestNegativeSum < A[i]) {
                            largestNegativeSum = A[i];
                        }

                        maxFromRight[i] = largestPositiveSum;

                    }

                    tempSum = tempSum + A[i];
                }
            }

        }

        long[] minFromRight = new long[n];
        long[] maxFromLeftWithIndexIncluded = new long[n];

        maxFromLeftWithIndexIncluded[0] = A[0];

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i] + maxFromLeftWithIndexIncluded[i - 1]) {
                maxFromLeftWithIndexIncluded[i] = A[i];
            } else {
                maxFromLeftWithIndexIncluded[i] = A[i] + maxFromLeftWithIndexIncluded[i - 1];
            }
        }

        minFromRight[n - 1] = A[n - 1];

        long smallestNegativeSum = A[n - 1] < 0 ? A[n - 1] : 1;
        tempSum = A[n - 1];
        long smallestPositiveSum = A[n - 1] >= 0 ? A[n - 1] : -1;

        for(int i=n-2;i>=0;i--)
        {
            if(tempSum+A[i]<0)
            {
                if(A[i]>=0)
                {
                    if(smallestNegativeSum==1 || smallestNegativeSum>tempSum)
                    {
                        minFromRight[i]=tempSum;
                        smallestNegativeSum=tempSum;
                    }
                    else
                    {
                        minFromRight[i]=smallestNegativeSum;
                    }

                    if(smallestPositiveSum==-1 || smallestPositiveSum>A[i])
                        smallestPositiveSum=A[i];

                    tempSum=tempSum+A[i];
                }
                else
                {
                    if(tempSum<0) {
                        if (smallestNegativeSum == 1 || smallestNegativeSum > tempSum + A[i]) {
                            minFromRight[i] = tempSum + A[i];
                            smallestNegativeSum = tempSum + A[i];
                        } else {
                            minFromRight[i] = smallestNegativeSum;
                        }

                        tempSum=tempSum+A[i];
                    }

                    else
                    {
                        if(smallestNegativeSum==1 || smallestNegativeSum>A[i])
                        {
                            minFromRight[i]=A[i];
                            smallestNegativeSum=A[i];
                        }
                        else
                        {
                            minFromRight[i]=smallestNegativeSum;
                        }

                        if(smallestPositiveSum==-1 || smallestPositiveSum>tempSum)
                            smallestPositiveSum=tempSum;

                        tempSum=A[i];
                    }
                }
            }
            else
            {
                if(A[i]<0)
                {
                    if(smallestNegativeSum==1 || smallestNegativeSum>A[i]) {
                        smallestNegativeSum = A[i];
                        minFromRight[i] = A[i];
                    }
                    else
                        minFromRight[i]=smallestNegativeSum;

                    if(smallestPositiveSum==-1 || smallestPositiveSum>tempSum+A[i])
                        smallestPositiveSum=tempSum+A[i];

                    tempSum=A[i];
                }
                else
                {
                    if(tempSum<0)
                    {
                        minFromRight[i]=smallestNegativeSum;

                        if(smallestPositiveSum==-1 || smallestPositiveSum>A[i])
                            smallestPositiveSum=A[i];

                        tempSum=tempSum+A[i];
                    }
                    else
                    {

                        if(smallestNegativeSum!=1)
                        {
                            minFromRight[i]=smallestNegativeSum;

                            if(A[i]<=tempSum)
                            {
                                if(smallestPositiveSum!=-1 || smallestPositiveSum>A[i])
                                    smallestPositiveSum=A[i];
                            }
                            else
                            {
                                if(smallestPositiveSum!=-1 || smallestPositiveSum>tempSum)
                                    smallestPositiveSum=tempSum;
                            }
                        }
                        else {
                            if (A[i] <= tempSum) {
                                if (smallestPositiveSum == -1 || smallestPositiveSum > A[i]) {
                                    minFromRight[i] = A[i];
                                    smallestPositiveSum = A[i];
                                } else {
                                    minFromRight[i] = smallestPositiveSum;
                                }
                            } else {
                                if (smallestPositiveSum == -1 || smallestPositiveSum > tempSum) {
                                    minFromRight[i] = tempSum;
                                    smallestPositiveSum = tempSum;
                                } else {
                                    minFromRight[i] = smallestPositiveSum;
                                }


                            }
                        }

                        tempSum=A[i];
                    }
                }
            }
        }

        long largestDiff=0;

        for(int i=0;i<n-1;i++)
        {
            long val=max(Math.abs(maxFromRight[i+1]-minFromLeftWithIndexIncluded[i]),Math.abs(maxFromLeftWithIndexIncluded[i]-minFromRight[i+1]));
            if(largestDiff<val)
                largestDiff=val;
        }

        return largestDiff;


    }

    private long max(long a,long b)
    {
        if(a<b)
            return b;
        else
            return a;
    }

}
