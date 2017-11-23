package cn.bput.zcc.listopreation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2017/11/23.
 */


/**
 * 给出若干闭合区间，合并所有重叠的部分
 */
public class Interval {
    public int start;
    public int end;
    public Interval(int start,int end){
        this.start = start;
        this.end = end;
    }

    public List<Interval> merge(List<Interval> intervals){
        bubbleSort(intervals);
        List<Interval> list = new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            if(list.size()==0){
                list.add(intervals.get(i));
            }else {
                if (list.get(list.size()-1).end>=intervals.get(i).start){
                    if(list.get(list.size()-1).end<intervals.get(i).end){
                        list.get(list.size()-1).end=intervals.get(i).end;
                    }
                }else {
                    list.add(intervals.get(i));
                }
            }
        }
        return list;
    }
    public void bubbleSort(List<Interval> intervals){
        for (int i=0; i<intervals.size()-1; i++){
            for(int j = intervals.size()-1; j>i;j--){
                if(intervals.get(j).start<intervals.get(j-1).start){
                    Interval interval = intervals.get(j);
                    intervals.set(j,intervals.get(j-1));
                    intervals.set(j-1,interval);
                }
            }
        }
    }
}
