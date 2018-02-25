package cn.bput.zcc.matrixOperation;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/2/25.
 */
public class TrapRainWater364 {
    public int trapRainWater(int[][] heights){
        int result = 0;
        if(heights==null || heights.length==0 || heights[0].length==0) return result;
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
            public int compare(Cell o1, Cell o2) {
                return o1.height-o2.height;
            }
        });
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            visited[i][0] = true;
            visited[i][n-1]=true;
            pq.offer(new Cell(i,0,heights[i][0]));
            pq.offer(new Cell(i,n-1,heights[i][n-1]));
        }
        for(int i=0; i<n; i++){
            visited[0][i]=true;
            visited[m-1][i]=true;
            pq.offer(new Cell(0,i,heights[0][i]));
            pq.offer(new Cell(m-1,i,heights[m-1][i]));
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.isEmpty()){
            Cell cell = pq.poll();
            for(int [] dir : dirs){
                int row = cell.x+dir[0];
                int col = cell.y + dir[1];
                if(row >= 0 && row<m && col>0 &&col<n && !visited[row][col]){
                    visited[row][col]=true;
                    result += Math.max(0,cell.height-heights[row][col]);
                    pq.offer(new Cell(row,col,Math.max(heights[row][col],cell.height)));
                }
            }
        }

        return result;
    }
    class Cell{
        public int x,y, height;
        public Cell(int x, int y, int height){
            this.x=x;
            this.y=y;
            this.height = height;
        }
    }
    public static void main(String[] args){
        int [][]test ={
                {12,13,0,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };
        TrapRainWater364 trapRainWater364 =new TrapRainWater364();
        trapRainWater364.trapRainWater(test);
    }
}
