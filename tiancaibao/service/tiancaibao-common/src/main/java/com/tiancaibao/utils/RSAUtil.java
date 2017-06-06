package com.tiancaibao.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class RSAUtil {

	/*
	 * 注意：参数privateKey是Pem私钥文件中去除头（-----BEGIN RSA PRIVATE KEY-----）和尾（-----END
	 * RSA PRIVATE KEY-----）以及换行符后的字符串。 如果签名报以下错误：
	 * java.security.spec.InvalidKeySpecException:
	 * java.security.InvalidKeyException: IOException : algid parse error, not a
	 * sequence 则说明rsa私钥的格式不是pksc8格式，需要使用以下命令转换一下： openssl pkcs8 -topk8 -inform
	 * PEM -in rsa_private_key.pem -outform PEM -nocrypt
	 * 然后再提取去除头和尾以及换行符后字符串作为java版用的rsa私钥。
	 */
	/**
	 * rsa签名
	 * 
	 * @param content
	 *            待签名的字符串
	 * @param privateKey
	 *            rsa私钥字符串
	 * @param charset
	 *            字符编码
	 * @return 签名结果
	 * @throws Exception
	 *             签名失败则抛出异常
	 */
	public static String rsaSign(String content, String privateKey, String charset) throws SignatureException {
		try {
			PrivateKey priKey = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));

			Signature signature = Signature.getInstance("SHA1WithRSA"); // OPENSSL_ALGO_SHA1
																		// 是一回事否?
			signature.initSign(priKey);
			if (StringUtils.isEmpty(charset)) {
				signature.update(content.getBytes());
			} else {
				signature.update(content.getBytes(charset));
			}
			byte[] signed = signature.sign();
			return new String(Base64.encodeBase64(signed));
		} catch (Exception e) {
			throw new SignatureException("RSAcontent = " + content + "; charset = " + charset, e);
		}
	}

	public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
		if (ins == null || StringUtils.isEmpty(algorithm)) {
			return null;
		}
		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		byte[] encodedKey = IOUtil.inputStream2String(ins).getBytes();
		encodedKey = Base64.decodeBase64(encodedKey);
		return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
	}
}
