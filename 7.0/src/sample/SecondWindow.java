package sample;


import Background.Documents.Attribute;
import Background.Documents.JsonDoc;
import Background.JsonObject.ObjectJ;
import Background.JsonObject.Objeto;
import Background.JsonStore.Store;
import Background.LinkedList.SimpleList.SimpleList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Case Second Windown
 * Crea ventana secundaria
 */
public class SecondWindow {
    static String input;
    static JsonDoc doc;

    /**
     * Ventana de nuevo Store
     * @param tittle Nombre de la ventana
     * @param message mensaje de la ventana
     * @return String
     */
    public static String display(String tittle, String message) {
        Stage window = new Stage();
        input=null;
        //window.initStyle(StageStyle.UTILITY);
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

    public static JsonDoc newDOC() {

        Stage window = new Stage();
        input=null;
        //window.initStyle(StageStyle.UTILITY);
        window.setTitle("New Doc");
        window.setMinWidth(300);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText("Put the name");
        TextField textinput = new TextField();
        textinput.setPromptText("Name");
        //textinput.promptTextProperty();
        textinput.setMaxWidth(120);
        Button createBtn = new Button("Create");
        createBtn.setTextFill(Paint.valueOf("#FFFFFF"));
        createBtn.setStyle("-fx-background-color:#27a549");
        createBtn.setOnAction((ActionEvent event) -> {
            if(!textinput.getText().isEmpty()) {
                doc=new JsonDoc(textinput.getText());
                window.close();
            }
        });

        VBox layout = new VBox(60);
        layout.getChildren().addAll(label,textinput,createBtn);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        doc.setAttributeList(newAttribute());
        return doc;
    }
    public static SimpleList<Attribute> newAttribute() {
        SimpleList<Attribute> attributeList = new SimpleList<>();

        Stage window = new Stage();
        input = null;
        //window.initStyle(StageStyle.UNIFIED);
        window.setTitle("Attribute List");
        window.setMinWidth(350);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText("New Attribute");
        label.setLayoutX(120);
        label.setLayoutY(10);

        TextField textName = new TextField();
        TextField textType = new TextField();
        TextField textKey = new TextField();
        TextField textRequired = new TextField();
        TextField textValue = new TextField();


        textName.setMaxWidth(120);
        textType.setMaxWidth(120);
        textKey.setMaxWidth(120);
        textRequired.setMaxWidth(120);
        textValue.setMaxWidth(120);

        textName.setPromptText("Name");
        textType.setPromptText("Type");
        textKey.setPromptText("Key");
        textRequired.setPromptText("Required");
        textValue.setPromptText("Value");

        textName.setLayoutY(60);
        textName.setLayoutX(110);
        textType.setLayoutY(90);
        textType.setLayoutX(110);
        textKey.setLayoutY(120);
        textKey.setLayoutX(110);
        textRequired.setLayoutY(150);
        textRequired.setLayoutX(110);
        textValue.setLayoutY(180);
        textValue.setLayoutX(110);

        Button createBtn = new Button("Add");
        createBtn.setTextFill(Paint.valueOf("#FFFFFF"));
        createBtn.setStyle("-fx-background-color:#27a549");
        createBtn.setLayoutX(135);
        createBtn.setLayoutY(220);
        Button ok = new Button("OK");
        ok.setTextFill(Paint.valueOf("#FFFFFF"));
        ok.setStyle("-fx-background-color:#0e4aa3");
        ok.setLayoutX(185);
        ok.setLayoutY(220);
        createBtn.setOnAction((ActionEvent event) -> {
            if ((!textName.getText().isEmpty()) &&
                    (!textType.getText().isEmpty()) && (!textKey.getText().isEmpty())
                    && (!textRequired.getText().isEmpty())) {
                Attribute temp = new Attribute(textName.getText(), textType.getText(), textKey.getText(), Boolean.parseBoolean(textRequired.getText()));
                attributeList.addLast(temp);
                textKey.clear();
                textName.clear();
                textRequired.clear();
                textValue.clear();
                textType.clear();
                // window.close();
            }
        });
        ok.setOnAction(event -> window.close());

        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(label, textName, textType, textKey, textRequired, textValue, createBtn, ok);
        //layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return attributeList;

    }

    public static void newObj() {
        SimpleList<ObjectJ> objectList = new SimpleList<>();
        Stage window = new Stage();
        input = null;
        window.setTitle("Object");
        window.setMinWidth(350);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText("New Object");
        label.setLayoutX(120);
        label.setLayoutY(10);
        AnchorPane layout = new AnchorPane();
        layout.getChildren().addAll(label);
        for (int i=1;i<5;i++){
            TextField textinput = new TextField();
            textinput.setPromptText("Value");
            textinput.setMaxWidth(140);
            textinput.setLayoutY(i*40);
            textinput.setLayoutX(90);
            layout.getChildren().addAll(textinput);
        }
        Button createBtn = new Button("Add");
        createBtn.setTextFill(Paint.valueOf("#FFFFFF"));
        createBtn.setStyle("-fx-background-color:#27a549");
        createBtn.setLayoutX(150);
        createBtn.setLayoutY(220);
        createBtn.setOnAction(event -> window.close());
        layout.getChildren().add(createBtn);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

}
