package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/24.
 */
public class PartitionArray {

    public void partitionArray(int[] nums){
        int pStart = 0;    //初始化指针pStart,让它指向数组第一个元素
        int pEnd = nums.length-1;  //初始化指针pEnd,让它指向数组最后一个元素
        while (pStart<pEnd){
            //后移pStart,直到它指向偶数
            while ((pStart<pEnd)&&(nums[pStart]%2!=0)){
                pStart++;
            }
            //后移pEnd,直到它指向奇数
            while ((pStart<pEnd)&&(nums[pEnd]%2==0)){
                pEnd--;
            }
            if(pStart<pEnd){  //交换值
                int temp = nums[pStart];
                nums[pStart]=nums[pEnd];
                nums[pEnd] = temp;
            }
        }
    }
}
