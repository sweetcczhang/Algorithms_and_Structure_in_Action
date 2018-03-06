package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2018/3/6.
 */
public class IsInterleave29 {
    /**
     * 使用动态规划来求解问题。
     * 解题关键：
     * 1.建立一个二维数组dp，dp[i][j]表示时s3可以由s1的前i个和s2的前j个组成，
     * 那么子问题就是dp[i-1][j]和dp[i][j-1],只有子问题成立，该问题才会成立。
     * 而dp[i-1][j]的子问题是dp[i-2][j]或者dp[i-1][j-1]，以此类推，最后都会
     * 归结为判断dp[1][0]或者dp[0][1]。
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1,String s2, String s3){

        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] =true;
        for (int i=1;i<=s1.length();i++){
            dp[i][0]= dp[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i=1;i<=s2.length();i++){
            dp[0][i] = dp[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i=1;i<=s1.length();i++){
            char c1 = s1.charAt(i-1);
            for(int j=1;j<=s2.length();j++){
                char c2 = s2.charAt(j-1);
                if(c1== s3.charAt(i+j-1)){
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if(c2 == s3.charAt(i+j-1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
