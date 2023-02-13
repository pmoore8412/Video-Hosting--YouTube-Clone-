package org.clone.videohosting.services.comments;


import org.clone.videohosting.entities.Comments;

import java.util.List;

public interface CommentsService {

    void addComment(Comments comment);

    Comments editComment(String id, Comments comment);

    List<Comments> getAllComments();

    void removeComment(String id);

}
