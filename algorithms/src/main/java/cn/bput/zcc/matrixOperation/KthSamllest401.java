package cn.bput.zcc.matrixOperation;

import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/2/25.
 */
public class KthSamllest401 {
    public int kthSmallest(int[][] matrix, int k){
        if(matrix==null || k<0 || k>matrix.length*matrix[0].length) return -1;
        int result=0;
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<Node> heap = new PriorityQueue<Node>();
        for(int i=0;i<m;i++){
            heap.add(new Node(i,0,matrix[i][0]));
        }
        int count = 1;
        while (count<k){
            if(heap.size()==0){
                break;
            }
            Node top = heap.poll();
            count++;
            if(top.col==matrix[0].length-1){
                continue;
            }
            heap.add(new Node(top.row, top.col+1,matrix[top.row][top.col+1]));
        }
        if(count<k){
            return -1;
        }
        return heap.poll().val;

    }
    class Node implements Comparable<Node>{

        public int col;
        public int row;
        public int val;
        public Node(int row,int col,int val){
            this.val=val;
            this.row = row;
            this.col = col;
        }
        public int compareTo(Node o) {
            return this.val>o.val ? 1 : this.val < o.val ? -1 : 0;
        }
    }
}
