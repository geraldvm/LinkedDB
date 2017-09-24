package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
    }

    public void mouseClick(MouseEvent mouseEvent){
        if(mouseEvent.getClickCount()==2){
            TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
            System.out.println(item.getValue());
        }


    }

}
