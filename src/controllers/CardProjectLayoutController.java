package controllers;

import beans.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.IprojectDao;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CardProjectLayoutController implements Initializable {

    @FXML
    private AnchorPane anchorpaneCard;

    @FXML
    private Pane paneLayout;

    @FXML
    private Label statusLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label nameLabel , creator;

    @FXML
    private ImageView illustrationImage;

    @FXML
    private Button tasksProject  ;

    @FXML
    private Label dateStartLabel;

    private  Project project ;

    public  void  setProject (Project project)
    {
        this.project =  project ;

    }

    public void setProjectName (String value)
    {
        this.nameLabel.setText(value);
    }

    public void setStatusLabel (Paint value)
    {
        this.statusLabel.setTextFill(Color.web(String.valueOf(value)));
    }

    public void setStatusLab (String value)
    {
        this.statusLabel.setText(value);
    }

    public void setTypeLabel (String value)
    {
        this.typeLabel.setText(value);
    }


    public void setDateStartLabel (String value)
    {
        this.dateStartLabel.setText(value);
    }

    public void setCreator (String creator)
    {
        this.creator.setText(creator);
    }


    String style = "-fx-background-color: rgba(255, 255, 255, 0.5);";

    public void setPaneLayoutColor (String style)
    {
        this.paneLayout.setStyle(style);
    }

    // enlever la boucle for

    public void getDetailProject ()
    {

                        try {

                            FXMLLoader fxmlLoader  =  new FXMLLoader(getClass().getResource("ProjectDetail.fxml")) ;
                            Parent root  =  null ;
                            root   =  (Parent) fxmlLoader.load() ;
                            Stage stage  =  new Stage()  ;
                            stage.initStyle(StageStyle.UNDECORATED);
                            stage.setScene(new Scene(root));
                            stage.show();
                            IprojectDao iprojectDao = new IprojectDao() ;

                                ProjectDetailController projectDetailController = fxmlLoader.getController();
                                projectDetailController.setProjectDetailName(iprojectDao.get(this.project.getId()).getName());
                                projectDetailController.setProjectDetailType(iprojectDao.get(this.project.getId()).getType());
                                projectDetailController.setProjectDetailDescription(iprojectDao.get(this.project.getId()).getDescription());
                                projectDetailController.setProjectDetailStartDate(iprojectDao.get(this.project.getId()).getStartDate().toString());
                                projectDetailController.setProjectDetailEndDate(iprojectDao.get(this.project.getId()).getEndDate().toString());
                                 projectDetailController.setProjectAuthor(iprojectDao.get(this.project.getId()).getUser().toString());

                        }catch (Exception e){

                            e.printStackTrace();
                        }




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }
}
