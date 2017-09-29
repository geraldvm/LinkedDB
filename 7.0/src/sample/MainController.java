package sample;

import Background.Commit.SaveFiles;
import Background.Documents.Attribute;
import Background.JsonObject.ObjectJ;
import Background.JsonObject.Objeto;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;
import Background.LinkedList.SimpleList.SimpleList;
import Background.Load.LoadFile;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.webkit.ContextMenuItem;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Background.Start;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    private Button Commit;
    @FXML
    private TableView tableView;
    @FXML
    private TreeView<String> treeView;
    @FXML
    private MenuItem showT;




    private Start init = new Start();


    Image folder = new Image(getClass().getResourceAsStream("/img/store.png"));
    Image file = new Image(getClass().getResourceAsStream("/img/a.png"));
    Image object = new Image(getClass().getResourceAsStream("/img/object.png"));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TreeItem<String> root = new TreeItem<>("Root");
        Commit.setDisable(true);
        /*
        z.newStore("StoreA");
        z.newStore("StoreB");
        z.newStore("StoreC");
        z.getStore(0).newDoc("DOC1");
        z.getStore(0).newDoc("DOC2");
        z.getStore(0).newDoc("DOC3");
        z.getStore(0).getDocs().find(0).getItem().addAttribute("ID",1,true,false,0);
        z.getStore(0).getDocs().find(0).getItem().addAttribute("Name",3,false,false);
        z.getStore(0).getDocs().find(0).getItem().addAttribute("Edad",1,false,false);
        z.getStore(0).getDocs().find(0).getItem().addObject(12258,"Carlos",25);
        z.getStore(0).getDocs().find(0).getItem().addObject(4588,"Pedro",26);
        z.getStore(0).getDocs().find(0).getItem().addObject("H","juan",35);
        //System.out.println(z.getStore(0).getDocs().find(0).getItem().getObjectList().find(0).getItem().getRow().);
        //SimpleList<Attribute> colAtrib = z.getStore(0).getDocs().find(0).getItem().getAttributeList();

        /*z.showStore();
        System.out.println("**********");
        z.deleteStore("StoreA");
        z.deleteStore("StoreB");
        z.deleteStore("StoreC");
        z.showStore();
*/

        LoadFile Read = new LoadFile();
        Read.loadStores();
        this.init.setStoreList(Read.getStoreList());
        createTree();


    }


    public void mouseClick(MouseEvent mouseEvent){
        if(mouseEvent.isPopupTrigger()) {
            TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
            if(item.getParent().getValue().equals("Root")){
                showT.setDisable(true);
            }
            else if (item.getParent().getParent().getValue().equals("Root")) {
                showT.setDisable(false);
            } else {
                showT.setDisable(true);
            }
        }




    }
    public void commitClick(MouseEvent commitEvent){
        if(commitEvent.getClickCount()==2){
            System.out.println("Commit");
            SaveFiles commit= new SaveFiles(init.getStoreList());
            commit.createFile();
            Commit.setDisable(true);
        }
    }
    @FXML
    void newStoreFunction(ActionEvent event) {
        String store =SecondWindow.display("NewStore","Store");
        if (store!=null){
            init.newStore(store);
            Commit.setDisable(false);
            createTree();
        }
    }

    @FXML
    void deleteFunction(ActionEvent event) {
        System.out.println("deleteF");

    }
    @FXML
    void deleteAllFunction(ActionEvent event) {
        if(!init.getStoreList().isEmpty()) {
            if (treeView.getSelectionModel().getSelectedItem().getParent().getValue().toString() == "Root") {
                init.deleteStore(treeView.getSelectionModel().getSelectedItem().getValue());
                Commit.setDisable(false);
            }else if (treeView.getSelectionModel().getSelectedItem().getParent().getParent().getValue() == "Root") {
                init.getStore(treeView.getSelectionModel().getSelectedItem().getParent().getValue()).eraseDoc(treeView.getSelectionModel().getSelectedItem().getValue().toString());
                Commit.setDisable(false);
            }
        }this.createTree();
    }

    @FXML
    void newDocFunction(ActionEvent event) {
        //TreeItem<String> item = treeView.getSelectionModel().getSelectedItem().parentProperty().toString();
        if (treeView.getSelectionModel().getSelectedItem().getParent().getValue().toString()=="Root"){
            System.out.println(treeView.getSelectionModel().getSelectedItem().getParent().getValue().toString());
            Commit.setDisable(false);



        }


        System.out.println("newDocFunction");
    }

    @FXML
    void newObjectFunction(ActionEvent event) {

        System.out.println("newObjectFunction");
    }




    @FXML
    void searchFunction(ActionEvent event) {
        System.out.println("searchFunction");
        eraseTB();

    }


    @FXML
    void showAllFunction(ActionEvent event) {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        this.eraseTB();
        tableView.refresh();
        this.createTable(item.getParent().getValue(),item.getValue());
    }


    @FXML
    public void updateFunction(ActionEvent event) {
        System.out.println("updateFunction");
        createTree();
    }



    private void createTree(){
        TreeItem<String> root = new TreeItem<>("Root");
        if (!this.init.getStoreList().isEmpty()) {
            for (int i = 0; i < this.init.getAmountStore(); ++i) {
                TreeItem<String> StoreN = new TreeItem<>(this.init.getStore(i).getStoreName(), new ImageView(folder));
                if (!this.init.getStore(i).getDocs().isEmpty()) {
                    for (int x = 0; x < this.init.getStore(i).getDocs().length(); ++x) {
                        this.init.getStore(i).getDocs().find(x);
                        TreeItem<String> docN = new TreeItem<>(this.init.getStore(i).getDocs().findItem(x).getName(), new ImageView(file));
                        StoreN.getChildren().add(docN);
                        if (!this.init.getStore(i).getDocs().findItem(x).getObjectList().isEmpty()) {
                            for (int y = 0; y < this.init.getStore(i).getDocs().findItem(x).getObjectList().length(); ++y) {
                                for (int n = 0; n <this.init.getStore(i).getDocs().findItem(x).getObjectList().findItem(y).getRow().length(); ++n) {
                                    //System.out.println(this.init.getStore(i).getDocs().findItem(x).getObjectList().findItem(y).getRow().findItem(n).isPrimary());
                                   if (this.init.getStore(i).getDocs().findItem(x).getObjectList().findItem(y).getRow().findItem(n).isPrimary()) {
                                        TreeItem<String> objectN = new TreeItem<>(this.init.getStore(i).getDocs().findItem(x).getObjectList().findItem(y).getRow().findItem(n).getValue().toString(), new ImageView(object));
                                        docN.getChildren().add(objectN);
                                   }
                                }

                            }
                        }
                    }
                }
                root.getChildren().add(StoreN);
            }
        }treeView.setRoot(root);
    }

    private void createTable(String storeName, String docName){
        for(int i=0;i<this.init.getStore(storeName).getDocs().length();++i) {
            if (this.init.getStore(storeName).getDocs().findItem(i).getName().equals(docName)) {
                this.Insert(this.init.getStore(storeName).getDocs().findItem(i).getAttributeList(),
                        this.init.getStore(storeName).getDocs().findItem(i).getObjectList());
            }
        }
    }
    private void Insert(SimpleList<Attribute> columnAttrib, SimpleList<ObjectJ> objectList) {

        List<String> columns = new ArrayList<String>();
        List<String> colAt = new ArrayList<String>();

        for (int i =0;i<columnAttrib.length();++i) {
            columns.add(columnAttrib.find(i).getItem().getName());
        }
        TableColumn [] tableColumns = new TableColumn[columns.size()];
        //int columnIndex = 0;
        for(int  k=0 ; k<columns.size(); k++) {
            int j = k;
            TableColumn col = new TableColumn(columns.get(k));
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });
            tableView.getColumns().addAll(col);
        }
        for (int n=0;n<objectList.length();++n) {
            addRows(objectList.find(n).getItem().getRow(), columns.size());
        }
    }
    private void addRows(SimpleList<Objeto> objectRow, int columnSize){
        ObservableList<Object> row = FXCollections.observableArrayList();
        for(int x=0;x<columnSize;x++)
        {

            Object Valid = objectRow.find(x).getItem().getValue();
            row.addAll(Valid);
        }tableView.getItems().add(row);
    }

    private void eraseTB(){
        tableView.getItems().clear();
        tableView.getColumns().clear();
        tableView.refresh();
    }



}