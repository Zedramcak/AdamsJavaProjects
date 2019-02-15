/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprepinaniscen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Adam
 */
public class JavaFXPrepinaniScen extends Application {

    Stage window;
    Scene scene1, scene2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        //Button 1
        Label label1 = new Label("Vitejte v prvni scene!");
        Button button1 = new Button("Jit na 2.scenu");
        button1.setOnAction(e -> window.setScene(scene2));
        
        //Layout 1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1,200,200);
        
        
        //Button 2
        Button button2 = new Button("Jit na 1.scenu");
        button2.setOnAction(e -> window.setScene(scene1));
        
        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2,600,300);
        
        //Dispplay scene 1 at first
        window.setScene(scene1);
        window.setTitle("Prechody");
        window.show();
        
    }
    
}
