package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/2.
 */
public class IsSubtree245 {
    public boolean isSubtree(TreeNode T1,TreeNode T2){
        if(T1==null && T2==null) return true;
        if(T1==null) return false;
        if(T2==null) return true;
        if(T1.val == T2.val){
            boolean res = isEqual(T1,T2);
            if(res) return res;
        }
        boolean left = isSubtree(T1.left,T2);
        if(left) return left;
        boolean right = isSubtree(T1.right, T2);
        return right;
    }
    public boolean isEqual(TreeNode T1, TreeNode T2){
        if(T1==null && T2==null) return true;
        if(T1==null) return false;
        if(T2==null) return false;
        if(T1.val==T2.val){
            boolean left = isEqual(T1.left,T2.left);
            boolean right = isEqual(T1.right,T2.right);
            if(left && right){
                return true;
            }
        }
        return false;
    }
}
