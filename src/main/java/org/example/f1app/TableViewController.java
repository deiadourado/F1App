package org.example.f1app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewController {

    @FXML
    private TableView<Driver> tableView;

    // Método para inicializar a TableView
    @FXML
    public void initialize() {
        // Criação das colunas da TableView
        TableColumn<Driver, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Driver, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Adiciona as colunas à TableView
        tableView.getColumns().addAll(nameColumn, ageColumn);

        // Preenche a TableView com dados de exemplo
        ObservableList<Driver> drivers = FXCollections.observableArrayList(
                new Driver("Lewis Hamilton", 37),
                new Driver("Max Verstappen", 24),
                new Driver("Valtteri Bottas", 32)
        );

        tableView.setItems(drivers);
    }

    // Classe de modelo para representar um piloto (Driver)
    public static class Driver {
        private String name;
        private int age;

        public Driver(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
