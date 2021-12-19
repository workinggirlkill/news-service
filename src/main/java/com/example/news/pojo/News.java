package com.example.news.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//Text不兼容
public class News {
   private  Integer id;
   private Integer categoryId;
   private String title;
   private String content;
   private String source;
   private Date publishTime;
   private  String author;
   private Integer level;
   private Integer status;
//   这里动的话前端传的日期类型不对,传过来是data，转成string了，后台用不了
//   public String getPublishTime() {
//      SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//      String time = format0.format(publishTime);
//      return time;
//   }
   //   多个状态码
//   private Message message;//每条数据都有一个状态码很sx
}
