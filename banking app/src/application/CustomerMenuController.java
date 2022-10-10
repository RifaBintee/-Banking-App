package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import banking.BankAccount;
import banking.DataHandler;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerMenuController implements Initializable{
	
	Parent root;
	Stage stage;
	Scene scene;

	@FXML
	public ComboBox<String> combobox;
	@FXML
	Label lbl1;
	@FXML
	Label lbl2;
	@FXML
	TextField tf1;
	@FXML
	TextField tf2;
	@FXML

	public ListView<String> listView;
	
	ObservableList<String> list = FXCollections.observableArrayList("Summary of one of your account", "Transaction of one of your account", "Display All");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		combobox.setItems(list);
		
	}
	
	public void selectAction(ActionEvent event) {
		String comboValue = combobox.getValue();
		
		switch(comboValue) {
		case "Summary of one of your account": 

			tf1.setEditable(true);
			break;
			
		case "Transaction of one of your account": 

			tf1.setEditable(true);
			break;
			
		case "Display All":

			tf1.setEditable(false);
			break;
		}
	}
	
	public void back(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	public void submit(ActionEvent event) throws IOException, ClassNotFoundException {
		listView.getItems().clear();
		String comboValue = combobox.getValue();
		String accNum, nid;
		accNum = tf1.getText();
		nid = tf2.getText();
		
		if(comboValue.equals("Display All")) {
			ObservableList<BankAccount> list2 = FXCollections.observableArrayList(Main.bank.findAccounts(nid));
			for(int i=0; i < list2.size();i++) {
				listView.getItems().addAll(list2.get(i).toString());
			}
		}
		
		else if(comboValue.equals("Summary of one of your account")) {
			try {
				ObservableList<BankAccount> list3 = FXCollections.observableArrayList(Main.bank.findAccount(nid, accNum));
				for(int i=0; i < list3.size();i++) {
					listView.getItems().addAll(list3.get(i).toString());
				}
			} catch (InvalidAccountException e) {
				listView.getItems().addAll("Sorry Account "+accNum+" not found!");
			}	
		}
		
		else if(comboValue.equals("Transaction of one of your account")) {
			try {
				ObservableList<Transaction> list4 = FXCollections.observableArrayList(Main.bank.getAccTransactions(nid, accNum));
				for(int i=0; i < list4.size();i++) {
					listView.getItems().addAll(list4.get(i).toString());
				}
			} catch (InvalidAccountException e) {
				listView.getItems().addAll("Sorry Account "+accNum+" not found!");
			}	
		}
		
		tf1.clear();
		tf2.clear();
	}	
}