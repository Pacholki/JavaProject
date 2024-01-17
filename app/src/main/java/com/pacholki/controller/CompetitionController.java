package com.pacholki.controller;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.pacholki.entity.Competition;
import com.pacholki.entity.Entity;
import com.pacholki.entity.TeamTableRow;
import com.pacholki.pane.CompetitionPane;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CompetitionController extends Controller implements Initializable {

    private Competition competition;

    @FXML
    private TableView<TeamTableRow> leagueTable;
    @FXML
    private MFXComboBox gameweekChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        competitionPane = new CompetitionPane(this);
        competition = mainPane.getCurrentCompetition();
        generateTable(competition.getMaxGameweek());
        gameweekChoiceBox.setText("Choose gameweek");
        gameweekChoiceBox.setItems(generateGameweekChoices());
    }

    public ObservableList<String> generateGameweekChoices() {
        List<String> choices = new ArrayList<>();
        for(int i = 1; i <= competitionPane.getGameweek(); i++) {
            choices.add("gameweek " + i);
        }
        return FXCollections.observableArrayList(choices);
    }

    public void generateTable(Integer gameweek) {
        
        List<TeamTableRow> sortedTeamTableData = competition.getTeams().stream()
            .map(team -> new TeamTableRow(team, gameweek))
            .sorted(Comparator.comparingInt(TeamTableRow::getPoints)
                .thenComparingInt(TeamTableRow::getGoalDifference).reversed())
            .collect(Collectors.toList());

        ObservableList<TeamTableRow> teamTableData = FXCollections.observableArrayList(sortedTeamTableData);

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
        leagueTable.setItems(teamTableData);
    }


    @Override
    public void updatePane(Entity entity) {
        System.out.println("this league pane should now be updated");
    }
    
}
