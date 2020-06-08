package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TaskController implements Initializable {


    @FXML
    private Button closeButton    , homeButton;
    @FXML
    private Button reduceButton  ;

    @FXML
    private Label loggedName  ;


    public  void setNameOfUserInTask (String value)
    {
        this.loggedName.setText(value);
    }


    public void reduceWindow ()
    {
        reduceButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) reduceButton.getScene().getWindow() ;
                stage.setIconified(true);
            }
        });
    }
    public void closeWindow ()
    {
        closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) closeButton.getScene().getWindow() ;
                stage.close();
            }
        });
    }

    public void home (ActionEvent event)
    {
        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("board.fxml"));
                    Parent root = null;
                    root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(new Scene(root));
                    stage.show();
                    // loadingImage.setVisible(false);
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
