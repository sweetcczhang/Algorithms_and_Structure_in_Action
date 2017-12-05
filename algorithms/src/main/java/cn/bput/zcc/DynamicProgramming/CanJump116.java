package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2017/12/4.
 */
public class CanJump116 {
    /**
     * 复习的重点贪心算法和动态规划算法
     * @param A
     * @return
     */
    public boolean canJump(int[] A) {
        // write your code here
        if(A.length==1) return true;
        int[] dp = new int[A.length];
        dp[0]=A[0];
        for(int i =1; i<A.length;i++){
            if(dp[i-1]>=i){
                dp[i] = Math.max(A[i]+i,dp[i-1]);
            }else {
                dp[i]=0;
            }
        }
        return dp[A.length-1]>=A.length-1;
    }

    /**
     * 贪心算法求解跳跃游戏
     * @param A
     * @return
     */
    public boolean canJump2(int[] A){
        if(A.length==1) return true;
        int max=A[0];
        for(int i=1;i<A.length;i++){
            if(max>=i){
                max = Math.max(max,i+A[i]);
            }else {
                return false;
            }
        }
        return true;
    }
}
