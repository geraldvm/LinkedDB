package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class NewStoreController implements Initializable {
    /*@FXML
    private TextField storeName;*/
    @FXML
    private Button controlJ;
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
