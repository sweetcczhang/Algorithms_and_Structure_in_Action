package cn.bput.zcc.listopreation;

import cn.bput.zcc.depthFirstSearch.CombinationSum135;

import java.util.Arrays;

/**
 * Created by 张城城 on 2017/12/11.
 */
public class FirstMissingPositive189 {

    CombinationSum135 combinationSum135;
    /**
     * 题目：丢失的第一个正整数
     * 描述：给出一个无序的整数数组，找出其中没有出现的最小正整数。
     * @param A
     * @return
     */
    public int firstMissingPositive(int [] A){

        int flag =-1;
        if(A==null||A.length==0||A[A.length-1]<=0 ) return 1;
        int[] B = combinationSum135.removeDuplicates(A);
        if(B.length==1 && B[0]!=1) return 1;
        for(int i=0;i<B.length-1;i++){
            if(B[i]>0){
                 if(flag>=0&&B[flag+1]!=1){
                     return 1;
                 }
                if(flag<0 && B[0]!=1) return 1;
                if(B[i+1] != B[i]+1){
                    return B[i]+1;
                }
            }else {
                flag = i;
            }
        }


        return B[B.length-1]+1;
    }

    /**
     * 本方法的解题思路是寻找缺失的数。让排序后的数组有如下规律A[i]=i+1;
     * 第一个不满足这个规律便是答案~如果全部满足则为n+1
     * @param A
     * @return
     */
    public int firstMissingPositive2(int [] A){
        if(A.length==0) return 1;
        int n = A.length;
        for(int i=0; i<n; i++){
            int digit = A[i];
            while (digit>0&&digit<=n&&A[digit-1]!=digit){
                int tmp = A[i];
                A[i] = A[digit-1];
                A[digit-1] = tmp;
                digit=A[i];
            }
        }
        for(int i=0;i<n;i++){
            if(A[i] != i+1)
                return i+1;
        }
        return n+1;
    }

}
