package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2018/1/7.
 */
public class FindDuplicate633 {

    /**
     *
     * 其核心思想快慢指针在之前的题目Linked List Cycle II中就有应用，这里应用的更加巧妙一些，
     * 由于题目限定了区间[1,n]，所以可以巧妙的利用坐标和数值之间相互转换，而由于重复数字的存在，
     * 那么一定会形成环，我们用快慢指针可以找到环并确定环的起始位置
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        // write your code here

       int slow =0, fast=0, t=0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        while (true){
            slow=nums[slow];
            t = nums[t];
            if(slow==t) break;
        }
        return slow;
    }

   public int findDuplicate2(int[] nums){

       return 0;
   }

    /**
     * 二分查找（Binary Search）+ 鸽笼原理（Pigeonhole Principle）
     *
     * 根据鸽笼原理，给定n + 1个范围[1, n]的整数，其中一定存在数字出现至少两次。
     * 假设枚举的数字为 n / 2：遍历数组，若数组中不大于n / 2的数字个数超过n / 2，
     * 则可以确定[1, n /2]范围内一定有解，否则可以确定解落在(n / 2, n]范围内。
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int low = 1, hight = nums.length-1;
        while (low<hight){
            int mid = low +(hight-low)/2;
            int count = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid) count++;
            }
            if(count<=mid) low = mid+1;
            else hight = mid;
        }
        return low;
    }
}
