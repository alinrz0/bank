package bank;

import bank.User.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    private Client client;
    public MainPageController(Client client) {
        this.client=client;
    }
    @FXML
    private TextField amountTextFieldDeposit;

    @FXML
    private TextField amountTextFieldTransfer;

    @FXML
    private TextField amountTextFieldWithdraw;

    @FXML
    private JFXButton doneButtonDeposit;

    @FXML
    private JFXButton doneButtonTransfer;

    @FXML
    private JFXButton doneButtonWithdraw;

    @FXML
    private Label errorLabelDeposit;

    @FXML
    private Label errorLabelWithdraw;

    @FXML
    private JFXButton exitButton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextFieldTransfer;

    @FXML
    private JFXListView<?> listViewTransactions;

    @FXML
    private JFXButton logOutButton;

    @FXML
    private JFXButton transactionsButton;

    @FXML
    void pressDoneButtonDeposit(ActionEvent event) {
        try {
            float number = Float.parseFloat(amountTextFieldDeposit.getText());
            client.setMoney(client.getMoney()+Float.parseFloat(amountTextFieldDeposit.getText()));
            amountTextFieldDeposit.clear();
            createAlert("deposit done successfully!");
        } catch (NumberFormatException ex) {
            errorLabelDeposit.setText("Invalid input. Please enter an float");
        }
    }

    @FXML
    void pressDoneButtonTransfer(ActionEvent event) {

    }

    @FXML
    void pressDoneButtonWithdraw(ActionEvent event) {
        try {
            float number = Float.parseFloat(amountTextFieldWithdraw.getText());
            if(number>client.getMoney()){
                errorLabelWithdraw.setText("you do not have enough money!");
            }else {
                client.setMoney(client.getMoney()-Float.parseFloat(amountTextFieldWithdraw.getText()));
                amountTextFieldWithdraw.clear();
                createAlert("withdraw done successfully!");
            }
        } catch (NumberFormatException ex) {
            errorLabelWithdraw.setText("Invalid input. Please enter an float");
        }
    }

    @FXML
    void pressExitButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void pressLogOutButton(ActionEvent event) throws IOException {
        Stage oldStage = (Stage) logOutButton.getScene().getWindow();
        oldStage.close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Open.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    @FXML
    void pressTransactionsButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idLabel.setText(String.valueOf(client.getId()));
    }

    private void createAlert(String content){
        Dialog dialog = new Dialog();
        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setStyle("-fx-background-color: #1064b3");
        dialogPane.setGraphic(null);
        dialog.setContentText(content);
        ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType);
        Button okButton = (Button) dialog.getDialogPane().lookupButton(okButtonType);
        okButton.setAlignment(Pos.CENTER);
        dialog.showAndWait();

    }
}
