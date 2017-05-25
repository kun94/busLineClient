package com.zhaokun.busLine.data.db;

import com.zhaokun.busLine.data.entity.BusLine;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BusLineRepository {

    long count();

    BusLine save(BusLine busLine);

    BusLine findOne(String busLineId);

    List<BusLine> findByBusLineName(String busLineName);

    List<BusLine> findByBusLineName(String busLineName, String limit, String offset);

    List<BusLine> findByBusStation(String busStationName);

    List<BusLine> findByBusStation(String busStationName, String limit, String offset);

    List<BusLine> findByStartAndEnd(String startStation, String endStation);

    List<BusLine> findByStartAndEnd(String startStation, String endStation, String limit, String offset);

    List<BusLine> findAll();

    List<BusLine> findByLimit(String limit, String offset);

    Boolean addBusLine(BusLine busLine);

    Boolean deleteBusLine(String busLineId);

    Boolean changeBusLine(BusLine busLine);
}
