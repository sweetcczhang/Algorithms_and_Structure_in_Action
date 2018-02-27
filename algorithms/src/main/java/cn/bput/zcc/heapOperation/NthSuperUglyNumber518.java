package cn.bput.zcc.heapOperation;

/**
 * Created by 张城城 on 2018/2/27.
 */
public class NthSuperUglyNumber518 {
    public int nthSuperUglyNumber(int n, int[] primes){
        int[] pq = new int[n];
        int len = primes.length;
        int[] index = new int[len];
        pq[0]=1;
        for (int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<len;j++){
                min = Math.min(pq[index[j]]*primes[j],min);
            }
            pq[i]=min;
            for (int j=0;j<len;j++){
                if(pq[i]%primes[j]==0){
                    index[j]++;
                }
            }
        }
        return pq[n-1];
    }
}
