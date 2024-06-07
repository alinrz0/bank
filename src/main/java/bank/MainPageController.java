package bank;

import bank.SQL.DB;
import bank.User.Client;
import bank.transaction.TransactionType;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    private Client client;

    private DB db=new DB();
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
    private Label errorLabelTransfer;

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
            client.setMoney(client.getMoney()+number);
            amountTextFieldDeposit.clear();
            db.setMoney(client);
            db.createTransaction(number, TransactionType.DEPOSIT,client.getId());
            createAlert("deposit done successfully!");
        } catch (NumberFormatException ex) {
            errorLabelDeposit.setText("Invalid input. Please enter an float");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void pressDoneButtonTransfer(ActionEvent event) {
        try {
            float number = Float.parseFloat(amountTextFieldTransfer.getText());
            if(number>client.getMoney()){
                errorLabelTransfer.setText("you do not have enough money!");
            }else if(!db.getAllID().contains(idTextFieldTransfer.getText())){
                errorLabelTransfer.setText("this id not exists!");
            }else {
                client.setMoney(client.getMoney()-number);
                db.setMoney(client);
                db.setMoney(new Client(Integer.parseInt(idTextFieldTransfer.getText()),number+db.getMoney(Integer.parseInt(idTextFieldTransfer.getText()))));
                db.createTransaction(number, TransactionType.TRANSFER,client.getId(), Integer.parseInt(idTextFieldTransfer.getText()));
                amountTextFieldTransfer.clear();
                createAlert("transfer done successfully!");
            }
        } catch (NumberFormatException ex) {
            errorLabelTransfer.setText("Invalid input. Please enter an float");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                db.setMoney(client);
                db.createTransaction(number, TransactionType.WITHDRAW,client.getId());
                createAlert("withdraw done successfully!");
            }
        } catch (NumberFormatException ex) {
            errorLabelWithdraw.setText("Invalid input. Please enter an float");
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
