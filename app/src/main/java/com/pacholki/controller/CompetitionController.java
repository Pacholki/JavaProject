package com.pacholki.controller;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import com.pacholki.entity.Competition;
import com.pacholki.entity.Entity;
import com.pacholki.entity.FixtureRow;
import com.pacholki.entity.TeamTableRow;
import com.pacholki.pane.CompetitionPane;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CompetitionController extends Controller {

    private Competition competition;

    @FXML
    private TableView<TeamTableRow> leagueTable;
    @FXML
    private TableView<FixtureRow> leagueFixtures;
    @FXML
    private MFXComboBox<GameweekChoice> tableGameweekChoiceBox;
    @FXML
    private MFXComboBox<GameweekChoice> fixtureGameweekChoiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        competitionPane = new CompetitionPane(this);
        competition = competitionPane.getCurrentCompetition();

        generateTable(competition.getPlayedGameweeks());
        generateFixtures(competition.getPlayedGameweeks());

        setTableGameweekChoiceBox(competition.getPlayedGameweeks());
        setFixtureGameweekChoiceBox(competition.getTotalGameweeks());
    }

    public class GameweekChoice {
        private String text;
        private Integer gameweek;
        public GameweekChoice(String text, Integer gameweek) {
            this.text = text;
            this.gameweek = gameweek;
        }
        @Override
        public String toString(){
            return text;
        }
    }

    private ObservableList<GameweekChoice> generateGameweekChoices(int maxGameweek) {
        List<GameweekChoice> choices = new ArrayList<>();
        for(int i = 1; i <= maxGameweek; i++) {
            choices.add(new GameweekChoice("gameweek " + i, i));
        }
        return FXCollections.observableArrayList(choices);
    }

    private void setTableGameweekChoiceBox(int maxGameweek) {
        // tableGameweekChoiceBox.setText("Choose gameweek");
        tableGameweekChoiceBox.setItems(generateGameweekChoices(maxGameweek));
        tableGameweekChoiceBox.setOnAction(event -> {
            competitionPane.setTableGameweek(tableGameweekChoiceBox.getValue().gameweek);
            generateTable(competitionPane.getTableGameweek());
        });
    }

    private void setFixtureGameweekChoiceBox(int maxGameweek) {
        // fixtureGameweekChoiceBox.setText("Choose gameweek");
        fixtureGameweekChoiceBox.setItems(generateGameweekChoices(maxGameweek));
        fixtureGameweekChoiceBox.setOnAction(event -> {
            competitionPane.setFixtureGameweek(fixtureGameweekChoiceBox.getValue().gameweek);
            generateFixtures(competitionPane.getFixtureGameweek());
        });
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

    public void generateFixtures(Integer gameweek) {
        
        List<FixtureRow> sortedFixtureRows = competition.getSchedule().stream()
            .filter(game -> game.getGameweek() == gameweek)
            .map(game -> new FixtureRow(game))
            .collect(Collectors.toList());
        
        ObservableList<FixtureRow> fixtureRows = FXCollections.observableArrayList(sortedFixtureRows);

        List<TableColumn<FixtureRow, ?>> columns = new ArrayList<>();
        Field[] fields = FixtureRow.class.getDeclaredFields();
        for (Field field : fields) {
            TableColumn<FixtureRow, ?> column = new TableColumn<>();
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            columns.add(column);
        }

        leagueFixtures.getColumns().setAll(columns);
        leagueFixtures.setItems(fixtureRows);
    }

    @Override
    public void updatePane(Entity entity) {}
    @Override
    public void showLoadScreen(Entity entity) {}
    @Override
    public void showError(Entity entity) {}
    @Override
    public void showOutdatedDataNotification(Entity entity) {}
}
