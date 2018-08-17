package cn.bput.zcc.leetcode;

import cn.bput.zcc.linkListOperation.ListNode;
import cn.bput.zcc.queueOperation.TreeNode;

import java.util.ArrayList;

/**
 * Created by zcc
 * Date on 2018/8/3
 */
public class LongestPalindrome {

    public static String palindrome(String s, int i, int j){
        while(i>=0 && j<s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                break;
            }
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

    public boolean Find(int target, int [][] array) {
        if(array==null || array.length==0 ||array[0].length==0){
            return false;
        }
        return false;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(listNode ==null){
            return result;
        }
        while (listNode!=null){
            int val = listNode.val;
            result.add(0,val);
            listNode = listNode.next;
        }


        return result;

    }



    public TreeNode build(int[] pre, int left, int right, int[] in, int start, int end){
        if(left>right || start>end) return null;
         TreeNode root = new TreeNode(pre[left]);
         int index = search(pre[left],in);
         root.left = build(pre,left+1, index-start+left,in,start, index-1);
         root.right = build(pre,index-start+left+1,right,in, index+1,end);
        return root;

    }
    public int search(int target, int[] array){
        for(int i =0; i<array.length;i++){
            if(array[i]==target){
                return i;
            }
        }
        return -1;
    }

    public int getMax(int m, int[] a, int[] b){
        int[] f = new int[m+1];
        f[0] = 1;
        for (int i=0;i<a.length;i++){
            for (int j=a[i]; j<=m;j++){
                f[j] += f[j-a[i]];
            }
        }
        for (int i=0;i<b.length;i++){
            for (int j=m;j>=b[i];j--){
                f[j] += f[j-b[i]];
            }
        }

        return f[m];

    }

    public static void main(String[] args){
        String s="qwerrty";

        String t = palindrome(s, 3,4);
        System.out.println(t);
    }


}
