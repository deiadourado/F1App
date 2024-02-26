package org.example.f1app;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

    // Método de inicialização
    @FXML
    public void initialize() {
        configureTableView();
        populateChartData();
        populateTableView();
    }

    // Configuração da TableView
    private void configureTableView() {
        TableColumn<DriverData, String> driverColumn = new TableColumn<>("Driver");
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));

        TableColumn<DriverData, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("numberWins"));

        tableView.getColumns().addAll(driverColumn, winsColumn);
    }

    // Método para popular o gráfico com os dados dos pilotos
    private void populateChartData() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Number of Wins");

        try (Connection connection = DatabaseController.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT driver, numberWins FROM BestDrivers");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String driver = resultSet.getString("driver");
                int numberWins = resultSet.getInt("numberWins");
                series.getData().add(new XYChart.Data<>(driver, numberWins));
            }

            barChart.getData().add(series);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para popular a TableView com os dados dos pilotos
    private void populateTableView() {
        try (Connection connection = DatabaseController.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM BestDrivers");
             ResultSet resultSet = statement.executeQuery()) {

            List<DriverData> dataList = new ArrayList<>();
            while (resultSet.next()) {
                String driver = resultSet.getString("driver");
                int numberWins = resultSet.getInt("numberWins");
                dataList.add(new DriverData(driver, numberWins));
            }

            tableView.getItems().addAll(dataList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
