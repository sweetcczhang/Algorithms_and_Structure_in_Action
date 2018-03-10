package cn.bput.zcc.DynamicProgramming;

public class MinimumTotal109 {
    public int minimumTotal(int[][] triangle){
         if(triangle==null || triangle.length==0) return 0;
         int min=Integer.MAX_VALUE;
        for(int i= triangle.length-1;i>0;i--)
            for(int j=0; j<triangle[i-1].length;j++){
             triangle[i-1][j] = Math.min(triangle[i][j],triangle[i][j+1])+triangle[i-1][j];
            }

        for(int i=0;i<triangle[0].length;i++){
                if(min>triangle[0][i]){
                    min = triangle[0][i];
                }
        }
        return min;
    }
}
