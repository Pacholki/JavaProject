package com.pacholki.controller;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pacholki.entity.Competition;
import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import com.pacholki.entity.TeamTableRow;
import com.pacholki.pane.LeaguePane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LeagueController extends Controller implements Initializable {

    private int gameweek;

    private Competition competition;

    @FXML
    private TableView<TeamTableRow> leagueTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leaguePane = new LeaguePane(this);
        competition = mainPane.getCurrentCompetition();
        gameweek = 20;
        generateTable();
    }

    public void generateTable() {
        
        ObservableList<TeamTableRow> teamTableData = FXCollections.observableArrayList();
        for (Team team : competition.getTeams()) {
            teamTableData.add(new TeamTableRow(team, gameweek));
        }

        List<TableColumn<TeamTableRow, ?>> columns = new ArrayList<>();
        Field[] fields = TeamTableRow.class.getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            if (field.getName().equals("colNames")) continue;
            TableColumn<TeamTableRow, ?> column = new TableColumn<>(TeamTableRow.colNames.get(i));
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            columns.add(column);
            i++;
        }

        leagueTable.getColumns().setAll(columns);
        System.out.println("siemaneczko");
        leagueTable.setItems(teamTableData);
    }

    // public List<TableColumn> generateTableColumns() {
    //     List<String> colNames = List.of("Team name", "Played", "Won", "Drawn", "Lost", "GF", "GA", "GD", "Points");
    //     List<TableColumn> columns = new ArrayList<>();
    //     for(String colName : colNames) {
    //         TableColumn column = new TableColumn();
    //         column.setText(colName);
    //         columns.add(column);
    //     }
    //     return columns;
    // }
    @Override
    public void updatePane(Entity entity) {
        System.out.println("this league pane should now be updated");
    }
    
}
