package it.polito.tdp.spellchecker.model;

public class Parola {
	private String parola;
	private boolean corretta;
	
	public Parola(String parola, boolean corretta) {
		this.parola = parola;
		this.corretta = corretta;
	}

	public String getParola() {
		return parola;
	}

	public boolean isCorretta() {
		return corretta;
	}

	@Override
	public String toString() {
		return parola+'\n';
	}
	
	
	

}
