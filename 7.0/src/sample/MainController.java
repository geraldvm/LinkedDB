package sample;

import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Background.Start;

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
    TreeItem<Person> per2 = new TreeItem<>(new Person("Paulina","p@gmail.com",25));
    TreeItem<Person> per3 = new TreeItem<>(new Person("Maria","mar_s@gmail.com",45));
    TreeItem<Person> per4 = new TreeItem<>(new Person("Delroy","l@hotmail.com",15));

    TreeItem<Person> rootTable = new TreeItem<>(new Person("Name","email",0));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TreeItem<String> root = new TreeItem<>("Root");
        Start z = new Start();
        z.newStore("StoreA");
        z.newStore("StoreB");
        z.newStore("StoreC");
        z.getStore(0).newDoc("DOC1");
        z.getStore(0).newDoc("DOC2");
        z.getStore(0).newDoc("DOC3");
        z.getStore(0).getDocs().find(0).getItem().addAttribute("ID",4,true,false);
        z.getStore(0).getDocs().find(0).getItem().addAttribute("Edad",1,true,false);
        z.getStore(0).getDocs().find(0).getItem().addObject("ID","ID","MANUEL");
        z.getStore(0).getDocs().find(0).getItem().addObject("ID","ID","NUEL");
        System.out.println(z.getStore(0).getDocs().find(0).getItem().getObjectList().find(0).getItem().getValue());
        createTree(z);

    }
    private void createTable(){

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
            //System.out.println(item.getValue());
        }
    }

    @FXML
    void deleteFunction(ActionEvent event) {
        System.out.println("deleteF");
    }
    @FXML
    void deleteAllFunction(ActionEvent event) {
        System.out.println("deleteALL");
    }

    @FXML
    void newDocFunction(ActionEvent event) {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        System.out.println(item.getValue());
        System.out.println("newDocFunction");
    }

    @FXML
    void newObjectFunction(ActionEvent event) {
        System.out.println("newObjectFunction");
    }

    @FXML
    void newStoreFunction(ActionEvent event) {
        System.out.println("newStoreFunction");
    }

    @FXML
    void searchFunction(ActionEvent event) {
        System.out.println("searchFunction");

    }

    @FXML
    void showAllFunction(ActionEvent event) {
        System.out.println("showAllFunction");
    }

    @FXML
    void updateFunction(ActionEvent event) {
        System.out.println("updateFunction");
    }



    private void createTree(Start z){
        TreeItem<String> root = new TreeItem<>("Root");
        for (int i=0;i<z.getAmountStore();++i){
            System.out.println(i);
            TreeItem<String> StoreN = new TreeItem<>(z.getStore(i).getStoreName(),new ImageView(folder));
            if(z.getStore(i).getDocs().length()>0){
                for(int x=0;x<z.getStore(i).getDocs().length();++x){
                    z.getStore(i).getDocs().find(x);
                    TreeItem<String> docN = new TreeItem<>(z.getStore(i).getDocs().find(x).getItem().getName(),new ImageView(file));
                    StoreN.getChildren().add(docN);
                    if(z.getStore(i).getDocs().find(x).getItem().getObjectList().length()>0){
                        for(int y=0; y<z.getStore(i).getDocs().find(x).getItem().getObjectList().length();++y){
                            TreeItem<String> objectN = new TreeItem<>(z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getValue().toString(),new ImageView(object));
                            docN.getChildren().add(objectN);
                        }
                    }
                }
            }root.getChildren().add(StoreN);
        }
        treeView.setRoot(root);
    }

}
