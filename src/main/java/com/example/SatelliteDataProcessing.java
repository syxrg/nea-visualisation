package com.example;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class SatelliteDataProcessing {
    @SerializedName("satellites")

    private List<Satellite> satelliteDataList;
    public List<Satellite> getSatelliteDataList() {
        return satelliteDataList;
    }

    public List<String> filterSatelliteByPlanet(int planetId) {
        if (planetId <= 0 || planetId > 9) {
            throw new IllegalArgumentException("Not a valid planet number in our Solar System");
        }

        List<String> containsSatellite = new ArrayList<>();
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getPlanetId() == planetId) {
                containsSatellite.add(satellite.getName());
            }

            if (containsSatellite.size() >= 2) {
                return containsSatellite;
            }
        }

        return containsSatellite;
    }

    public List<String> filterSatelliteByLetter(String satelliteFirstLetter) {
        if (satelliteFirstLetter == null || satelliteFirstLetter == "") {
            throw new IllegalArgumentException("Satellite first letter input is null or empty");
        }

        if (satelliteFirstLetter.length() > 1) {
            throw new IllegalArgumentException("");
        }

        List<String> containsLetter = new ArrayList<>();
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getName().contains(satelliteFirstLetter.toUpperCase())) {
                containsLetter.add(satellite.getName());
            }

            if (containsLetter.size() >= 2) {
                return containsLetter;
            }
        }

        return containsLetter;
    }

    public List<String> filterSatelliteRadiusGreaterThan(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Negative radius is not valid");
        }

        List<String> satelliteRadiusGreaterThan = new ArrayList<>();
        for (Satellite satellite : satelliteDataList) {
            if (Double.parseDouble(satellite.getRadius()) >= radius ) {
                satelliteRadiusGreaterThan.add(satellite.getName());
            }

            if (satelliteRadiusGreaterThan.size() >= 2) {
                return satelliteRadiusGreaterThan;
            }
        }

        return satelliteRadiusGreaterThan;
    }

    public List<String> filterSatelliteDensityGreaterThan (double density) {
        if (density <= 0) {
            throw new IllegalArgumentException("Negative density is not valid");
        }

        List<String> satelliteDensityGreaterThan = new ArrayList<>();
        for (Satellite satellite : satelliteDataList) {
            if (Double.parseDouble(satellite.getDensity()) >= density) {
                satelliteDensityGreaterThan.add(satellite.getName());
            }

            if (satelliteDensityGreaterThan.size() >= 2) {
                return satelliteDensityGreaterThan;
            }
        }

        return satelliteDensityGreaterThan;
    }

    public int getNumberOfSatellitesOrbitingPlanet (int planetId) {
        if (planetId <= 0 || planetId > 9) {
            throw new IllegalArgumentException("Not a valid planet number in our Solar System");
        }

        int count = 0;
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getId() == planetId) {
                count++;
            }
        }

        return count;
    }

    public int getNumberOfSatellitesStartingWithLetter(String satelliteFirstLetter) {
        if (satelliteFirstLetter == null || satelliteFirstLetter == "") {
            throw new IllegalArgumentException("Satellite first letter input is null or empty");
        }

        if (satelliteFirstLetter.length() > 1 || satelliteFirstLetter.length() < 0) {
            throw new IllegalArgumentException("");
        }

        int count = 0;
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getName().startsWith(satelliteFirstLetter)) {
                count++;
            }
        }

        return count;
    }

    public double getAverageMagnitudeOfSatellitesOrbitingPlanet (int planetId) {
        if (planetId <= 0 || planetId > 9) {
            throw new IllegalArgumentException("Not a valid planet number in our Solar System");
        }

        List<Double> averageMagnitudeSatellites = new ArrayList<>();
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getId() ==  planetId) {
                double satelliteMagnitude = Double.parseDouble(satellite.getMagnitude());
                averageMagnitudeSatellites.add(satelliteMagnitude);
            }
        }
        double averageMagnitude = 0;
        for (double magnitudeValue : averageMagnitudeSatellites) {
            averageMagnitude = (averageMagnitude + magnitudeValue) / averageMagnitudeSatellites.size();
        }

        return averageMagnitude;
    }

    public double getAverageAlbedoOfSatellitesOrbitingPlanet (int planetId) {
        if (planetId <= 0 || planetId > 9) {
            throw new IllegalArgumentException("Not a valid planet number in our Solar System");
        }

        List<Double> averageAlbedoSatellites = new ArrayList<>();
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getId() == planetId) {
                double satelliteAlbedo = Double.parseDouble(satellite.getAlbedo());
                averageAlbedoSatellites.add(satelliteAlbedo);
            }
        }
        double averageAlbedo = 0;
        for (double albedoValue : averageAlbedoSatellites) {
            averageAlbedo = (averageAlbedo + albedoValue) / averageAlbedoSatellites.size();
        }

        return averageAlbedo;
    }
}
