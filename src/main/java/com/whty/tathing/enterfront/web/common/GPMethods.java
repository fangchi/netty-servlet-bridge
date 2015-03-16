// Copyright (C) 2012 WHTY
package com.whty.tathing.enterfront.web.common;



import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.whty.util.Converts;


/**
 * Created by IntelliJ IDEA. User: fibiger Date: 2009-05-05 Time: 10:18:48 To
 * change this template use File | Settings | File Templates.
 */
public class GPMethods {

	private static final Logger logger = LoggerFactory.getLogger(GPMethods.class);
	
	/**
	 * ECB模式中的DES/3DES/TDES算法(数据不需要填充),支持8、16、24字节的密钥 说明：3DES/TDES解密算法 等同与
	 * 先用前8个字节密钥DES解密 再用中间8个字节密钥DES加密 最后用后8个字节密钥DES解密 一般前8个字节密钥和后8个字节密钥相同
	 *
	 * @param key
	 *            加解密密钥(8字节:DES算法 16字节:3DES/TDES算法
	 *            24个字节:3DES/TDES算法,一般前8个字节密钥和后8个字节密钥相同)
	 * @param data
	 *            待加/解密数据(长度必须是8的倍数)
	 * @param mode
	 *            0-加密，1-解密
	 * @return 加解密后的数据 为null表示操作失败
	 */
	public static String desecb(String key, String data, int mode) {
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
				enc = Cipher.getInstance("DES/ECB/NoPadding");
			} else if (key.length() == 32) {
				// 计算加解密密钥，即将16个字节的密钥转换成24个字节的密钥，24个字节的密钥的前8个密钥和后8个密钥相同,并生成安全密钥
				keySpec = new SecretKeySpec(Converts.stringToBytes(key
						+ key.substring(0, 16)), "DESede");
				// 将key前8个字节复制到keyecb的最后8个字节

				// 生成算法
				enc = Cipher.getInstance("DESede/ECB/NoPadding");
			} else if (key.length() == 48) {
				// 生成安全密钥
				keySpec = new SecretKeySpec(Converts.stringToBytes(key),
						"DESede"); // key

				// 生成算法
				enc = Cipher.getInstance("DESede/ECB/NoPadding");
			} else {
				logger.error("Key length is error");
				return null;
			}

			// 初始化
			enc.init(opmode, keySpec);

			// 返回加解密结果
			return (Converts.bytesToHex(enc.doFinal(Converts
					.stringToBytes(data)))).toUpperCase(); // 开始计算
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
		return null;
	}

}