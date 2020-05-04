//package hanu.view;
//
//import deprecated.AccountRepositoryImpl;
//import hanu.db.connect;
//import hanu.model.domain.Account;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.sql.Connection;
//
//public class LoginView extends Scene {
//
//
//
//    public LoginView(Parent root) {
//        super(root);
//    }
//
////    public LoginView() {
////        super();
////    }
////
////    public LoginView init() throws IOException {
////        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/login.fxml"));
////
////        return this;
////    }
//
////    @FXML
////    TextField usernameField;
////    @FXML
////    TextField passwordField;
////
////    @FXML
////    private void attemptLogin(ActionEvent event) {
////        Connection connection = connect.getConnection();
////        AccountRepositoryImpl ari= new AccountRepositoryImpl();
////
////        String username= usernameField.getText();
////        String password= passwordField.getText();
////
////        System.out.println("Executed login");
////        System.out.println(username + " " + password);
////
////        Account account= ari.findByUsernameAndPassword(username, password);
////        if (account!=null){
////            System.out.println(account.toString());
////            System.out.println("Login success");
////        }
////        else{
////            System.out.println("Login failed");
////        }
////    }
////
////    public void createDashboardView(ActionEvent actionEvent) throws IOException {
////        Stage activeWindow = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
////        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("resources/admindashboardview.fxml"));
////        Scene scene = new AdminDashboardView(root);
////        activeWindow.setScene(scene);
////        System.out.println("navigated!");
////    }
//
//
//}
