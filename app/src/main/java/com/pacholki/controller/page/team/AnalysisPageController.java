package com.pacholki.controller.page.team;

import com.pacholki.controller.Controller;
import com.pacholki.entity.AdvancedTableRow;
import com.pacholki.entity.Entity;
import com.pacholki.entity.Per90AdvancedTableRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AnalysisPageController extends Controller {

    @FXML
    private TableView<AdvancedTableRow> analysisTable;
    @FXML
    private TableView<Per90AdvancedTableRow> per90analysisTable;
    @FXML
    private CheckBox checkBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateAnalysisTable();
        per90analysisTable.setVisible(false);
        per90analysisTable.setManaged(false);
    }

    public void generateAnalysisTable() {
        List<AdvancedTableRow> sortedAnalysisTableData = teamPane.getCurrentTeam().getPlayers().stream()
                .map(player -> new AdvancedTableRow(player))
                .sorted(Comparator.comparing(AdvancedTableRow::getName))
                .collect(Collectors.toList());

        ObservableList<AdvancedTableRow> analysisTableData = FXCollections.observableArrayList(sortedAnalysisTableData);

        List<TableColumn<AdvancedTableRow, ?>> columns = new ArrayList<>();
        Field[] fields = AdvancedTableRow.class.getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            if (field.getName().equals("colNames")) continue;
            TableColumn<AdvancedTableRow, ?> column = new TableColumn<>(AdvancedTableRow.colNames.get(i));
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            columns.add(column);
            i++;
        }

        analysisTable.getColumns().setAll(columns);
        analysisTable.setItems(analysisTableData);
    }

    public void generateAnalysisTablePer90() {
        List<Per90AdvancedTableRow> sortedAnalysisTableData = teamPane.getCurrentTeam().getPlayers().stream()
                .map(player -> new Per90AdvancedTableRow(player))
                .sorted(Comparator.comparing(Per90AdvancedTableRow::getName))
                .collect(Collectors.toList());

        ObservableList<Per90AdvancedTableRow> analysisTableData = FXCollections.observableArrayList(sortedAnalysisTableData);

        List<TableColumn<Per90AdvancedTableRow, ?>> columns = new ArrayList<>();
        Field[] fields = Per90AdvancedTableRow.class.getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            if (field.getName().equals("colNames")) continue;
            TableColumn<Per90AdvancedTableRow, ?> column = new TableColumn<>(Per90AdvancedTableRow.colNames.get(i));
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            columns.add(column);
            i++;
        }

        per90analysisTable.getColumns().setAll(columns);
        per90analysisTable.setItems(analysisTableData);
    }

    public void toggleView() {
        if (checkBox.isSelected()) {
            per90analysisTable.setVisible(true);
            per90analysisTable.setManaged(true);

            analysisTable.setVisible(false);
            analysisTable.setManaged(false);

            generateAnalysisTablePer90();
        } else {
            analysisTable.setVisible(true);
            analysisTable.setManaged(true);

            per90analysisTable.setVisible(false);
            per90analysisTable.setManaged(false);

            generateAnalysisTable();
        }
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
