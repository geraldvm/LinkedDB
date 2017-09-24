package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    TreeView<String> treeView;

    Image folder = new Image(getClass().getResourceAsStream("/img/store.png"));
    Image file = new Image(getClass().getResourceAsStream("/img/a.png"));
    Image object = new Image(getClass().getResourceAsStream("/img/object.png"));


    //-----------------Table----------------------
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

    TreeItem<Person> rootTable = new TreeItem<>(new Person("Name","email",0));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> root = new TreeItem<>("Root");
        TreeItem<String> StoreA = new TreeItem<>("StoreA", new ImageView(folder));
        TreeItem<String> StoreB = new TreeItem<>("StoreB", new ImageView(folder));
        TreeItem<String> StoreC = new TreeItem<>("StoreC", new ImageView(folder));
        root.getChildren().addAll(StoreA,StoreB,StoreC);

        TreeItem<String> Doc1 = new TreeItem<>("JsonDoc1",new ImageView(file));
        TreeItem<String> Doc2 = new TreeItem<>("JsonDoc2",new ImageView(file));
        TreeItem<String> Doc3 = new TreeItem<>("JsonDoc3",new ImageView(file));
        StoreA.getChildren().addAll(Doc1,Doc2,Doc3);
        //StoreA.setExpanded(true);
        //Expandir El nodo

        TreeItem<String> ObjA = new TreeItem<>("ObjectA",new ImageView(object));
        TreeItem<String> ObjB = new TreeItem<>("ObjectB",new ImageView(object));
        TreeItem<String> ObjC = new TreeItem<>("ObjectC",new ImageView(object));
        Doc1.getChildren().addAll(ObjA,ObjC,ObjB);

        treeView.setRoot(root);

        rootTable.getChildren().setAll(per1,per2,per3,per4);

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
        tableView.setRoot(rootTable);
        tableView.setShowRoot(false);

    }

    public void mouseClick(MouseEvent mouseEvent){
            if(mouseEvent.getClickCount()==2){
            TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
            System.out.println(item.getValue());
        }


    }

}
