package org.example.f1app;

import javafx.beans.property.*;

public class DriverData {
    private String driver;
    private int worldChampionships;
    private double numberRaces;
    private double numberWins;
    private double polePositions;
    private double careerPoints;

    public DriverData(String driver, int worldChampionships, double numberRaces, double numberWins, double polePositions, double careerPoints) {
        this.driver = driver;
        this.worldChampionships = worldChampionships;
        this.numberRaces = numberRaces;
        this.numberWins = numberWins;
        this.polePositions = polePositions;
        this.careerPoints = careerPoints;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getWorldChampionships() {
        return worldChampionships;
    }

    public void setWorldChampionships(int worldChampionships) {
        this.worldChampionships = worldChampionships;
    }

    public double getNumberRaces() {
        return numberRaces;
    }

    public void setNumberRaces(double numberRaces) {
        this.numberRaces = numberRaces;
    }

    public double getNumberWins() {
        return numberWins;
    }

    public void setNumberWins(double numberWins) {
        this.numberWins = numberWins;
    }

    public double getPolePositions() {
        return polePositions;
    }

    public void setPolePositions(double polePositions) {
        this.polePositions = polePositions;
    }

    public double getCareerPoints() {
        return careerPoints;
    }

    public void setCareerPoints(double careerPoints) {
        this.careerPoints = careerPoints;
    }
}
