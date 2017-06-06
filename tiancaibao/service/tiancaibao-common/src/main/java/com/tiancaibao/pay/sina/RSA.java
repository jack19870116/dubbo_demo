package com.tiancaibao.pay.sina;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * <p>
 * RSA签名,加解密处理核心文件，注意：密钥长度1024
 * </p>
 * 
 * @author leelun
 * @version $Id: RSA.java, v 0.1 2013-11-15 下午2:33:53 lilun Exp $
 */
public class RSA {

	/**
	 * 签名算法
	 */
	public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
	/**
	 * 加密算法RSA
	 */
	public static final String KEY_ALGORITHM = "RSA";
	/**
	 * RSA最大加密明文大小
	 */
	private static final int MAX_ENCRYPT_BLOCK = 117;

	/**
	 * RSA最大解密密文大小
	 */
	private static final int MAX_DECRYPT_BLOCK = 128;

	/**
	 * 获取公钥的key
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";

	/**
	 * 获取私钥的key
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	/**
	 * <p>
	 * 生成密钥对(公钥和私钥)
	 * </p>
	 *
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> genKeyPair() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;

	}

	public static void main(String[] args) throws Exception {
		/*
		 * Map<String, Object> genKeyPair = genKeyPair();
		 * 
		 * String base64publicKey = getPublicKey(genKeyPair);
		 * System.out.println("公钥 \n" + base64publicKey); String
		 * base64privateKey = getPrivateKey(genKeyPair);
		 * System.out.println("私钥\n" + base64privateKey);
		 * 
		 * String passwd = "cat123113"; String charsetName = "utf-8";
		 * 
		 * String encryptByPublicKey =
		 * Base64.encodeBase64String((encryptByPublicKey(
		 * passwd.getBytes(charsetName), base64publicKey)));
		 * System.out.println("加密\n" + encryptByPublicKey);
		 * 
		 * // byte[] decryptByPrivateKey =
		 * decryptByPrivateKey(Base64.decodeBase64(
		 * "JkyqNwIXRP6Awb9u4WoCMHqoGp+PVwrmFHismagWuwyOGaAhmI2wOFRrndK4qrapt/b0cImpiIZlF0HeH9f9bQcKtjeRlClMzwu67MqXv+OgcwJAjn0Af1UtV8xUuLndiQ5CTc25784LVVaRhtFQXxRAvSDmlLMH0JsWXPv00yE="
		 * ), //
		 * "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIGm543B4xth1v4IyXx1Q2/mDlMdgsP1nfdwAwDgY2OY9ixtw1AvI7lBKUs2OlsLCim3tvmUU/xMYtS6zjHQR3pLhZ30qY3Do0tuzM0Samk/0deVP2xPj9KEvQKlUXih8VLw7+BfAJMmNhknQe8rcYFNI/YL1aWKlOlZD71Am6B7AgMBAAECgYAgbyugN+/jqr9I/9O/8enz9V6CBnDvKuPgwcHOl1Pl159GEBN7XL+YGagF68P/gKyDMTVyDFxSUp2q0CzDI3Kt1c4oyd/THT1+Z5BzQMs/TzRGeGirGWp5B40nuuYldAd/A3ngSD1nM1B9azz8NIUyHGYN25/AG7D7OpZyqV42CQJBANpXg2//q+8wDhtFARR2cpSDNrd3kImHTN9vzaMn+PJoIG8N8/9k/NtCzEojjvs3sM7qZjqM9DlxtGsCBXMVNJUCQQCYA3N5PWSFulaG94mEZtqCV1SsI9Xusz6FbfJBax7/c6oJcxBk8+1ZHhqS2YY/qY7DJQ5Q1FZi/8dWnQosGqzPAkBPTF1mPds6AZ/982/S+Lngik9DDt+ls0gOFlL/ILNfhsXQz6aAaTMUhwwfGQ8C2lUSsTrzpOHGQy+ddZx5EYiJAkBs/4x9EphRixsgC75/QYDMlPIRvGBZmAzsf7mFTtobMURrIiZPPNijXgKP6YlpfJrxMlDhhF+s/NpiMJhqp3XhAkEAvU3abcsyG3TTh8lqDxZ//ymz/PlP+kYxxad2dmUen/AhpscZLpcHzgWceG63UWYJItXFW3CvSURuzoyWF5sWMw=="
		 * ); // String string = new String(decryptByPrivateKey, "utf-8"); //
		 * System.out.println("解密后\n" + "++"+string+"++");
		 * 
		 * 
		 * 
		 * String text=
		 * "_input_charset=utf-8&client_ip=120.27.159.197&identity_id=bifuiit10000100171&identity_type=UID&member_type=1&partner_id=200032411678&request_time=20160914164321&service=create_activate_member&version=1.0";
		 * String charset="UTF-8"; String privatekey=
		 * "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALWovWB8a7gwyK1x"+
		 * "JEHhCS4e9PB2mrcHUdVkHe5+hoQjlCvVBsc5ixippX2rXeScpB2im1W+DIX3IyYY"+
		 * "t1bk9GVyIKwr63wN7c6OvgHNyh/dGVhVuxlVF7ThZhg1Bjtu+0Qf6oZ0GoncRbak"+
		 * "4DyXSkLJevsLpJcvGmNhSpRoHZRNAgMBAAECgYBUZcEWQrgJKyEQ86/Uq6iINPm3"+
		 * "fmMDBfOPIKSHWWFFowIEG0S66pElNCwe5q8It33IBvQEMfe/hcJewLztMhIZBztO"+
		 * "KwczcWuIgye6BGcwuoiawxcPZpG/xvy4R9TYLKiMTL2t2smd0eC+pUemQaI5DE1e"+
		 * "z/6SMdOVkm8BoolWQQJBANgGtZjGGkA8WP7OG/HTiyrfomE3VdyFlUZ3yLIIC6WL"+
		 * "ErvTMnFzb/AFNprSn6BT63MRGljqCguy8Q+SZ6QJzm8CQQDXRgqzQJGfKAa5oz4j"+
		 * "ygKWkcedMWnly4MUb5hASwAEn3hgGyPp+NHbC349Y3ot6VZGFQiskAXwGghl3A8F"+
		 * "5ucDAkAA6pZenYiC+T6PZiRsNC+E8QnpS6jLlK17bQqm5q3V9+8OaOjv3kN9Syhe"+
		 * "I8KVlYWMKWhpNCTyw8GOBVr3MSt1AkBDyM49uysfTl8vvPMoGcfO2YBdQt3xea+A"+
		 * "k9MBC5yp1/zzZhhc5/hMXMYXVmd2ZW7BCoZ8r6zu+YODb1NbrGU5AkBAWdVmZd+3"+
		 * "huuv5UI7kyoTEYuZJqYaFivC3RpxYj658vxwff8VjS3KS2hIqOpkUS5p8pZzW3xY"+
		 * "SxOp+BVT1R9A"; System.out.println(privatekey); String publickey=
		 * "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1qL1gfGu4MMitcSRB4QkuHvTwdpq3B1HVZB3ufoaEI5Qr1QbHOYsYqaV9q13knKQdoptVvgyF9yMmGLdW5PRlciCsK+t8De3Ojr4Bzcof3RlYVbsZVRe04WYYNQY7bvtEH+qGdBqJ3EW2pOA8l0pCyXr7C6SXLxpjYUqUaB2UTQIDAQAB";
		 * //加签 String str = sign(text,privatekey, charset);
		 * 
		 * System.out.println("sign="+str);
		 * 
		 * if(verify(text, str, publickey,charset )) {
		 * System.out.println("true"); } else { System.out.println("false"); }
		 */
		String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1qL1gfGu4MMitcSRB4QkuHvTwdpq3B1HVZB3ufoaEI5Qr1QbHOYsYqaV9q13knKQdoptVvgyF9yMmGLdW5PRlciCsK+t8De3Ojr4Bzcof3RlYVbsZVRe04WYYNQY7bvtEH+qGdBqJ3EW2pOA8l0pCyXr7C6SXLxpjYUqUaB2UTQIDAQAB";

