package com.wap.community.Controller;

import com.wap.community.DTO.CreateArticleRequest;
import com.wap.community.Entity.Article;
import com.wap.community.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String getBoardsPage(Model model) {
        model.addAttribute("articles", boardService.getAllArticles());
        return "boards";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Article> CreateArticle(@RequestBody CreateArticleRequest request) {
        Article article = boardService.CreateArticle(request);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }
}
