package com.tiancaibao.pay.sina;
/*package com.tiancaibao.sinautil;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



*//**
 * Servlet implementation class GetSignMsg
 *//*
public class notify_url extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#HttpServlet()
	 *//*
	public notify_url() {
		super();
		// TODO Auto-generated constructor stub
	}

	SignUtil signutil = new SignUtil();

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	*//**
	 * @return 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sign=request.getParameter("sign");
		String sign_type = request.getParameter("sign_type");//
		String like_result = Tools.createLinkString(Tools.getParameterMap(request,true), false);
		String _input_charset=request.getParameter("_input_charset");
		String signKey = "";
		try {
			if ("RSA".equalsIgnoreCase(sign_type.toString())) {
				signKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDv0rdsn5FYPn0EjsCPqDyIsYRawNWGJDRHJBcdCldodjM5bpve+XYb4Rgm36F6iDjxDbEQbp/HhVPj0XgGlCRKpbluyJJt8ga5qkqIhWoOd/Cma1fCtviMUep21hIlg1ZFcWKgHQoGoNX7xMT8/0bEsldaKdwxOlv3qGxWfqNV5QIDAQAB";
			}
			try {
				if (SignUtil.Check_sign(like_result.toString(),sign,sign_type,signKey,_input_charset )) 
				{
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("success");
				} else {
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().print("sign error!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("非法请求！！！");
		}
	}
}
*/