package cn.bput.zcc.queueOperation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/11.
 */
public class FirstUniqueNumber {
    /**
     * 题目：数据流中第一个唯一的数字
     * 解题思路：使用一个hashMap维护数字出现的次数，使用一个链表维护出现一次的数字。
     * @param nums
     * @param number
     * @return
     */
    public static int firstUniqueNumber(int[]nums, int number){
        if(nums==null || nums.length==0) return -1;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<Integer>();
        int flag = -1;
        for(int i =0; i<nums.length;i++){
            Integer c = map.get(nums[i]);
            if(c!=null){
                map.put(nums[i], c+1);
                list.remove(Integer.valueOf(nums[i]));
            }else {
                map.put(nums[i],1);
                list.add(nums[i]);
            }
            if(nums[i]==number){
                flag = i;
                break;
            }
        }
        if(flag!=-1 && !list.isEmpty()){
            return list.get(0);
        }

        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1,2,2,1,3,4,4,5,6};
        firstUniqueNumber(nums, 5);
    }
}
