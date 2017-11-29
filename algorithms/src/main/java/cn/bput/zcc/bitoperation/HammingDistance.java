package cn.bput.zcc.bitoperation;

/**
 * Created by 张城城 on 2017/11/29.
 */
public class HammingDistance {

    /**
     * 统计一个数组中两两之间的汉明距离之和。
     * 汉明距离是两个数二进制表示时，不一样的位数之和。
     * 求解思路：
     * 1.这里如果使用双重循环一个个比较两个数字的差异，可以算出来，但是在时间上会有用例超时。
     * 2.我们把每一个数都看成32位，对于每一位，我们统计数组中每一个数在这一位为一的个数，那么
     * 在这一位上，所有的情况就是为一的数乘以为零的数，这是一个排列组合的问题，这样就可以很快的
     * 计算出结果。
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for(int i=0;i<32;i++){
            int countOne = 0;
            for (int j=0; j<nums.length; j++){
                int num = nums[j];
                countOne += (num>>i)&1;
            }
            result += countOne*(nums.length-countOne);
        }
        return result;
    }
}
