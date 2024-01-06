package com.pacholki.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;
import com.pacholki.pane.LeaguePane;
import com.pacholki.pane.MainPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LeagueController extends Controller implements Initializable {

    @FXML
    private TableView leagueTable;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leaguePane = new LeaguePane(this);
        int gameweek = 13;
        generateTable();
    }

    public void generateTable() {
        leagueTable.getColumns().setAll(generateTableColumns());

    }

    public List<TableColumn> generateTableColumns() {
        List<String> colNames = List.of("Team name", "Played", "Won", "Drawn", "Lost", "GF", "GA", "GD", "Points");
        List<TableColumn> columns = new ArrayList<>();
        for(String colName : colNames) {
            TableColumn column = new TableColumn();
            column.setText(colName);
            columns.add(column);
        }
        return columns;
    }
    @Override
    public void updatePane(Entity entity) {
        System.out.println("this league pane should now be updated");
    }
    
}
