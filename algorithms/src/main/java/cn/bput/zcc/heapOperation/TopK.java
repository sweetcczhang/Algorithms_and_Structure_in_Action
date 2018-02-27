package cn.bput.zcc.heapOperation;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/2/27.
 */
public class TopK {
    public int[] topK(int[] nums, int k){
        if(nums==null || nums.length==0 || nums.length<k || k<=0) return null;
        int[] result = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1>o2 ? -1 : 1;
            }
        });
        for (int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
        }
        for(int i=0;i<k;i++){
            result[i]=pq.poll();
        }
        return result;
    }
}
