package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Ricerca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Ricerca ricerca;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolaAnagramma;

    @FXML
    private TextArea txtOK;

    @FXML
    private TextArea txtNOT;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
    	//pulisco il campo di lavoro per non "sommare" le parole
    	txtOK.clear();
    	txtNOT.clear();
     
    	//leggo la parola
    	String parola = txtParola.getText();
    	
    	//CONTROLLO INSERIMENTO PAROLA
    	
    	if (!this.ricerca.controllaParola(parola)) {
    		txtOK.setText("NON HAI INSERITO UNA PAROLA");
    		txtParola.clear();
    		return;
    	}
    	
    	//effettuo il metodo anagrammi
    	List<String> parole = this.ricerca.anagrammi(parola);
    	
    	List<String> ok = new LinkedList<String>();
    	List<String> not = new LinkedList<String>();
    	// in questo modo studio se sono corrette o meno e stampo
    	//voglio provare però a inserire le stringhe in una lista per non stampare quelle già presenti
    	
    	for (String a : parole) {
			if(this.ricerca.isCorrect(a)) {
			
				if(!ok.contains(a))
				ok.add(a);
				//txtOK.appendText(a+"\n");
			}
			else {
				if (!not.contains(a))
				not.add(a);
				//txtNOT.appendText(a+"\n");
			}
		}

    	txtOK.setText(ok.toString());
    	txtNOT.setText(not.toString());

    }

    @FXML
    void doReset(ActionEvent event) {

    	txtParola.clear();
    	txtOK.clear();
    	txtNOT.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagramma != null : "fx:id=\"btnCalcolaAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOK != null : "fx:id=\"txtOK\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNOT != null : "fx:id=\"txtNOT\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        
        ricerca = new Ricerca();

    }
    
    public void setRicerca(Ricerca ricerca) {
    	this.ricerca=ricerca;
    	}
}
