package cn.bput.zcc.hashtableOperation;

import java.util.HashMap;

/**
 * Created by 张城城 on 2018/2/2.
 */
public class Maxdiff698 {
     public int maxdiff(int[][] arrs){
         int min= Integer.MAX_VALUE,max=Integer.MIN_VALUE;
         int smin= min, smax = max;
         int result = 0;
         HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
          for(int i =0; i<arrs.length;i++){
              if(min>arrs[i][0]) {
                  smin = min;
                  min = arrs[i][0];
                  map.put(min,i);
              }
              if(max<arrs[i][arrs[i].length-1]) {
                  smax =max;
                  max = arrs[i][arrs[i].length-1];
                  map.put(max,i);
              }
          }
          if(map.get(min) == map.get(max)){
              result = ((max-smin)>(smax-max))? max-smin:smax-smin;
          }else {
              result = max -min;
         }
         return result;
     }
}
