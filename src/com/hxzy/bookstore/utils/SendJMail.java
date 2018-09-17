package com.hxzy.bookstore.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	
	public static boolean sendMail(String email,String emailmsg){
		String from="zhangjidong20005@163.com";//发件人的邮件地址zaa@163.com
		String username="zhangjidong20005@163.com";//发件人的账户
		String password="liu2005";//发件人的密码
		String to=email;
		
		Properties prop=new Properties();
		//邮件服务器的地址
		prop.setProperty("mail.transport.protocol", "smtp");//发邮件使用的协议
		prop.setProperty("mail.smtp.host", "smtp.163.com");//指定smtp服务器
		//整个邮件环境信息
		Session session=Session.getInstance(prop);
		//设置输出调试的信息
		session.setDebug(true);
		//message代表一封邮件
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setSubject("用户激活");
			
			message.setContent(emailmsg,"text/html;charset=utf-8");
			//从session环境中获取邮件的对象
			Transport transport=session.getTransport();
			//连接邮件服务器
			transport.connect("smtp.163.com", username, password);
			//发送邮件
			transport.sendMessage(message, new Address[]{new InternetAddress(to)});
			transport.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

}
