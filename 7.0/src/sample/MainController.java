package sample;

import Background.Documents.Attribute;
import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;
import Background.LinkedList.SimpleList.SimpleList;
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


    Image folder = new Image(getClass().getResourceAsStream("/img/store.png"));
    Image file = new Image(getClass().getResourceAsStream("/img/a.png"));
    Image object = new Image(getClass().getResourceAsStream("/img/object.png"));


    //-----------------Table----------------------


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TreeItem<String> root = new TreeItem<>("Root");
        Commit.setDisable(true);
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
        SimpleList<Attribute> colAtrib = z.getStore(0).getDocs().find(0).getItem().getAttributeList();
        createTree(z);
        createTable(z);

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
    public void updateFunction(ActionEvent event) {
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

    private void createTable(Start z){
        this.createColumns(this.Insert(z.getStore(0).getDocs().find(0).getItem().getAttributeList()));
    }
    private List<String> Insert(SimpleList<Attribute> columnAttrib) {
        List<String> columns = new ArrayList<String>();
        int columnIndex = 0;
        for (int i =0;i<columnAttrib.length();++i) {
            columns.add(columnAttrib.find(i).getItem().getName());
            //columnIndex = 0;
        }
        return columns;
    }
    private void createColumns(List<String> columns){
        TableColumn[] tableColumns;
        tableColumns = new TableColumn[columns.size()];
        for (int n=0;n<columns.size();++n){
            tableColumns[n]= new TableColumn(columns.get(n));
        }
        tableView.getColumns().addAll(tableColumns);
        System.out.println("ok");
    }

}