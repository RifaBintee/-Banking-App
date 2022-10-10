package application;
import java.io.IOException;

import banking.InSufficientBalanceException;
import banking.InvalidAccountException;
import banking.MaxWithdawException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;



public class TransferController {
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField mytext1;
	@FXML
	private TextField mytext2;
	@FXML
	private TextField mytext3;
	
	public void Confirm(ActionEvent event)  {
		 
		 String accNum = mytext1.getText(); 
		String  accNum2 = mytext2.getText();
	    double 	transactionbalance= Double.parseDouble(mytext3.getText());
	    
	    try {
			Main.bank.transfer(accNum, accNum2, transactionbalance);
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InSufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MaxWithdawException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		Main.bank.saveData();
		
		mytext1.clear();
		mytext2.clear();
		mytext3.clear();
		
}
	
	public void back(ActionEvent event) throws IOException {
		 
		root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
