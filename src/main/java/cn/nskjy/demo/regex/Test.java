package cn.nskjy.demo.regex;

public class Test {

    public static void main(String[] args) {
        System.out.println(isPasswordContinuous("dfghjkl"));
    }

    /**
     * 密码是否是正序或反序连续4位及以上
     * @param pwd
     * @return true为正确，false为错误。
     */
    public static boolean isPasswordContinuous(String pwd) {
        int count = 0;//正序次数
        int reverseCount = 0;//反序次数
        String[] strArr = pwd.split("");
        for(int i = 1 ; i < strArr.length-1 ; i ++) {//从1开始是因为划分数组时，第一个为空
            if(isPositiveContinuous(strArr[i],strArr[i+1])) {
                count ++;
            }
            else {
                count = 0;
            }
            if(isReverseContinuous(strArr[i],strArr[i+1])) {
                reverseCount ++;
            }
            else {
                reverseCount = 0;
            }
            if(count > 2 || reverseCount > 2) break;
        }
        if(count > 2 || reverseCount > 2) return false;
        return true;
    }

    /**
     * 是否是正序连续
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isPositiveContinuous(String str1 , String str2) {
        if(str2.hashCode() - str1.hashCode() == 1) return true;
        return false;
    }
    /**
     * 是否是反序连续
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isReverseContinuous(String str1 , String str2) {
        if(str2.hashCode() - str1.hashCode() == -1) return true;
        return false;
    }
    /**
     * - 字母区分大小写，可输入符号<br/>
     - 密码必须同时包含字母和数字<br/>
     - 密码长度8-20位<br/>
     - 密码中不能存在连续4个及以上的数字或字母（如：1234、7654、abcd、defgh等）<br/>
     - 密码中不能包含个人手机号后4位<br/>
     @author Miaozz.
     @param phone 手机号码
      * @param password 密码
     * @return true为正确，false为错误
     */
    public static boolean isPasswordAvailable(String phone,String password) {
        String last4No = phone.substring(phone.length()-4);
        String str = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$";//必须同时包含字母数字并且是8-20位
        if(!password.contains(last4No) && password.matches(str)) {
            return isPasswordContinuous(password);
        }
        return false;
    }
}
