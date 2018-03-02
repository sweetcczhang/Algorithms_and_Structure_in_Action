package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/2.
 */
public class IsIdentical469 {
    public boolean isIdentical(TreeNode a, TreeNode b){
        if(a==null && b==null) return true;
         if(a==null || b==null ) return false;
        if(a.val==b.val){
            boolean left = isIdentical(a.left,b.left);
            boolean right = isIdentical(a.right,b.right);
            return  (left&&right);
        }
        return false;
    }
}
