package cn.nskjy.demo.regex;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static boolean test5(String str) {
        char[][] keyCode = {
                {'1','2','3','4','5','6','7','8','9','0'},
                {'q','w','e','r','t','y','u','i','o','p'},
                {'a','s','d','f','g','h','j','k','l'},
                {'z','x','c','v','b','n','m'}
        };
        char[] c = str.toCharArray();
        List<Integer> x = new ArrayList<Integer>();
        List<Integer>  y = new ArrayList<Integer>();
        for (int i = 0; i < c.length; i++) {
            char temp = c[i];
            toHere:
            for(int j=0;j<keyCode.length;j++){
                for(int k=0;k<keyCode[j].length;k++){
                    if(temp== keyCode[j][k]){
                        x.add(j);
                        y.add(k);
                        break toHere;
                    }
                }
            }
        }
        boolean flag= false;
        for(int i=0;i<x.size()-2;i++){
// x                 b
            if(x.get(i)==x.get(i+1)&&x.get(i+1) == x.get(i+2)){//三者在同一y行上
                if(y.get(i)>y.get(i+2)){
                    if( y.get(i)-1 ==  y.get(i+1) &&  y.get(i)-2 ==  y.get(i+2)){
                        flag=true;
                        break;
                    }
                }else{
                    if( y.get(i)+1 ==  y.get(i+1) &&  y.get(i)+2 ==  y.get(i+2)){
                        flag=true;
                        break;
                    }
                }

            }else if(x.get(i)!=x.get(i+1)&&x.get(i+1) != x.get(i+2) &&x.get(i)!=x.get(i+2)){//三者均不在同一行上
                if(x.get(i)>x.get(i+2)){
                    if((x.get(i)-1 == x.get(i+1) && x.get(i)-2 ==  x.get(i+2))){
                        flag=true;
                    }
                }else{
                    if( x.get(i)+1 == x.get(i+1) && x.get(i)+2 ==  x.get(i+2)){
                        flag=true;
                        break;
                    }
                }

            }

        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(test5("fhk456"));
    }
}
