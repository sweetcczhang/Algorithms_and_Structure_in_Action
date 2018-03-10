package cn.bput.zcc.DynamicProgramming;

public class MinPathSum110 {
    public int minPathSum(int[][] grid){
        if(grid ==null || grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=1;i<grid[0].length;i++){
            grid[0][i] = grid[0][i]+grid[0][i-1];
        }
        for(int i=1;i<grid.length;i++){
            grid[i][0]=grid[i][0]+grid[i-1][0];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j] = Math.min(grid[i][j-1],grid[i-1][j])+grid[i][j];
            }
        }
        return grid[m-1][n-1];
    }
}
