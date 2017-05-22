package org.operativni;

import java.util.ArrayList;

import org.deklerativni.Odjel;
import org.deklerativni.Odsjek;
import org.deklerativni.Vrsta;

public class Validacija {

	// ako se vrsta naalzi u listi vrsta u odsejku vraca false
	public static boolean vrsteUOdsjeku(String imeVrste,
			ArrayList<Vrsta> listaVrsta) {
		for (Vrsta vrsta : listaVrsta) {
			if (vrsta.getNazivVrste().equals(imeVrste))
				System.out.println("Vrsta " + imeVrste
						+ " vec postoji u odsjeku!");
			return false;
		}
		return true;
	}

	public static boolean odsjekaUOdjelu(String brojOdsjeka,
			ArrayList<Odsjek> listaodsjeka) {
		for (Odsjek odsjek : listaodsjeka) {
			if (odsjek.getBrojOdsjeka().equals(brojOdsjeka)) {
				System.out.println("Odsjek (" + brojOdsjeka
						+ ") vec postoji u odjelu!");
				return false;
			}
		}
		return true;
	}

	public static boolean odjelaUIskazu(String brojOdjela,
			ArrayList<Odjel> listaOdjela) {
		for (Odjel odjel : listaOdjela) {
			if (odjel.getBrojOdjela().equals(brojOdjela)) {
				System.out.println("Odjel broj " + brojOdjela
						+ " vec postoji u Iskazu sjeèe!");
				return false;
			}
		}
		return true;
	}
}

