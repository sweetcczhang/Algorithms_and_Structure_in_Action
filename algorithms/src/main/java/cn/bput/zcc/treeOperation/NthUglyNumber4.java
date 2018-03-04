package cn.bput.zcc.treeOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2018/3/4.
 */
public class NthUglyNumber4 {
    public int nthUglyNumber(int n){
        List<Integer> queue = new ArrayList<Integer>();
        queue.add(1);
        int a=0,b=0,c=0;
        for (int i=1; i<n;i++){
            int min = Math.min(queue.get(a)*2,Math.min(queue.get(b)*3,queue.get(c)*5));
            queue.add(min);
            if(min%2==0) a++;
            if(min%3==0) b++;
            if(min%5==0) c++;
        }
        return queue.get(n-1);
    }
}
