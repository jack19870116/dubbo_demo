package com.tiancaibao.service.pay;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.exception.ServiceException;
import com.tiancaibao.pay.sina.Base64;
import com.tiancaibao.pay.sina.CallServiceUtil;
import com.tiancaibao.pay.sina.GsonUtil;
import com.tiancaibao.pay.sina.PropertiesUtil;
import com.tiancaibao.pay.sina.RSA;
import com.tiancaibao.pay.sina.SignUtil;
import com.tiancaibao.pay.sina.Tools;
import com.tiancaibao.utils.RegexUtil;
import com.tiancaibao.utils.StringUtil;

/**
 * 新浪支付业务层接口实现类
 * 
 * @author Mack 2017年2月3日 下午5:03:41
 */
@Service("sinaPaySendService")
public class PaySinaPaySendService {

	private static final Logger log = LoggerFactory.getLogger(PaySinaPaySendService.class);
	
	public String send2SinPayGetSinaUrl(Object obj) {
		Map<String, Object> params = Tools.objectToMap(obj);
		log.info("获取到的参数 params ＝ " + params + ";\n");
		// 记录返回结果
		// Map<String, String> resultmap = new HashMap<String, String>();
		String _input_charset = (String) params.get("_input_charset");// 字符编码集
		String sign_type = (String) params.get("sign_type");// 签名类型
		String service = (String) params.get("service");// 接口名称
		String url = Tools.get_url(service);// 遍历接口名，选取对应的请求网关地址
		// 加密密钥
		String encrypt = PropertiesUtil.getValue("DEBUG_SINAPAY_RSA_PUBLIC_KEY");
		Map<String, String> param1 = Tools.getParameterMap(params, true);
		// 去除map中为空参数
		Iterator<Map.Entry<String, String>> it = param1.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String value = entry.getValue();
			// String key = entry.getKey();
			try {
				if (value == null || value == "" || value.equals("")) {
					it.remove();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 加密部分
		Map<String, Object> properties = params;
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		String[] arr = Tools.get_need_RSA();// 需要加密key的数组
		Arrays.sort(arr);
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			// String base64_value_encrypt = null;
			try {
				if (null == valueObj) {
					value = "";
				} else if (valueObj instanceof String) {
					String valuesin = (String) valueObj;
					// 如果key在数组内则对其做加密
					if (Arrays.binarySearch(arr, name) >= 0) {
						byte[] value_encrypt = null;
						value_encrypt = RSA.encryptByPublicKey(valuesin.getBytes("utf-8"), encrypt);
						String base64_value_encrypt = Base64.encode(value_encrypt);
						// 将加密好的value放到map中替换原有值
						// param1.put(name, value_encrypt.toString());
						param1.put(name, base64_value_encrypt.toString());
					} else {
						value = valueObj.toString();
					}
				} else if (valueObj instanceof String[]) {
					String[] values = (String[]) valueObj;
					for (int j = 0; j < values.length; j++) {
						value = values[j] + ",";
					}
					value = Tools.trimInnerSpaceStr(value.substring(0, value.length() - 1));
					// 如果key在数组内则对其做加密
					if (Arrays.binarySearch(arr, name) >= 0) {
						byte[] value_encrypt = null;
						value_encrypt = RSA.encryptByPublicKey(value.getBytes("utf-8"), encrypt);
						String base64_value_encrypt = Base64.encode(value_encrypt);
						// 将加密好的value放到map中替换原有值
						// param1.put(name, value_encrypt.toString());
						param1.put(name, base64_value_encrypt.toString());
					} else {
						value = valueObj.toString();
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// 加签
		String content = Tools.trimInnerSpaceStr(Tools.createLinkString(param1, false));
		String signKey = null;
		String sign = null;
		if ("RSA".equalsIgnoreCase(sign_type)) {
			// 加签密钥
			signKey = PropertiesUtil.getValue("DEBUG_SINAPAY_RSA_SIGN_PRIVATE_KEY");
		}
		try {
			// 计算签名
			sign = SignUtil.sign(content, sign_type, signKey, _input_charset);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		param1.put("sign", sign);
		param1.put("sign_type", sign_type);
		String param = Tools.createLinkString(param1, true);
		// 获取同步响应
		String result = null;
		try {
			result = URLDecoder.decode(CallServiceUtil.sendPost(url, param), _input_charset);
			log.info("获取到的同步响应 result ＝ " + result + ";\n");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (result == null || StringUtil.isEmpty(result)) {
			throw new ServiceException("新浪接口未返回数据");
		}
		String pattern = "action=\\'(.*?)\\'"; // 此处正则是否正确
		String sinaUrl = RegexUtil.pregMatch(pattern, result);
		String pattern2 = "<input type=\"hidden\" name=\"ft\" value=\"(.*?)\" />";
		String sinaUrl2 = RegexUtil.pregMatch(pattern2, result);
		if (StringUtils.isNotBlank(sinaUrl2)) {
			sinaUrl = sinaUrl + "?ft=" + sinaUrl2;
		}
		return sinaUrl;

	}
	

	@SuppressWarnings("rawtypes")
	public <T> T send2SinPay(Object obj, Class<T> t) {
		Map<String, Object> params = Tools.objectToMap(obj);
		log.info("获取到的参数 params ＝ " + params + ";\n");
		// 记录返回结果
		// Map<String, String> resultmap = new HashMap<String, String>();
		String _input_charset = (String) params.get("_input_charset");// 字符编码集
		String sign_type = (String) params.get("sign_type");// 签名类型
		String service = (String) params.get("service");// 接口名称
		String url = Tools.get_url(service);// 遍历接口名，选取对应的请求网关地址
		// 加密密钥
		String encrypt = PropertiesUtil.getValue("DEBUG_SINAPAY_RSA_PUBLIC_KEY");
		Map<String, String> param1 = Tools.getParameterMap(params, true);
		// 去除map中为空参数
		Iterator<Map.Entry<String, String>> it = param1.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String value = entry.getValue();
			// String key = entry.getKey();
			try {
				if (value == null || value == "" || value.equals("")) {
					it.remove();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 加密部分
		Map<String, Object> properties = params;
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		String[] arr = Tools.get_need_RSA();// 需要加密key的数组
		Arrays.sort(arr);
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			// String base64_value_encrypt = null;
			try {
				if (null == valueObj) {
					value = "";
				} else if (valueObj instanceof String) {
					String valuesin = (String) valueObj;
					// 如果key在数组内则对其做加密
					if (Arrays.binarySearch(arr, name) >= 0) {
						byte[] value_encrypt = null;
						value_encrypt = RSA.encryptByPublicKey(valuesin.getBytes("utf-8"), encrypt);
						String base64_value_encrypt = Base64.encode(value_encrypt);
						// 将加密好的value放到map中替换原有值
						// param1.put(name, value_encrypt.toString());
						param1.put(name, base64_value_encrypt.toString());
					} else {
						value = valueObj.toString();
					}
				} else if (valueObj instanceof String[]) {
					String[] values = (String[]) valueObj;
					for (int j = 0; j < values.length; j++) {
						value = values[j] + ",";
					}
					value = Tools.trimInnerSpaceStr(value.substring(0, value.length() - 1));
					// 如果key在数组内则对其做加密
					if (Arrays.binarySearch(arr, name) >= 0) {
						byte[] value_encrypt = null;
						value_encrypt = RSA.encryptByPublicKey(value.getBytes("utf-8"), encrypt);
						String base64_value_encrypt = Base64.encode(value_encrypt);
						// 将加密好的value放到map中替换原有值
						// param1.put(name, value_encrypt.toString());
						param1.put(name, base64_value_encrypt.toString());
					} else {
						value = valueObj.toString();
					}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// 加签
		String content = Tools.trimInnerSpaceStr(Tools.createLinkString(param1, false));
		String signKey = null;
		String sign = null;
		if ("RSA".equalsIgnoreCase(sign_type)) {
			// 加签密钥
			// signKey =
			// "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO/6rPCvyCC+IMalLzTy3cVBz/+wamCFNiq9qKEilEBDTttP7Rd/GAS51lsfCrsISbg5td/w25+wulDfuMbjjlW9Afh0p7Jscmbo1skqIOIUPYfVQEL687B0EmJufMlljfu52b2efVAyWZF9QBG1vx/AJz1EVyfskMaYVqPiTesZAgMBAAECgYEAtVnkk0bjoArOTg/KquLWQRlJDFrPKP3CP25wHsU4749t6kJuU5FSH1Ao81d0Dn9m5neGQCOOdRFi23cV9gdFKYMhwPE6+nTAloxI3vb8K9NNMe0zcFksva9c9bUaMGH2p40szMoOpO6TrSHO9Hx4GJ6UfsUUqkFFlN76XprwE+ECQQD9rXwfbr9GKh9QMNvnwo9xxyVl4kI88iq0X6G4qVXo1Tv6/DBDJNkX1mbXKFYL5NOW1waZzR+Z/XcKWAmUT8J9AkEA8i0WT/ieNsF3IuFvrIYG4WUadbUqObcYP4Y7Vt836zggRbu0qvYiqAv92Leruaq3ZN1khxp6gZKl/OJHXc5xzQJACqr1AU1i9cxnrLOhS8m+xoYdaH9vUajNavBqmJ1mY3g0IYXhcbFm/72gbYPgundQ/pLkUCt0HMGv89tn67i+8QJBALV6UgkVnsIbkkKCOyRGv2syT3S7kOv1J+eamGcOGSJcSdrXwZiHoArcCZrYcIhOxOWB/m47ymfE1Dw/+QjzxlUCQCmnGFUO9zN862mKYjEkjDN65n1IUB9Fmc1msHkIZAQaQknmxmCIOHC75u4W0PGRyVzq8KkxpNBq62ICl7xmsPM=";
			// MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBpueNweMbYdb+CMl8dUNv5g5THYLD9Z33cAMA4GNjmPYsbcNQLyO5QSlLNjpbCwopt7b5lFP8TGLUus4x0Ed6S4Wd9KmNw6NLbszNEmppP9HXlT9sT4/ShL0CpVF4ofFS8O/gXwCTJjYZJ0HvK3GBTSP2C9WlipTpWQ+9QJugewIDAQAB

			signKey = PropertiesUtil.getValue("DEBUG_SINAPAY_RSA_SIGN_PRIVATE_KEY");
		}
		try {
			// 计算签名
			sign = SignUtil.sign(content, sign_type, signKey, _input_charset);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		param1.put("sign", sign);
		param1.put("sign_type", sign_type);
		String param = Tools.createLinkString(param1, true);
		// 获取同步响应
		String result = null;
		try {
			result = URLDecoder.decode(CallServiceUtil.sendPost(url, param), _input_charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (result == null || StringUtil.isEmpty(result)) {
			throw new ServiceException("新浪接口未返回数据");
		}
		Map<String, String> content2 = GsonUtil.fronJson2Map(result);
		if ("RSA".equalsIgnoreCase(content2.get("sign_type").toString())) {
			// 验签公钥
			// signKey =
			// "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDv0rdsn5FYPn0EjsCPqDyIsYRawNWGJDRHJBcdCldodjM5bpve+XYb4Rgm36F6iDjxDbEQbp/HhVPj0XgGlCRKpbluyJJt8ga5qkqIhWoOd/Cma1fCtviMUep21hIlg1ZFcWKgHQoGoNX7xMT8/0bEsldaKdwxOlv3qGxWfqNV5QIDAQAB";
			signKey = PropertiesUtil.getValue("DEBUG_SINAPAY_RSA_SIGN_PUBLIC_KEY");
		}
		String sign_result = content2.get("sign").toString();
		String sign_type_result = content2.get("sign_type").toString();
		String _input_charset_result = content2.get("_input_charset").toString();
		content2.remove("sign");
		content2.remove("sign_type");
		content2.remove("sign_version");
		// 去除map中为空参数
		Iterator<Map.Entry<String, String>> it2 = content2.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry<String, String> entry2 = it2.next();
			String value2 = entry2.getValue();
			// String key = entry2.getKey();
			try {
				if (value2 == null || value2 == "" || value2.equals("")) {
					it2.remove();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String like_result = Tools.trimInnerSpaceStr(Tools.createLinkString(content2, false));
		// 对同步响应做验签
		try {
			if (!SignUtil.Check_sign(like_result.toString(), sign_result, sign_type_result, signKey,
					_input_charset_result)) {
				throw new ServiceException("sign error");
			}
		} catch (ServiceException se) {
			throw new ServiceException(se.getMessage());
		} catch (Exception ee) {
			throw new ServiceException("sign exception");
		}
		T parseObject = JSONObject.parseObject(result, t);
		return parseObject;
	}

	// @SuppressWarnings("rawtypes")
	// public Map<String, String> send(SinaBaseRequestParam qbrpar) {
	/*
	 * Map<String, String> params = new HashMap<>(); try {
	 * BeanUtils.populate(qbrpar, params); } catch (Exception e2) {
	 * e2.printStackTrace(); } // 记录返回结果 Map<String, String> resultmap = new
	 * HashMap<String, String>(); //
	 * =======================发送部分========================= String
	 * _input_charset = (String) params.get("_input_charset");// 字符编码集 String
	 * sign_type = (String) params.get("sign_type");// 签名类型 String service =
	 * (String) params.get("service");// 接口名称 String url =
	 * Tools.get_url(service);// 遍历接口名，选取对应的请求网关地址 //
	 * 参数去除sign,sign_type,sign_version Map<String, String> param1 =
	 * Tools.getParameterMap(params, true); // 去除map中为空参数
	 * Iterator<Map.Entry<String, String>> it = param1.entrySet().iterator();
	 * while (it.hasNext()) { Map.Entry<String, String> entry = it.next();
	 * String value = entry.getValue(); //String key = entry.getKey(); try { //
	 * value不能是null，否则equals会抛错 if (value == null || value == "" ||
	 * value.equals("")) { it.remove(); } } catch (Exception e) {
	 * e.printStackTrace(); } } // 加密部分 Map properties = params; Iterator
	 * entries = properties.entrySet().iterator(); Map.Entry entry; String name
	 * = ""; String value = ""; String[] arr = Tools.get_need_RSA();//
	 * 需要加密key的数组 Arrays.sort(arr); while (entries.hasNext()) { entry =
	 * (Map.Entry) entries.next(); name = (String) entry.getKey(); Object
	 * valueObj = entry.getValue(); String base64_value_encrypt = null; try { if
	 * (null == valueObj) { value = ""; } else if (valueObj instanceof String[])
	 * { String[] values = (String[]) valueObj; for (int j = 0; j <
	 * values.length; j++) { value = values[j] + ","; } value =
	 * Tools.trimInnerSpaceStr(value.substring(0, value.length() - 1)); // 加密公钥
	 * String encrypt =
	 * "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBpueNweMbYdb+CMl8dUNv5g5THYLD9Z33cAMA4GNjmPYsbcNQLyO5QSlLNjpbCwopt7b5lFP8TGLUus4x0Ed6S4Wd9KmNw6NLbszNEmppP9HXlT9sT4/ShL0CpVF4ofFS8O/gXwCTJjYZJ0HvK3GBTSP2C9WlipTpWQ+9QJugewIDAQAB";
	 * // 如果key在数组内则对其做加密 if (Arrays.binarySearch(arr, name) >= 0) { byte[]
	 * value_encrypt = null; value_encrypt =
	 * RSA.encryptByPublicKey(value.getBytes("utf-8"), encrypt);
	 * base64_value_encrypt = Base64.encode(value_encrypt); //
	 * 将加密好的value放到map中替换原有值 param1.put(name, base64_value_encrypt.toString());
	 * } else { value = valueObj.toString(); } } } catch (Exception e1) {
	 * e1.printStackTrace(); } } // 加签 String content =
	 * Tools.trimInnerSpaceStr(Tools.createLinkString(param1, false)); String
	 * signKey = null; String sign = null; if
	 * ("RSA".equalsIgnoreCase(sign_type)) { // 加签私钥 signKey =
	 * "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAO/6rPCvyCC+IMalLzTy3cVBz/+wamCFNiq9qKEilEBDTttP7Rd/GAS51lsfCrsISbg5td/w25+wulDfuMbjjlW9Afh0p7Jscmbo1skqIOIUPYfVQEL687B0EmJufMlljfu52b2efVAyWZF9QBG1vx/AJz1EVyfskMaYVqPiTesZAgMBAAECgYEAtVnkk0bjoArOTg/KquLWQRlJDFrPKP3CP25wHsU4749t6kJuU5FSH1Ao81d0Dn9m5neGQCOOdRFi23cV9gdFKYMhwPE6+nTAloxI3vb8K9NNMe0zcFksva9c9bUaMGH2p40szMoOpO6TrSHO9Hx4GJ6UfsUUqkFFlN76XprwE+ECQQD9rXwfbr9GKh9QMNvnwo9xxyVl4kI88iq0X6G4qVXo1Tv6/DBDJNkX1mbXKFYL5NOW1waZzR+Z/XcKWAmUT8J9AkEA8i0WT/ieNsF3IuFvrIYG4WUadbUqObcYP4Y7Vt836zggRbu0qvYiqAv92Leruaq3ZN1khxp6gZKl/OJHXc5xzQJACqr1AU1i9cxnrLOhS8m+xoYdaH9vUajNavBqmJ1mY3g0IYXhcbFm/72gbYPgundQ/pLkUCt0HMGv89tn67i+8QJBALV6UgkVnsIbkkKCOyRGv2syT3S7kOv1J+eamGcOGSJcSdrXwZiHoArcCZrYcIhOxOWB/m47ymfE1Dw/+QjzxlUCQCmnGFUO9zN862mKYjEkjDN65n1IUB9Fmc1msHkIZAQaQknmxmCIOHC75u4W0PGRyVzq8KkxpNBq62ICl7xmsPM=";
	 * } try { // 计算签名 sign = SignUtil.sign(content, sign_type, signKey,
	 * _input_charset); } catch (Exception e1) { e1.printStackTrace(); }
	 * param1.put("sign", sign); param1.put("sign_type", sign_type); String
	 * param = Tools.createLinkString(param1, true); // 获取同步响应 String result =
	 * null; try { // 返回结果 result =
	 * URLDecoder.decode(CallServiceUtil.sendPost(url, param), _input_charset);
	 * Map<String, String> content2 = GsonUtil.fronJson2Map(result); if
	 * ("RSA".equalsIgnoreCase(content2.get("sign_type").toString())) { // 验签公钥
	 * signKey =
	 * "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDv0rdsn5FYPn0EjsCPqDyIsYRawNWGJDRHJBcdCldodjM5bpve+XYb4Rgm36F6iDjxDbEQbp/HhVPj0XgGlCRKpbluyJJt8ga5qkqIhWoOd/Cma1fCtviMUep21hIlg1ZFcWKgHQoGoNX7xMT8/0bEsldaKdwxOlv3qGxWfqNV5QIDAQAB";
	 * } String sign_result = content2.get("sign").toString(); String
	 * sign_type_result = content2.get("sign_type").toString(); String
	 * _input_charset_result = content2.get("_input_charset").toString();
	 * content2.remove("sign"); content2.remove("sign_type");
	 * content2.remove("sign_version"); // 去除map中为空参数 Iterator<Map.Entry<String,
	 * String>> it2 = content2.entrySet().iterator(); while (it2.hasNext()) {
	 * Map.Entry<String, String> entry2 = it2.next(); String value2 =
	 * entry2.getValue(); //String key = entry2.getKey(); //
	 * value不能是null，否则equals会抛错 if (value2 == null || value2 == "" ||
	 * value2.equals("")) { it2.remove(); } } String like_result =
	 * Tools.trimInnerSpaceStr(Tools.createLinkString(content2, false)); //
	 * 对同步响应做验签 if (SignUtil.Check_sign(like_result.toString(), sign_result,
	 * sign_type_result, signKey, _input_charset_result)) {
	 * System.out.println(result); resultmap.put("result", result); return
	 * resultmap; } else { resultmap.put("error", "sign error!"); return
	 * resultmap; } } catch (Exception e) { // 获取返回的表单 resultmap.put("result",
	 * result); //return resultmap; }
	 */
	// return null;
	// }

}
