package by.home.service;

import by.home.dao.Dao;
import by.home.model.Comment;
import by.home.model.ErrorMessage;
import by.home.model.Message;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentsService {

    private Map<Long, Message> messageMap = Dao.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getComments();
        return new ArrayList<>(commentMap.values());
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getComments();
        if (commentMap.isEmpty()) {
            comment.setId(1);
        } else {
            comment.setId(commentMap.size() + 1);
        }
        commentMap.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        commentMap.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> commentMap = messageMap.get(messageId).getComments();
        return commentMap.remove(commentId);
    }

    public Comment getComment(long messageId, long commentId) {
        ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "doc");
        Response response = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        Message message = messageMap.get(messageId);
        if (message == null) {
            throw new NotFoundException(response);
        }
        Map<Long, Comment> commentMap = message.getComments();
        Comment comment = commentMap.get(commentId);
        if (comment == null) {
            throw new NotFoundException(response);
        }
        return comment;
    }
}
