package cn.bput.zcc.hashtableOperation;

import cn.bput.zcc.linkListOperation.ListNode;

import java.util.*;

/**
 * Created by 张城城 on 2018/1/31.
 */
public class Intersection547 {
    public int[] intersection(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> hashSet1 = new HashSet<Integer>();
        HashSet<Integer> hashSet2 = new HashSet<Integer>();
        for(int i =0;i<nums1.length;i++){
            if(!hashSet1.contains(nums1[i])){
                hashSet1.add(nums1[i]);
            }
        }
        for (int i =0;i<nums2.length;i++){
            if(!hashSet2.contains(nums2[i])){
                hashSet2.add(nums2[i]);
            }
        }
        Iterator<Integer> iterator = hashSet1.iterator();
        while (iterator.hasNext()){
             int value = iterator.next();
            if(hashSet2.contains(value)){
                list.add(value);
            }
        }
        int len = list.size();
        int[] result = new int[len];
        for(int i=0;i<len;i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
