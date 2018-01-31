package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;

/**
 * Created by 张城城 on 2018/1/30.
 */
public class MaxPoints186 {
    public int maxPoints(Point[] points){
        if(points==null || points.length==0) return 0;
        if(points.length<=2) return points.length;
        int result =0;
        for(int i =0; i<points.length-1;i++){
            int x = points[i].x;
            int y = points[i].y;
            HashMap<Double,Integer> map = new HashMap<Double, Integer>();
            int samep=0;
            int samex=1;
            for(int j=0;j<points.length;j++){
                if(i!=j) {
                    if (points[j].x == x && points[j].y == y) samep++;
                    if (points[j].x == x) {
                        samex++;
                        continue;
                    }
                    double k = (double) (points[j].y - y) / (points[j].x - x);
                    if (map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 2);
                    }
                 result = Math.max(result,map.get(k)+samep);
                }
            }
            result = Math.max(result,samex);
        }
        return result;
    }
}
