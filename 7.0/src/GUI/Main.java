package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) {

       window = primaryStage;
       window.setTitle("LinkedDB");

        TreeItem<String> root, StoreA, StoreB;

        //Root

        root=new TreeItem<>();
        root.setExpanded(true);

        //StoreA
        StoreA= makeBranch("StoreA",root);
        makeBranch("DOC1", StoreA);
        makeBranch("DOC2", StoreA);
        makeBranch("DOC3", StoreA);

        //StoreB
        StoreB= makeBranch("StoreB",root);
        makeBranch("DOC6", StoreB);
        makeBranch("DOC7", StoreB);
        makeBranch("DOC8", StoreB);

        //Create tree
        tree= new TreeView<>(root);
        tree.setShowRoot(false);
        /*tree.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) ->{
            if (newValue != null)
                System.out.println(newValue.getValue());
        });*/


       //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout,300,200);
        window.setScene(scene);
        window.show();
    }

    //Create Branches
    public TreeItem<String> makeBranch(String tittle, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(tittle);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
