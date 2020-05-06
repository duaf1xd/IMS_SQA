package hanu.view;

import hanu.controllers.AccountController;
import hanu.model.domain.Account;
import hanu.model.domain.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountView {
//    private Scene dashboardPage;
    @FXML public TextField usernameField;
    @FXML public PasswordField passwordField;
    @FXML public PasswordField confirmPasswordField;
    @FXML public ChoiceBox roleChoiceBox;
    @FXML public Label statusLabel;
    AccountController ac= new AccountController();


    public void attemptCreateAccount(ActionEvent actionEvent) throws Exception{
        String username= usernameField.getText();
        String password= passwordField.getText();
        String confirmPassword= confirmPasswordField.getText();
        String role= (String)roleChoiceBox.getValue();

        System.out.println(username);
        System.out.println(password);
        System.out.println(confirmPassword);
        System.out.println(role);

        if(validateNewAccount(username, password, confirmPassword, role).equals("OK")){
            Account account= new Account(username, password, Role.valueOf(role));
            if(ac.add(account)){
                statusLabel.setText("Added account successfully");
                LoginView lv= new LoginView();
                lv.createDashboardView(actionEvent);

//                AdminDashboardView adw= new AdminDashboardView();
//                FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("/admindashboardview.fxml"));
//                Parent secondPane = secondPageLoader.load();
//                Scene secondScene = new Scene(secondPane, 1200, 800);
//                setDashboardPage(secondScene);
//                toDashboardPage(actionEvent);
            }
            else statusLabel.setText("Failed to add account to database");

        }
        else statusLabel.setText(validateNewAccount(username, password, confirmPassword, role));
    }

    private String validateNewAccount(String username, String password, String confirmPassword, String role)
    {
        if(username.length()<4){
            return "Username must be at least 4 characters";
        }
        else if(password.length()<4){
            return "Password must be at least 4 characters";
        }
        else if(!password.equals(confirmPassword)){
            return "Password and repeated password does not match";
        }
        else if(!role.equals("Admin")
                &&!role.equals("InventoryManager")
                &&!role.equals("Salesperson")){
            return "Impressive. How did you even mismatch the role?";
        }
        else return "OK";
    }

//    @FXML
//    public void setDashboardPage(Scene scene) {
//        dashboardPage = scene;
//    }
//
//    @FXML
//    private void toDashboardPage(ActionEvent event) {
//        //label.setText("Hello World!");
//        System.out.println("Switch to dashboard page");
//        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        primaryStage.setScene(dashboardPage);
//    }
}
