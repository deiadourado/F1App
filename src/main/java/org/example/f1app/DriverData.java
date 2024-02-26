package org.example.f1app;

import javafx.beans.property.*;

public class DriverData {
    private final StringProperty driver;
    private final IntegerProperty numberWins;

    public DriverData(String driver, int numberWins) {
        this.driver = new SimpleStringProperty(driver);
        this.numberWins = new SimpleIntegerProperty(numberWins);
    }

    // Getters
    public String getDriver() {
        return driver.get();
    }

    public StringProperty driverProperty() {
        return driver;
    }

    public int getNumberWins() {
        return numberWins.get();
    }

    public IntegerProperty numberWinsProperty() {
        return numberWins;
    }
}
