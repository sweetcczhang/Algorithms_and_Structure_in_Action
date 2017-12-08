package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/8.
 */
public class MaxProfit149 {
    /**
     * 题目描述：lintcode 149
     * 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
     * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices==null || prices.length<2) return 0;
        int globalMin = prices[0];
        int now=0;
        int globalMax = 0;
        for(int i= 1;i<prices.length;i++){
            if(globalMin<prices[i]){
                now = prices[i]-globalMin;
            }else {
                globalMin = prices[i];
            }
            globalMax = Math.max(globalMax, now);
        }
        return globalMax;
    }
}
