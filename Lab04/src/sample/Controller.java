package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Text actiontarget;
    @FXML
    private TextField UserName;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        System.out.println("Click");
        System.out.println(UserName.getText());
        System.out.println(nameField.getText());
        System.out.println(emailField.getText());
        String phoneNumber = phoneField.getText();
        String regex = "^\\d{3}-\\d{3}-\\d{4}";
        if (phoneNumber.matches(regex)){
            System.out.println(phoneNumber);
        }else {
            System.out.println("Please enter phone number in format 000-000-0000");
        }
        actiontarget.setText("Sign in button pressed");

    }
}
