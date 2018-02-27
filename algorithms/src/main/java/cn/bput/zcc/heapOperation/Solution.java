package cn.bput.zcc.heapOperation;

import cn.bput.zcc.linkListOperation.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/2/27.
 */
public class Solution {
    int k;
    List<Integer> list;
    public Solution(int k){
        this.k = k;
        list = new ArrayList<Integer>();
    }
    public void add(int num){
        list.add(num);
    }
    public List<Integer> topK(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i=0;i<list.size();i++){
            if(priorityQueue.size()<k){
                priorityQueue.offer(list.get(i));
            }else {
                int data = priorityQueue.peek();
                int s = list.get(i);
                if(data<s){
                    priorityQueue.poll();
                    priorityQueue.offer(s);
                }
            }
        }
        int size = priorityQueue.size();
        for(int i=0;i<size;i++){
            list1.add(0,priorityQueue.poll());
        }
        return list1;
    }
    public static void main(String[] args){
        Solution solution = new Solution(3);
        solution.add(3);
        solution.add(10);
        solution.topK();
        solution.add(1000);
        solution.add(-99);
        solution.topK();
        solution.add(4);
        solution.topK();

    }
}
