package com.example;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Email System");

        Group root = new Group();
        Scene scene = new Scene(root,Color.BLACK);
        stage.setScene(scene);
        stage.show();

        GridPane mainContainer = new GridPane();
        TextField usernameTextField = new TextField();

        LinkedHashMap<String,String> fields = new LinkedHashMap<String, String>();
        fields.put("username", "ece18aba10cc34");
        fields.put("password", "201120514d76b0");
        fields.put("host", "sandbox.smtp.mailtrap.io");
        fields.put("senderAddress", "");
        fields.put("receiverAddress", "");
        int i = 0;
        for(Entry<String, String> field : fields.entrySet()){
            TextField textField = new TextField();
            textField.setText(field.getValue());
            Label label = new Label();
            label.setText(field.getKey());
            mainContainer.add(label,0,i);
            mainContainer.add(textField,1,i);
            i++;
        }
        usernameTextField.setText("ece18aba10cc34");
        mainContainer.add(usernameTextField,1,0);

        /* Sender sender = new Sender();
        sender.send("ece18aba10cc34", "201120514d76b0", "sandbox.smtp.mailtrap.io",
        "sender@email.com", "receiver@email.com"); */
    }
}