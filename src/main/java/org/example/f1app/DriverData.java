import javafx.beans.property.*;

public class DriverData {
    private final StringProperty driver;
    private final IntegerProperty worldChampionships;
    private final IntegerProperty numberRaces;
    private final IntegerProperty numberWins;
    private final IntegerProperty polePositions;
    private final DoubleProperty careerPoints;

    public DriverData(String driver, int worldChampionships, int numberRaces, int numberWins, int polePositions, double careerPoints) {
        this.driver = new SimpleStringProperty(driver);
        this.worldChampionships = new SimpleIntegerProperty(worldChampionships);
        this.numberRaces = new SimpleIntegerProperty(numberRaces);
        this.numberWins = new SimpleIntegerProperty(numberWins);
        this.polePositions = new SimpleIntegerProperty(polePositions);
        this.careerPoints = new SimpleDoubleProperty(careerPoints);
    }

    // Getters
    public String getDriver() {
        return driver.get();
    }

    public StringProperty driverProperty() {
        return driver;
    }

    public int getWorldChampionships() {
        return worldChampionships.get();
    }

    public IntegerProperty worldChampionshipsProperty() {
        return worldChampionships;
    }

    public int getNumberRaces() {
        return numberRaces.get();
    }

    public IntegerProperty numberRacesProperty() {
        return numberRaces;
    }

    public int getNumberWins() {
        return numberWins.get();
    }

    public IntegerProperty numberWinsProperty() {
        return numberWins;
    }

    public int getPolePositions() {
        return polePositions.get();
    }

    public IntegerProperty polePositionsProperty() {
        return polePositions;
    }

    public double getCareerPoints() {
        return careerPoints.get();
    }

    public DoubleProperty careerPointsProperty() {
        return careerPoints;
    }
}
