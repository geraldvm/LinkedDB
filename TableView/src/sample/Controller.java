package sample;


import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private TableView<ObservableList<Object>> tableView= new TableView<>();
    Test b =new Test();
    @FXML
    private void initialize() {
        createColumns(Insert());
        //addRows();
    }

    public List<String> Insert() {
        List<String> columns = new ArrayList<String>();
        List<String> rows = new ArrayList<String>();
        int columnIndex = 0;
        for (int i =0;i<5;i++) {
            columns.add("col" + i);
            //columnIndex = 0;
        }
        return columns;
    }
    public void createColumns(List<String> columns){

        for (int n=0;n<columns.size();++n){
            final int finalIdx = n;
            TableColumn<ObservableList<Object>,Object> column = new TableColumn<>(columns.get(n));
            column.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(finalIdx)));
            tableView.getColumns().add(column);
        }

        System.out.println("ok");
    }

    public void addRows(){
        for (int i = 0; i < 5; i++) {
            tableView.getItems().add(FXCollections.observableArrayList(b.getTest(i)));
        }
    }
    private static class Test {
        private List<String> test = new ArrayList<>();

        public List<String> getTest(int i) {
            for (int n = 0; n < 5; ++n) {
                List<String> test = new ArrayList<>();
                test.add("Column" + n + "value" + i);
            }
            return test;
        }

    }


}
