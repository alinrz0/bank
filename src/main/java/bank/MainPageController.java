package bank;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainPageController {

    @FXML
    private TextField amountTextFieldDeposite;

    @FXML
    private TextField amountTextFieldTransfer;

    @FXML
    private TextField amountTextFieldWithdraw;

    @FXML
    private JFXButton doneButtonDeposit;

    @FXML
    private JFXButton doneButtonTransfer;

    @FXML
    private JFXButton doneButtonWithraw;

    @FXML
    private Label errorLabelDeposite;

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

    }

    @FXML
    void pressDoneButtonTransfer(ActionEvent event) {

    }

    @FXML
    void pressDoneButtonWithdrwa(ActionEvent event) {

    }

    @FXML
    void pressExitButton(ActionEvent event) {

    }

    @FXML
    void pressLogOutButton(ActionEvent event) {

    }

    @FXML
    void pressTransactionsButton(ActionEvent event) {

    }

}
