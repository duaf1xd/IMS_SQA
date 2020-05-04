package hanu;

import hanu.controllers.LandingController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("../resources/landing.fxml"));
        Parent firstPane= firstPaneLoader.load();
        primaryStage.setTitle("Hello World");
        Scene firstScene= new Scene(firstPane, 800, 600);


        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("../resources/login.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 800, 600);

        LandingController landingController= (LandingController) firstPaneLoader.getController();
        landingController.setLoginPage(secondScene);

        primaryStage.setScene(firstScene);
        primaryStage.show();
//        new HomepageView().init().show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
