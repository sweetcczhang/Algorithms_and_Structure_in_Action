package cn.bput.zcc.listopreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/8.
 */
public class MajorityNumber47 {
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if(nums==null && nums.size()==0) return 0;
        selectSort(nums);
        int max = 1;
        int temp = 1;
        int flags= nums.get(0);
        int now = nums.get(0);
        for(int j=1;j<nums.size();j++){
            if(now==nums.get(j)){
                temp++;
            }else {
                if(temp>max){
                    flags = now;
                    max = temp;
                }
                now = nums.get(j);
                temp =1;
            }
        }
        if(temp>max){
            flags = now;
        }
        return flags;
    }

    public void  selectSort(List<Integer> nums){
         for (int i=0;i<nums.size();i++){
             int index = i;
             for(int j=i+1; j<nums.size();j++){
                    if(nums.get(j)<nums.get(index)){
                        index = j;
                    }
             }
             if(index!=i){
                 int temp = nums.get(i);
                 nums.set(i,nums.get(index));
                 nums.set(index,temp);
             }
         }
    }
    public static  void main(String[] args){
        MajorityNumber47 majorityNumber47 = new MajorityNumber47();
        List<Integer> a = new ArrayList<Integer>();
        a.add(99);
        a.add(2);
        a.add(99);
        a.add(2);
        a.add(99);
        a.add(3);
        a.add(3);
        majorityNumber47.majorityNumber(a);
    }
}
