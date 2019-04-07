
	package it.polito.tdp.anagrammi.controller;
	import java.net.URL;
import java.util.ArrayList;
import java.util.List;
	import java.util.ResourceBundle;
	import java.util.Set;

	import it.polito.tdp.anagrammi.model.Model;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class AnagrammiController {

		Model model;
		
	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtParola"
	    private TextField txtParola; // Value injected by FXMLLoader

	    @FXML // fx:id="btnCalcola"
	    private Button btnCalcola; // Value injected by FXMLLoader

	    @FXML // fx:id="txtCorretti"
	    private TextArea txtCorretti; // Value injected by FXMLLoader

	    @FXML // fx:id="txtErrati"
	    private TextArea txtErrati; // Value injected by FXMLLoader

	    @FXML // fx:id="btnReset"
	    private Button btnReset; // Value injected by FXMLLoader

	    @FXML
	    void doCalcola(ActionEvent event) {
	    	
	    	txtCorretti.clear();
	    	txtErrati.clear();
	  
	    	// prendo la parola inserita dall'utente
	    		String parolaInserita = txtParola.getText();
	    		List<String> soluzioni = model.calcolaAnagrammi(parolaInserita);
	    		for (String anagramma: soluzioni) {
	    			System.out.println(anagramma);
	    			if (model.isCorrectModel(anagramma)) {
	    				txtCorretti.appendText(anagramma + "\n");
	    			}
	    			else {
	    				txtErrati.appendText(anagramma + "\n");
	    			}
	    		}
	    	
	    	
	    	
	    }

	    @FXML
	    void doReset(ActionEvent event) {
	    	txtCorretti.clear();
	    	txtErrati.clear();
	    	txtParola.clear();
	    }
	    
	    /**
		 * @param model the model to set
		 */

		

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	    }

		public void setModel(Model model) {
			this.model = model;
	}

}


