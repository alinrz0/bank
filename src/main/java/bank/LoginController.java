package bank;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private RadioButton clientRadioButton;

    @FXML
    private Label errorLabel;

    @FXML
    private JFXButton loginButton;

    @FXML
    private RadioButton managerRadioButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private JFXButton singUpButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    void pressLoginButton(ActionEvent event) {

    }

    @FXML
    void pressSingUpButton(ActionEvent event) {

    }

}
