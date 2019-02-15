package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event){
        System.out.println("TYS NA ME KLIKNUL!!!");
        label.setText("AHOOOOOJ");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
