package com.example;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class SatelliteDataProcessing {
    @SerializedName("satellites")

    private List<Satellite> satelliteDataList;
    public List<Satellite> getSatelliteDataList() {
        return satelliteDataList;
    }

    /**
     * Function that filters names of satellite orbiting a certain planet
     * @param planetId the particular planet number being filtered for. eg, Mercury's planet ID is 1.
     * @return returns first 2 names of planets that is part of planetId
     */
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

    /**
     * Function that filters names of satellites by their first letter
     * @param satelliteFirstLetter the particular letter being filtered for. eg, Moon's first letter is M
     * @return returns first 2 names of satellites that contains satelliteFirstLetter
     */
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

    /**
     * Function that filters names of satellites with radius greater than a certain number
     * @param radius the particular radius greater than being filtered for
     * @return returns first 2 names of satellites that radius is greater than
     */
    public List<String> filterSatelliteRadiusGreaterThan(double radius) {
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

    /**
     * Function that filters names of satellites with density greater than a certain number
     * @param density the particular denity greater than being filtered for
     * @return returns first 2 names of satellites that density is greater than
     */
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

    /**
     * Function that obtains number of satellites orbiting a certain planet
     * @param planetId the particular planet number being filtered for. eg, Mercury's planet ID is 1.
     * @return returns number of satellites orbiting planetId
     */
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

    /**
     * Function that obtains number of satellites starting with certain letter
     * @param satelliteFirstLetter the particular letter being filtered for. eg, Moon's first letter is M
     * @return returns number of satellites starting with satelliteFirstLetter
     */
    public int getNumberOfSatellitesStartingWithLetter(String satelliteFirstLetter) {
        if (satelliteFirstLetter == null || satelliteFirstLetter == "") {
            throw new IllegalArgumentException("Satellite first letter input is null or empty");
        }

        if (satelliteFirstLetter.length() > 1 || satelliteFirstLetter.length() < 0) {
            throw new IllegalArgumentException("");
        }

        int count = 0;
        for (Satellite satellite : satelliteDataList) {
            if (satellite.getName().startsWith(satelliteFirstLetter.toUpperCase())) {
                count++;
            }
        }

        return count;
    }

    /**
     * Function that obtains average magnitude of satellite orbiting certain planet
     * @param planetId the particular planet number being filtered for. eg, Mercury's planet ID is 1.
     * @return returns average magnitude of satellite/s orbiting planetId
     */
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

    /**
     * Function that obtains average albedo of satellite orbiting certain planet
     * @param planetId the particular planet number being filtered for. eg, Mercury's planet ID is 1.
     * @return returns average albedo of satellite/s orbiting planetId
     */
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
