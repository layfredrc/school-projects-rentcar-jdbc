package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * The type Main controller.
 */
public class MainController {
      @FXML
    private TextField emailTxt;
    @FXML
    private PasswordField passwordTxt;
    @FXML
    private Button loginBtn;

    /**
     * Gets login.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void getLogin(ActionEvent event) throws IOException {
       /* String email = emailTxt.getText();
        String password = passwordTxt.getText();
        String params = email + " " + password;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(params);

        alert.showAndWait();
        if (email.equals("") || password.equals("")) {
        }*/
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        Stage window = (Stage) loginBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }




}
