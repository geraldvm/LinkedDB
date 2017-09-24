package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    TreeView<String> treeView;

    Image folder = new Image(getClass().getResourceAsStream("/img/folder.png"));


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> root = new TreeItem<>("Root", new ImageView(folder));
        TreeItem<String> StoreA = new TreeItem<>("StoreA");
        TreeItem<String> StoreB = new TreeItem<>("StoreB");
        TreeItem<String> StoreC = new TreeItem<>("StoreC");
        root.getChildren().addAll(StoreA,StoreB,StoreC);

        TreeItem<String> Doc1 = new TreeItem<>("JsonDoc1");
        TreeItem<String> Doc2 = new TreeItem<>("JsonDoc2");
        TreeItem<String> Doc3 = new TreeItem<>("JsonDoc3");
        StoreA.getChildren().addAll(Doc1,Doc2,Doc3);

        TreeItem<String> ObjA = new TreeItem<>("ObjectA");
        TreeItem<String> ObjB = new TreeItem<>("ObjectB");
        TreeItem<String> ObjC = new TreeItem<>("ObjectC");
        Doc1.getChildren().addAll(ObjA,ObjC,ObjC);

        treeView.setRoot(root);





    }
}
