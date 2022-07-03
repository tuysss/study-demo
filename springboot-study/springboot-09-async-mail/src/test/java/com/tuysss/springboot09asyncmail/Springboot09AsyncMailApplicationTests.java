package com.tuysss.springboot09asyncmail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/*
* 一个简单的邮件发送流程
*/
@SpringBootTest
class Springboot09AsyncMailApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    /*
     * 一个简单的邮件发送流程
     */
    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        //邮件主题
        mailMessage.setSubject("Clare GoodBye!");
        //邮件内容
        mailMessage.setText("second test...");
        //设置接收方
        mailMessage.setTo("2511227193@qq.com");
        //设置发送方
        mailMessage.setFrom("2862670249@qq.com");

        mailSender.send(mailMessage);
    }

    /*
     * 一个复杂的邮件发送流程
     */
    @Test
    void contextLoads2() throws MessagingException {
        //两种创建方式  MimeMailMessage mimeMailMessage = new MimeMailMessage();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject("tuysss hihi plus");

        helper.setText("<p style='color:orange'> bling bling yeah~</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\TianYanning\\Pictures\\Saved Pictures\\1.jpg"));

        helper.setTo("2862670249@qq.com");
        helper.setFrom("yanning.tian@foxmail.com");

        mailSender.send(mimeMessage);
    }


    /**
     * 封装方法,将在Controller中应用
     * @param html
     * @param subject
     * @param text
     * @param attachmentFilename
     * @param attachmentFilepath
     * @param sendTo
     * @param sendFrom
     * @throws MessagingException
     */
    public void sendMail(boolean html,String subject,String text,String attachmentFilename,
                         String attachmentFilepath,String sendTo,String sendFrom)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject(subject);
        helper.setText(text,html);
        helper.addAttachment(attachmentFilename,new File(attachmentFilepath));

        helper.setTo(sendTo);
        helper.setFrom(sendFrom);

        mailSender.send(mimeMessage);
    }

    /**
     * 封装方法，重载
     * @param html
     * @param subject
     * @param text
     * @param sendTo
     * @param sendFrom
     * @throws MessagingException
     */
    public void sendMail(boolean html,String subject,String text, String sendTo,String sendFrom)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setSubject(subject);
        helper.setText(text,html);

        helper.setTo(sendTo);
        helper.setFrom(sendFrom);

        mailSender.send(mimeMessage);
    }
}
