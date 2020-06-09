package controllers;

import beans.Project;
import com.jfoenix.controls.JFXDatePicker;
import config.NotifyMe;
import interfaces.Iproject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.IprojectDao;
import model.IuserDao;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static controllers.LoginController.sessionID;

public class CreateProjectController  implements Initializable {

    @FXML
    private Button closeButton    ;
    @FXML
    private Button reduceButton  ;
    @FXML
    private  ImageView loader ;

    @FXML
    private Label description;

    @FXML
    private TextField nameField;

    @FXML
    private Button createButton;

    @FXML
    private TextField typeField;

    @FXML
    private TextField descriptionField;

    @FXML
    private JFXDatePicker startDateField;

    @FXML
    private JFXDatePicker endDateField;

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
    public  void create ()
    {
       createButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent event) {
               loader.setVisible(true);
               String name  =  nameField.getText() ;
               String type  =  typeField.getText() ;
               String description = descriptionField.getText() ;
               LocalDate startDate =  startDateField.getValue() ;
               LocalDate endDate  =  endDateField.getValue() ;


               Iproject iproject = new  IprojectDao () ;

               if (name.trim().equals("")||type.trim().equals("")||description.trim().equals("")){
                   NotifyMe notifyMe =  new NotifyMe() ;
                   notifyMe.errorChampsNotify();
                   loader.setVisible(false);
               }else {
                   loader.setVisible(true);
                   IuserDao iuserDao =  new IuserDao() ;
                   Project project = new Project()  ;
                   project.setName(name);
                   project.setType(type);
                   project.setDescription(description);
                   project.setStartDate(startDate);
                   project.setEndDate(endDate);
                   project.setUser(sessionID);
                   int ok  = iproject.add(project) ;
                   if (ok !=  0 )
                   {
                       NotifyMe notifyMe  = new   NotifyMe () ;
                       notifyMe.projectAddedSuccessfully();
                       loader.setVisible(false);
                   }else {
                       NotifyMe notifyMe  = new   NotifyMe () ;
                       notifyMe.errorChampsNotify();
                       loader.setVisible(false);
                   }
               }
           }
       });
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loader.setVisible(false);
    }
}
