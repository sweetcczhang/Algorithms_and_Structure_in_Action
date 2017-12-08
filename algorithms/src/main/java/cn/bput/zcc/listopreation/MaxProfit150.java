package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/8.
 */
public class MaxProfit150 {
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices ==null ||prices.length<2) return 0;
        int globalMin = prices[0];
        int globalMax = prices[0];
        int now = 0;
        int sum = 0;
        for(int i=1; i<prices.length;i++){
            if(globalMin<prices[i]&&globalMax<prices[i]){
                now = prices[i]- globalMin;
                globalMax = prices[i];
            }else {
                globalMin = prices[i];
                globalMax = prices[i];
                sum += now;
                now = 0;
            }
        }
        sum +=now;
        return sum;
    }
    public static void main(String[] args){
        MaxProfit150 maxProfit150 =new MaxProfit150();
        int[] a = {3,2,6,5,0,3};
        maxProfit150.maxProfit(a);
    }
}
