package hanu.view;

import hanu.controllers.AccountController;
import hanu.model.domain.Account;
import hanu.model.domain.Role;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardView {
    AccountController ac= new AccountController();

    @FXML
    public Label userCountLabel;

    @FXML
    public TableView<Account> userTable;
    @FXML
    public TableColumn<Account, Integer> idColumn;
    @FXML
    public TableColumn<Account, String> usernameColumn;
    @FXML
    public TableColumn<Account, String> passwordColumn;
    @FXML
    public TableColumn<Account, Role> roleColumn;

//    private final List<Account> data =
//            FXCollections.observableArrayList(
//                    new Account(1,"Jacob", "Smith", Role.Admin),
//                    new Account(2,"Isabella", "Johnson", Role.InventoryManager),
//                    new Account(3,"Ethan", "Williams", Role.Salesperson)
//            );



    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Account, Integer>("id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("password"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<Account, Role>("role"));
        userTable.getItems().setAll(parseUserList());

    }

    @FXML
    public void showCreateAccountView(ActionEvent event) throws Exception{
        CreateAccountPopup pop= new CreateAccountPopup();
        pop.display();
    }

    private ObservableList<Account> parseUserList() {
        userCountLabel.setText(Integer.toString(ac.findAll().size()));
        return FXCollections.observableArrayList(ac.findAll());

    }
}


