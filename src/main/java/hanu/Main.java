package hanu;

import hanu.view.HomepageView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        System.out.println(Main.class.getResource("/landing.fxml"));
//        System.out.println(Main.class.getResource("../resources/landing.fxml"));
//        System.out.println(Main.class.getResource("landing.fxml"));
//        System.out.println(Main.class.getResource("landing.fxml"));
//        System.out.println(Main.class.getResource("/landing.fxml"));
//        System.out.println(Main.class.getResource("landing.fxml"));
//        System.out.println(Main.class.getResource("/java/resources/landing.fxml"));
//        System.out.println(Main.class.getResource("/landing.fxml"));
//        System.out.println(Main.class.getResource("/src/main/java/resources/landing.fxml"));
//        System.out.println(Main.class.getResource("C:\\Users\\duaf1xd\\IdeaProjects\\ims_sqa\\src\\main\\java\\resources\\landing.fxml"));
//        System.out.println(Main.class.getResource("C:/Users/duaf1xd/IdeaProjects/ims_sqa/src/main/java/resources/landing.fxml"));

        FXMLLoader homepageLoader = new FXMLLoader(getClass().getResource("/landing.fxml"));
        Parent firstPane= homepageLoader.load();
        primaryStage.setTitle("Inventory Management System");
        Scene firstScene= new Scene(firstPane, 800, 600);


        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 800, 600);

        HomepageView landingController= (HomepageView) homepageLoader.getController();
        landingController.setLoginPage(secondScene);

        primaryStage.setScene(firstScene);
        primaryStage.show();
//        new HomepageView().init().show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
