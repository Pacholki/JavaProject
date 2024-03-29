package com.pacholki.controller.page.team;

import com.pacholki.controller.Controller;
import com.pacholki.entity.Entity;
import com.pacholki.entity.StatsTableRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class StatsPageController extends Controller {

    @FXML
    private TableView<StatsTableRow> statsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateStatsTable();
    }

    public void generateStatsTable() {

        List<StatsTableRow> sortedStatsTableData = teamPane.getCurrentTeam().getPlayers().stream()
                .map(player -> new StatsTableRow(player))
                .sorted(Comparator.comparingInt(StatsTableRow::getMatchesPlayed)
                        .thenComparingInt(StatsTableRow::getPlayTime).reversed())
                .collect(Collectors.toList());

        ObservableList<StatsTableRow> statTableData = FXCollections.observableArrayList(sortedStatsTableData);

        List<TableColumn<StatsTableRow, ?>> columns = new ArrayList<>();
        Field[] fields = StatsTableRow.class.getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            if (field.getName().equals("colNames")) continue;
            TableColumn<StatsTableRow, ?> column = new TableColumn<>(StatsTableRow.colNames.get(i));
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            columns.add(column);
            i++;
        }

        statsTable.getColumns().setAll(columns);
        statsTable.setItems(statTableData);
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
