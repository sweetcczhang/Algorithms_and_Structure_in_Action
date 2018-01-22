package cn.bput.zcc.linkListOperation;

import java.util.*;

/**
 * Created by 张城城 on 2018/1/22.
 */
public class MajorityNumber48 {
    public int majorityNumber(List<Integer> nums, int k){
        double flag = 1.0/k;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.size();i++){
            if(map.containsKey(nums.get(i))){
                int temp = map.get(nums.get(i))+1;
                if(1.0*temp/nums.size()>flag)
                    return nums.get(i);
                map.put(nums.get(i), temp);
            }else {
                map.put(nums.get(i),1);
            }
        }

        return 0;
    }
}
