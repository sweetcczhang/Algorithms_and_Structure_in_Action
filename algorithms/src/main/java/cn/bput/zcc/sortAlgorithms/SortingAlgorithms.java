package cn.bput.zcc.sortAlgorithms;

/**
 * Created by 张城城 on 2017/11/17.
 */
public class SortingAlgorithms {

    /**
     * 冒泡排序
     * 算法原理
     * 相邻的数据进行两两比较，小数放在前面，大数放在后面，这样一趟下来，
     * 最小的数就被排在了第一位，第二趟也是如此，如此类推，直到所有的数据排序完成
     * @param nums
     */
    public void bubbleSort(int[] nums){
        int len = nums.length;
        for(int i =0; i<len-1;i++){
            for(int j=len-1;j>i;j--){
                if(nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 算法原理
     先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，
     再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     以此类推，直到所有元素均排序完毕。
     * @param nums
     */
    public void selectSort(int[] nums){
        int len = nums.length;
        for(int i=0; i<len; i++){
            int index = i;
            for(int j=i+1; j<len;j++){
                if(nums[index]>nums[j]){
                    index = j;
                }
            }
            if(index!=i){
                int temp = nums[i];
                nums[i]=nums[index];
                nums[index] = temp;
            }
        }
    }

    /**
     * 插入排序
     * 算法原理
     * 将数据分为两部分，有序部分与无序部分，一开始有序部分包含第1个元素，依次将
     * 无序的元素插入到有序部分，直到所有元素有序。插入排序又分为直接插入排序、二
     * 分插入排序、链表插入等，这里只讨论直接插入排序。它是稳定的排序算法，时间复
     * 杂度为O(n^2)
     * @param nums
     */
    public void insertSort(int[] nums){
        int len = nums.length;
        for(int i=1; i<len; i++){
            int j = i-1;
            int k = nums[i];
            while (j>-1 && k< nums[j]){
                 nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = k;
        }
    }

    /**
     * 快速排序的算法原理
     * 快速排序是目前在实践中非常高效的一种排序算法，它不是稳定的排序算法，平均时
     * 间复杂度为O(nlogn)，最差情况下复杂度为O(n^2)。
     * 它的基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的
     * 所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进
     * 行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right){
        if(left<right){
           int i=left, j=right, target = nums[left];
            while (i<j){
                while (i<j && nums[j]>target){
                    j--;
                }
                if(i<j){
                    nums[i++] = nums[j];
                }
                while (i<j && nums[i]<target){
                    i++;
                }
                if(i<j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = target;
            quickSort(nums,left, i-1);
            quickSort(nums, i+1, right);
        }
    }




}
