package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class NewDocController implements Initializable{
    @FXML
    private Button createBtn;
    @FXML
    private TextField input;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void create(MouseEvent createEvent){
        if(createEvent.getClickCount()==2){
            System.out.println(input.getText());


            //System.out.println(item.getValue());
        }

    }
}

