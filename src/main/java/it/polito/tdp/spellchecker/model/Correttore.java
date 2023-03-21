package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Correttore {

	public List<Parola>parole;
	public List<String>paroleNelDizionario;
	
	public Correttore() {
		
		this.parole = new ArrayList<>();
		this.paroleNelDizionario = new ArrayList<>();
	}
	
	public void loadDictionary(String language) {//serve per settare la lingua e scaricare il file dizionario della lingua settata
		if(language =="English") {
			try {
				FileReader fr = new FileReader("English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while((word = br.readLine())!=null) {
					this.paroleNelDizionario.add(word);
				}
				br.close();
			
			}catch(IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
		if(language =="Italiano") {
			try {
				FileReader fr = new FileReader("Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while((word = br.readLine())!=null) {
					this.paroleNelDizionario.add(word);
				}
				br.close();
			
			}catch(IOException e){
				System.out.println("Errore nella lettura del file");
			}
		}
	}
	
	public List<String>spellCheckText(String s){//serve per ritornare tutte le parole sbagliate
		String frase = s.replaceAll(".,\\/#!?$", "");
		List<String>listaParoleInseriteSTRING = new ArrayList<String>();
		List<String>listaParoleInseriteErrateSTRING = new ArrayList<String>();
		List<Parola>listaParoleInserite = new ArrayList<Parola>();

    	for (String parola : frase.split(" ")) {//per ogni parola nella stringa inserita
    		listaParoleInseriteSTRING.add(parola);
    	}
    	//creo doppio ciclo per vedere se ogni parola nella mia stringa è contenuta nel dizionario se si creo parola con true se no con false
    	// no: meglio salvare dizionario in una lista
    	for(String x : listaParoleInseriteSTRING) {
    		if(this.paroleNelDizionario.contains(x)) {
    			Parola p = new Parola(x,true);
    			listaParoleInserite.add(p);
    		}
    		else {
    			Parola p = new Parola(x,false);
    			listaParoleInserite.add(p);
    			listaParoleInseriteErrateSTRING.add(p.getParola());
    		}
   		}
    	return listaParoleInseriteErrateSTRING;
	}
}
