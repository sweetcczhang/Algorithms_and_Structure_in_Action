package cn.bput.zcc.listopreation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张城城 on 2017/11/30.
 */
public class ThreeSum {

    /**
     * 三个数的和基础还是两个数的和、两个数的和||，a+b+c = 0，等价于a+b = -c,
     * 这样就和两个数的和|| 很类似，当然也可以参考两个数的和I求解。先对数组排
     * 序，排序后的数组，定义其实节点i，然后对i+1 到len内的所有节点进行两端遍
     * 历，这里利用二分查找的思想，设两端的两个下标是left 和right ，显然
     * sum=nums[i] + nums[left] + nums[right] >0时候 ，right--,小于0的时候left++,
     * 等于0的时候就是答案。时间复杂度O(NlogN)
     * @param numbers
     * @return
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        bubbleSort(numbers);
        for(int i=0;i<numbers.length;i++){
            int j=i+1;
            int k=numbers.length-1;
            while (j<k){
                int sum = numbers[i]+numbers[j]+numbers[k];
                if(sum==0){
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(numbers[i]);
                    path.add(numbers[j]);
                    path.add(numbers[k]);
                   if(result.contains(path)==false) {
                       result.add(path);
                   }
                   j++;
                    k--;

                }else if (sum<0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return result;
    }
    public void bubbleSort(int[] numbers){
        int index = 0;
        for(int i = 0; i<numbers.length;i++){
            index = i;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[j]<numbers[index]){
                    index=j;
                }
            }
            if(index!=i){
                int temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;
            }
        }
    }
}
