package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/16.
 */
public class MinNumber379 {
    /**
     * 题目：将数组重新排序以构造最小值
     * 描述：
     * 给定一个整数数组，请将其重新排序，以构造最小值。
     * 思路：本题的本质也是数组排序问题，其主要的思路是对数组大小的重新定义。即：
     * (s1+s2)与(s2+s1)的大小，即如前者小于后者则s1<s2,否则s1>s2,其中s1与s2是整数转换的字符串。
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        // write your code here
        StringBuilder result = new StringBuilder();
        if(nums==null || nums.length==0) return "0";
        quick(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            if(result.toString().length()==0 && nums[i]==0) continue;
            result.append(String.valueOf(nums[i]));
        }
        if(result.toString().length()==0)
            return "0";
        return result.toString();
    }

    public void quick(int[] nums, int left, int right){
        if(left<right){
            int result = nums[left];
            int i=left, j=right;
            while (i<j){
                while (i<j && compare(nums[j],result)>=0)
                    j--;
                while (i<j && compare(result,nums[i])>=0)
                    i++;
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums, left, i);
            quick(nums, left,i-1);
            quick(nums, i+1,right);
        }
    }
    public int compare(int n1, int n2){
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);
        return (s1+s2).compareTo(s2+s1);
    }
    public void swap(int[] nums,int i, int j){
         int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
