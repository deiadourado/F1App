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
        showChart(); // Exibir gráfico por padrão ao iniciar
    }

    private void configureTableView() {
        TableColumn<DriverData, String> driverColumn = new TableColumn<>("Driver");
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));

        TableColumn<DriverData, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("numberWins"));

        TableColumn<DriverData, Integer> worldChampionshipsColumn = new TableColumn<>("World Championships");
        worldChampionshipsColumn.setCellValueFactory(new PropertyValueFactory<>("worldChampionships"));

        TableColumn<DriverData, Integer> numberRacesColumn = new TableColumn<>("Number of Races");
        numberRacesColumn.setCellValueFactory(new PropertyValueFactory<>("numberRaces"));

        tableView.getColumns().addAll(driverColumn, winsColumn, worldChampionshipsColumn, numberRacesColumn);
    }

    private void populateTableView() {
        tableView.getItems().clear();

        try (Connection connection = DatabaseController.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM BestDrivers");
             ResultSet resultSet = statement.executeQuery()) {

            List<DriverData> dataList = new ArrayList<>();
            while (resultSet.next()) {
                String driver = resultSet.getString("driver");
                int numberWins = resultSet.getInt("numberWins");
                int worldChampionships = resultSet.getInt("worldChampionships");
                int numberRaces = resultSet.getInt("numberRaces");

                dataList.add(new DriverData(driver, numberWins, worldChampionships, numberRaces));
            }

            tableView.getItems().addAll(dataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void configureComboBox() {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Wins",
                        "World Championships",
                        "Number of Races"
                );
        dataSelectionComboBox.setItems(options);
        dataSelectionComboBox.setValue("Wins"); // Definir valor padrão
        dataSelectionComboBox.setOnAction(event -> {
            populateChartData();
            handleDataSelection();
        });
    }

    private void populateChartData() {
        barChart.getData().clear();
    
        try (Connection connection = DatabaseController.getConnection()) {
            String selectedData = dataSelectionComboBox.getValue();
            String query = "SELECT driver, numberWins, worldChampionships, numberRaces FROM BestDrivers";
    
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
    
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                while (resultSet.next()) {
                    String driver = resultSet.getString("driver");
                    int dataValue = resultSet.getInt(selectedData.toLowerCase() + "Championships");
    
                    series.getData().add(new XYChart.Data<>(driver, dataValue));
                }
    
                barChart.getData().add(series);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void showTable() {
        tableView.setVisible(true);
        barChart.setVisible(false);
    }

    @FXML
    public void showChart() {
        tableView.setVisible(false);
        barChart.setVisible(true);
    }

    @FXML
    public void handleDataSelection() {
        // Seu código para lidar com a seleção de dados aqui
        String selectedData = dataSelectionComboBox.getValue();
        System.out.println("Selected data: " + selectedData);
    }
}
