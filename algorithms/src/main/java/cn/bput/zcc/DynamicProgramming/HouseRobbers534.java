package cn.bput.zcc.DynamicProgramming;

public class HouseRobbers534 {

    public int houseRobber(int[]nums){

        if(nums==null) return 0;
        if(nums.length==1) return nums[0];
        int result1 = house(nums,0,nums.length-2);
        int result2 = house(nums,1,nums.length-1);
        return Math.max(result1,result2);
    }
    public int house(int[] nums, int start, int end){
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int max0=0;
        int max1=nums[start];
        int max2 = nums[start+1];
        for(int i=start+2; i<=end;i++){
            int max3 = nums[i]+ Math.max(max0,max1);
            max0=max1;
            max1=max2;
            max2 =max3;
        }
        return Math.max(max1,max2);
    }
}
