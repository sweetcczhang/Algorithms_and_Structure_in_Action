package cn.bput.zcc.sortAlgorithms;

/**
 * Created by zcc
 * Date on 2018/8/7
 */
public class IsNumber {

    public String num;
    public boolean isNumber(char[] str){

        if(str==null) return false;
        num = new String(str);
        boolean numberic = scanInterge();
        if (num.length()!=0 && num.charAt(0)=='.'){


            if (num.length()==1){
                return false;
            }
            num =num.substring(1);
            numberic = unSignInterge() || numberic;
        }
        if (num.length()!=0 && (num.charAt(0)== 'e' || num.charAt(0)=='E')){

            if (num.length()==1){
                return false;
            }
            num = num.substring(1);
            numberic = scanInterge() && numberic;
        }
        return numberic && num.length()==0;
    }

    public boolean scanInterge(){
       if (num.charAt(0)=='+' || num.charAt(0)=='-'){
           num = num.substring(1);
       }
       return unSignInterge();
    }

    public boolean unSignInterge(){
        int i=0;
        while (i<num.length() && num.charAt(i)>='0' && num.charAt(i)<='9'){
            i++;
        }
        if (i<num.length()){
            num = num.substring(i);
        }else {
            num = "";
        }
        return i>0;
    }

}
