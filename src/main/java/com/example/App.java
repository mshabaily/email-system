package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    
    protected List<TextField> textFields = new ArrayList<TextField>();
    static LinkedHashMap<String,String> fields = new LinkedHashMap<String, String>();

    public static void main(String[] args){
        fields.put("senderAddress", "");
        fields.put("receiverAddress", "");
        fields.put("Title", "");
        fields.put("Message", "");
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Email System");

        GridPane mainContainer = new GridPane();

        int i = 0;
        for(Entry<String, String> field : fields.entrySet()){
            TextField textField = new TextField();
            textField.setText(field.getValue());
            textFields.add(textField);
            Label label = new Label();
            label.setText(field.getKey());
            mainContainer.add(label,0,i);
            mainContainer.add(textField,1,i);
            i++;
        }
        EventHandler<ActionEvent> sendEmail = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent sendEmail)
            {
                String[] args = new String[fields.size()+1];
                int position = 0;
                for(TextField textfield : textFields){
                    args[position] = (textfield.getText());
                    position++;
                }
                Sender sender = new Sender();
                try {
                    sender.send(args[0],args[1],args[2],args[3]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            };
        Button sendButton = new Button("SEND EMAIL");
        sendButton.setOnAction(sendEmail);
        mainContainer.add(sendButton,0,fields.size(),1,2);
        Scene scene = new Scene(mainContainer);
        stage.setScene(scene);
        stage.show();
    }
}