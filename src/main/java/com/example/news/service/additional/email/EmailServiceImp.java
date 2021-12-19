package com.example.news.service.additional.email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
@Repository
public class EmailServiceImp implements EmailService{
//    直接引用了,引用和注入不能同时存在·
    @Autowired
    JavaMailSenderImpl mailSender;
    @Override
    @Async//成异步任务了
    public void sendText(String account) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("登录账号密码");
        message.setText("账号：admin\n密码：123456");
//        这里直接是自己邮箱，后面改成需要的邮箱
//        客户端
        message.setFrom("xxxxxxxxxx@qq.com");
//        收件人
        message.setTo(account);
        mailSender.send(message);
    }
}
