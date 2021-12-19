package com.example.news.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewsCategory {
    private Integer categoryId;
    private String title;
    private Integer sort;
}
