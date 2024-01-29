package com.pacholki.controller.page.team;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.controller.Controller;
import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    }

    private void setImage(ImageView image) {
        String imagePath = "/com/pacholki/media/generic/pudzian.png";
        InputStream inputStream = getClass().getResourceAsStream(imagePath);
        Image img = new Image(inputStream);
        image.setImage(img);
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
