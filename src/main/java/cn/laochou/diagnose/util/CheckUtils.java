package cn.laochou.diagnose.util;

public class CheckUtils {


    // 比较粗糙的验证
    public static boolean validIdCard(String idCard) {
        if(idCard == null) return false;
        int length = idCard.length();
        return length == 18;
    }


}
