package org.clone.videohosting.services.comments;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.clone.videohosting.entities.Comments;
import org.clone.videohosting.repositories.CommentsRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private CommentsRepository commentsRepository;

    @Override
    public void addComment(Comments comment) {
        commentsRepository.save(comment);
    }

    @Override
    public Comments editComment(String id, Comments comment) {
        return null;
    }

    @Override
    public List<Comments> getAllComments() {
        return commentsRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public void removeComment(String id) {
        Optional<Comments> comment = commentsRepository.findById(id);

        commentsRepository.delete(comment.get());
    }


    
}
