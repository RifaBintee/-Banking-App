package application;
import java.io.IOException;

import banking.InvalidAccountException;
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
public class depositController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField mytext1;
	@FXML
	private TextField mytext2;
	
	public void deposit(ActionEvent event) throws IOException, InvalidAccountException {
		 
		 String accNum = mytext1.getText(); 
		
	    double amount= Double.parseDouble(mytext2.getText());

	//    try {
			Main.bank.deposit(accNum, amount);
		//} catch (InvalidAccountException e) {
			
			//e.printStackTrace();
		//}
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