		byte[] barr = encryptByPublicKey("18249663899".getBytes(), publickey);
		System.out.println(Base64.encodeBase64String(barr));
	}

	/**
	 * 签名字符串
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param privateKey
	 *            私钥(BASE64编码)
	 *
	 * @param charset
	 *            编码格式
	 * @return 签名结果(BASE64编码)
	 */
	public static String sign(String text, String privateKey, String charset) throws Exception {

		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		signature.update(getContentBytes(text, charset));
		byte[] result = signature.sign();
		return Base64.encodeBase64String(result);

	}

	public static String sign(String text, PrivateKey privateKey, String charset)
			throws SignatureException, InvalidKeyException {
		try {
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initSign(privateKey);
			signature.update(getContentBytes(text, charset));
			byte[] result = signature.sign();
			return Base64.encodeBase64String(result);
		} catch (NoSuchAlgorithmException e) {
			// 不可能发生，
			return null;
		}
	}

	/**
	 * 签名字符串
	 *
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            客户签名结果
	 * @param publicKey
	 *            公钥(BASE64编码)
	 * @param charset
	 *            编码格式
	 * @return 验签结果
	 */
	public static boolean verify(String text, String sign, String publicKey, String charset) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(publicK);
		signature.update(getContentBytes(text, charset));
		return signature.verify(Base64.decodeBase64(sign));

	}

	/**
	 * <P>
	 * 私钥解密
	 * </p>
	 *
	 * @param encryptedData
	 *            已加密数据
	 * @param privateKey
	 *            私钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;

	}

	/**
	 * <p>
	 * 公钥解密
	 * </p>
	 *
	 * @param encryptedData
	 *            已加密数据
	 * @param publicKey
	 *            公钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段解密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
				cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_DECRYPT_BLOCK;
		}
		byte[] decryptedData = out.toByteArray();
		out.close();
		return decryptedData;

	}

	/**
	 * <p>
	 * 公钥加密
	 * </p>
	 *
	 * @param data
	 *            源数据
	 * @param publicKey
	 *            公钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(publicKey);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;

	}

	/**
	 * <p>
	 * 公钥加密
	 * </p>
	 *
	 * @param data
	 *            源数据
	 * @param cert
	 *            证书
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, Certificate cert) throws Exception {

		// 对数据加密
		PublicKey uk = cert.getPublicKey();
		Cipher cipher = Cipher.getInstance(uk.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, uk);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;

	}

	/**
	 * <p>
	 * 私钥加密
	 * </p>
	 *
	 * @param data
	 *            源数据
	 * @param privateKey
	 *            私钥(BASE64编码)
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		byte[] cache;
		int i = 0;
		// 对数据分段加密
		while (inputLen - offSet > 0) {
			if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
				cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			i++;
			offSet = i * MAX_ENCRYPT_BLOCK;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;

	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * <p>
	 * 获取私钥
	 * </p>
	 *
	 * @param keyMap
	 *            密钥对
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return Base64.encodeBase64String(key.getEncoded());
	}

	/**
	 * <p>
	 * 获取公钥
	 * </p>
	 *
	 * @param keyMap
	 *            密钥对
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		return Base64.encodeBase64String(key.getEncoded());
	}

	/**
	 * 从文件中加载私钥
	 * 
	 * @param keyFileName
	 *            私钥文件名
	 * @return 是否成功
	 * @throws Exception
	 */
	public static String loadPrivateKeyByFile() throws Exception {
		try {
			URL path = Thread.currentThread().getContextClassLoader().getResource("");
			System.out.println(new FileReader(URLDecoder.decode(path.toString() + "/key/rsa_sign_private", "utf-8")));
			BufferedReader br = new BufferedReader(
					new FileReader(URLDecoder.decode(path.toString() + "/key/rsa_sign_private", "utf-8")));
			String readLine = null;
			StringBuilder sb = new StringBuilder();
			while ((readLine = br.readLine()) != null) {
				sb.append(readLine);
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
			System.out.println(e);
			throw new Exception("私钥数据读取错误，请根据私钥实际地址获取");
		} catch (NullPointerException e) {
			throw new Exception("私钥输入流为空");
		}
	}

	/**
	 * 使用新浪支付RSA公钥加密
	 */
	public static String encrypt(String content) {
		String publickey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1qL1gfGu4MMitcSRB4QkuHvTwdpq3B1HVZB3ufoaEI5Qr1QbHOYsYqaV9q13knKQdoptVvgyF9yMmGLdW5PRlciCsK+t8De3Ojr4Bzcof3RlYVbsZVRe04WYYNQY7bvtEH+qGdBqJ3EW2pOA8l0pCyXr7C6SXLxpjYUqUaB2UTQIDAQAB";
		byte[] barr = null;
		try {
			barr = encryptByPublicKey(content.getBytes(), publickey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Base64.encodeBase64String(barr);
	}
}
