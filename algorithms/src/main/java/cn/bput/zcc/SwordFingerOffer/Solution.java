package cn.bput.zcc.SwordFingerOffer;


import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by 张城城 on 2018/4/4.
 */
public class Solution {
    List<Character> list = new ArrayList<Character>();
    HashSet<Character> set = new HashSet<Character>();
    public void Insert(char ch)
    {
        if(set.contains(ch)){
            if(list.contains(ch)){
                int index = list.indexOf(ch);
                list.remove(index);
            }
        }else {
            set.add(ch);
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (list.size()==0) return '#';
        return list.get(0);
    }
    public static void main(String[] args){
        String ch ="google";
        Solution solution =new Solution();
        for (int i=0;i<ch.length();i++){
            solution.Insert(ch.charAt(i));
            System.out.print(solution.FirstAppearingOnce());
        }
    }


}
