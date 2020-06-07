package sample;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label appName;

    @FXML
    private Label description;

    @FXML
    private Pane spinnerPane;
    @FXML
    private Label logoLabel;


    Main main ;
    Stage stage ;
    public  void  main (Stage stage , Main main)
    {
        this.main = main ;
        this.stage = stage  ;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TranslateTransition translateTransition =new TranslateTransition(Duration.seconds(0.5),logoLabel);
        translateTransition.setByY(700);
        translateTransition.play();

        TranslateTransition translateTransition0 =new TranslateTransition(Duration.seconds(0.5),appName);
        translateTransition0.setByY(700);
        translateTransition0.play();

        TranslateTransition translateTransition00 =new TranslateTransition(Duration.seconds(0.5),description);
        translateTransition00.setByY(700);
        translateTransition00.play();


        translateTransition.setOnFinished(event ->{
            TranslateTransition translateTransition1 =new TranslateTransition(Duration.seconds(1),logoLabel);
            translateTransition1.setByY(-700);
            translateTransition1.play();

            translateTransition1.setOnFinished(event1 -> {


                appName.setVisible(true);

                TranslateTransition translateTransition11 =new TranslateTransition(Duration.seconds(1),appName);
                translateTransition11.setByY(-700);
                translateTransition11.play();

                translateTransition11.setOnFinished(event2 -> {

                    description.setVisible(true);
                    TranslateTransition translateTransition111 =new TranslateTransition(Duration.seconds(1),description);
                    translateTransition111.setByY(-700);
                    translateTransition111.play();

                    translateTransition111.setOnFinished(event3 -> {
                        spinnerPane.setVisible(true);

                        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),spinnerPane);
                        fadeTransition.setFromValue(0);
                        fadeTransition.setToValue(1);
                        fadeTransition.play();

                        fadeTransition.setOnFinished(event4 -> {

                                    FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(4),rootPane);
                                    fadeTransition1.setFromValue(1);
                                    fadeTransition1.setToValue(0.1);
                                    fadeTransition1.play();

                                    fadeTransition1.setOnFinished(event5 -> {
                                        main.closeStage();
                                        System.out.println("------- splash screen is closed --------");
                                        try {
                                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../controllers/Login.fxml"));
                                            Parent root1 = (Parent) fxmlLoader.load();
                                            Stage stage = new Stage();
                                            stage.initStyle(StageStyle.UNDECORATED);
                                            stage.setScene(new Scene(root1));
                                            stage.show();
                                            //((Node) (event.getSource())).getScene().getWindow().hide();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    });



                                }
                        );

                    });

                });
            });

        });
    }


}
