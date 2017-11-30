package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2017/11/28.
 */
public class UniquePaths2 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int n = obstacleGrid.length;
        System.out.println("n:"+n);
        int m = obstacleGrid[0].length;
        System.out.println("m:"+m);
        //int[][] result = new int[n][m];
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        boolean flag = true;
        for(int i =0; i<n;i++ ){
            if(!flag){
                obstacleGrid[i][0]=0;
                continue;
            }
            if(obstacleGrid[i][0]==1){
                obstacleGrid[i][0]=0;
                flag=false;
            }else {
                obstacleGrid[i][0]=1;
            }
        }
        flag =true;
        for(int i =1; i<m;i++ ){
            if(!flag){
                obstacleGrid[0][i]=0;
                continue;
            }
            if(obstacleGrid[0][i]==1){
                obstacleGrid[0][i]=0;
                flag=false;
            }else {
                obstacleGrid[0][i]=1;
            }
        }
        for(int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else {
                    obstacleGrid[i][j]= obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[n-1][m-1];
    }

    public static void main(String[] args){
        int [][] a = {{0}};
        uniquePathsWithObstacles(a);
    }
}
