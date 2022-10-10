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

public class StudentAccountController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField mytext1;
	@FXML
	private TextField mytext2;
	@FXML
	private TextField mytext3;
	@FXML
	private TextField mytext4;
	@FXML
	private TextField mytext5;
	@FXML
	private Label lbl1;
	
	public void submit(ActionEvent event) throws IOException {
		 
		 String name = mytext1.getText(); 
		String  nid = mytext2.getText();
	    double balance= Double.parseDouble(mytext3.getText());

		String studentId = mytext4.getText(); 
		String  InstitutionName = mytext5.getText();

	    Main.bank.addAccount(name, nid, balance, InstitutionName, studentId);
	    String acc = Main.bank.addAccount(name, nid, balance,InstitutionName, studentId);
		lbl1.setText(acc);
		Main.bank.saveData();
		mytext1.clear();
		mytext2.clear();
		mytext3.clear();
		mytext4.clear();
		mytext5.clear();
}
	public void back(ActionEvent event) throws IOException {
		 
		root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene =new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}

