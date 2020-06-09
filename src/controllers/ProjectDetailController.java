package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectDetailController  implements Initializable {



    @FXML
    private Label enterLabel;

    @FXML
    private Label appName;

    @FXML
    private Button updateButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button reduceButton;

    @FXML
    private ImageView loader;

    @FXML
    private Button deleteButton;

    @FXML
    private ImageView projectDetailImage;

    @FXML
    private Label projectDetailName;

    @FXML
    private Label projectDetailType;

    @FXML
    private Label projectDetailDescription;

    @FXML
    private ImageView authorProjectDetailImage;

    @FXML
    private Label projectDetailEndDate , projectAuthor;

    @FXML
    private Label projectDetailStartDate;


    @FXML
    public void closeWindow() {

        closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) closeButton.getScene().getWindow() ;
                stage.close();
            }
        });
    }

    @FXML
    public void reduceWindow(ActionEvent event) {
        reduceButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Stage stage = (Stage) reduceButton.getScene().getWindow() ;
                stage.setIconified(true);
            }
        });
    }

    public  void setProjectDetailName(String value)
    {
        this.projectDetailName.setText(value);
    }
    public  void setProjectDetailType(String value)
    {
        this.projectDetailType.setText(value);
    }

    public  void setProjectDetailDescription(String value)
    {
        this.projectDetailDescription.setText(value);
    }

    public  void setProjectDetailStartDate(String value)
    {
        this.projectDetailStartDate.setText(value);
    }

    public  void setProjectDetailEndDate(String value)
    {
        this.projectDetailEndDate.setText(value);
    }

    public  void setProjectAuthor(String value)
    {
        this.projectAuthor.setText(value);
    }




    @FXML
    void deleteProject( ) {

    }


    @FXML
    void updateProject(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            loader.setVisible(false);

    }
}
