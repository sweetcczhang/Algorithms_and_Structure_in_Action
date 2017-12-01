package cn.bput.zcc.listopreation;

import cn.bput.zcc.sortAlgorithms.SortingAlgorithms;

/**
 * Created by 张城城 on 2017/12/1.
 */

public class SortColors {

    SortingAlgorithms sortingAlgorithms;
    public void sortColors(int[] nums) {
        // write your code here
        int left = 0;
        int right = nums.length-1;
        sortingAlgorithms.quickSort(nums, left, right);
    }

}
