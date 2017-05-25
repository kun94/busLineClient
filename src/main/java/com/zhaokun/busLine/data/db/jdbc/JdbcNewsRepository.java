package com.zhaokun.busLine.data.db.jdbc;

import com.zhaokun.busLine.data.db.NewsRepository;
import com.zhaokun.busLine.data.db.UserRepository;
import com.zhaokun.busLine.data.entity.News;
import com.zhaokun.busLine.data.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcNewsRepository implements NewsRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcNewsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<News> findByBusLineId(String busLineId) {
        return jdbcTemplate.query("SELECT * FROM NEWS WHERE BUSLINEID = ?",new NewsMapper(), busLineId);
    }

    @Override
    public List<News> findByTime() {
        return jdbcTemplate.query("SELECT * FROM NEWS ORDER BY NEWSTIME DESC", new NewsMapper());
    }

    private static final class NewsMapper implements RowMapper<News> {
        public News mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            News news = new News();
            news.setNewsId(resultSet.getString("newsId"));
            news.setBusLineId(resultSet.getString("busLineId"));
            news.setNewsText(resultSet.getString("newsText"));
            news.setNewsTime(resultSet.getString("newsTime"));
            return news;
        }
    }
}
