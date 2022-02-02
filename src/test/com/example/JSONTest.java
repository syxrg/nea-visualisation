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

    @Test
    public void testFilterSatelliteByPlanet() {
        List<String> toReturn = new ArrayList<>();
        toReturn.add("Phobos");
        toReturn.add("Deimos");
        assertEquals(toReturn, satelliteData.filterSatelliteByPlanet(4));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFilterSatelliteByInvalidPlanetId() {
        satelliteData.filterSatelliteByPlanet(-1);
    }

    @Test
    public void testFilterSatelliteByLetter() {
        List<String> toReturn = new ArrayList<>();
        toReturn.add("Callisto");
        toReturn.add("Carme");
        assertEquals(toReturn, satelliteData.filterSatelliteByLetter("c"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFilterSatelliteByMoreThanOneLetter() {
        satelliteData.filterSatelliteByLetter("hi");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFilterSatelliteByLetterNullInput() {
        satelliteData.filterSatelliteByLetter(null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFilterSatelliteByLetterEmptyInput() {
        satelliteData.filterSatelliteByLetter("");
    }

    @Test
    public void testFilterSatelliteRadiusGreaterThan() {
        List<String> toReturn = new ArrayList<>();
        toReturn.add("Moon");
        toReturn.add("Io");
        assertEquals(toReturn, satelliteData.filterSatelliteRadiusGreaterThan(100));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFilterSatelliteRadiusGreaterThanNegativeNumber() {
        satelliteData.filterSatelliteRadiusGreaterThan(-1);
    }

    @Test
    public void testFilterSatelliteDensityGreaterThan() {
        List<String> toReturn = new ArrayList<>();
        toReturn.add("Moon");
        toReturn.add("Io");
        assertEquals(toReturn, satelliteData.filterSatelliteDensityGreaterThan(2.6));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFilterSatelliteDensityGreaterThanNegativeNumber() {
        satelliteData.filterSatelliteDensityGreaterThan(-100);
    }



}
