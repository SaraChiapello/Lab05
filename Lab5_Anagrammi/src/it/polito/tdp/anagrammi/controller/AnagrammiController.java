/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	Model model=new Model();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultatiCorretti"
    private TextArea txtRisultatiCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultatiErrati"
    private TextArea txtRisultatiErrati; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
		txtRisultatiCorretti.clear();
		txtRisultatiErrati.clear();
		try {
		if (txtParola.getText().isEmpty()) {
			txtRisultatiCorretti.appendText("Nessun risultato: parola inesistente");
			return;
		}
		
		Set<String> s=model.calcolaAnagrammi(txtParola.getText());
		
		for(String c:s) {
			if(model.isCorrect(c))
				txtRisultatiCorretti.appendText(c+"\n");
			else
				txtRisultatiErrati.appendText(c+"\n");
		}
		}catch (RuntimeException e) {
			txtRisultatiCorretti.setText("ERRORE");
		} 
    }
    
    /*
     *     	txtRisultato.clear();

		try {
							
			int matricola = Integer.parseInt(txtMatricola.getText());
			Studente s= model.getStudente(matricola);
			
			if (s == null) {
				txtRisultato.appendText("Nessun risultato: matricola inesistente");
				return;
			}
			if(model.isIscritto(s, corso))
				txtRisultato.appendText("già iscritto");
			else {
				if (!model.iscrivi(s, corso)) {
					txtRisultato.appendText("Errore durante l'iscrizione al corso");
					return;
				} else {
					txtRisultato.appendText("Studente iscritto al corso!");
				}
			}
		} catch (NumberFormatException e) {
			txtRisultato.setText("Inserire una matricola nel formato corretto.");
		} catch (RuntimeException e) {
			txtRisultato.setText("ERRORE DI CONNESSIONE AL DATABASE!");
		} 
*/
    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtRisultatiCorretti.clear();
    	txtRisultatiErrati.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRisultatiCorretti != null : "fx:id=\"txtRisultatiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtRisultatiErrati != null : "fx:id=\"txtRisultatiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
