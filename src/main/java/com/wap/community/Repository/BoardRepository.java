package com.wap.community.Repository;

import com.wap.community.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Article, Long> {
}
