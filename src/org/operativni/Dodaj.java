package org.operativni;

import java.util.List;
import java.util.Scanner;

import org.deklerativni.Doznaka;
import org.deklerativni.Njega;
import org.deklerativni.Odjel;
import org.deklerativni.Odsjek;
import org.deklerativni.Proreda;
import org.deklerativni.Redovna;
import org.deklerativni.Sjeca;
import org.deklerativni.Uzici;
import org.deklerativni.Vanredne_i_stete;
import org.deklerativni.Vrsta;

public class Dodaj {
	static Scanner unos = new Scanner(System.in);

	public static void dodaj(List<Odjel> odjeli) {

		Odjel odjel = Dodaj.odjel(odjeli);
		Odsjek odsjek = odsjek(odjel);
		Vrsta vrsta = vrstu(odsjek);
		Doznaka doznaka = doznaku(odsjek, vrsta);
		postavioDefaultSjece(vrsta);
		Sjeca sjeca = sjecu();
		
		vrsta.setDoznaka(doznaka);
		 
		sumeBruto(vrsta);
		sumeNeto(vrsta);
		prelaz(vrsta);
		
		odsjek.getListaVrsta().add(vrsta);
		odjel.getListaOdsjeka().add(odsjek);
		odjeli.add(odjel);
	}

	public static Odjel odjel(List<Odjel> odjeli) {
		System.out.println("Unesite broj odjela:");
		int brojOdjela = unos.nextInt();

		if (Validacija.odjela(brojOdjela, odjeli)) {
			Odjel odjel = new Odjel(brojOdjela);
			return odjel;

		}
		return null;
	}

	public static Odsjek odsjek(Odjel odjel) {
		System.out.println("Unesite broj odsjeka:");
		int brojOdsjeka = unos.nextInt();
		System.out.println("Unesite gazdinsku klasu");
		int gk = unos.nextInt();
		if (Validacija.odsjeka(brojOdsjeka, odjel, gk)) {
			Odsjek odsjek = new Odsjek(brojOdsjeka, gk);

			return odsjek;

		}
		return null;

	}

	public static Vrsta vrstu(Odsjek odsjek) {
		System.out.println("Unesite vrstu u numerickom obliku:");
		int imeVrste = unos.nextInt();
		if (Validacija.vrste(imeVrste, odsjek.getListaVrsta())) {
			Vrsta vrsta = new Vrsta(imeVrste);
			// postavioDefaultSjece(vrsta);
			return vrsta;

		}
		return null;
	}

	// ubacivanje doznake....
	public static Doznaka doznaku(Odsjek odsjek, Vrsta vrsta) {
		System.out
				.println("Unesite prvo doznaku redosledom: bruto->ogrev->tehnika u cjelobrojnom obliku:");
		int bruto = unos.nextInt();
		int ogrev = unos.nextInt();
		int tehnika = unos.nextInt();
		System.out.println(bruto + " " + ogrev + " " + tehnika);
		Doznaka doznaka = new Doznaka(bruto, ogrev, tehnika);
		return doznaka;

	}

	private static void postavioDefaultSjece(Vrsta vrsta) {

		// napravio default konstruktore sa vrjednostima 0, te u koliko
		// atribut vrste SJECA je null, tj nije instanciran dodajemo
		// default rjednosti 0

		Sjeca njega = new Njega();
		vrsta.setNjega(njega);

		Proreda proreda = new Proreda();
		vrsta.setProreda(proreda);

		Redovna redovna = new Redovna();
		vrsta.setRedovna(redovna);

		Vanredne_i_stete van = new Vanredne_i_stete();
		vrsta.setVanredne(van);

		Sjeca uzici = new Uzici();
		vrsta.setUzici(uzici);

	}

	public static Sjeca sjecu() {
		System.out
				.println("Koju sjeèu zelite unjeti:\n1-Njega\n2-Proreda\n3-Redovna\n4-Vanredna-Steta\n5-Uzici");
		int uslov = unos.nextInt();
		switch (uslov) {
		case 1:
			System.out
					.println("Unesite : bruto->ogrev->tehnika u cjelobrojnom obliku:");
			Sjeca sjeca = new Njega(unos.nextInt(), unos.nextInt(),
					unos.nextInt());
			return sjeca;

		case 2:
			System.out
					.println("Unesite : bruto->ogrev->tehnika u cjelobrojnom obliku:");
			Sjeca proreda = new Proreda(unos.nextInt(), unos.nextInt(),
					unos.nextInt());
			return proreda;
		case 3:
			System.out
					.println("Unesite : bruto->ogrev->tehnika u cjelobrojnom obliku:");
			Sjeca redovna = new Redovna(unos.nextInt(), unos.nextInt(),
					unos.nextInt());
			return redovna;
		case 4:
			System.out
					.println("Unesite : bruto->ogrev->tehnika u cjelobrojnom obliku:");
			Sjeca van = new Vanredne_i_stete(unos.nextInt(), unos.nextInt(),
					unos.nextInt());
			return van;
		case 5:
			System.out
					.println("Unesite : bruto->ogrev->tehnika u cjelobrojnom obliku:");
			Sjeca uzici = new Uzici(unos.nextInt(), unos.nextInt(),
					unos.nextInt());
			return uzici;
		default:
			System.out.println("pogresan unos");
			return sjecu();
		}

	}

	private static void sumeBruto(Vrsta vrsta) {
		int bruto = vrsta.getNjega().getBruto() + vrsta.getProreda().getBruto()
				+ vrsta.getRedovna().getBruto()
				+ vrsta.getVanredne().getBruto() + vrsta.getUzici().getBruto();
		vrsta.setSumaBruto(bruto);
	}

	private static void sumeNeto(Vrsta vrsta) {
		int neto = vrsta.getNjega().getNeto() + vrsta.getRedovna().getNeto()
				+ vrsta.getProreda().getNeto() + vrsta.getVanredne().getNeto()
				+ vrsta.getUzici().getNeto();
		vrsta.setSumaNeto(neto);
	}

	private static void prelaz(Vrsta vrsta) {
		// ako je nesto ostalo neposjeceno
		int doznaceno = vrsta.getDoznaka().getBruto();

		int posjeceno = vrsta.getSumaBruto() - vrsta.getVanredne().getBruto();
		// -50=100-50;
		int prelaz = doznaceno - posjeceno;

		vrsta.setNeposjecenoBruto(prelaz);

	}

}
