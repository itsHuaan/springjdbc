package org.example.springjdbc_demo.controllers;

import org.example.springjdbc_demo.models.ReplyModel;
import org.example.springjdbc_demo.services.impl.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/reply/v1")
public class ReplyController {
    private final ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> addReply(@RequestBody ReplyModel reply) {
        int result = replyService.save(reply);
        return result > 0
                ? ResponseEntity.ok().body(reply)
                : ResponseEntity.notFound().build();
    }
}
