package org.operativni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.deklerativni.Odjel;
import org.deklerativni.Odsjek;
import org.deklerativni.Vrsta;

public class Validacija {

	// ako se vrsta naalzi u listi vrsta u odsejku vraca false
	public static boolean vrste(int imeVrste, Collection<Vrsta> listaVrsta) {
		for (Vrsta vrsta : listaVrsta) {
			if (vrsta.getNazivVrste() == (imeVrste))
				System.out.println("Vrsta " + imeVrste
						+ " vec postoju odsjeku!");
			return false;
		}
		return true;
	}

	public static boolean odsjeka(int brojOdsjeka, Odjel odjel, int gk) {
		for (Odsjek odsjek : odjel.getListaOdsjeka()) {
			if (odsjek.getBrojOdsjeka() == (brojOdsjeka)) {
				System.out.println("Odsjek (" + brojOdsjeka
						+ ") vec postoji u odjelu!");
				return false;
			}

		}
		return GK(gk, odjel.getListaOdsjeka());
	}

	private static boolean GK(int gk, Collection<Odsjek> odsjeci) {
		for (Odsjek odsjek : odsjeci) {
			if (odsjek.getGK() == gk) {
				System.out.println("Gazdinska klasa " + gk
						+ " vec postoji u odjlu, provjerite vase unose.");
				return false;
			}

		}
		return true;

	}

	public static boolean odjela(int brojOdjela, List<Odjel> listaOdjela) {
		for (Odjel odjel : listaOdjela) {
			if (odjel.getBrojOdjela() == (brojOdjela)) {
				System.out.println("Odjel broj " + brojOdjela
						+ " vec postoji u Iskazu sjeèe!");
				return false;
			}
		}
		return true;
	}
}
