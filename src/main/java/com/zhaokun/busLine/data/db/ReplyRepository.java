package com.zhaokun.busLine.data.db;

import com.zhaokun.busLine.data.entity.BusLine;
import com.zhaokun.busLine.data.entity.Reply;

import java.util.List;

public interface ReplyRepository {

    long count();

    List<Reply> findByCommentId(String commentId);

    Boolean addReply(Reply reply);

}
