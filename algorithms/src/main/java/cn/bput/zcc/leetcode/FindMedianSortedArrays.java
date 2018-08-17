package cn.bput.zcc.leetcode;

/**
 * Created by zcc
 * Date on 2018/8/3
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArray(int[]A, int[]B){

        int m = A.length;
        int n = B.length;
        if (m>n){
            int[] temp = A;
            A = B;
            B =temp;
            int flag = m;
            m = n;
            n = flag;
        }

        int iMin = 0; int iMax = m;
        int halflen = (m + n +1)/2;
        while (iMin<iMax){
            int i = (iMin + iMax)/2;
            int j = halflen -i;
            if (i<iMax && B[j-1]>A[i]){
                iMin = iMin +1;
            }else if (i>iMin && A[i-1]>B[j]){
                iMax = iMax - 1;
            }else {
                int maxleft = 0;
                if(i==0) {
                    maxleft = B[j-1];
                }else if (j==0){
                    maxleft = A[j-1];
                }else {
                    maxleft = Math.max(A[i-1], B[j-1]);
                }
                if ((m+n)%2==1) return maxleft;

                int minRight = 0;
                if (i==m){
                    minRight = B[j];
                }else if (j==n){
                    minRight = A[i];
                }else {
                    minRight = Math.min(A[i],B[j]);
                }
                return (minRight+maxleft)/2.0;
            }
        }

        return 0.0;
    }
}
