package cn.bput.zcc.sortAlgorithms;

public class LargestNumber184 {

    public String largestNumber(int[] nums){
        if(nums==null || nums.length==0) return "0";
        sort(nums,0,nums.length-1);
        StringBuilder s = new StringBuilder();
        if(nums[nums.length-1]==0) return "0";
        for(int i=nums.length-1;i>=0;i--){
            s.append(nums[i]);
        }
        return s.toString();
    }
    public void sort(int[] nums, int start, int end){
        if(start<end){
            int i=start; int j=end; int target = nums[start];
            while (i<j){
                while (i<j && compare(nums[j],target)){
                    j--;
                }
                if(i<j){
                    nums[i++]= nums[j];
                }
                while (i<j && compare(target,nums[i])){
                    i++;
                }
                if(i<j){
                    nums[j--]=nums[i];
                }
            }
            nums[i]=target;
            sort(nums,start,i-1);
            sort(nums,i+1,end);
        }

    }
    public boolean compare(int a, int b){
        double s1= Double.valueOf(""+a+b);
        double s2 = Long.valueOf(""+b+a);
        if(s1>=s2) return true;
        return false;
    }
}
