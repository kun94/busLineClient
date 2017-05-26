package com.zhaokun.busLine.data.db;

import com.zhaokun.busLine.data.entity.Comment;
import com.zhaokun.busLine.data.entity.User;

import java.util.List;

public interface CommentRepository {

    List<Comment> findByBusLineId(String busLineId);

    boolean addComment(Comment comment);

    boolean addCommentLike(String commentId);
}
