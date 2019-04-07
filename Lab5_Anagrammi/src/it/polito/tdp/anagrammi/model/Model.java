package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammiDAO;

public class Model {
	
	public List<String> calcolaAnagrammi(String originale) {
		List<String> soluzioni = new ArrayList<String>();
		String parziale = "";
		int level = 0;
		recursion(originale, parziale, level, soluzioni);
		return soluzioni;
	}
	
	public void recursion(String originale, String parziale, int level, List<String> soluzioni) {
		
		if(level == originale.length()) {
			soluzioni.add(parziale);
			return;
		}
	
		for(int i = 0; i < originale.length(); i++) {		
			
			if(possoAggiungereLettera(parziale, originale, originale.charAt(i))) {
				parziale += originale.charAt(i);
				recursion(originale, parziale, level+1, soluzioni);
				
				// backtrack con il substring, elimino la lettera level-1 ogni volta
				// scrivendo solo parziale.substring(0, parziale.length()-1); non funzionava, perche?
				parziale = parziale.substring(0, parziale.length()-1);
				
			}
		}
		
	}
	// se la parola parziale ha un numero di una specifica lettera minore di quello della parola originale posso andare avanti
	public boolean possoAggiungereLettera(String parziale, String originale, char c) {
		boolean bool = false;
			if (contaCarattere(c, parziale) < contaCarattere(c, originale)) {
				
				bool = true;
				
			} 
		return bool;
	}
	
	public int contaCarattere(char c, String parola) {
		int num = 0;

		for(int i = 0; i<parola.length(); i++) {
			if (parola.charAt(i) == c) {
				num = num+1;
			}
		}
		System.out.println(num);
		return num;
	}

	AnagrammiDAO oggettoDAO = new AnagrammiDAO();
	public boolean isCorrectModel(String anagramma) {
		return oggettoDAO.isCorrect(anagramma);
	}
	
}
	
