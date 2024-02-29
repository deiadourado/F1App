package org.example.f1app;

import javafx.beans.property.*;

public class DriverData {
    private final StringProperty driver;
    private final IntegerProperty numberWins;
    private final IntegerProperty worldChampionships;
    private final IntegerProperty numberRaces;

    public DriverData(String driver, int numberWins, int worldChampionships, int numberRaces) {
        this.driver = new SimpleStringProperty(driver);
        this.numberWins = new SimpleIntegerProperty(numberWins);
        this.worldChampionships = new SimpleIntegerProperty(worldChampionships);
        this.numberRaces = new SimpleIntegerProperty(numberRaces);
    }

    // Getters for driver
    public String getDriver() {
        return driver.get();
    }

    public StringProperty driverProperty() {
        return driver;
    }

    // Getters for numberWins
    public int getNumberWins() {
        return numberWins.get();
    }

    public IntegerProperty numberWinsProperty() {
        return numberWins;
    }

    // Getters for worldChampionships
    public int getWorldChampionships() {
        return worldChampionships.get();
    }

    public IntegerProperty worldChampionshipsProperty() {
        return worldChampionships;
    }

    // Getters for numberRaces
    public int getNumberRaces() {
        return numberRaces.get();
    }

    public IntegerProperty numberRacesProperty() {
        return numberRaces;
    }
}

