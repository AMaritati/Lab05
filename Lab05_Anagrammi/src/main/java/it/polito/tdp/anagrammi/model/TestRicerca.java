package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;



public class TestRicerca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Ricerca ric = new Ricerca() ;
AnagrammaDAO aDAO = new AnagrammaDAO();
		
		List<String> ana_dog = ric.anagrammi("cane") ;
		System.out.println(ana_dog) ;
		List<String> ok = new LinkedList<String>();
		List<String> not = new LinkedList<String>();
		
		for (String a : ana_dog) {
			if(aDAO.isCorrect(a)) {
				ok.add(a);
			}
			else {
				not.add(a);
			}
		}
		//stampo parole corrette
		System.out.println(ok) ;
		System.out.println(not) ;
	}

}
