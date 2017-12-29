package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/12/28.
 */
public class ReversePairs532 {


    int result =0;

    public long reversePairs(int[] A) {
        // write your code here
        mergeSort(A,0,A.length-1);
        return result;
    }

    public void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i=start;
        int j= mid+1;
        int k=0;
        /**
         * 将两个已排序好的数组归并成一个有序的数组
         */
        while (i<mid+1 && j<end+1){
            if(nums[i]>nums[j]){
                temp[k++] = nums[j++];
                result+=(mid-i+1);
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
        for(i=0; i<temp.length; i++){
            nums[i+start] = temp[i];
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
}
