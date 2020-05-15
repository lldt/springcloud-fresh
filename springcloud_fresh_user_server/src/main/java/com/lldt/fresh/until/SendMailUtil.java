package com.lldt.fresh.until;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 发送邮箱的工具类
 * @author blackSwan
 *
 */
@Component
@ConfigurationProperties(prefix="spring.mail")
public class SendMailUtil {
	@Value("${spring.mail.username}")
	private String sendEmail;   // 发件箱
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * 发送html格式的邮件
	 * @param receiveEmail  收件箱
	 * @param name   称呼
	 * @param code   验证码
	 * @return
	 */
	public boolean sendHtmlMail(String receiveEmail, String name, String code) {
		if (StringUtil.checkNull(receiveEmail, name, code)) {
			return false;
		}
		
		try {
			
			// 建立邮件的信息，我们需要发送的是html格式邮件
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			
			// 设置收件人， 寄件人
			messageHelper.setTo(receiveEmail);
			messageHelper.setFrom(sendEmail);
			messageHelper.setSubject("源辰在线考试系统");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String str ="<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body><p style='font-size: 20px; font-weight:bold; '>尊敬的: "+name+", 您好! </p>"
					+ "<p style='text-indent: 2em; font-size: 20px;'>欢迎使用源辰在线考试系统密码找回功能，您本次的验证码是 "
					+ "<span style='font-size: 30px;font-weight: bold;color:red'>"+code+"</span>， 3分钟之内有效，请尽快使用! </p>"
					+ "<p style='text-align:right; padding-right: 20px;'>"
					+ "a href='http://www.hyycinfo.com' style='font-size: 180px>衡阳市源辰信息科技有限公司技术部</a></p>"
					+ "<span style='font-size: 18px; float:right; margin-right: 60px;'>"+sdf.format(new Date())+"</span></body></html>";
			
			// 设置邮件正文
			messageHelper.setText(str, true);
			mailSender.send(mimeMessage);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;
	}
}
