package com.example.news.service.additional.email;

import org.springframework.stereotype.Repository;
@Repository
public interface EmailService {
    //发送文本
     void sendText(String account);
}
