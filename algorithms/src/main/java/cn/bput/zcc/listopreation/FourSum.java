package cn.bput.zcc.listopreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 张城城 on 2017/12/1.
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(numbers);
        for(int i= 0; i<numbers.length-3;i++){
            if(i!=0&&numbers[i]==numbers[i-1])
                continue;
            for(int j= i+1; j<numbers.length-2;j++){
                if(j!=i+1&&numbers[j]==numbers[j-1])
                    continue;
                int left = j+1;
                int right = numbers.length-1;
                while (left<right){
                    int sum = numbers[i]+numbers[j]+numbers[left]+numbers[right];
                    if(sum<target){
                        left++;
                    }else if(sum>target){
                        right--;
                    }else {
                        List<Integer> path = new ArrayList<Integer>();
                        path.add(numbers[i]);
                        path.add(numbers[j]);
                        path.add(numbers[left]);
                        path.add(numbers[right]);
                        result.add(path);
                        left++;
                        right--;
                        while (left<right&&numbers[left]==numbers[left-1])
                            left++;
                        while (left<right&&numbers[right]==numbers[right+1])
                            right--;
                    }
                }
            }
        }

        return result;
    }
}
