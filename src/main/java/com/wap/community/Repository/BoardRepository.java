package com.wap.community.Repository;

import com.wap.community.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByOrderByIdDesc();
}
