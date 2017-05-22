package org.operativni;

import java.util.ArrayList;

import org.deklerativni.Odsjek;

public class ObradiOdjel {

	public static void dodajOdsjek(Odsjek odsjek, ArrayList<Odsjek> listaOdsjeka) {
		if (!listaOdsjeka.contains(odsjek))
			listaOdsjeka.add(odsjek);
	}
}
