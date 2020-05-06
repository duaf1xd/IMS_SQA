package hanu.view;

import hanu.controllers.AccountController;
import hanu.db.connect;
import hanu.model.domain.Account;
import hanu.model.domain.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;

public class LoginView {
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;
    private Scene dashboardPage;

    Connection connection = connect.getConnection();
    AccountController ari= new AccountController();

    @FXML
    private void createDashboardView(ActionEvent event) throws Exception{
        String username= usernameField.getText();
        String password= passwordField.getText();

        System.out.println("Executed login");
        System.out.println(username + " " + password);

        Account account= ari.findByUsernameAndPassword(username, password);
        if (account!=null){
            if(account.getRole()== Role.Admin){
                FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("/admindashboardview.fxml"));
                Parent secondPane = secondPageLoader.load();
                Scene secondScene = new Scene(secondPane, 1200, 800);
                setDashboardPage(secondScene);
                toDashboardPage(event);
            }
        }
        else{
            System.out.println("Login failed");
        }
    }


    @FXML
    public void setDashboardPage(Scene scene) {
        dashboardPage = scene;
    }

    @FXML
    private void toDashboardPage(ActionEvent event) {
        //label.setText("Hello World!");
        System.out.println("Switch to dashboard page");
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(dashboardPage);
    }
}
