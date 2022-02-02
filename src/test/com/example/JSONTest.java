package com.example;


import com.example.SatelliteDataProcessing;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JSONTest {
    private SatelliteDataProcessing satelliteData;
    @Before
    public void setUp() throws IOException {
        Gson gson = new Gson();
        Reader jsonReader = Files.newBufferedReader(Paths.get("src/main/resources/satellite.json"));
        satelliteData = gson.fromJson(jsonReader, SatelliteDataProcessing.class);
    }

    @Test
    public void checkCorrectNumberOfSatellitesInDataSet() {
        assertEquals(50, satelliteData.getSatelliteDataList().size());
    }

}
