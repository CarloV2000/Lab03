package it.polito.tdp.spellchecker.model;

public class TestCorrettore {

	public static void main(String[] args) {
		Correttore corr = new Correttore();
		corr.loadDictionary("English");
		System.out.println(corr.paroleNelDizionario.toString());
	}
}
