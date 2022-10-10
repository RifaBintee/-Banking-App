package application;

import java.io.IOException;

import javafx.scene.Parent;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class EmployeeMenuController {
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextArea text1;
	@FXML
	private TextArea text2;
	@FXML
	private TextArea text3;
	@FXML
	private TextArea text4;
	@FXML
	private TextArea text5;


public void CreatAccount(ActionEvent event) throws IOException{
	
	Parent root =  FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	
	
	}

public void DepositeMoney(ActionEvent event) throws IOException{

	Parent root =  FXMLLoader.load(getClass().getResource("Deposit.fxml"));
	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	
	
	}
public void back1(ActionEvent event) throws IOException {
	 
	root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	 stage=(Stage)((Node)event.getSource()).getScene().getWindow();
	scene =new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void toView(ActionEvent event) throws IOException{
	
	root = FXMLLoader.load(getClass().getResource("Display.fxml"));
	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}

public void withdraw(ActionEvent event) throws IOException{
	
	Parent root =  FXMLLoader.load(getClass().getResource("withdraw.fxml"));
	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	
	
	}
public void Transfer(ActionEvent event) throws IOException{
	
	Parent root =  FXMLLoader.load(getClass().getResource("Transfer.fxml"));
	stage =(Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	
	
	}

}
