package Sample;

import Utils.CommonUtils;
import Utils.GenEntityMySql;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.Scene;

import java.awt.peer.DialogPeer;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program extends Application
{
    private Stage stage;
    private final double MINIMUM_WIDTH=1000;
    private final double MINIMUM_HEIGHT=250.0;
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
//            GenEntityMySql genEntityMySql=new GenEntityMySql();
//            genEntityMySql.StartGenEntity();
            stage = primaryStage;
            stage.setTitle("Cash System");
            stage.setMinWidth(MINIMUM_WIDTH);
            stage.setMinHeight(MINIMUM_HEIGHT);
            gotoLogin();//display the login page
            System.out.println(CommonUtils.getLocalMac(InetAddress.getLocalHost()));
            System.out.println(CommonUtils.getLocalMacByHutool(InetAddress.getLocalHost()));
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void gotoLogin()//jump to the login page.
    {
        try
        {
            LoginController loginController = (LoginController)replaceSceneContent("Login.fxml");
            loginController.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoCashPage()
    {
        try
        {
            CashPageController cashPageController = (CashPageController)replaceSceneContent("CashPage.fxml");
            cashPageController.setApp(this);
        } catch (Exception e) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void gotoDialog(String title, String headerText, String contentText)
    {
        DialogPane dialogPane = new DialogPane();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(dialogPane,650,450);
        dialogStage.setScene(scene);
    }


    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Program.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Program.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 650, 450);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}
