package cn.bput.zcc.listopreation;

import java.util.List;

/**
 * Created by 张城城 on 2017/11/30.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        bubbleSort(numbers);
        for(int i=0;i<numbers.length;i++){
            for(int k = numbers.length-1;k>i+1;k--){

            }

        }

        return null;
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
