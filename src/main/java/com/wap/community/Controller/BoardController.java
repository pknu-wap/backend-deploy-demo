package com.wap.community.Controller;

import com.wap.community.DTO.CreateArticleRequest;
import com.wap.community.Entity.Article;
import com.wap.community.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Article CreateArticle(@RequestBody CreateArticleRequest request) {
        return boardService.CreateArticle(request);
    }
}
