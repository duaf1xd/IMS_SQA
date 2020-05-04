package hanu.controllers;

import hanu.db.AccountRepositoryImpl;
import hanu.db.connect;
import hanu.model.domain.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;

public class LoginController {
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;

    @FXML
    private void attemptLogin(ActionEvent event) {
        Connection connection = connect.getConnection();
        AccountRepositoryImpl ari= new AccountRepositoryImpl();

        String username= usernameField.getText();
        String password= passwordField.getText();

        System.out.println("Executed login");
        System.out.println(username + " " + password);

        Account account= ari.findByUsernameAndPassword(username, password);
        if (account!=null){
            System.out.println(account.toString());
            System.out.println("Login success");
        }
        else{
            System.out.println("Login failed");
        }
    }
}
