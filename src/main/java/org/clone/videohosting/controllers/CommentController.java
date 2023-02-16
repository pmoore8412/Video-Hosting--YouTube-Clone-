package org.clone.videohosting.controllers;

import org.clone.videohosting.entities.Comments;
import org.clone.videohosting.services.comments.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@CrossOrigin
public class CommentController {

    private CommentsService commentsService;

    @PostMapping("/new-comment")
    public ResponseEntity<String> addComment(Comments comment) {

        commentsService.addComment(comment);

        return ResponseEntity.ok("Comment added successfully");

    }
    
}
