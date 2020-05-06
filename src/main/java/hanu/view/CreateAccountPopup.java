package hanu.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;


public class CreateAccountPopup {


    public void display() throws Exception
    {
        Stage popupwindow=new Stage();

        FXMLLoader popupLoader = new FXMLLoader(getClass().getResource("/newaccountpopup.fxml"));
        Parent firstPane= popupLoader.load();
        Scene firstScene= new Scene(firstPane, 400, 800);

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("This is a pop up window");


        popupwindow.setScene(firstScene);

        popupwindow.showAndWait();

    }

}