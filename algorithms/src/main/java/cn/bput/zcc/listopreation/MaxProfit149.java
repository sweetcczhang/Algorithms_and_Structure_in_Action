package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/8.
 */
public class MaxProfit149 {
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
