package org.clone.videohosting.controllers;

import java.util.List;

import org.clone.videohosting.entities.Comments;
import org.clone.videohosting.services.comments.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@CrossOrigin
public class CommentController {

    private CommentsService commentsService;

    @PostMapping("/new/comment")
    public ResponseEntity<String> addComment(@RequestBody Comments comment) {

        commentsService.addComment(comment);

        return ResponseEntity.ok("Comment added successfully");

    }

    @PutExchange("/comment/edit/{id}")
    public ResponseEntity<Comments> editComment(@PathVariable(name = "id") String id, @RequestBody Comments comment) {

        return ResponseEntity.ok(commentsService.editComment(id, comment));

    }

    @GetMapping("/list/all")
    public ResponseEntity<List<Comments>> getAllComments() {

        return ResponseEntity.ok(commentsService.getAllComments());

    }

    @DeleteMapping("/comment/remove/{id}")
    public ResponseEntity<String> removeComment(@PathVariable(name = "id") String id) {

        commentsService.removeComment(id);

        return ResponseEntity.ok("Comment removed");

    }
    
}
