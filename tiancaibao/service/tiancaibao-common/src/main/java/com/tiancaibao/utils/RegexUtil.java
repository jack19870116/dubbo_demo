package com.tiancaibao.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {

	public static String pregMatch(String pattern,String matcher){
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(matcher);
		if(m.find()){
			return m.group(1);
		}
		return null;
	}
	
	public static void main(String[] args) {
		String pattern="action=\\'(.*?)\\' method=&quot;isU&quot;";
		String str = " <!DOCTYPE HTML PUBLIC "+"-//W3C//DTD HTML 4.01//EN"+ "http://www.w3.org/TR/html4/strict.dtd"+"><html><head><meta http-equiv="+"Content-Type" +"content="+"text/html; charset=UTF-8" +"/></head><body>	<form id="+"form1"+" action='https://test.pay.sina.com.cn/website/error?ft=30c6e46e-377c-43eb-be7c-51c79536d3f3' method="+"isU"+">			</form></body><script language="+"javascript"+"> form1.submit();</script></html>";
		System.out.println(pregMatch(pattern,str));
		
		
		        String strss = "<input type=\"button\" value=\"jakcy\">";
		        Pattern patterns = Pattern.compile("<input type=\"(.+?)\" value=\"(.+?)\">");
		        boolean matcher = pattern.matches(strss);
		 
		       /* while (matcher.find()) {
		            System.out.println("Value is: " + matcher.group(2));
		        }*/
		    }
		
		
}

