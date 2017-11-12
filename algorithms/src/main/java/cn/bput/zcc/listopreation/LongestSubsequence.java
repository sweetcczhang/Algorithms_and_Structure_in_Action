package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/12.
 */
public class LongestSubsequence {


    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here

        if(A.length==0){
            return 0;
        }
        int[] dp= new int[A.length];
        dp[0]=1;
        int maxLeft = dp[0];
        for(int i=1; i<A.length;i++){
            if(A[i]>A[i-1]){
                dp[i] = dp[i-1]+1;
            }else {
                dp[i]=1;
            }
            maxLeft=Math.max(maxLeft,dp[i]);
        }

        dp[A.length-1] = 1;
        int maxRight = 1;
        for(int i = A.length-2; i>=0; i--){
            if(A[i]>A[i+1]){
                dp[i] = dp[i+1]+1;
            }else {
                dp[i] = 1;
            }
            maxRight = Math.max(dp[i],maxRight);
        }
        return Math.max(maxLeft,maxRight);
    }
}
