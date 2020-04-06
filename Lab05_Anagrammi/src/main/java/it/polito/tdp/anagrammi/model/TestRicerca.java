package it.polito.tdp.anagrammi.model;

import java.util.List;



public class TestRicerca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Ricerca ric = new Ricerca() ;
		
		List<String> ana_dog = ric.anagrammi("dog") ;
		System.out.println(ana_dog) ;
	}

}
