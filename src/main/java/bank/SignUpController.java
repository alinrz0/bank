package bank;

import bank.SQL.DB;
import bank.User.Client;
import bank.User.Gender;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

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

    private Gender getGender(String name){
        if(name.equals("M"))
            return Gender.MALE;
        else if (name.equals("F"))
            return Gender.FEMALE;
        else
            return Gender.OTHER;
    }


    @FXML
    void pressSingUpButton(ActionEvent event) throws IOException {
        if (firstnameTextField.getText().equals("") || lastnameTextField.getText().equals("") || usernameTextField.getText().equals("") || passwordField.getText().equals("") || phoneTextField.getText().equals("") || emailTextField.getText().equals("") || idTextField.getText().equals("") || repeatPasswordField.getText().equals("") || genderComboBox.getValue() == null || birthdayPicker.getValue() == null) {
            errorLabel.setText("please fill all item!");
        }else if(new DB().usernameExist(usernameTextField.getText())){
            errorLabel.setText("this username exist please choose another username!");
        }else if (!passwordField.getText().equals(repeatPasswordField.getText())) {
            errorLabel.setText("please fill the password correct!");
        } else {
            new DB().insertClient(passwordField.getText(), firstnameTextField.getText(), lastnameTextField.getText(), phoneTextField.getText(), emailTextField.getText(), usernameTextField.getText(), Date.valueOf(birthdayPicker.getValue()), genderComboBox.getValue(), idTextField.getText());
            Client client=new Client(firstnameTextField.getText(), lastnameTextField.getText(), emailTextField.getText(), phoneTextField.getText(),idTextField.getText(),0, getGender(genderComboBox.getValue()), Date.valueOf(birthdayPicker.getValue()),new DB().getClientId(usernameTextField.getText()),usernameTextField.getText(),passwordField.getText());
            Stage oldStage = (Stage) singUpButton.getScene().getWindow();
            oldStage.close();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Open.class.getResource("MainPage.fxml"));
            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {

                @Override
                public Object call(Class<?> cls) {
                    if (cls == MainPageController.class) {
                        return new MainPageController(client);
                    } else
                        try {
                            return cls.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                }

            });
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
    }

    @FXML
    void pressExitButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressLoginButton(ActionEvent event) throws IOException {
        Stage oldStage = (Stage) singUpButton.getScene().getWindow();
        oldStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Open.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderComboBox.getItems().addAll("Male", "Female", "Other");
    }
}
