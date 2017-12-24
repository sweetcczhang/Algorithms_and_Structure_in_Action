package cn.bput.zcc.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/22.
 */
public class ContinuousSubarraySum402 {
    public static List<Integer> continuousSubarraySum(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(A==null ||A.length==0) return result;
        int max =A[0];
        int submax =A[0];
        int start =0;
        int subStart = 0;
        int end = 0;
        for(int i =1; i<A.length; i++){
            if(submax<0 &&submax<=A[i]){
                submax=A[i];
                subStart = i;
            }else {
                submax +=A[i];
            }
            if(submax>max){
                max = submax;
                start=subStart;
                end = i;
            }
        }
        result.add(start);
        result.add(end);
        return result;
    }
    public static void main(String[] args){
        int[] A={1,2,-2,-100,1,2,-2};
        continuousSubarraySum(A);
    }


}
