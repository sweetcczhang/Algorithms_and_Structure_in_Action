package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2018/3/8.
 */
public class NumDistinct118 {
    /**
     * Ø r a b b b i t
     * Ø 1 1 1 1 1 1 1 1
     * r 0 1 1 1 1 1 1 1
     * a 0 0 1 1 1 1 1 1
     * b 0 0 0 1 2 3 3 3
     * b 0 0 0 0 1 3 3 3
     * i 0 0 0 0 0 0 3 3
     * t 0 0 0 0 0 0 0 3
     * 解题方法：动态规划
     * 解题思路：
     * 使用二维数组dp[i][j]表示字符串T的前i个在字符串的前j个中出现的次数。
     *
     * @param S
     * @param T
     * @return
     */
    public int numDistinct(String S, String T){
        if(S==null && T==null) return 1;
        if(S==null && T!=null) return 0;
        if(S!=null && T==null) return 1;
        int[][] dp = new int[T.length()+1][S.length()+1];
        for(int i=0;i<=S.length();i++) dp[0][i]=1;
        for (int i=1;i<=T.length();i++) dp[i][0]=0;
        for(int i=1;i<=T.length();i++){
            for(int j=1;j<=S.length();j++){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }
}
