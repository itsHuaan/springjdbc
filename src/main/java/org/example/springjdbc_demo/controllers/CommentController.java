package org.example.springjdbc_demo.controllers;

import org.example.springjdbc_demo.dto.CommentDto;
import org.example.springjdbc_demo.models.ApiResponse;
import org.example.springjdbc_demo.models.CommentModel;
import org.example.springjdbc_demo.services.impl.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/comment/v1")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getComments(@RequestParam(required = false) Long postId, @RequestParam(required = false) Long userId) {
        ResponseEntity<ApiResponse<Object>> notFoundResponse = ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>("No comments fetched", null, HttpStatus.NOT_FOUND));
        if (postId == null && userId == null) {
            List<CommentDto> comments = commentService.getAll();
            return comments != null
                    ? ResponseEntity.ok(comments)
                    : notFoundResponse;
        } else if (postId == null) {
            List<CommentDto> comments = commentService.getByUserId(userId);
            return comments != null
                    ? ResponseEntity.ok(comments)
                    : notFoundResponse;
        } else if (userId == null) {
            List<CommentDto> comments = commentService.getByPostId(postId);
            return comments != null
                    ? ResponseEntity.ok(comments)
                    : notFoundResponse;
        } else {
            List<CommentDto> comments = commentService.getSpecificComment(postId, userId);
            return comments != null
                    ? ResponseEntity.ok(comments)
                    : notFoundResponse;
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addComment(@RequestBody CommentModel commentModel) {
        int result = commentService.save(commentModel);
        return result == 1
                ? ResponseEntity.ok(new ApiResponse<>("Comment added", result, HttpStatus.CREATED))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>("Failed to add comment", result, HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateComment(@RequestBody CommentModel commentModel) {
        int result = commentService.save(commentModel);
        return result == 2
                ? ResponseEntity.ok(new ApiResponse<>("Comment updated", result, HttpStatus.OK))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>("Failed to update comment", result, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    @ResponseBody
    public ResponseEntity<?> deleteComment(@RequestParam Long id) {
        int result = commentService.delete(id);
        return result > 0
                ? ResponseEntity.ok(new ApiResponse<>("Comment deleted", result, HttpStatus.CREATED))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>("Failed to delete comment", result, HttpStatus.BAD_REQUEST));
    }
}
