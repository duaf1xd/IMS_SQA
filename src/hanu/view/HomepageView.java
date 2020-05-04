//package hanu.view;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HomepageView extends Stage {
//
//    public HomepageView init() throws IOException {
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/landing.fxml"));
//        Scene scene = new Scene(root);
//        setScene(scene);
//        return this;
//    }
//
//    public void createLoginView(ActionEvent actionEvent) throws IOException {
//        Stage activeWindow = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/login.fxml"));
//        Scene scene = new LoginView(root);
//        activeWindow.setScene(scene);
//        System.out.println("navigated!");
//    }
//
//}
