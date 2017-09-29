package sample;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class NewStoreController implements Initializable{
    /*@FXML
    private TextField storeName;*/
    @FXML
    private Button controlJ;
    @FXML
    private TextField input;
    private String j;
    @FXML
    Stage stageStore;
    private boolean close=false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    @FXML
    public void create(MouseEvent createEvent){
        if(createEvent.getClickCount()==2){
            //System.out.println(input.getText());
            j= input.getText();
            this.close=true;
            //controlJ.setOnAction(event -> window.close);


            //System.out.println(item.getValue());
        }

    }

    public String getJ() {
        controlJ.setOnAction(event -> {
            j= input.getText();
                    });
        return j;
    }

    public boolean isClose() {
        return this.close;
    }
}
