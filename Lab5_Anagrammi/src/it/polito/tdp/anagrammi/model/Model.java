package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDB;
import javafx.scene.chart.Chart;



public class Model {
	ParolaDB PDB;
	public Model() {
		PDB=new ParolaDB();
	
	}
//set no elementi dupplicati
	public Set<String> calcolaAnagrammi(String parola){
		Set<String> anagrammi=new HashSet<String>();
		String parziale="";
		calcola(parziale,parola,0,anagrammi);
		return anagrammi;
	}

private void calcola(String parziale, String parola, int passo, Set<String> anagrammi) {
	if(passo==parola.length()) {
		anagrammi.add(parziale);
		return;
	}
	
	for(int i=0;i<parola.length();i++) {
		
		if(charCounter(parziale,parola.charAt(i))<charCounter(parola,parola.charAt(i))) {
			parziale+=parola.charAt(i);
			calcola(parziale,parola,passo+1,anagrammi);
			parziale=parziale.substring(0, parziale.length()-1);
		}
	}
}

private int charCounter(String string, char c) { //conta quante volte vengono ripetute le lettere
	int count=0;
	for(int i=0;i<string.length();i++) {
		if(string.charAt(i)==c) {
			count++;
		}
	}
	return count;

}
public boolean isCorrect(String parola) {
	return PDB.isCorrect(parola);
}

	}
