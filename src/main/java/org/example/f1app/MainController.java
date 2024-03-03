package org.example.f1app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TableView<DriverData> tableView;

    @FXML
    private ComboBox<String> dataSelectionComboBox;

    @FXML
    public void initialize() {
        configureTableView();
        configureComboBox();
        populateTableView();
        populateChartData(); // Populating the chart on initialization
        showChart(); // Display the chart by default on initialization
    }

    @SuppressWarnings("unchecked")
    private void configureTableView() {
        // Configuring the TableView with columns
        TableColumn<DriverData, String> driverColumn = new TableColumn<>("Driver");
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));

        TableColumn<DriverData, Integer> worldChampionshipsColumn = new TableColumn<>("World Championships");
        worldChampionshipsColumn.setCellValueFactory(new PropertyValueFactory<>("worldChampionships"));

        TableColumn<DriverData, Double> numberRacesColumn = new TableColumn<>("Number of Races");
        numberRacesColumn.setCellValueFactory(new PropertyValueFactory<>("numberRaces"));

        TableColumn<DriverData, Double> numberWinsColumn = new TableColumn<>("Number of Wins");
        numberWinsColumn.setCellValueFactory(new PropertyValueFactory<>("numberWins"));

        TableColumn<DriverData, Double> polePositionsColumn = new TableColumn<>("Pole Positions");
        polePositionsColumn.setCellValueFactory(new PropertyValueFactory<>("polePositions"));

        TableColumn<DriverData, Double> careerPointsColumn = new TableColumn<>("Career Points");
        careerPointsColumn.setCellValueFactory(new PropertyValueFactory<>("careerPoints"));

        // Adding columns to the TableView
        tableView.getColumns().addAll(driverColumn, worldChampionshipsColumn, numberRacesColumn, numberWinsColumn, polePositionsColumn, careerPointsColumn);
    }

    private void populateTableView() {
        // Populating the TableView with data from the database
        tableView.getItems().clear();

        try (Connection connection = DatabaseController.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM BestDrivers");
             ResultSet resultSet = statement.executeQuery()) {

            List<DriverData> dataList = new ArrayList<>();
            while (resultSet.next()) {
                String driver = resultSet.getString("driver");
                double numberWins = resultSet.getDouble("numberWins");
                int worldChampionships = resultSet.getInt("worldChampionships");
                double numberRaces = resultSet.getDouble("numberRaces");
                double polePositions = resultSet.getDouble("polePositions");
                double careerPoints = resultSet.getDouble("careerPoints");

                dataList.add(new DriverData(driver, worldChampionships, numberRaces, numberWins, polePositions, careerPoints));
            }

            tableView.getItems().addAll(dataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configureComboBox() {
        // Configuring the ComboBox with data options
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "World Championships",
                        "Number Races",
                        "Number Wins",
                        "Pole Positions",
                        "Career Points"
                );
        dataSelectionComboBox.setItems(options);
        dataSelectionComboBox.setValue("World Championships"); // Set default value
        dataSelectionComboBox.setOnAction(event -> {
            populateChartData();
            handleDataSelection();
        });
    }

    private void populateChartData() {
        // Populating the BarChart with data based on user-selected category
        barChart.getData().clear();

        String selectedData = dataSelectionComboBox.getValue();
        String columnName = selectedData.toLowerCase().replace(" ", ""); // Remove spaces and convert to lowercase

        String query = "SELECT driver, " + columnName + " FROM BestDrivers";

        try (Connection connection = DatabaseController.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            while (resultSet.next()) {
                String driver = resultSet.getString("driver");
                Number dataValue = resultSet.getDouble(columnName);

                series.getData().add(new XYChart.Data<>(driver, dataValue));
            }

            barChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showTable() {
        // Switching visibility to TableView
        tableView.setVisible(true);
        barChart.setVisible(false);
    }

    @FXML
    public void showChart() {
        // Switching visibility to BarChart
        tableView.setVisible(false);
        barChart.setVisible(true);
    }

    @FXML
    public void handleDataSelection() {
        // Code to handle data selection here
        String selectedData = dataSelectionComboBox.getValue();
        System.out.println("Selected data: " + selectedData);
    }
}
