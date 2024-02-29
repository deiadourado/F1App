package org.example.f1app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController {

    @FXML
    private TableView<DriverData> tableView;

    @FXML
    public void initialize() {
        configureTableView();
        // Data population is handled by MainController
    }

    private void configureTableView() {
        TableColumn<DriverData, String> driverColumn = new TableColumn<>("Driver");
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));

        TableColumn<DriverData, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("numberWins"));

        tableView.getColumns().addAll(driverColumn, winsColumn);
    }
}