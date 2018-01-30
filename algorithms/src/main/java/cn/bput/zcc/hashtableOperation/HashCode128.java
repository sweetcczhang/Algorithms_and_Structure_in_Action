package cn.bput.zcc.hashtableOperation;



/**
 * Created by 张城城 on 2018/1/30.
 */
public class HashCode128 {
    public int hashCode(char[] key, int HASH_SIZE){
        int len = key.length;
        long hash = 0;
        for(int i=0; i<len; i++){
            hash = hash *33 + key[i];
            hash = hash % HASH_SIZE;
        }
        return (int)hash;
    }
}
