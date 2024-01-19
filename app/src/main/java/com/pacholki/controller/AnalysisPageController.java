package com.pacholki.controller;

import com.pacholki.entity.AdvancedTableRow;
import com.pacholki.entity.Entity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class AnalysisPageController extends Controller implements Initializable {

    @FXML
    private TableView<AdvancedTableRow> analysisTable;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateAnalysisTable();
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

    @Override
    public void updatePane(Entity entity) {
    }
}
