package org.example.checkbox;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckBoxGui extends Application {
    CheckBox chWeb;
    CheckBox chDesktop;
    CheckBox chMobile;
    Label response;
    Label allTargets;
    String targets = "";

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Demonstrate Checkboxes");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 400, 400);
        stage.setScene(scene);
        Label heading = new Label("Select Deployment optons");
        response = new Label("No Deployment selected.");
        allTargets = new Label("Target list <none>");

        //создать флажки
        chWeb = new CheckBox("Web");
        chDesktop = new CheckBox("Desktop");
        chMobile = new CheckBox("Mobile");
        //обработать события действия от флажка
        chWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(chWeb.isSelected()){
                    response.setText("Selected Web options");
                }else {
                    response.setText("Web deployment cleared");
                }
                showAll();
            }
        });
        chDesktop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(chDesktop.isSelected()){
                    response.setText("Desktop deployment selected");
                }else {
                    response.setText("Desktop deployment cleared");
                }
                  showAll();
            }
        });
        chMobile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(chMobile.isSelected()){
                    response.setText("Mobile deployment selected");
                }else {
                    response.setText("Mobile deployment cleared");
                }
                showAll();
            }
        });

        Separator separator = new Separator();
        separator.setPrefWidth(500);
        Separator separator1 = new Separator();
        separator.setPrefWidth(200);

        rootNode.getChildren().addAll(heading, separator, chWeb,
                chDesktop, chMobile, response, allTargets);

        stage.show();

    }
    void showAll(){
        targets = "";
        if(chWeb.isSelected()) targets = "Web ";
        if(chDesktop.isSelected()) targets = "Desktop ";
        if(chMobile.isSelected()) targets = "Mobile ";
        if(targets.equals("")) targets = "<none>";
        allTargets.setText("Target list: " + targets);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


























