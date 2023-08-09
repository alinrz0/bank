package bank;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private JFXComboBox<String> genderComboBox;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private PasswordField repeatPasswordField;

    @FXML
    private JFXButton singUpButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    void pressSingUpButton(ActionEvent event) {

    }

}
