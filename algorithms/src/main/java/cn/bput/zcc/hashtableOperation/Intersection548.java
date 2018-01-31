package cn.bput.zcc.hashtableOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/31.
 */
public class Intersection548 {
    public int[] intersection(int[] nums1, int[] nums2){
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> hashMap1 = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> hashMap2 = new HashMap<Integer, Integer>();
        for(int i =0;i<nums1.length;i++){
            if(!hashMap1.containsKey(nums1[i])){
                hashMap1.put(nums1[i],1);
            }else {
                hashMap1.put(nums1[i],hashMap1.get(nums1[i])+1);
            }
        }
        for(int i =0;i<nums2.length;i++){
            if(!hashMap2.containsKey(nums2[i])){
                hashMap2.put(nums2[i],1);
            }else {
                hashMap2.put(nums2[i],hashMap2.get(nums2[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: hashMap2.entrySet()){
            if(hashMap1.containsKey(entry.getKey())){
                int size=0;
                if(hashMap1.get(entry.getKey())<entry.getValue()){
                    size = hashMap1.get(entry.getKey());
                }else {
                    size = entry.getValue();
                }
                    for(int i=0;i<size;i++){
                        list.add(entry.getKey());
                    }
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
