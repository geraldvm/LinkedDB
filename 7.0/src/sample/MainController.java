package sample;

import Background.Documents.Attribute;
import Background.JsonObject.ObjectJ;
import Background.JsonObject.Objeto;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;
import Background.LinkedList.SimpleList.SimpleList;
import com.sun.org.apache.xpath.internal.SourceTree;
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
    private ContextMenu contMenu;
    List<String> columns = new ArrayList<String>();
    private Start z = new Start();


    Image folder = new Image(getClass().getResourceAsStream("/img/store.png"));
    Image file = new Image(getClass().getResourceAsStream("/img/a.png"));
    Image object = new Image(getClass().getResourceAsStream("/img/object.png"));

    ObservableList<Table> data = FXCollections.observableArrayList(
            new Table(12258,"Carlos",25),
            new Table(18,"Juan",25),
            new Table(12258,"Pablo",26));


    //-----------------Table----------------------


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TreeItem<String> root = new TreeItem<>("Root");
        Commit.setDisable(true);

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
        createTree(z);

    }


    public void mouseClick(MouseEvent mouseEvent){
        if(mouseEvent.getClickCount()==2){
            TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
            //System.out.println(item.getValue());
        }
    }
    public void commitClick(MouseEvent commitEvent){
        if(commitEvent.getClickCount()==2){
            System.out.println("Commit");
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
    void newStoreFunction(ActionEvent event) {
        System.out.println("newStoreFunction");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewStoreWin.fxml"));
            Parent rootStore = ((Parent) fxmlLoader.load());
            Stage stageStore = new Stage();
            //stageStore.initStyle(StageStyle.UNIFIED);
            stageStore.setTitle("New Store");
            stageStore.setScene(new Scene(rootStore));
            stageStore.show();
        }catch (Exception e){
            System.out.println("Can't Load window");
        }
    }

    @FXML
    void searchFunction(ActionEvent event) {
        System.out.println("searchFunction");

    }

    @FXML
    void showAllFunction(ActionEvent event) {
        System.out.println("showAllFunction");
        createTable(z);
    }

    @FXML
    public void updateFunction(ActionEvent event) {
        System.out.println("updateFunction");
    }



    private void createTree(Start z){
        TreeItem<String> root = new TreeItem<>("Root");
        for (int i=0;i<z.getAmountStore();++i){
            TreeItem<String> StoreN = new TreeItem<>(z.getStore(i).getStoreName(),new ImageView(folder));
            if(z.getStore(i).getDocs().length()>0){
                for(int x=0;x<z.getStore(i).getDocs().length();++x){
                    z.getStore(i).getDocs().find(x);
                    TreeItem<String> docN = new TreeItem<>(z.getStore(i).getDocs().find(x).getItem().getName(),new ImageView(file));
                    StoreN.getChildren().add(docN);
                    if(z.getStore(i).getDocs().find(x).getItem().getObjectList().length()>0){
                        for(int y=0; y<z.getStore(i).getDocs().find(x).getItem().getObjectList().length();++y){
                            for(int n=0;n<z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getRow().length();++n){
                                if(z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getRow().find(n).getItem().isPrimary()){
                                    //System.out.println(z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getRow().find(n).getItem().getColumn()+"---"+z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getRow().find(n).getItem().isPrimary()+"----"+z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getRow().find(n).getItem().getValue());
                                    TreeItem<String> objectN = new TreeItem<>(z.getStore(i).getDocs().find(x).getItem().getObjectList().find(y).getItem().getRow().find(n).getItem().getValue().toString(),new ImageView(object));
                                    docN.getChildren().add(objectN);
                                }
                            }

                        }
                    }
                }
            }root.getChildren().add(StoreN);
        }
        treeView.setRoot(root);
    }

    private void createTable(Start z){
        this.Insert(z.getStore(0).getDocs().find(0).getItem().getAttributeList(),z);
    }
    private void Insert(SimpleList<Attribute> columnAttrib, Start z) {


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
        addRows(z.getStore(0).getDocs().find(0).getItem().getObjectList().find(0).getItem().getRow(),columns.size());
    }
    private void addRows(SimpleList<Objeto> objectRow, int columnSize){
        ObservableList<Object> row = FXCollections.observableArrayList();
        for(int x=0;x<columnSize;x++)
        {

            //System.out.println(s[x]);
            Object Valid = objectRow.find(x).getItem().getValue();
            row.addAll(Valid);
        }tableView.getItems().add(row);
    }



}