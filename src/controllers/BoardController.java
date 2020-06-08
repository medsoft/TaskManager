package controllers;

import beans.User;
import javafx.animation.PauseTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.IuserDao;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController  implements Initializable {


    @FXML
    private AnchorPane boardAnchorpane;
    @FXML
    private StackPane boardStackpane;
    @FXML
    private Button closeButton ,homeButton  ,  create ,refreshButton  ;
    @FXML
    private Button reduceButton  , taskButton;
    @FXML
    private ImageView loading ;

    @FXML
    private Label loggedName  ;


    public  void setNameOfUser (String value)
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addProjectList();
        loading.setVisible(false);
    }

    public void refresh ()
    {
        refreshButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               loading.setVisible(true);
               PauseTransition pauseTransition = new PauseTransition();
               pauseTransition.setDuration(Duration.seconds(3));
               pauseTransition.setOnFinished(ev -> {

                   try {
                               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("board.fxml"));
                               Parent root = null;
                               root = (Parent) fxmlLoader.load();
                               Stage stage = new Stage();
                               stage.initStyle(StageStyle.UNDECORATED);
                               stage.setScene(new Scene(root));
                               stage.show();
                               loading.setVisible(false);
                               ((Node) (event.getSource())).getScene().getWindow().hide();
                           } catch (IOException e) {
                               e.printStackTrace();

                           }


               });

               pauseTransition.play();
           }
       });

    }
    public void createProject ()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateProject.fxml"));
            Parent root = null;
            root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
            // loadingImage.setVisible(false);
            // ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    private void addProjectList ()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProjectList.fxml")) ;
        try {
            Node node = fxmlLoader.load() ;
            boardStackpane.getChildren().add(node) ;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @FXML
    private void openTask (ActionEvent event)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Task.fxml"));
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
    public void home ()
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
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        });
    }
}
