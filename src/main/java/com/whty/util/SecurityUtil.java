package com.whty.util;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityUtil {

	private static Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

	/**
	 * RSA签名
	 * 
	 * @param key
	 *            RSA的密钥 公钥用X.509编码；私钥用PKCS#8编码
	 * @param data
	 *            输入数据
	 * @param mode
	 *            0-加密，1-解密
	 * @param type
	 *            0-私钥加密，公钥解密 1-公钥加密，私钥解密
	 * @return 签名后的数据 为null表示操作失败
	 */
	public static String generateRSA(String key, String data, int mode, int type) {
		try {
			// 判断加密还是解密
			int opmode = (mode == 0) ? Cipher.ENCRYPT_MODE
					: Cipher.DECRYPT_MODE;
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			Key strkey = null;
			if (mode != type) { // 生成公钥
				KeySpec keySpec = new X509EncodedKeySpec(
						Converts.stringToBytes(key)); // X.509编码
				strkey = keyFactory.generatePublic(keySpec);
			} else { // 生成私钥
				KeySpec keySpec = new PKCS8EncodedKeySpec(
						Converts.stringToBytes(key)); // PKCS#8编码
				strkey = keyFactory.generatePrivate(keySpec);
			}

			// 获得一个RSA的Cipher类，使用私钥加密
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			// RSA/ECB/PKCS1Padding

			// 初始化
			cipher.init(opmode, strkey);

			// 返回加解密结果
			return (Converts.bytesToHex(cipher.doFinal(Converts
					.stringToBytes(data)))).toUpperCase(); // 开始计算
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return null;
	}

	/**
	 * md5加密
	 */
	public final static String encodeByMD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * CBC模式中的DES/3DES/TDES算法(数据不需要填充),支持8、16、24字节的密钥 说明：3DES/TDES解密算法 等同与
	 * 先用前8个字节密钥DES解密 再用中间8个字节密钥DES加密 最后用后8个字节密钥DES解密 一般前8个字节密钥和后8个字节密钥相同
	 * 
	 * @param key
	 *            加解密密钥(8字节:DES算法 16字节:3DES/TDES算法
	 *            24个字节:3DES/TDES算法,一般前8个字节密钥和后8个字节密钥相同)
	 * @param data
	 *            待加/解密数据(长度必须是8的倍数)
	 * @param icv
	 *            初始链值(8个字节) 一般为8字节的0x00 icv=GPConstant.icvRand
	 * @param mode
	 *            0-加密，1-解密
	 * @return 加解密后的数据 为null表示操作失败
	 */
	public static String descbc(String key, String data, String icv, int mode) {
		try {
			// 判断加密还是解密
			int opmode = (mode == 0) ? Cipher.ENCRYPT_MODE
					: Cipher.DECRYPT_MODE;

			SecretKey keySpec = null;

			Cipher enc = null;

			// 判断密钥长度
			if (key.length() == 16) {
				// 生成安全密钥
				keySpec = new SecretKeySpec(Converts.stringToBytes(key), "DES");
				// key

				// 生成算法
				enc = Cipher.getInstance("DES/CBC/NoPadding");
			} else if (key.length() == 32) {
				// 计算加解密密钥，即将16个字节的密钥转换成24个字节的密钥，24个字节的密钥的前8个密钥和后8个密钥相同,并生成安全密钥
				keySpec = new SecretKeySpec(Converts.stringToBytes(key
						+ key.substring(0, 16)), "DESede");
				// 将key前8个字节复制到keycbc的最后8个字节

				// 生成算法
				enc = Cipher.getInstance("DESede/CBC/NoPadding");
			} else if (key.length() == 48) {
				// 生成安全密钥
				keySpec = new SecretKeySpec(Converts.stringToBytes(key),
						"DESede"); // key

				// 生成算法
				enc = Cipher.getInstance("DESede/CBC/NoPadding");
			} else {
				logger.error("Key length is error");
				return null;
			}

			// 生成ICV
			IvParameterSpec ivSpec = new IvParameterSpec(
					Converts.stringToBytes(icv)); // icv
			// 初始化
			enc.init(opmode, keySpec, ivSpec);
			// 返回加解密结果
			return (Converts.bytesToHex(enc.doFinal(Converts
					.stringToBytes(data)))).toUpperCase(); // 开始计算
		} catch (Exception e) {
			logger.error("Exception: ", e);
		}
		return null;
	}
	

	 /**
    * 填充80数据，首先在数据块的右边追加一个'80',如果结果数据块是8的倍数，不再进行追加,如果不是,追加0x00到数据块的右边，直到数据块的长度是8的倍数。
    * @param data 待填充80的数据
    * @return
    */
   public static String padding80(String data) {
       int padlen = 8 - (data.length() / 2) % 8;
       StringBuffer padstr = new StringBuffer();
       for (int i = 0; i < padlen - 1; i++)
           padstr.append("00");
       data = data + "80" + padstr.toString();
       return data;
   }
   
   /**
    * 填充paddingStr数据，如果结果数据块是8的倍数，不再进行追加,如果不是,追加到数据块的右边，直到数据块的长度是8的倍数。
    * @param data 待填充的数据
    * @return
    */
   public static String padding(String data,String paddingStr) {
       int padlen = 8 - (data.length() / 2) % 8;
       if (padlen != 8) {
           StringBuffer padstr = new StringBuffer();
           for (int i = 0; i < padlen; i++)
               padstr.append(paddingStr);
           data += padstr;
           return data;
       } else {
           return data;
       }
   }
	
	 /**
    * 填充05数据，如果结果数据块是8的倍数，不再进行追加,如果不是,追加0x05到数据块的右边，直到数据块的长度是8的倍数。
    * @param data 待填充05的数据
    * @return
    */
   public static String padding05(String data) {
   	return padding(data,"05");
   }
	
	/**
    * 填充20数据，如果结果数据块是8的倍数，不再进行追加,如果不是,追加0x20到数据块的右边，直到数据块的长度是8的倍数。
    * @param data 待填充20的数据
    * @return
    */
   public static String padding20(String data) {
       return padding(data,"20");
   }
	
	/**
	 * 填充00数据，如果结果数据块是8的倍数，不再进行追加,如果不是,追加0x00到数据块的右边，直到数据块的长度是8的倍数。
	 * @param data 待填充00的数据
	 * @return
	 */
	public static String padding00(String data) {
		return padding(data,"00");
	}
	
	/**
     * ECB模式中的DES/3DES/TDES算法(数据不需要填充),支持8、16、24字节的密钥 说明：3DES/TDES解密算法 等同与
     * 先用前8个字节密钥DES解密 再用中间8个字节密钥DES加密 最后用后8个字节密钥DES解密 一般前8个字节密钥和后8个字节密钥相同
     * @param key  加解密密钥(8字节:DES算法 16字节:3DES/TDES算法
     *             24个字节:3DES/TDES算法,一般前8个字节密钥和后8个字节密钥相同)
     * @param data 待加/解密数据(长度必须是8的倍数)
     * @param mode 0-加密，1-解密
     * @return 加解密后的数据 为null表示操作失败
     */
    public static String desecb(String key, String data, int mode) {
        try {

            // 判断加密还是解密
            int opmode = (mode == 0) ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE;
            SecretKey keySpec = null;
            Cipher enc = null;
            // 判断密钥长度
            if (key.length() == 16) {
                // 生成安全密钥
                keySpec = new SecretKeySpec(str2bytes(key), "DES");// key
                // 生成算法
                enc = Cipher.getInstance("DES/ECB/NoPadding");
            } else if (key.length() == 32) {
                // 计算加解密密钥，即将16个字节的密钥转换成24个字节的密钥，24个字节的密钥的前8个密钥和后8个密钥相同,并生成安全密钥
                keySpec = new SecretKeySpec(str2bytes(key
                        + key.substring(0, 16)), "DESede");// 将key前8个字节复制到keyecb的最后8个字节
                // 生成算法
                enc = Cipher.getInstance("DESede/ECB/NoPadding");
            } else if (key.length() == 48) {
                // 生成安全密钥
                keySpec = new SecretKeySpec(str2bytes(key), "DESede");// key
                // 生成算法
                enc = Cipher.getInstance("DESede/ECB/NoPadding");
            } else {
                logger.info("Key length is error");
                return null;
            }
            // 初始化
            enc.init(opmode, keySpec);
            // 返回加解密结果
            return (Converts.bytesToHex(enc.doFinal(str2bytes(data))))
                    .toUpperCase();// 开始计算
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return null;
    }
    
    /**
	 * 将16进制组成的字符串转换成byte数组 例如 hex2Byte("0710BE8716FB"); 将返回一个byte数组
	 * b[0]=0x07;b[1]=0x10;...b[5]=0xFB;
	 * @param src 待转换的16进制字符串
	 * @return
	 */
	public static byte[] str2bytes(String src) {
		if (src == null || src.length() == 0 || src.length() % 2 != 0) {
			return null;
		}
		int nSrcLen = src.length();
		byte byteArrayResult[] = new byte[nSrcLen / 2];
		StringBuffer strBufTemp = new StringBuffer(src);
		String strTemp;
		int i = 0;
		while (i < strBufTemp.length() - 1) {
			strTemp = src.substring(i, i + 2);
			byteArrayResult[i / 2] = (byte) Integer.parseInt(strTemp, 16);
			i += 2;
		}
		return byteArrayResult;
	}
	
	/**
	 * 订单接口md5加密算法
	 * @param plainText
	 * @return
	 */
	
	public static String encodeByMD5ByOrder(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error("md加密失败：" + e.getMessage());
		}
		return "";
	}
	
	/**
	 * des加解密 ， 3des加解密；补位80
	 * @param key 16位des 32位3des
	 * @param data 加解密数据
	 * @param mode 0-加密" 1-解密
	 * @return
	 */
	public static String thrDes(String key, String data , int mode) {
		if(mode == 0){
			data = byteToHex(data.getBytes());
			data = padding80(data);
			
		}
		String result = desecb(key, data, mode);
		if(mode == 1){
			for(int i=0 ; i<result.length(); i+=2){
				String res = result.substring(i , i+2);
				if(res.equals("80")){
					result = result.substring(0,i);
					break;
				}
			}
			try {
				result = new String(hexToBytes(result) , "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	public static String byteToHex(byte[] buffer) {
		  StringBuffer hexString = new StringBuffer();
		  String hex;
		  int iValue;   for (int i = 0; i < buffer.length; i++) {
		   iValue = buffer[i];
		   if (iValue < 0)
		    iValue += 256;    hex = Integer.toString(iValue, 16);
		   if (hex.length() == 1)
		    hexString.append("0" + hex);
		   else
		    hexString.append(hex);
		  }   return hexString.toString().toUpperCase();
		 }

		
		 /**
		  * @param hex
		  *            每两个字节进行处理
		  * @return
		  */
		 public static byte[] hexToBytes(String hex) {
		  byte[] buffer = new byte[hex.length() / 2];
		  String strByte;   for (int i = 0; i < buffer.length; i++) {
		   strByte = hex.substring(i * 2, i * 2 + 2);
		   buffer[i] = (byte) Integer.parseInt(strByte, 16);
		  }   return buffer;
		 }
		 
		 
		 public static String generalStringToAscii(int length) {

				int num = 1;
				String strRandom;

				for (int i = 0; i < length; i++) {
					num *= 10;
				}

				try {
					Thread.sleep(10);
					Random rand = new Random((new Date()).getTime());
					strRandom = Integer.toString(rand.nextInt(num));

					int len = strRandom.length();
					for (int i = 0; i < length - len; i++) {
						strRandom = "0" + strRandom;
					}

				} catch (InterruptedException e) {
					strRandom = "00000000";
				}

				StringBuffer sbu = new StringBuffer();
				char[] chars = strRandom.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					sbu.append((int) chars[i]);
				}
				return sbu.toString();
			}


			/*
			 * 将字符串编码成16进制数字,适用于所有字符（包括中文）
			 */
			public static String encodeHexString(String str) {
				// 根据默认编码获取字节数组
				byte[] bytes = str.getBytes();
				final String hexString = "0123456789abcdef";
				StringBuilder sb = new StringBuilder(bytes.length * 2);
				// 将字节数组中每个字节拆解成2位16进制整数
				for (int i = 0; i < bytes.length; i++) {
					sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
					sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
				}
				return sb.toString();
			}
			
			/*
			 * 将16进制数字解码成字符串,适用于所有字符（包括中文）
			 */
			public static String hexStringToString(String bytes) throws UnsupportedEncodingException {
				ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
				final String hexString = "0123456789abcdef";
				// 将每2位16进制整数组装成一个字节
				for (int i = 0; i < bytes.length(); i += 2)
					baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
				return new String(baos.toByteArray(), "UTF-8");
			}
			
			/**
			 * 将byte数组转换成16进制组成的字符串 例如 一个byte数组 b[0]=0x07;b[1]=0x10;...b[5]=0xFB;
			 * byte2hex(b); 将返回一个字符串"0710BE8716FB"
			 * 
			 * @param bytes
			 *            待转换的byte数组
			 * @return
			 */
			public static String bytesToHexString(byte[] bytes) {
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
	
}
