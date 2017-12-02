package cn.bput.zcc.listopreation;

import cn.bput.zcc.sortAlgorithms.SortingAlgorithms;

/**
 * Created by 张城城 on 2017/12/1.
 */

public class SortColors {


    SortingAlgorithms sortingAlgorithms;

    /**
     * 给定一个包含红，白，蓝且长度为 n 的数组，将数组元素进行分类使相同颜色的元素相邻，
     * 并按照红、白、蓝的顺序进行排序。我们可以使用整数 0，1 和 2 分别代表红，白，蓝。
     * @param nums
     */
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length-1;
        sortingAlgorithms.quickSort(nums, left, right);
    }

}
