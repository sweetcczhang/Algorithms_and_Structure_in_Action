package cn.bput.zcc.heapOperation;

import java.util.*;

/**
 * Created by 张城城 on 2018/2/26.
 */
public class TopFrequentWords471 {
    public String[] topFrequentWords(final String[] words, int k){
        String [] result = new String [k];
        Map<String ,Integer> map = new TreeMap<String, Integer>();
        PriorityQueue<Words> pq = new PriorityQueue<Words>(words.length, new Comparator<Words>() {
            public int compare(Words o1, Words o2) {
                if(o1.count!=o2.count)
                    return o1.count> o2.count ? -1:1;
                else {
                    return o1.words.compareTo(o2.words);
                }
            }
        });
        for(String word : words){
            if(map.containsKey(word)){
                map.put(word,map.get(word)+1);
            }else {
                map.put(word,1);
            }
        }
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            pq.offer(new Words(entry.getKey(),entry.getValue()));
        }
        for (int i=0;i<k;i++){
            result[i]=pq.poll().words;
        }
        return result;
    }
    class Words{
        String words;
        int count;
        public Words(String words, int count){
            this.words = words;
            this.count = count;
        }
    }
}
