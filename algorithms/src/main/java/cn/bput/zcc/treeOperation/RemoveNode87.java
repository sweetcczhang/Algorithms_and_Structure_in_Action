package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/3/5.
 */
public class RemoveNode87 {
    /**
     * 二叉查找树删除的时候分为四种情况：
     * 1. 删除的节点为叶子节点。若该叶子节点为根节点，则把根节点设置为空。
     * 若不是根节点则把该节点设置为空~
     * 2. 删除的节点没有左孩子节点。若该节点为根节点则 root = current.right.
     * 若不是根节点，则该用右孩子来代替删除的节点
     * 3. 删除的节点没有右孩子。若该节点为根节点则 root = current.left。
     * 若不是根节点，则用左孩子来代替删除的节点。
     * 4. 若删除的节点既有左孩子又有右孩子节点。则使用该删除节点的右子树的小节点或者
     * 左子树最大节点来代替该节点。
     * @param
     * @return
     */
    public TreeNode removeNode(TreeNode root, int value){
        if(root==null) return root;
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while (current.val!=value){
            parent = current;
            if(current.val>value){
                current = current.left;
                isLeftChild = true;
            }else {
                current = current.right;
                isLeftChild = false;
            }
            if (current==null){
                return root;
            }
        }
        if(current.left==null && current.right==null){
            if(current==root){
                root =null;
            }else if(isLeftChild) {
                parent.left =null;
            }else {
                parent.right = null;
            }
        }else if(current.left==null){
            if(current ==root){
                root = root.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else {
                parent.right = current.right;
            }
        }else if(current.right==null){
            if(current==root){
                root = root.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else {
                parent.right = current.left;
            }
        }else if(current.left!=null && current.right!=null){
            TreeNode successor = getDeleteSuccessor(current);
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else {
                parent.right = successor;
            }
            successor.left = current.left;

        }
        return root;
    }
    public TreeNode getDeleteSuccessor(TreeNode deleteNode){
        TreeNode parentSuccessor = null;
        TreeNode successor  = null;
        TreeNode current = deleteNode.right;
        while (current!=null){
            parentSuccessor = successor;
            successor = current;
            current = current.left;
        }
        if(successor != deleteNode.right){
            parentSuccessor.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }
}
