package com.spring.springGroupS.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//@Component
@Service
public class ProjectProvide {
	
	@Autowired
	JavaMailSender mailSender;
	
	//메일 보내기
	@PostMapping("/mail/mailForm")
	public String mailSend(
				String toMail,
				String title,
				String mailFlag
			) throws MessagingException {		
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		
		String content = "";
		
		messageHelper.setTo(toMail);
		messageHelper.setSubject(title);
		messageHelper.setText(content);
		
		// 메세지보관함에 저장되는 'content'변수안에 발신자의 필요한 정보를 추가로 담아준다.
		content = content.replace("\n", "<br>");
		content += "<br><hr><h3>SpringGroup에서 보냅니다.</h3><br><hr>";
		content += "<b>"+mailFlag+"</b><br>";
		content += "<p><img src=\"cid:main.jpg\" width='500px'></p>";
		content += "<p>방문하기 : <a href='http://49.142.157.251:9090/cjgreen'>springGroup</a></p>";
		content += "<hr>";
		messageHelper.setText(content, true);
		
		FileSystemResource file = new FileSystemResource(request.getSession().getServletContext().getRealPath("/resources/images/main.jpg"));
		messageHelper.addInline("main.jpg", file);
		
		// 메일 전송하기
		mailSender.send(message);
		
		return "1";
	}
}
