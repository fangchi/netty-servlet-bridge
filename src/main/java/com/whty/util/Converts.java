package com.whty.util;

public class Converts {

	 /**
     * @param hex
     *            将16进制的ascii 转成中文
     * @return
     */
    public static String hexToAscii(String hex) {
        byte[] buffer = new byte[hex.length() / 2];
        String strByte;

        for (int i = 0; i < buffer.length; i++) {
            strByte = hex.substring(i * 2, i * 2 + 2);
            buffer[i] = (byte) Integer.parseInt(strByte, 16);
        }

        return new String(buffer);
    }

    /**
     * @param hex
     *            每两个字节进行处理
     * @return
     */
    public static byte[] hexToBytes(String hex) {
        byte[] buffer = new byte[hex.length() / 2];
        String strByte;

        for (int i = 0; i < buffer.length; i++) {
            strByte = hex.substring(i * 2, i * 2 + 2);
            buffer[i] = (byte) Integer.parseInt(strByte, 16);
        }

        return buffer;
    }
    
    /**
     * 字节数组转为16进制
     *
     * @param bytes
     *            字节数组
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        int len = bytes.length;
        for (int j = 0; j < len; j++) {
            if ((bytes[j] & 0xff) < 16) {
                buff.append('0');
            }
            buff.append(Integer.toHexString(bytes[j] & 0xff));
        }
        return buff.toString();
    }
    
    /**
     * 字符串转换为字节数组
     * <p>
     * stringToBytes("0710BE8716FB"); return: b[0]=0x07;b[1]=0x10;...b[5]=0xfb;
     */
    public static byte[] stringToBytes(String string) {
        if (string == null || string.length() == 0
                || string.length() % 2 != 0) {
            return null;
        }
        int stringLen = string.length();
        byte byteArrayResult[] = new byte[stringLen / 2];
        StringBuffer sb = new StringBuffer(string);
        String strTemp;
        int i = 0;
        while (i < sb.length() - 1) {
            strTemp = string.substring(i, i + 2);
            byteArrayResult[i / 2] = (byte) Integer.parseInt(strTemp, 16);
            i += 2;
        }
        return byteArrayResult;
    }
    
    /**
     * 整数转为指定长度的字符串
     *
     * @param n
     *            整数
     * @param len
     *            指定长度
     * @return
     */
    public static String intToString(int n, int len) {
        String str = String.valueOf(n);
        int strLen = str.length();
        String zeros = "";
        for (int loop = len - strLen; loop > 0; loop--) {
            zeros += "0";
        }
        if (n >= 0) {
            return zeros + str;
        }
        else {
            return "-" + zeros + str.substring(1);
        }
    }
}
