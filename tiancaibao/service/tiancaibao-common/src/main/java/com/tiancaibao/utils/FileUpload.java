/**
 * 
 */
package com.tiancaibao.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;



/**
 * @author zhouzhihang
 *
 *2017年4月24日
 */
public class FileUpload {
	
	
	
	public    String path;
	
	public  FileUpload(){
		  Calendar a=Calendar.getInstance();
		  this.path=a.get(Calendar.YEAR)+"/"+(a.get(Calendar.MONTH)+1)+"/"+(a.get(Calendar.DATE))+"/";
	  }
	
	

	/**
	 * 发布借款上传文件
	 */
	
	public  String  borrowUpload(HttpServletRequest request) throws IllegalStateException, IOException{
		String name="";
		long  startTime=System.currentTimeMillis();
	   StringBuilder reqult=new StringBuilder();
			   
		
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
       CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
               request.getSession().getServletContext());
       //检查form中是否有enctype="multipart/form-data"
       if(multipartResolver.isMultipart(request))
       {
           //将request变成多部分request
           MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
          //获取multiRequest 中所有的文件名
           Iterator iter=multiRequest.getFileNames();
            
           while(iter.hasNext())
           {
               //一次遍历所有文件
               MultipartFile file=multiRequest.getFile(iter.next().toString());
               //System.out.println(file);
               if(file!=null)
               {
            	   name= file.getOriginalFilename(); 
            	   String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
                 
                   Pattern pattern = Pattern.compile(reg);
                   Matcher matcher = pattern.matcher(name.toLowerCase());
                   if(matcher.find()){
            	   name=name.substring(name.lastIndexOf("."));
            	   name=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+name;
            	   name=path+name;
                   String path_="/Users/Magic/Downloads/Tomcat7/webapps/images/"+name;
                  
                   File real=new File(path_);
                  
                   //上传
                   if(!real.exists())    
                   {    
                       try {   
                    	   real.mkdirs();
                    	   real.createNewFile();    
                       } catch (IOException e) {    
                           // TODO Auto-generated catch block    
                           e.printStackTrace();    
                       }    
                   } 
                   
                   file.transferTo(real);
                   reqult.append("[{name:'"+name+"',");
                   
              }else{
            	  return "error";
              }
               }
                
           }
          
       }
       long  endTime=System.currentTimeMillis();
       System.out.println("运行时间："+String.valueOf(endTime-startTime)+"ms");
       String requestUrl = request.getScheme() //当前链接使用的协议
    		    +"://" + request.getServerName()//服务器地址 
    		    + ":" + request.getServerPort()+"/images/";
       reqult.append("url:'"+requestUrl+name+"'}]");
     
  
		return reqult.toString();
	}
	
	
	
	
	
	
	


	public static void main(String[] args) throws InterruptedException {
		  Calendar a=Calendar.getInstance();
		  System.out.println(a.get(Calendar.YEAR));//得到年
		  System.out.println(a.get(Calendar.MONTH)+1);//由于月份是从0开始的所以加1
		  System.out.println(a.get(Calendar.DATE));
		 
		  System.out.println( System.getProperty("user.dir"));
		  String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
          String imgp= "3D3D43DC-3075-4E56-BE13-B6BB4BDCB3B0.png";
          Pattern pattern = Pattern.compile(reg);
          Matcher matcher = pattern.matcher(imgp.toLowerCase());
          System.out.println(matcher.find());
		  }
	
	
	
}
