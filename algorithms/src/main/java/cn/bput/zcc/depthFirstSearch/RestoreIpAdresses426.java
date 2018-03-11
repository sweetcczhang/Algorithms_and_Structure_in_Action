package cn.bput.zcc.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAdresses426 {
    public List<String> restoreIpAdresses(String s){
        List<String> result = new ArrayList<String>();
        dfs(s,0,"",result);
        return result;
    }
    public void dfs(String s,int index, String ip, List<String> result){
        int len = ip.split("\\.").length;
        if(index==s.length() && len==4){
            result.add(ip);
            return;
        }
        if(index==s.length() || len>4){
            return;
        }
        for(int i = index+1;i<=s.length();i++){
            String sub = s.substring(index,i);
            if(sub.charAt(0)=='0' && sub.length()>1) continue;
            if(sub.length()>3) continue;
            int w= Integer.valueOf(sub);
            if(w>255) continue;
            if(ip.equals("")){
                ip =ip+sub;
            }else {
                ip = ip+"."+sub;
            }
            dfs(s,i,ip,result);
            if(ip.split("\\.").length>1){
                ip = ip.substring(0,ip.length()-sub.length()-1);
            }else {
                ip="";
            }
        }
    }
    public static void main(String[] args){
        String s ="0000";
        RestoreIpAdresses426 r = new RestoreIpAdresses426();
        r.restoreIpAdresses(s);
//        String a ="0.0";
//        String[] w = a.split("\\.");
//        System.out.println(a.split(".").length);
    }
}
