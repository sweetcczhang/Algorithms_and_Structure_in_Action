package cn.bput.zcc.dataStruck;



import java.util.ArrayList;
import java.util.List;

public class Insert30 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        List<Interval> result = new ArrayList<Interval>();
        if(intervals==null || intervals.size()<1) {
            result.add(newInterval);
            return result;
        }
        int index = 0;

        for(int i=0; i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(newInterval.end<interval.start){
                result.add(interval);

            } else if(newInterval.start> interval.end){
                result.add(interval);
                index++;
            } else{
                newInterval.start = Math.min(interval.start,newInterval.start);
                newInterval.end = Math.max(interval.end,newInterval.end);
            }

        }
        result.add(index,newInterval);
        return result;
    }
}
