package cn.bput.zcc.treeOperation;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by 张城城 on 2018/3/4.
 */
public class TopKMovie808 {
    /**
     * 1.建立数据结构Pair维护index和rating的关系。
     * 2.使用优先级队列来存储索Pair。使用rating来对优先级队列进行降序排序。
     * 3.使用深度优先遍历来进行遍历dfs。
     * @param rating
     * @param G
     * @param S
     * @param K
     * @return
     */
    public int[] topKMovie(int[] rating, int[][]G, int S, int K){
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(rating.length, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return o2.rating-o1.rating;
            }
        }) ;
        boolean[] visted = new boolean[rating.length];
        dfs(G,rating,S,S,queue,visted);
        if(queue.size()<K){
            K = queue.size();
        }
        int [] result = new int[K];
        int i=0;
        while (i<K){
            result[i++]= queue.poll().index;
        }
        return result;
    }
    public void dfs(int[][]G,int[] rating,int S, int x, PriorityQueue<Pair> queue, boolean[] visited){
        if(visited[x]) return;
        visited[x]=true;
        if(x!=S){
            queue.offer(new Pair(x,rating[x]));
        }
        for(int i=0;i<G[x].length;i++){
            dfs(G,rating,S,G[x][i],queue,visited);
        }
    }

    class Pair{
        int index;
        int rating;
        public Pair(int index,int rating){
            this.index = index;
            this.rating = rating;
        }
    }
}
