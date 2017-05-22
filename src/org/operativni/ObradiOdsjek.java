package org.operativni;

import java.util.ArrayList;

import org.deklerativni.Odsjek;
import org.deklerativni.Vrsta;

public class ObradiOdsjek {

	public static void dodajVrstu(Odsjek odsjek, Vrsta vrsta) {
		//NESTO SAM OVDJE MJENJAO LISTE KASTovao???
		ArrayList<Vrsta> listaVrstaOdsjek = (ArrayList<Vrsta>) odsjek.getListaVrsta();
		for (Vrsta postojecaVrsta : listaVrstaOdsjek) {
			if (!postojecaVrsta.getNazivVrste().equals(vrsta.getNazivVrste()))
				listaVrstaOdsjek.add(vrsta);
			else
				System.out.println("Vrsta " + vrsta.getNazivVrste()
						+ " se vec nalazi u odsjeku");
		}
	}

	public static Odsjek registrujOdsjekSaKnjigama(String broj, int GK,
			String knjigaPremjerdbe, String knjigaDoznake) {
		Odsjek odsjek = new Odsjek(broj, GK, knjigaPremjerdbe, knjigaDoznake);
		return odsjek;

	}

	public static Odsjek registrujOdsjekBezKnjiga(String broj, int GK) {
		Odsjek odsjek = new Odsjek(broj, GK);
		return odsjek;

	}
}

