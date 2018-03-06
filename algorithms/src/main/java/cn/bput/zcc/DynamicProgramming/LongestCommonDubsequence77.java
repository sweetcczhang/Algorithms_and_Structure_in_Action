package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2018/3/6.
 */
public class LongestCommonDubsequence77 {
    public int longestCommonSubsequence(String A, String B){
        if(A==null || B==null) return 0;
        int[][] dp = new int[A.length()+1][B.length()+1];
        for (int i=1;i<=A.length();i++){
            char a = A.charAt(i-1);
            for (int j=1;j<=B.length();j++){
                char b= B.charAt(j-1);
                if(a==b){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
