package cn.bput.zcc.listopreation;

/**
 * Created by 张城城 on 2017/11/26.
 */
public class RemoveElement {

    /**
     * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。
     * 元素的顺序可以改变，并且对新的数组不会有影响。
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem){
        int count = 0;
        int len = A.length;
        for(int i=0;i<A.length;i++){
            if(A[i]==elem){
                len--;
            }else {
                A[count++] = A[i];
            }
        }
        return len;
    }
}
