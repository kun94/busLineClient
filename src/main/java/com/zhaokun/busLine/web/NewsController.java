package com.zhaokun.busLine.web;

import com.google.gson.Gson;
import com.zhaokun.busLine.data.db.CommentRepository;
import com.zhaokun.busLine.data.db.NewsRepository;
import com.zhaokun.busLine.data.entity.Comment;
import com.zhaokun.busLine.data.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value = "/findNewsByBusLineId", method = RequestMethod.GET)
    public void searchByBusLine(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("busLineId"));
        Gson gson = new Gson();
        Collection<News> newsList = newsRepository.findByBusLineId(request.getParameter("busLineId"));
        System.out.println(gson.toJson(newsList));
        response.getWriter().write(gson.toJson(newsList));
    }

    @RequestMapping(value = "/findNewsByTime", method = RequestMethod.GET)
    public void searchNews(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        Collection<News> newsList = newsRepository.findByTime();
        System.out.println(gson.toJson(newsList));
        response.getWriter().write(gson.toJson(newsList));
    }
}
