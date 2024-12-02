package xwj.demo.utils;

import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.crypto.symmetric.DES;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricAlgorithm;

public class hutoolCipher {
    private static byte[] hexStr2ByteArr(String strIn) {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    public static void main(String[] args) {
        String content = "test中文";

//随机生成密钥
        byte[] key = SecureUtil.generateKey("TH@1qw3e4r").getEncoded();

//构建
        DES des = SecureUtil.des(key);

//加密解密

//        byte[] encrypt = des.encrypt(content);
        byte[] decrypt = des.decrypt(hexStr2ByteArr("bc59c8a3838ff1ef0d4032e423f278bb"));

//加密为16进制，解密为原字符串
//        String encryptHex = des.encryptHex(content);
        String decryptStr = des.decryptStr("bc59c8a3838ff1ef0d4032e423f278bb");
        System.out.println(decryptStr);
    }
}
