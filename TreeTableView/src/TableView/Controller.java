package TableView;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.ChoiceBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    private TreeTableView<Person> tableView;
    @FXML
    private TreeTableColumn<Person, String> col1;
    @FXML
    private TreeTableColumn<Person, String> col2;
    @FXML
    private TreeTableColumn<Person, Number> col3;

    TreeItem<Person> per1 = new TreeItem<>(new Person("Gerald","gerald@hotmail.com",12));
    TreeItem<Person> per2 = new TreeItem<>(new Person("Luisa","l@gmail.com",25));
    TreeItem<Person> per3 = new TreeItem<>(new Person("Pablo","pab_s@gmail.com",45));
    TreeItem<Person> per4 = new TreeItem<>(new Person("Jose","jota@hotmail.com",15));

    TreeItem<Person> root = new TreeItem<>(new Person("Name","email",0));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.getChildren().setAll(per1,per2,per3,per4);

        col1.setCellValueFactory(param -> param.getValue().getValue().getNameProperty());
        col2.setCellValueFactory(param -> param.getValue().getValue().getEmailProperty());
        col3.setCellValueFactory(param -> param.getValue().getValue().getAgeProperty());

        col1.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        col1.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TreeTableColumn.CellEditEvent<Person, String> event) {
                TreeItem<Person> currentEditingPerson= tableView.getTreeItem(event.getTreeTablePosition().getRow());
                currentEditingPerson.getValue().setNameProperty(event.getNewValue());
            }
        });
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("@hotmail.com","@gmail.com","@dropbox.com");
        col2.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn((list)));
        //col2.setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn((list)));
        tableView.setEditable(true);
        tableView.setRoot(root);
        tableView.setShowRoot(false);



    }


}
