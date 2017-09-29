package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StoreWin implements Initializable {
    @FXML
    static private Button controlJ;
    @FXML
    static private TextField input;
    @FXML
    public void create(MouseEvent event){
        storeName=input.getText();
        stageStore.close();

    }
    //private final Properties fxmlLoader;
    static private Parent rootStore;
    private static String storeName;
    private static Stage stageStore;
    public StoreWin(){

    }
    public void load() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewStoreWin.fxml"));
        rootStore = ((Parent) fxmlLoader.load());
        stageStore = new Stage();
        stageStore.setScene(new Scene(rootStore));
        stageStore.setTitle("New Store");
        stageStore.show();
    }

    public static String display() {



        return storeName;


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
