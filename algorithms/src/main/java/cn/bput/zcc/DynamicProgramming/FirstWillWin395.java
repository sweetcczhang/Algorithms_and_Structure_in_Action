package cn.bput.zcc.DynamicProgramming;

/**
 * Created by 张城城 on 2017/12/20.
 */
public class FirstWillWin395 {
    /**
     * 动态规划的一个小技巧：用到从后往前的小技巧
     * 题目： 硬币排成线 II
     * 描述：
     * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从左边依次拿走 1 或 2 个硬币，
     * 直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。请判定 第
     * 一个玩家 是输还是赢？
     * @param values
     * @return
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int len = values.length;
        if(len<=2) return true;
        int[] dp = new int[len+1];
        dp[len] = 0;
        dp[len-1] = values[len-1];
        dp[len-2] = values[len-2] + values[len-1];
        dp[len-3] = values[len-3] + values[len-2];

        for(int i=len-4;i>=0;i--){
            dp[i] = Math.max(values[i]+Math.min(dp[i+2],dp[i+3]),values[i]+values[i+1]+Math.min(dp[i+3],dp[i+4]));
        }
        int sum =0;
        for(int a:values)
            sum +=a;
        return dp[0]>sum-dp[0];
    }
}
