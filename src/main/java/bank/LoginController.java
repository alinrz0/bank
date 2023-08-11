package bank;

import bank.SQL.DB;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

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
    void pressLoginButton(ActionEvent event) throws IOException {
        if(usernameTextField.getText().equals("")||passwordField.getText().equals("")){
            errorLabel.setText("please fill the items!");
        }else if(!new DB().checkClientInformation(usernameTextField.getText(),passwordField.getText())){
            errorLabel.setText("information are incorrect!");
        }else {
            Stage oldStage=(Stage) loginButton.getScene().getWindow();
            oldStage.close();
            Stage stage=new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Open.class.getResource("MainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
    }

    @FXML
    void pressSingUpButton(ActionEvent event) throws IOException {
        Stage oldStage=(Stage) singUpButton.getScene().getWindow();
        oldStage.close();
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Open.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    void pressExitButton(ActionEvent event) {
        System.exit(0);
    }
}
