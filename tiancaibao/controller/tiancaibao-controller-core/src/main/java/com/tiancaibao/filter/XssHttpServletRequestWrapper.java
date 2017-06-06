package com.tiancaibao.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	
	private Map<String, String[]> params = new HashMap<String, String[]>();

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request); // 将request交给父类，以便于调用对应方法的时候，将其输出
		this.params.putAll(request.getParameterMap());// 将参数表，赋予给当前的Map以便于持有request中的参数
	}

	// 重载一个构造方法
	public XssHttpServletRequestWrapper(HttpServletRequest request, Map<String, Object> extendParams) {
		this(request);
		addAllParameters(extendParams);// 这里将扩展参数写入参数表
	}

	public void addAllParameters(Map<String, Object> otherParams) {// 增加多个参数
		for (Map.Entry<String, Object> entry : otherParams.entrySet()) {
			addParameter(entry.getKey(), entry.getValue());
		}
	}

	public void addParameter(String name, Object value) {// 增加参数
		if (value != null) {
			if (value instanceof String[]) {
				params.put(name, (String[]) value);
			} else if (value instanceof String) {
				params.put(name, new String[] { (String) value });
			} else {
				params.put(name, new String[] { String.valueOf(value) });
			}
		}
	}

	@Override
	public String getHeader(String name) {
		return StringEscapeUtils.escapeHtml4(super.getHeader(name));
	}

	@Override
	public String getQueryString() {
		return StringEscapeUtils.escapeHtml4(super.getQueryString());
	}

	@Override
	public String getParameter(String name) { // 重写getParameter，代表参数从当前类中的map获取
		String[] values = params.get(name);
		if (values == null || values.length == 0) {
			return null;
		}
		return values[0];

		// return StringEscapeUtils.escapeHtml4(super.getParameter(name));
	}

	@Override
	public String[] getParameterValues(String name) {
		// String[] values = super.getParameterValues(name);
		// if(values != null) {
		// int length = values.length;
		// String[] escapseValues = new String[length];
		// for(int i = 0; i < length; i++){
		// escapseValues[i] = StringEscapeUtils.escapeHtml4(values[i]);
		// }
		// return escapseValues;
		// }
		// return super.getParameterValues(name);

		return params.get(name);

	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		Set<String> paramNames = new LinkedHashSet<String>();
		Enumeration<String> paramEnum = super.getParameterNames();
		while (paramEnum.hasMoreElements()) {
			paramNames.add(paramEnum.nextElement());
		}
		paramNames.addAll(params.keySet());
		return Collections.enumeration(paramNames);
		//return super.getParameterNames();
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		//return super.getParameterMap();
		return params;
	}

}
