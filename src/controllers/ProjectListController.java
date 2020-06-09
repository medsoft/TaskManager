package controllers;

import beans.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import model.IprojectDao;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProjectListController  implements Initializable {

    @FXML
    private AnchorPane anchorpaneList;

    @FXML
    private ScrollPane scrollpaneList;

    @FXML
    private FlowPane flowcontainer;

    public void refresh (){
        IprojectDao iprojectDao = new IprojectDao() ;
        ObservableList<Project> projects = FXCollections.observableArrayList() ;
        List<Project>projectList = iprojectDao.getAll() ;

        for (Project pro : projectList){
            projects.add(pro) ;

            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CardProjectLayout.fxml"));
                Node node = fxmlLoader.load();
                CardProjectLayoutController cardProjectLayoutController = fxmlLoader.getController();
                cardProjectLayoutController.setProjectName(pro.getName());
                cardProjectLayoutController.setProject(pro);
                cardProjectLayoutController.setTypeLabel(pro.getType());
                cardProjectLayoutController.setDateStartLabel(pro.getStartDate().toString());
                cardProjectLayoutController.setCreator(pro.getUser().toString());

                String illustration = Integer.toString(pro.getStatus());
                if (illustration.equals("1")) {
                  //   cardProjectLayoutController.setIllustrationImage();
                } else if (illustration.equals("2")) {
                    //cardProjectLayoutController.setIllustrationImage();

                }

                String status = Integer.toString(pro.getStatus());
                if (status.equals("1")) {
                    cardProjectLayoutController.setStatusLabel(Paint.valueOf("#17806D"));;
                    cardProjectLayoutController.setStatusLab("Done");
                } else if (status.equals("2")) {
                    cardProjectLayoutController.setStatusLabel(Paint.valueOf("#474c5c"));
                    cardProjectLayoutController.setStatusLab("New Project");

                }

                flowcontainer.getChildren().add(node) ;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refresh();
    }
}
