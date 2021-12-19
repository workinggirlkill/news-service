package com.example.news.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String nickname;
    private String account;
    private String password;
//    不从数据库拿，直接从这里生成一个token
    private String token;
}
