package com.example;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class SatelliteDataProcessing {
    @SerializedName("satellites")

    private List<Satellite> satelliteDataList;
    public List<Satellite> getSatelliteDataList() {
        return satelliteDataList;
    }

    
}
