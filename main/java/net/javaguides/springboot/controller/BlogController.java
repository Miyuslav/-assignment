package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.service.PostService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {
    private PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }
  // to handle localhost:8080/

    @GetMapping("/")
    public String viewBlogPosts(Model model){
        List<PostDto> postsResponse = postService.findAllPosts();
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";

    }
}

