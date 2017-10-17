package com.example.transferstation.model;

/**
 * Created by 정인섭 on 2017-10-17.
 */

public class SubwayTransitInfo {
    private StationDayTrnsitNmpr StationDayTrnsitNmpr;

    public StationDayTrnsitNmpr getStationDayTrnsitNmpr (){
        return StationDayTrnsitNmpr;
    }

    public void setStationDayTrnsitNmpr (StationDayTrnsitNmpr StationDayTrnsitNmpr){
        this.StationDayTrnsitNmpr = StationDayTrnsitNmpr;
    }

    @Override
    public String toString(){
        return "ClassPojo [StationDayTrnsitNmpr = "+StationDayTrnsitNmpr+"]";
    }
}
