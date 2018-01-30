package cn.bput.zcc.hashtableOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张城城 on 2018/1/30.
 */
public class Anagrams171 {
    /**
     * lintcode 171
     * 题目：乱序字符串
     * 描述：给出一个字符串数组S，找到其中所有的乱序字符串(Anagram)。
     * 如果一个字符串是乱序字符串，那么他存在一个字母集合相同，但顺
     * 序不同的字符串也在S中。
     * 解题思路：想办法把乱序字符串映射成相同的hash值，然后使用hashtable进行保存。
     * @param strs
     * @return
     */
    public List<String> anagrams(String [] strs){
        if(strs==null || strs.length<2) return null;
        List<String> result = new ArrayList<String>();
        Map<String,ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            String  key = generate(str);
            ArrayList<String> res = hash.get(key);
            if(res==null){
                res = new ArrayList<String>();
                hash.put(key,res);
            }
            res.add(str);
        }
        for(ArrayList<String> f: hash.values()){
            if(f.size()>1) result.addAll(f);
        }
        return result;
    }
    public String generate(String str){
        int [] hash = new int[26];
        for(int i =0; i <str.length();i++){
            int a = str.charAt(i)-'a';
            hash[a]++;
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<26;i++){
            if(hash[i]==0) continue;
            char c = (char)('a'+i);
            builder.append(c);
            builder.append(hash[i]);
        }
        return builder.toString();
    }
}
