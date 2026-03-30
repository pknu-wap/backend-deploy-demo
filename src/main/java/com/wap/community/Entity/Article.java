package com.wap.community.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    private Long id;
    private String content;
}
