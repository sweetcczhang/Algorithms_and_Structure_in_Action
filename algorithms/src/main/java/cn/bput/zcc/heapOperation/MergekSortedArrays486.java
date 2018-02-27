package cn.bput.zcc.heapOperation;

import cn.bput.zcc.linkListOperation.Partion96;

import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/2/27.
 */
public class MergekSortedArrays486 {
    public int[] mergeSortedArrays(int[][] arrays){
        if(arrays==null || arrays.length==0 ) return null;
        int len = 0;
        for(int i =0;i<arrays.length;i++){
            len +=arrays[i].length;
        }
        if(len==0) return new int[]{};
        int [] result = new int[len];
        int m = arrays.length;
        int count=0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(arrays.length);
        for(int i=0; i<m;i++) pq.offer(new Node(i,0,arrays[i][0]));
        while (count<len){
            if (pq.size()==0){
                break;
            }
            Node node= pq.poll();
            result[count++]=node.val;
            if(node.col==arrays[node.row].length-1){
                continue;
            }
            pq.offer(new Node(node.row, node.col+1, arrays[node.row][node.col+1]));
        }
        return result;
    }
    class Node implements Comparable<Node>{
        int val;
        int row;
        int col;
        public Node(int row, int col, int val){
            this.row = row;
            this.val = val;
            this.col = col;
        }

        public int compareTo(Node o) {
            return this.val-o.val;
        }
    }
}
