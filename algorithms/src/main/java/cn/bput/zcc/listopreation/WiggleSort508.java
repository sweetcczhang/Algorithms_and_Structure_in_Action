package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/27.
 */
public class WiggleSort508 {
    /**
     * 题目：摆动排序
     * 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质：
     * nums[0] <= nums[1] >= nums[2] <= nums[3]....
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        // write your code here
        for(int i=0; i<nums.length; i+=2){
            int low=i;
            int higt=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[low]>nums[j]){
                    low = j;
                }
                if(nums[higt]<nums[j]){
                    higt=j;
                }
            }
            if(low!=i){
                int temp= nums[low];
                nums[low] = nums[i];
                nums[i]=temp;
            }
            if((i+1)<nums.length){
                if(higt!=i){
                    int temp=nums[i+1] ;
                    nums[i+1]= nums[higt];
                    nums[higt] = temp;
                }else {
                    int temp = nums[low];
                    nums[low] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

    }
    public static void main(String[] args){
        int[] a={3, 5, 2, 1, 6, 4};
        wiggleSort(a);
    }
}
