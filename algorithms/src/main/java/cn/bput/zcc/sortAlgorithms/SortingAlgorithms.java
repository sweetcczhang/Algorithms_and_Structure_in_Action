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

    /**
     *归并排序具体工作原理如下（假设序列共有n个元素）：

     将序列每相邻两个数字进行归并操作（merge)，形成floor(n/2)个序列，排序后每个序列包含两个元素
     将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
     重复步骤2，直到所有元素排序完毕

     归并排序是稳定的排序算法，其时间复杂度为O(nlogn)，如果是使用链表的实现的话，空间复杂度可以
     达到O(1)，但如果是使用数组来存储数据的话，在归并的过程中，需要临时空间来存储归并好的数据，
     所以空间复杂度为O(n)
     * @param nums
     * @param start
     * @param mid
     * @param end
     */
    public void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[nums.length];
        int i=start;
        int j= mid+1;
        int k=0;
        /**
         * 将两个已排序好的数组归并成一个有序的数组
         */
        while (i<mid+1 && j<end+1){
            if(nums[i]>nums[j]){
                temp[k++] = nums[j++];
            }else {
                temp[k++] = nums[i++];
            }
        }
        while (i<mid+1){
            temp[k++] = nums[i++];
        }
        while (j<end+1){
            temp[k++] = nums[j++];
        }
        for(i=0, j=start; j<=end; i++,j++){
            nums[i] = temp[j];
        }

    }

    public void mergeSort(int[] nums, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    /**
     * 将数组nums构建大根堆
     * @param nums 待调整的数组
     * @param i   待调整的数组元素的下标
     * @param len 数组的长度
     */
    public void heapAdjust(int[] nums, int i, int len){
        int child;
        int temp;
        for(; 2*i+1<len;i = child){
            child = 2 * i + 1;    //子结点的位置 = 2 * 父结点的位置 + 1
            //得到子节点中键值较大的节点
            if(child<len-1 && nums[child]< nums[child+1]){
                child++;
            }
            //如果较大的子节点大于父节点那么吧较大的子节点往上移动，替换它的父节点
            if(nums[i]<nums[child]){
                temp = nums[i];
                nums[i] = nums[child];
                nums[child] = temp;
            }
            else {
                break;
            }
        }
    }

    /**
     * 堆排序算法
     */
    public void heapSort(int[] nums, int len){
        int i;
        //调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
        for(int j=len/2-1; j>=0; j--){
            heapAdjust(nums,j,len);
        }
        for(i=len-1; i>0;i--){
            // 将第1个元素与当前最后一个元素交换，保证当前的最后一个位置的元素都是现在的这个序列中最大的
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            heapAdjust(nums,0,i);
        }
    }


}
