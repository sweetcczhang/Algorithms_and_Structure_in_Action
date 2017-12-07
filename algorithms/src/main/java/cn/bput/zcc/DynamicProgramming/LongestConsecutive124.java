package cn.bput.zcc.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 张城城 on 2017/12/7.
 */
public class LongestConsecutive124 {
    public int longestConsecutive(int[] num) {
        // write your code here
        if(num==null||num.length==0) return 0;
        if(num.length==1) return 1;
        Arrays.sort(num);
        int globalMax = 0;
        int localMax = 1;
        for(int i=1;i<num.length;i++){
            if(num[i-1]+1==num[i]){
                localMax++;
            }else if(num[i-1]+1<num[i]) {
                localMax = 1;
            }
            if(localMax>globalMax){
                globalMax = localMax;
            }
        }
        return globalMax;
    }
}
