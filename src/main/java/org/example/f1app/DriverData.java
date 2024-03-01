package org.example.f1app;

import javafx.beans.property.*;

public class DriverData {
    private String driver;
    private int worldChampionships;
    private int numberRaces;
    private int numberWins;
    private int polePositions;
    private double careerPoints;

    public DriverData(String driver, int worldChampionships, int numberRaces, int numberWins, int polePositions, double careerPoints) {
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

    public int getNumberRaces() {
        return numberRaces;
    }

    public void setNumberRaces(int numberRaces) {
        this.numberRaces = numberRaces;
    }

    public int getNumberWins() {
        return numberWins;
    }

    public void setNumberWins(int numberWins) {
        this.numberWins = numberWins;
    }

    public int getPolePositions() {
        return polePositions;
    }

    public void setPolePositions(int polePositions) {
        this.polePositions = polePositions;
    }

    public double getCareerPoints() {
        return careerPoints;
    }

    public void setCareerPoints(double careerPoints) {
        this.careerPoints = careerPoints;
    }
}
