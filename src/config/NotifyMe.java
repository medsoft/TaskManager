package config;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * Created by macbookair on 16/02/2018.
 */
public class NotifyMe {
    Image staff = new Image("/pictures/logonotif.png");

   public void errorChampsNotify() {
       TrayNotification tray = new TrayNotification();
       tray.setTitle("Informations  Task ");
       tray.setTrayIcon(staff);
       tray.setImage(staff);
       tray.setMessage("Veuillez remplir toutes les informations ");
       tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
       tray.setAnimationType(AnimationType.SLIDE);
       tray.showAndDismiss(Duration.seconds(5));
       tray.showAndWait();
   }

   public void access () {
       TrayNotification tray = new TrayNotification();
       tray.setImage(staff);
       tray.setTitle("Informations  Task");
       tray.setMessage("Vous pouvez acceder a votre  compte");
       tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
       tray.setAnimationType(AnimationType.POPUP);
       tray.showAndDismiss(Duration.seconds(3));
   }

   public  void mauvaisIdentifiants () {

       TrayNotification tray = new TrayNotification();
       tray.setImage(staff);
       tray.setTitle("Informations  Task");
       tray.setMessage("Vos identifiants ne coresspondent pas ");
       tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
       tray.setAnimationType(AnimationType.SLIDE);
       tray.showAndDismiss(Duration.seconds(3));

   }
    public  void whenUserIsAdded () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations  Task ");
        tray.setMessage(" Un nouvel entreprise vient d'etre ajouter ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));
    }
    public  void whenClientrIsAdded () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle(" Informations  Task");
        tray.setMessage(" Un nouveau  client vient d'etre ajouter ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));
    }
    public  void projectAddedSuccessfully  () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations  Task ");
        tray.setMessage(" Un nouveau  projet  vient d'etre creer  ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }
    public  void taskAddSuccessfully () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage(" Un nouvelle   tache  vient d'etre ajouter ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));

    }
    public void showPopupNotification () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Task ");
        tray.setMessage("Merci de  remplir tous les champs  ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

    public void showPopupNotificationWhenSoldeIsCredit () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage("La mission a bien �t� attribue ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

    public void showPopupNotificationWhenSoldeIsCredi () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage("La mission a �t� refus�   ");
        tray.setRectangleFill(Paint.valueOf("#2d4f6c"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

}
