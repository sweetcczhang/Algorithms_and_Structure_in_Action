package cn.bput.zcc.listopreation;

import java.util.Arrays;

/**
 * Created by 张城城 on 2017/12/11.
 */
public class FirstMissingPositive189 {
    /**
     * 题目：丢失的第一个正整数
     * 描述：给出一个无序的整数数组，找出其中没有出现的最小正整数。
     * @param A
     * @return
     */
    public int firstMissingPositive(int [] A){

        Arrays.sort(A);
        int flag =-1;
        if(A==null||A.length==0||A[A.length-1]<=0 ) return 1;
        int[] B = removeDuplicates(A);
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
    public int[] removeDuplicates(int[] candidates){
        Arrays.sort(candidates);
        int index = 0;
        for(int i=0; i<candidates.length;i++){
            if(candidates[i]!=candidates[index]){
                candidates[++index] = candidates[i];
            }
        }
        int [] num = new int[index+1];
        for(int i=0;i<=index;i++){
            num[i] = candidates[i];
        }
        return num;
    }
}