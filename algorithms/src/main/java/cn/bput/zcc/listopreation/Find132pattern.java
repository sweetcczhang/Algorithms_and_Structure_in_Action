package cn.bput.zcc.listopreation;

import java.util.Stack;

/**
 * Created by 张城城 on 2017/11/30.
 */
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        // write your code here
        int i = 0, j=0, k=0;
        int n = nums.length;
        while (i<n){
            while (i<n-1&&nums[i]>=nums[i+1]) i++;
            j=i+1;
            while (j<n-1&&nums[j]<=nums[j+1]) j++;
            k=j+1;
            while (k<n){
                if(nums[i]<nums[j]&&nums[i]<nums[k]&&nums[k]<nums[j]){
                    return true;
                }
                k++;
            }
            i=j+1;
        }
        return false;
    }

    /**
     * 思路是我们维护一个栈和一个变量third，其中third就是第三个数字，也是pattern 132中的2，
     * 栈里面按顺序放所有大于third的数字，也是pattern 132中的3，那么我们在遍历的时候，如
     * 果当前数字小于third，即pattern 132中的1找到了，我们直接返回true即可，因为已经找到了，
     * 注意我们应该从后往前遍历数组。如果当前数字大于栈顶元素，那么我们按顺序将栈顶数字取出，
     * 赋值给third，然后将该数字压入栈，这样保证了栈里的元素仍然都是大于third的，我们想要的
     * 顺序依旧存在，进一步来说，栈里存放的都是可以维持second > third的second值，其中的任何
     * 一个值都是大于当前的third值，如果有更大的值进来，那就等于形成了一个更优的
     * second > third的这样一个组合，并且这时弹出的third值比以前的third值更大，为什么要保证
     * third值更大，因为这样才可以更容易的满足当前的值first比third值小这个条件
     * @param nums
     * @return
     */
    public boolean find132patternStack(int[] nums) {
        Integer third= Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<third) return true;
            else {
                while (!stack.empty()&& nums[i]>stack.lastElement()){
                    third=stack.lastElement();
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }

}
