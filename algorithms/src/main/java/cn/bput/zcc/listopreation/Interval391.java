package cn.bput.zcc.listopreation;

import java.util.*;

/**
 * Created by 张城城 on 2017/12/19.
 */
public class Interval391 {
    int start, end;
    Interval391(int start, int end) {
       this.start = start;
       this.end = end;
   }

    public int countOfAirplanes(List<Interval391> airplanes) {
        // write your code here
        if(airplanes ==null || airplanes.size()==0) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new TreeSet<Integer>();
        for(int i=0; i<airplanes.size();i++){
            int start = airplanes.get(i).start;
            int end = airplanes.get(i).end;
            if(map.containsKey(start)){
                map.put(start,map.get(start)+1);
            }else {
                map.put(start,1);
            }
            if(map.containsKey(end)){
                map.put(end, map.get(end)-1);
            }else {
                map.put(end,-1);
            }
            set.add(start);
            set.add(end);
        }
        Iterator<Integer> it = set.iterator();
        int maxNum = Integer.MIN_VALUE;
        int count = 0;
        while (it.hasNext()){
            count +=map.get(it.next());
            maxNum = Math.max(count, maxNum);
        }

        return maxNum;
    }
}
