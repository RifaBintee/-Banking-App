package application;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import banking.BankAccount;
import banking.InvalidAccountException;
import banking.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewController implements Initializable {
	static String accNum, type, nid;
	Parent root;
	Stage stage;
	Scene scene;

	@FXML
	 ComboBox<String> combobox;
	@FXML
	TextField tf1;
	@FXML
	TextField tf2;
	@FXML
	TextField tf3;
	@FXML
	 ListView<String> view;
	
	ObservableList<String> list = FXCollections.observableArrayList("Summery of one of your account", "Transaction of one of your account", "List of specific account type", "Display All");
	
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		combobox.setItems(list);
//	}	
//	
	public void select(ActionEvent event) {
		String comboValue = combobox.getValue();
		
		switch(comboValue) {
		case "Summary of one of your account": 

			tf1.setEditable(true);
			tf2.setEditable(false);
			tf3.setEditable(false);
			break;
			
		case "Transaction of one of your account": 

			tf1.setEditable(true);
			tf2.setEditable(false);
			tf3.setEditable(true);
			break;
			
		case "List of specific account type":
			tf1.setEditable(false);
			tf2.setEditable(true);
			tf3.setEditable(false);
			break;
		case "Display All":

			tf1.setEditable(false);
			tf2.setEditable(false);
			tf3.setEditable(false);
			break;
		}
	}
	
	public void back(ActionEvent action) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("EmployeeMenu.fxml"));
	    Stage stage = (Stage)((Node)action.getSource()).getScene().getWindow();
	    Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
    public void exit(ActionEvent action) {
		System.exit(0);
	}
	
	public void submit(ActionEvent event) throws IOException, ClassNotFoundException {
		view.getItems().clear();
		String comboValue = combobox.getValue();
		accNum = tf1.getText();
		type = tf2.getText();
		nid = tf3.getText();
		
		if(comboValue.equals("Display All")) {
			ObservableList<BankAccount> list2 = FXCollections.observableArrayList(Main.bank.getAccounts());
			for(int i=0; i < list2.size();i++) {
				view.getItems().addAll(list2.get(i).toString());
			}
		}
		
		else if(comboValue.equals("Summary of one of your account")) {
			try {
				ObservableList<BankAccount> list3 = FXCollections.observableArrayList(Main.bank.findAccount(accNum));
				for(int i=0; i < list3.size();i++) {
					view.getItems().addAll(list3.get(i).toString());
				}
			} catch (InvalidAccountException e) {
				view.getItems().addAll("Sorry Account "+accNum+" not found!");
			}	
		}
		
		else if(comboValue.equals("Transaction of one of your account")) {
			try {
				ObservableList<Transaction> list4 = FXCollections.observableArrayList(Main.bank.getAccTransactions(nid, accNum));
				for(int i=0; i < list4.size();i++) {
					view.getItems().addAll(list4.get(i).toString());
				}
			} catch (InvalidAccountException e) {
				view.getItems().addAll("Sorry Account "+accNum+" not found!");
			}	
		}
		
		else {
			ObservableList<BankAccount> list3 = FXCollections.observableArrayList(Main.bank.getAccounts(type));
			for(int i=0; i < list3.size();i++) {
				view.getItems().addAll(list3.get(i).toString());
			}	
		}
		
		tf1.clear();
		tf2.clear();
		tf3.clear();
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		combobox.setItems(list);
	}

}
