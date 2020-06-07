package controllers;


import beans.User;
import config.NotifyMe;
import interfaces.Iuser;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.IuserDao;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController   implements Initializable {


    @FXML
    private Label enterLabel;

    @FXML
    private Label appName;

    @FXML
    private Label description;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button LoginButton;
    @FXML
    private ImageView loadingImage  ;
    @FXML
    private Button closeButton;

    @FXML
    private Button reduceButton;

    public void reduceWindow ()
    {
        reduceButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) reduceButton.getScene().getWindow() ;
                stage.setIconified(true); ;
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

    /*
    Login functionnality
     */
    public void login (ActionEvent event){

        loadingImage.setVisible(true);
        String username =  usernameField.getText() ;
        String password = passwordField.getText();
        PauseTransition pauseTransition = new PauseTransition();
        pauseTransition.setDuration(Duration.seconds(6));
        pauseTransition.setOnFinished(ev ->{
            if(username.trim().equals("") || password.trim().equals("")){
                NotifyMe notifyMe =  new NotifyMe() ;
                notifyMe.errorChampsNotify();
                loadingImage.setVisible(false);
            }else{
                IuserDao iuserDao = new IuserDao () ;
                User user = iuserDao.getLogin(username  , password);
                if (user != null) {
                    NotifyMe notifyMe = new NotifyMe() ;
                    notifyMe.access();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("board.fxml"));
                        Parent root = null;
                        root = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setScene(new Scene(root));
                        stage.show();
                        loadingImage.setVisible(false);
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    NotifyMe notifyMe = new NotifyMe() ;
                    notifyMe.mauvaisIdentifiants();
                    loadingImage.setVisible(false);
                }
            }

        });
        pauseTransition.play();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    loadingImage.setVisible(false);


    }
}
