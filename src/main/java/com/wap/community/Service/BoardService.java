package com.wap.community.Service;

import com.wap.community.DTO.CreateArticleRequest;
import com.wap.community.Entity.Article;
import com.wap.community.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Article CreateArticle(CreateArticleRequest request) {
        Article article = new Article();
        article.setContent(request.getContent());
        boardRepository.save(article);
        return article;
    }
}
