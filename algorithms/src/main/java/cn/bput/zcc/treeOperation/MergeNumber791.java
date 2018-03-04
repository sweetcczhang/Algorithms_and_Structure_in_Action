package cn.bput.zcc.treeOperation;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 张城城 on 2018/3/4.
 */
public class MergeNumber791 {
    public int mergeNumber(int[] numbers){
        if(numbers==null || numbers.length<2) return 0;
        int result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i=0;i<numbers.length;i++){
             queue.offer(numbers[i]);
        }
        while (queue.size()>=2){
            int n = queue.poll()+queue.poll();
            result+=n;
            queue.offer(n);
        }
        return result;
    }
}
