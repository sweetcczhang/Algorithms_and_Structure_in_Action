package cn.bput.zcc.sortAlgorithms;

import java.util.Arrays;

public class SubArraySum139 {
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int sum=0;
        int[] result = {0,0};
        Pair[] pair=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            pair[i]=new Pair(i,sum);
        }
        Arrays.sort(pair);
        int min = Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++){
            if(min> pair[i].sum-pair[i-1].sum){
                min = pair[i].sum-pair[i-1].sum;
                result[0]= Math.min(pair[i].index,pair[i-1].index)+1;
                result[1]=Math.max(pair[i].index,pair[i-1].index);

            }
        }
        return result;
    }
    class Pair implements Comparable<Pair>{
        public int index;
        public int sum;
        public Pair(int index,int sum){
            this.index = index;
            this.sum = sum;
        }

        public int compareTo(Pair o) {
            return o.sum-this.sum;
        }
    }
}
