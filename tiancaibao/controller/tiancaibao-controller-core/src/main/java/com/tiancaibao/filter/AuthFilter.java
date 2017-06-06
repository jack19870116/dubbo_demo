package com.tiancaibao.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.tiancaibao.utils.HttpRequest;

public class AuthFilter implements Filter {

	// private final String errorPath = "/login.html";
	static final String[] MAIN_URL = { "/auth/" };

	private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);
	
	public void init(FilterConfig arg0) throws ServletException {

	}

	public void destroy() {

	}

	public static String getRemoteAddrIp(HttpServletRequest request) {
		String ipFromNginx = getHeader(request, "X-Real-IP");
		return ""; // ObjectUtils.isEmpty(ipFromNginx) ? request.getRemoteAddr()
					// : ipFromNginx;
	}

	private static String getHeader(HttpServletRequest request, String headName) {
		String value = request.getHeader(headName);
		return ""; // !ObjectUtils.isBlank(value) &&
					// !"unknown".equalsIgnoreCase(value) ? value : "";
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		request.setCharacterEncoding("utf-8");

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			// Form表单enctype="multipart/form-data" 提交 获得普通文本域值
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> iter = items.iterator();
				XssHttpServletRequestWrapper requestWrapper = new XssHttpServletRequestWrapper(request);
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						String key = item.getFieldName();
						String value = item.getString("utf-8");
						requestWrapper.addParameter(key, value);
					}
				}
				Enumeration<String> enu = requestWrapper.getParameterNames();
				while (enu.hasMoreElements()) {
					String paraName = (String) enu.nextElement();
					log.info(paraName + ":" + requestWrapper.getParameter(paraName));
				}
				chain.doFilter(requestWrapper, response);
			} catch (Exception fue) {
				fue.printStackTrace();
			}
		} else if (request.getParameterNames().hasMoreElements()) {// 普通数据类型不用解析
			chain.doFilter(request, response);
		} else {// json 类型需要解析赋值

			String requestJsonString = HttpRequest.getRequestJsonString(request);
			log.info("请求requestJsonString:" + requestJsonString);
			if (requestJsonString != null && requestJsonString.indexOf("&") < 0) {
				try {
					JSONObject json = JSONObject.parseObject(requestJsonString);
					XssHttpServletRequestWrapper requestWrapper = new XssHttpServletRequestWrapper(request);
					Iterator<String> it = json.keySet().iterator();
					while (it.hasNext()) {
						String key = (String) it.next();
						requestWrapper.addParameter(key, json.get(key));
					}

					Enumeration<String> enu = requestWrapper.getParameterNames();
					while (enu.hasMoreElements()) {
						String paraName = (String) enu.nextElement();
						log.info(paraName + ":" + requestWrapper.getParameter(paraName));
					}
					log.info("\n");
					chain.doFilter(requestWrapper, response);
				} catch (Exception e) {// 如果解析不是json,或者报错直接返回原值
					e.printStackTrace();
					chain.doFilter(request, response);
				}
			} else {
				chain.doFilter(request, response);
			}
		}
	}
}
