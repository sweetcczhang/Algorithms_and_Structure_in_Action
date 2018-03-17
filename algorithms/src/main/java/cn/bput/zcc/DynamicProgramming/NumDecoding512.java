package cn.bput.zcc.DynamicProgramming;

public class NumDecoding512 {
    /**
     * 使用动态规划解题
     * 思路：设dp[i]表示前一个编码有多少中解法。
     * 状态转移方程是：
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        // write your code here
        if(s==null || s.length()==0) return 0;
        if(s.length()==1 && s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)!='0'){
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2'&&s.charAt(i-1)-'0'<=6)){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];

    }
}
