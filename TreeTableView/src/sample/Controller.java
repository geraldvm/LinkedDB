package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.util.Callback;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TreeTableView<String> tableView; //Valor que va mostrar
    @FXML
    private TreeTableColumn<String, String> col1;//Valores de cada col
    TreeItem<String> item_l1 = new TreeItem<>("DOC1");
    TreeItem<String> item_l2 = new TreeItem<>("DOC2");
    TreeItem<String> parent1 = new TreeItem<>("StoreA");

    TreeItem<String> item_h1 = new TreeItem<>("DOC5");
    TreeItem<String> item_h2 = new TreeItem<>("DOC6");
    TreeItem<String> item_h3 = new TreeItem<>("DOC7");
    TreeItem<String> parenth = new TreeItem<>("StoreB");

    TreeItem<String> root = new TreeItem<>("LinkedDB");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        parent1.getChildren().setAll(item_l1,item_l2);
        parenth.getChildren().setAll(item_h1,item_h3,item_h2);
        col1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue()));
        root.getChildren().setAll(parent1,parenth);
        tableView.setRoot(root);
    }
    @FXML
    private void makeChange(ActionEvent event){
        item_h2.setValue("HELLO");
    }
}
