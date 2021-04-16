package com.nstc.mail.controller;

import com.nstc.mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.util.Date;

@RestController
@Controller
public class MailController {
    @Autowired
    IMailService imailService;

    @GetMapping("/send")
    public void senMail(){
        imailService.sendSimpleMail("wuyahui@nstc.com.cn","主题：你好普通邮件","内容：第一封邮件");
    }
    @GetMapping("/send2")
    public void senMail2(){
      //  imailService.sendHtmlMail("wuyahui@nstc.com.cn","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }

    @GetMapping("/send3")
    public void senMail3(){
        imailService.sendAttachmentsMail("wuyahui@nstc.com.cn","主题：你好html邮件","<h1>内容：第一封html邮件</h1>","D:\\a.txt");
    }

    @GetMapping("/send4")
    public void senMail4(){
        String[] to = {"wuyahui@nstc.com.cn","songjingyong@nstc.com.cn"};
        imailService.sendHtmlMail(to,"主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }

}
