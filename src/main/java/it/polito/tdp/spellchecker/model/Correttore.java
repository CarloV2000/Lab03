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
	String lingua = "";
	
	public Correttore() {
		
		this.parole = new ArrayList<Parola>();
		this.paroleNelDizionario = new ArrayList<String>();
		
	}
	/**
	 * serve per settare la lingua e scaricare il contenuto del file dizionario della lingua settata nella ArrayList appositamente creata
	 * @param language è il riferimento al nome del file contenente tutte le parole della lingua selezionata
	 */
	public void loadDictionary(String language) {
		if(language == "English")
			lingua = ("src/main/resources/English.txt").strip();
		else if (language == "Italiano")
			lingua = ("src/main/resources/Italian.txt").strip();
		
		try {
			FileReader fr = new FileReader(lingua);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine())!=null) {
				this.paroleNelDizionario.add(word.toLowerCase());
			}
			br.close();
		}catch(IOException e){
			System.out.println("Errore nella lettura del file");
		}
	}
	/**
	 * serve per salvare con l'attributo corretta (true o false) tutte le parole inserite(e ritornarle)
	 * @param s è la stringa inserita
	 * @return una lista di parole a partire dalle stringhe generate dalla stringa inserita
	 */
	public List<Parola>spellCheckText(String s){
		String frase = s.replaceAll("[.,\\\\/#!$%\\\\^&\\\\*;:{}=\\\\-_`~()\\\\[\\\\]\\\"]", "");
		List<String>listaParoleInseriteSTRING = new ArrayList<String>();
		List<Parola>listaParoleInserite = new ArrayList<Parola>();

    	for (String parola : frase.split(" ")) {//per ogni parola nella stringa inserita (spazio come separatore)
    		listaParoleInseriteSTRING.add(parola);
    	}
    	//salvare il dizionario in una lista e controllare se essa contiene le parole digitate una ad una
    	for(String x : listaParoleInseriteSTRING) {
    		Parola p;
    		if(this.paroleNelDizionario.contains(x)) {
    			p = new Parola(x,true);
    		}
    		else {
    			p = new Parola(x,false);
    		}
    		
    		listaParoleInserite.add(p);
   		}
    	return listaParoleInserite;
	}
/**
 * serve per stampare le parole errate in una lista di parole
 * @param lista una lista di parole
 * @return una stringa contenente tutte le parole con l'attributo boolean corretta = false
 */
	public String stampaParoleErrate(List<Parola>lista){
		String paroleErrate = "";
		for(Parola x : lista) {
			if(x.isCorretta()==false)
				paroleErrate+=x.getParola()+" ";
		}
		return paroleErrate;
	}
	
	public int contaErrori(String s) {
		String sSenzaSpazi = s.replaceAll(" ", "");
		int numParole;
		numParole = s.length()-sSenzaSpazi.length();
		return numParole;
	}
	public double contaSecondiSpellCheck(String s) {
		double tic = System.currentTimeMillis()/1000;
		this.spellCheckText(s);
		double toc = System.currentTimeMillis()/1000;
		return (toc-tic);
	}
}
