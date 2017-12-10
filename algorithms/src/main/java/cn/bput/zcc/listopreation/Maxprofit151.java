package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/10.
 */
public class Maxprofit151 {

    public int maxProfit2(int[] prices){
        if(prices ==null ||prices.length<2) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(min<prices[i]){
                left[i] = Math.max(left[i-1],prices[i]-min);
            }else {
                left[i] = left[i-1];
                min = prices[i];
            }
        }
        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(max>=prices[i]){
                right[i] = Math.max(right[i+1], max-prices[i]);
            }else {
                right[i] = right[i+1];
                max = prices[i];
            }
        }
        int globalMax = 0;
        for(int i=0; i<prices.length;i++){
            globalMax = Math.max(left[i]+right[i], globalMax);
        }

        return globalMax;
    }

    public int maxProfit(int[] prices){
        if(prices ==null ||prices.length<2) return 0;
        int firstMax = 0;
        int seconfMax = 0;
        int globalMin = prices[0];
        int globalMax = prices[0];
        int now = 0;
        for(int i=1; i<prices.length;i++){
            if(globalMin<prices[i]&& globalMax<prices[i]){
                now = prices[i]-globalMin;
                globalMax = prices[i];
            }else {
                 if(now>firstMax){
                     seconfMax = firstMax;
                     firstMax = now;
                 }else if(now>seconfMax){
                     seconfMax = now;
                 }
                 globalMin = prices[i];
                globalMax = prices[i];
            }
        }
        if(now>firstMax){
            seconfMax = firstMax;
            firstMax = now;
        }else if(now>seconfMax){
            seconfMax = now;
        }
        return firstMax+seconfMax;
    }
    public static void main(String[] args){
        Maxprofit151 maxProfit151 =new Maxprofit151();
        int[] a = {1,2};
        maxProfit151.maxProfit2(a);
    }
}
