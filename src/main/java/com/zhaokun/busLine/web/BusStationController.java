package com.zhaokun.busLine.web;

import com.google.gson.Gson;
import com.zhaokun.busLine.data.db.BusLineRepository;
import com.zhaokun.busLine.data.db.BusStationRepository;
import com.zhaokun.busLine.data.db.NewsRepository;
import com.zhaokun.busLine.data.entity.BusLine;
import com.zhaokun.busLine.data.entity.BusLinePage;
import com.zhaokun.busLine.data.entity.BusStation;
import com.zhaokun.busLine.data.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Controller
public class BusStationController {

    @Autowired
    private BusStationRepository busStationRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private BusLineRepository busLineRepository;

    @RequestMapping(value = "/busStationData", method = RequestMethod.GET)
    public void getData(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("search"));
        System.out.println(request.getParameter("busLineId"));
        Gson gson = new Gson();
        Collection<BusStation> ints = busStationRepository.findByBusLineId(request.getParameter("busLineId"));
        System.out.println(gson.toJson(ints));
        response.getWriter().write(gson.toJson(ints));
    }

    @RequestMapping(value = "/addBusStation", method = RequestMethod.GET)
    public void addBusStation(HttpServletResponse response, HttpServletRequest request, Model model, BusStation busStation) throws IOException {
        request.setCharacterEncoding("Utf-8");
        System.out.println(busStation.getArrivalTime());
        System.out.println(busStation.getBusLineId());
        busStationRepository.addBusStation(busStation);
    }

    @RequestMapping(value = "/busStationDetail", method = RequestMethod.GET)
    public String busStationDetail(HttpServletResponse response, HttpServletRequest request, HttpSession session, Model model) throws IOException {
        response.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("busLineId"));
        Collection<BusStation> busStations = busStationRepository.findByBusLineId(request.getParameter("busLineId"));
        Collection<News> newsList = newsRepository.findByBusLineId(request.getParameter("busLineId"));
        BusLine busLine = busLineRepository.findOne(request.getParameter("busLineId"));
        System.out.println(busStations.toString());
        session.setAttribute("busStations", busStations);
        session.setAttribute("busLine", busLine);
        session.setAttribute("newsList", newsList);
        return "busStationDetail.html";
    }
}
