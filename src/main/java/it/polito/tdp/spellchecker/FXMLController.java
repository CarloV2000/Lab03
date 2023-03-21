/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Correttore;
import it.polito.tdp.spellchecker.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	private Correttore model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLingua;

    @FXML
    private Label txtNumeroErrori;

    @FXML
    private TextArea txtParoleSbagliate;

    @FXML
    private Label txtTempoSpellCheck;

    @FXML
    private TextArea txtTestoInserito;

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtParoleSbagliate.clear();
    	this.txtTestoInserito.clear();
    	this.txtNumeroErrori.setText("");
    	this.txtTempoSpellCheck.setText("");
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	String testoInserito = this.txtTestoInserito.getText();
    	String lingua = cmbLingua.getValue();
    	model.loadDictionary(lingua);
    	this.txtParoleSbagliate.setText(model.spellCheckText(testoInserito).toString());
    }

    @FXML
    void initialize() {
        assert cmbLingua != null : "fx:id=\"cmbLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumeroErrori != null : "fx:id=\"txtNumeroErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParoleSbagliate != null : "fx:id=\"txtParoleSbagliate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempoSpellCheck != null : "fx:id=\"txtTempoSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTestoInserito != null : "fx:id=\"txtTestoInserito\" was not injected: check your FXML file 'Scene.fxml'.";
        this.cmbLingua.getItems().add("English");
        this.cmbLingua.getItems().add("Italiano");
    }

	public void setModel(Correttore model) {
		this.model = model;
	}

}


