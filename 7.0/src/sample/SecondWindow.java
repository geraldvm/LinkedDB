package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * Case Second Windown
 * Crea ventana secundaria
 */
public class SecondWindow {
    static String input;

    /**
     * Ventana de nuevo Store
     * @param tittle Nombre de la ventana
     * @param message mensaje de la ventana
     * @return String
     */
    public static String display(String tittle, String message) {
        Stage window = new Stage();
        input=null;
        //window.initStyle(StageStyle.UNIFIED);
        window.setTitle(tittle);
        window.setMinWidth(300);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText(message);
        TextField textinput = new TextField();
        textinput.setPromptText("Name");
        //textinput.promptTextProperty();
        textinput.setMaxWidth(120);
        Button createBtn = new Button("Create");
        createBtn.setTextFill(Paint.valueOf("#FFFFFF"));
        createBtn.setStyle("-fx-background-color:#27a549");
        createBtn.setOnAction(event -> {
            if(!textinput.getText().isEmpty()) {
                input = textinput.getText();
                window.close();
            }
        });

        VBox layout = new VBox(60);
        layout.getChildren().addAll(label,textinput,createBtn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return input;
    }
    public static String newDoc(String tittle, String message) {
        Stage window = new Stage();
        input=null;
        //window.initStyle(StageStyle.UNIFIED);
        window.setTitle(tittle);
        window.setMinWidth(300);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText(message);
        TextField textinput = new TextField();
        textinput.setPromptText("Name");
        //textinput.promptTextProperty();
        textinput.setMaxWidth(120);
        Button createBtn = new Button("Create");
        createBtn.setTextFill(Paint.valueOf("#FFFFFF"));
        createBtn.setStyle("-fx-background-color:#27a549");
        createBtn.setOnAction(event -> {
            if(!textinput.getText().isEmpty()) {
                input = textinput.getText();
                window.close();
            }
        });

        VBox layout = new VBox(60);
        layout.getChildren().addAll(label,textinput,createBtn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return input;
    }
}
