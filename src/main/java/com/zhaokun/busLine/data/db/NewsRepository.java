package com.zhaokun.busLine.data.db;

import com.zhaokun.busLine.data.entity.BusLine;
import com.zhaokun.busLine.data.entity.Comment;
import com.zhaokun.busLine.data.entity.News;

import java.util.List;

public interface NewsRepository {

    List<News> findByBusLineId(String busLineId);

    List<News> findByTime();

}
