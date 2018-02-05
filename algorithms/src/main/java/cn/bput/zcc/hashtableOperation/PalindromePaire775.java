package cn.bput.zcc.hashtableOperation;


import cn.bput.zcc.linkListOperation.Partion96;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 张城城 on 2018/2/5.
 */
public class PalindromePaire775 {
    public List<List<Integer>> palindromePaire( String[] words){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        List<Integer>  pld = new ArrayList<Integer>();
        if(words==null || words.length==0) return null;
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
            if(!words[i].equals("")&& paire(words[i]))
                pld.add(i);

        }
        for(int i =0;i<words.length;i++){
            if(words[i].equals("")){
                for(int x:pld){
                    List<Integer> list1 = new ArrayList<Integer>();
                    list1.add(i);
                    list1.add(x);
                    result.add(list1);
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(x);
                    list.add(i);
                    result.add(list);
                }
            }else {
                for(int j =0;j<words[i].length();j++){
                    String left = words[i].substring(0,j);
                    String right = words[i].substring(j,words[i].length());
                    String releft = reverse(left);
                    String reright = reverse(right);
                    if(paire(left) && map.containsKey(reright) && !reright.equals("")){
                        List<Integer> list = new ArrayList<Integer>();
                        if(map.get(reright)!=i){
                            list.add(map.get(reright));
                            list.add(i);
                            result.add(list);
                        }
                    }
                    if(paire(right) && map.containsKey(releft) && !releft.equals("")){
                        List<Integer> list = new ArrayList<Integer>();
                        if(map.get(releft)!=i){
                            list.add(i);
                            list.add(map.get(releft));
                            result.add(list);
                        }
                    }
                }
            }

        }
        return result;
    }
    public String reverse(String source){
        StringBuilder sb = new StringBuilder(source);
        return sb.reverse().toString();
    }
    public boolean paire(String str){

        if(str.length()%2!=1){
            int size = str.length()/2;
            int i =1;
            int flag=size;
            while(size<str.length()){
                if(str.charAt(flag-i)!=str.charAt(size)) return false;
                i++;
                size++;
            }
        }else {
            int size = str.length()/2;
            int i =1,flag=size;
            while (size<str.length()-1){
                if(str.charAt(flag-i)!=str.charAt(size+1)) return false;
                i++;
                size++;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[] words={"a",""};
        PalindromePaire775 p = new PalindromePaire775();
        p.palindromePaire(words);
    }
}
