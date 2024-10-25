package org.example.springjdbc_demo.controllers;

import org.example.springjdbc_demo.dto.PostDto;
import org.example.springjdbc_demo.models.ApiResponse;
import org.example.springjdbc_demo.services.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("api/post/v1")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getPost(@RequestParam(required = false) Long id) {
        if (id == null) {
            List<PostDto> allPosts = postService.getAll();
            return allPosts != null && !allPosts.isEmpty()
                    ? ResponseEntity.ok(allPosts)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No posts fetched", null, HttpStatus.NOT_FOUND));
        } else {
            PostDto post = postService.getById(id);
            return post != null
                    ? ResponseEntity.ok(post)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("Post not found", null, HttpStatus.NOT_FOUND));
        }
    }
    @GetMapping("/all")
    public String getAllPosts(Model model) {
        List<PostDto> posts = postService.getAll();
        if (posts == null || posts.isEmpty()) {
            model.addAttribute("message", "No posts available.");
        } else {
            model.addAttribute("posts", posts);
        }
        return "index";
    }

    @GetMapping("/post-details")
    public String postDetails(@RequestParam(name = "id") Long postId, Model model){
        model.addAttribute("post", postService.getById(postId));
        return "post-details";
    }
}
