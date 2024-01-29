package com.pacholki.controller.page.team;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.pacholki.controller.Controller;
import com.pacholki.entity.Competition;
import com.pacholki.entity.Entity;
import com.pacholki.entity.FixtureRow;
import com.pacholki.entity.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.pacholki.util.Tools.display;

public class InfoPageController extends Controller {

    @FXML
    private ImageView teamImage;
    @FXML
    private Label teamNameText;
    @FXML
    private Label leagueText;
    @FXML
    private Label pointsText;
    @FXML
    private Label bilansText;
    @FXML
    private Label playersCountText;
    @FXML
    private TableView<FixtureRow> teamFixtures;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImage(teamImage);
        Integer max_gmw = competitionPane.getCurrentCompetition().getTotalGameweeks();
        Team team = competitionPane.getCurrentTeam();
        teamNameText.setText("Team name: " + team.getName());
        leagueText.setText("League name: " + competitionPane.getCurrentCompetition());
        pointsText.setText("Points this season: " + team.getPoints(max_gmw) + "  Place: " + team.getTeamPlace(competitionPane.getCurrentCompetition(), team));
        bilansText.setText("W: " + team.getGamesWon(max_gmw) +
                "    D: " + team.getGamesDrawn(max_gmw) +
                "    L: " + team.getGamesLost(max_gmw));
        playersCountText.setText("Number of players: " + team.getPlayers().size());
        generateTeamFixture(competitionPane.getCurrentTeam());
    }

    private void setImage(ImageView image) {
        String imagePath = "/com/pacholki/media/generic/pudzian.png";
        InputStream inputStream = getClass().getResourceAsStream(imagePath);
        Image img = new Image(inputStream);
        image.setImage(img);
    }

    public void generateTeamFixture(Team team) {
        Competition competition = competitionPane.getCurrentCompetition();
        List<FixtureRow> sortedFixtureRows = competition.getSchedule().stream()
                .filter(game -> game.getHomeTeam() == team || game.getAwayTeam() == team)
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

        teamFixtures.getColumns().setAll(columns);
        teamFixtures.setItems(fixtureRows);
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
