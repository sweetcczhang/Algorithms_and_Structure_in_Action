package cn.bput.zcc.listopreation;

import java.util.Arrays;

/**
 * Created by 张城城 on 2017/12/18.
 */
public class SmallestDifference387 {
    /**
     * 题目：最小差
     * 描述：
     * 给定两个整数数组（第一个是数组 A，第二个是数组 B），在数组 A 中取 A[i]，
     * 数组 B 中取 B[j]，A[i] 和 B[j]两者的差越小越好(|A[i] - B[j]|)。返回最小差。
     * @param A
     * @param B
     * @return
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        Arrays.sort(A);
        Arrays.sort(B);
        if(A.length==0 &&B.length==0) return 0;
        if(A.length==0 && B.length>0)return B[0];
        if(A.length>0 && B.length==0) return A[0];
        int i=0,j=0;
        int min = Integer.MAX_VALUE;
        int localMin = Integer.MAX_VALUE;
        while (i<A.length && j<B.length){
            if(A[i]==B[j]){
                return 0;
            }else if(A[i]<B[j]){
                localMin = B[j]-A[i];
                i++;
            }else {
                localMin = A[i]-B[j];
                j++;
            }
            min = Math.min(localMin,min);
        }
        return min;
    }
}
