package org.example.f1app;

import javafx.beans.property.*;

public class DriverData {
    // Define JavaFX properties for each data field
    private final StringProperty driver;
    private final IntegerProperty worldChampionships;
    private final DoubleProperty numberRaces;
    private final DoubleProperty numberWins;
    private final DoubleProperty polePositions;
    private final DoubleProperty careerPoints;

    // Constructor
    public DriverData(String driver, int worldChampionships, double numberRaces, double numberWins, double polePositions, double careerPoints) {
        this.driver = new SimpleStringProperty(driver);
        this.worldChampionships = new SimpleIntegerProperty(worldChampionships);
        this.numberRaces = new SimpleDoubleProperty(numberRaces);
        this.numberWins = new SimpleDoubleProperty(numberWins);
        this.polePositions = new SimpleDoubleProperty(polePositions);
        this.careerPoints = new SimpleDoubleProperty(careerPoints);
    }

    // Getter and setter methods for each property
    public String getDriver() {
        return driver.get();
    }

    public StringProperty driverProperty() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver.set(driver);
    }

    public int getWorldChampionships() {
        return worldChampionships.get();
    }

    public IntegerProperty worldChampionshipsProperty() {
        return worldChampionships;
    }

    public void setWorldChampionships(int worldChampionships) {
        this.worldChampionships.set(worldChampionships);
    }

    public double getNumberRaces() {
        return numberRaces.get();
    }

    public DoubleProperty numberRacesProperty() {
        return numberRaces;
    }

    public void setNumberRaces(double numberRaces) {
        this.numberRaces.set(numberRaces);
    }

    public double getNumberWins() {
        return numberWins.get();
    }

    public DoubleProperty numberWinsProperty() {
        return numberWins;
    }

    public void setNumberWins(double numberWins) {
        this.numberWins.set(numberWins);
    }

    public double getPolePositions() {
        return polePositions.get();
    }

    public DoubleProperty polePositionsProperty() {
        return polePositions;
    }

    public void setPolePositions(double polePositions) {
        this.polePositions.set(polePositions);
    }

    public double getCareerPoints() {
        return careerPoints.get();
    }

    public DoubleProperty careerPointsProperty() {
        return careerPoints;
    }

    public void setCareerPoints(double careerPoints) {
        this.careerPoints.set(careerPoints);
    }
}
