package cn.bput.zcc.listopreation;

import java.util.ArrayList;

/**
 * Created by 张城城 on 2017/12/4.
 */
public class LongestIncreasingSubsequence76 {

    /**
     * 题目：
     * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
     * 最长上升子序列的定义：
     * 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的
     * 由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
     *
     * 贪心策略：时间复杂度:O(n*lg(n))
     *
     * 策略：
     * 这里是定义一个List数组，存储这个升序子序列，并且还是动态变化的，对于新来的元素，通过二分查找，
     * 插入到这个list数组中，当大于list数组最后一个元素的时候直接在最后插入，如果在list数组中间位置，
     * 就直接在中间位置插入，为什么？说明中间位置额那个数比需要插入的数字大，我们找的是最长的升序子序列，
     * 比他大的当然需要被小的替代了，由于list数组是动态变化的，最后list数组的大小就是最长升序子序列，
     * 并且其存储的数就是这个升序子序列，上面的方法对这个升序序列不好存储的。同时中间状态的list数组
     * 也是原数组中间位置的最长升序子序列
     *
     * 举例：原序列为1，5，8，3，6，7栈为1，5，8，此时读到3，用3替换5，
     * 得到1，3，8； 再读6，用6替换8，得到1，3，6；再读7，得到最终栈
     * 为1，3，6，7。最长递增子序列为长度4。
     * @param nums
     * @return
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int len = nums.length;
        ArrayList<Integer> db = new ArrayList<Integer>();
        if(nums==null||len==0){
            return 0;
        }
        for(int i=0;i<len;i++){
            if(db.isEmpty()|| db.get(db.size()-1)<nums[i]){
                db.add(nums[i]);
            }else {
                int index = findFirstLargeEqual(db,nums[i]);
                db.set(index,nums[i]);
            }
        }
        for(int i =0; i<db.size();i++){
            System.out.print(db.get(i)+" ");
        }
        return db.size();
    }
    public int findFirstLargeEqual(ArrayList<Integer> list, int num){
        int left = 0;
        int right = list.size()-1;
        while (left<right){
            int mid = (left+right)/2;
            if(list.get(mid)<=num){
                left = mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }



    public static void main(String[] args){
        LongestIncreasingSubsequence76 a =new LongestIncreasingSubsequence76();
        int[] b= {4,2,4,5,3,7};
        a.longestIncreasingSubsequence(b);
    }
}
