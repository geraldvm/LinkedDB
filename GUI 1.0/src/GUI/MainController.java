package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    @FXML
    TreeView selectionTreeView;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        createTree();
    }

    public void createTree(String... rootItems) {
        //create root
        TreeItem<String> root = new TreeItem<>("Root");
        //root.setExpanded(true);
        //create child
        TreeItem<String> itemChild = new TreeItem<>("Child");
        itemChild.setExpanded(false);
        //root is the parent of itemChild
        root.getChildren().add(itemChild);
        selectionTreeView.setRoot(root);
    }


}
