package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/24.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums){
        int len = nums.length;
        int flags = 0;
        for(int i=len-1;i>=0;i--){
            if(nums[i]==0){
                flags++;
                for(int j=i;j<len-flags;j++){
                    nums[j]=nums[j+1];
                }
                nums[len-flags]=0;
            }
        }
    }
}
