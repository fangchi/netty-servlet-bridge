package com.whty.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
//	private static final Logger logger = LoggerFactory.getLogger(Encryptor.class);

	/**
	 * 加密算法
	 * 
	 * @author baojw@whty.com.cn
	 * @date 2014年9月28日 下午1:57:58
	 */
	public enum Algorithm {
		DES, DESede, Blowfish
	}

	/**
	 * 块加密模式
	 * 
	 * @author baojw@whty.com.cn
	 * @date 2014年9月28日 下午2:38:11
	 */
	public enum BlockCypherMode {
		/**
		 * 电子密码本（Electronic Code Book）
		 */
		ECB,
		/**
		 * 密码块链接（Cipher Block Chaining）
		 */
		CBC,
		/**
		 * 密码反馈（Cipher Feedback）
		 */
		CFB,
		/**
		 * 输出反馈（Output Feedback）
		 */
		OFB
	}

	@SuppressWarnings("unused")
	private static Cipher buildDesCipher(byte[] key, int opmode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		return Encryptor.buildCipher(key, "DES", "DES/ECB/NoPadding", opmode);
	}

	private static final Map<Integer, Cipher> ENCRYPT_POOL = new HashMap<Integer, Cipher>();
	private static final Map<Integer, Cipher> DECRYPT_POOL = new HashMap<Integer, Cipher>();

	private static Cipher buildDesedeCipher(byte[] key, int opmode, final Map<Integer, Cipher> pool) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		int hashcode = key.hashCode();

		Cipher cipher = pool.get(hashcode);
		if (cipher == null) {
			byte[] md5 = md5(key);
			byte[] _key = new byte[24];
			System.arraycopy(md5, 0, _key, 0, 16);
			System.arraycopy(md5, 0, _key, 16, 8);

			cipher = Encryptor.buildCipher(_key, "DESede", "DESede/ECB/NoPadding", opmode);
			pool.put(hashcode, cipher);
		}
		return cipher;
	}

	private static Cipher buildCipher(byte[] key, String algorithm, String transformation, int opmode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

		// 构造安全密钥实例
		SecretKey secretKey = new SecretKeySpec(key, algorithm);

		// 构造加密器
		Cipher cipher = Cipher.getInstance(transformation);
		// byte[] biv = new byte[8];
		// System.arraycopy(key, 0, biv, 0, 8);
		// IvParameterSpec iv = new IvParameterSpec(biv);

		// 初始化加密器
		cipher.init(opmode, secretKey);

		return cipher;
	}

	/**
	 * 加密<br>
	 * 1.固定加密算法/模式/填充方式（DESede/ECB/NoPadding）的加密方法。<br>
	 * 2.密钥必须是长度为24的字节数组<br>
	 * 3.明文字节数组长度不是8的倍数，末尾用0填充补齐
	 * 
	 * @param key
	 * @param plaintext
	 * @return
	 * 
	 * @author baojw@whty.com.cn
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @date 2014年9月28日 下午2:49:31
	 */
	public static byte[] encrypt(byte[] key, byte[] plaintext) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// 构造加密器
		Cipher cipher = buildDesedeCipher(key, Cipher.ENCRYPT_MODE, ENCRYPT_POOL);
		// 填充
		plaintext = padding(plaintext);
		// 加密
		byte[] ciphertext = cipher.doFinal(plaintext);
		// 编码
		byte[] result = encodeBase64(ciphertext);
		// 输出
		return result;
	}

	/**
	 * 解密<br>
	 * 1.固定加密算法/模式/填充方式（DESede/ECB/NoPadding）的解密方法。<br>
	 * 2.密钥必须是长度为24的字节数组<br>
	 * 3.自动剔除密文字节数组末尾的(byte)0字节
	 * 
	 * @param key
	 * @param ciphertext
	 * @return
	 * 
	 * @author baojw@whty.com.cn
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @date 2014年9月28日 下午2:49:40
	 */
	public static byte[] decrypt(byte[] key, byte[] ciphertext) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// 构造加密器
		Cipher cipher = buildDesedeCipher(key, Cipher.DECRYPT_MODE, DECRYPT_POOL);
		// 反编码
		byte[] text = decodeBase64(ciphertext);
		// 解密
		byte[] plaintext = cipher.doFinal(text);
		// 反填充
		plaintext = unpadding(plaintext);
		// 输出
		return plaintext;
	}

	/**
	 * 补齐填充
	 * 
	 * @param plaintext
	 * @return
	 * 
	 * @author baojw@whty.com.cn
	 * @date 2014年9月28日 下午2:59:35
	 */
	private static byte[] padding(byte[] plaintext) {
		if (null == plaintext) {
			return null;
		}
		int length = plaintext.length;
		int k = plaintext.length % 8;
		if (k == 0) {
			return plaintext;
		}

		byte[] dest = new byte[length + 8 - k];
		System.arraycopy(plaintext, 0, dest, 0, length);
		return dest;
	}

	/**
	 * 反补齐填充
	 * 
	 * @param ciphertext
	 * @return
	 * 
	 * @author baojw@whty.com.cn
	 * @date 2014年9月28日 下午2:59:58
	 */
	private static byte[] unpadding(byte[] ciphertext) {
		if (null == ciphertext) {
			return null;
		}
		int length = 0;
		for (int i = ciphertext.length - 1; i > -1; i--) {
			if (ciphertext[i] != 0) {
				length = i + 1;
				break;
			}
		}

		if (length == ciphertext.length) {
			return ciphertext;
		}

		byte[] dest = new byte[length];
		System.arraycopy(ciphertext, 0, dest, 0, length);
		return dest;
	}

	private static byte[] encodeBase64(byte[] b) {
		if (b == null) {
			return null;
		}

		if (b.length == 0) {
			return new byte[0];
		}

		byte[] res = new byte[b.length * 2];
		for (int i = 0; i < b.length; i++) {
			toArray(b[i], res, i * 2);
		}
		return res;
	}

	private static byte[] decodeBase64(byte[] b) {
		if (b == null) {
			return null;
		}

		if (b.length == 0) {
			return new byte[0];
		}

		byte[] res = new byte[b.length / 2];
		for (int i = 0; i < res.length; i++) {
			toByte(b, res, i);
		}
		return res;
	}

	/**
	 * 字节转字节数组
	 * 
	 * @param b
	 * @return
	 * 
	 * @author baojw@whty.com.cn
	 * @date 2014年10月9日 下午3:20:22
	 */
	private static void toArray(byte b, byte[] out, int index) {
		int tmp = b & 0xFF;
		out[index + 1] = (byte) int2byte(tmp & 0xF);
		if (tmp > 9) {
			out[index] = (byte) int2byte(tmp >> 4);
		}else{
			out[index] = 48;
		}
	}

	private static int int2byte(int i) {
		return (i < 10) ? (48 + i) : (87 + i);
	}

	/**
	 * 字节数组转字节
	 * 
	 * @param b
	 * @return
	 * 
	 * @author baojw@whty.com.cn
	 * @date 2014年10月9日 下午3:20:56
	 */
	private static void toByte(byte[] b, byte[] out, int index) {
		int end = byte2int(b[index * 2 + 1]);
		if (b[index * 2] != 48) {
			end += (byte2int(b[index * 2]) << 4);
		}
		out[index] = (byte) end;
	}

	private static int byte2int(byte i) {
		return (i < 87) ? (i - 48) : (i - 87);
	}

	private static byte[] md5(byte[] txt) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(txt);
		return md.digest();
	}
}
