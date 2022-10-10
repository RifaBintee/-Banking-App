package application;

import java.io.IOException;

import banking.InSufficientBalanceException;
import banking.InvalidAccountException;
import banking.MaxWithdawException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WithdrawController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField mytext1;
	@FXML
	private TextField mytext2;
	
	 public void Confirm(ActionEvent event) throws InvalidAccountException, InSufficientBalanceException, MaxWithdawException {

	        String an=mytext1.getText();
	        double wa=Double.parseDouble(mytext2.getText());
	        Main.bank.withdraw(an,wa);
	        Main.bank.saveData();
	    }
	
	 public void back(ActionEvent event) throws IOException {
		 
			root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
			 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			scene =new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	
	
	
}
