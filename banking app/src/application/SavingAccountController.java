package application;

import java.io.IOException;

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

public class SavingAccountController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Label mylabel;
	@FXML
	private TextField mytext1;
	@FXML
	private TextField mytext2;
	@FXML
	private TextField mytext3;
	@FXML
	private TextField mytext4;
	@FXML
	private Label lbl1;
	@FXML
	private Button myButton;
	
	public void submit(ActionEvent event) throws IOException {
		 String name = mytext1.getText(); 
		String  nid = mytext3.getText();
	    double 	balance= Double.parseDouble(mytext2.getText());
	    double 	maxwithdraw= Double.parseDouble(mytext4.getText());
	    Main.bank.addAccount(name, nid, balance, maxwithdraw);
	    String acc = Main.bank.addAccount(name, nid, balance,maxwithdraw);
		lbl1.setText(acc);
		Main.bank.saveData();
		mytext1.clear();
		mytext2.clear();
		mytext3.clear();
		mytext4.clear();
 }
	
	public void Back(ActionEvent event) throws IOException {
		 
		root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}