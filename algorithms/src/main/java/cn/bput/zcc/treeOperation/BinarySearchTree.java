package cn.bput.zcc.treeOperation;

/**
 * Created by 张城城 on 2018/1/25.
 */
public class BinarySearchTree {

    private TreeNode root;



    /**
     * 查找
     *    树的深度n O(logn)
     *    1.从根节点root开始查找
     *    2.如果比当前节点小则找其左节点
     *    3.如果比当前节点大则找其右节点
     *    4.如果与当前节点相等则返回当前值。
     *    5.查找完毕未找到
     * @param val
     * @return
     */
    public TreeNode search(int val){
        TreeNode current = root;
        while (current!=null && current.val!=val){
            if(current.val<val){
                current=current.left;
            }else if(current.val>val){
                current = current.right;
            }
        }
        return current;
    }
    public void insert(int val){
        //新增节点
        TreeNode newNode = new TreeNode(val);
        TreeNode current = root;
        TreeNode parent = null;
        if(current==null){
            root = newNode;
            return ;
        }
        while(true){
            parent = current;
            if(current.val<val){
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    break;
                }
            }else {
                current = current.right;
                if (current==null){
                    parent.left = newNode;
                    break;
                }
            }
        }
    }

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
     * @param val
     * @return
     */
    public TreeNode delete(int val){
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while(current.val!=val){
            parent = current;
            if(current.val>val){
                isLeftChild = true;
                current = current.left;
            }else {
                isLeftChild =false;
                current =current.right;
            }
            if(current == null){
                return current;
            }
        }
        if(current.left==null && current.right==null){
            if (current==root) root = null;
            if(isLeftChild==true){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if(current.left==null){
            if(current==root){
                root=current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else {
                parent.right = current.right;
            }
        }else if(current.right==null){
            if(current==root){
                root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else {
                parent.right = current.left;
            }
        }else if(current.left!=null && current.right!=null){
            //
            TreeNode successor = getDeleteSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else {
                parent.right = successor;
            }
            successor.left = current.left;
        }

        return current;
    }
    public TreeNode getDeleteSuccessor(TreeNode deleteNode){
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode current = deleteNode.right;
        while (current!=null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if(successor!=deleteNode.right){
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public BinarySearchTree(){
        this.root =null;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void toString(TreeNode root){
        if (root!=null){
            toString(root.left);
            System.out.println("value = " + root.val);
            if(root.right!=null){
                System.out.print("->");
            }
            toString(root.right);
        }
    }

}
