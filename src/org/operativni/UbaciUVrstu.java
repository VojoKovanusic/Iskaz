package org.operativni;

import java.util.ArrayList;

import org.deklerativni.Doznaka;
import org.deklerativni.Njega;
import org.deklerativni.Proreda;
import org.deklerativni.Redovna;
import org.deklerativni.Sjeca;
import org.deklerativni.Uzici;
import org.deklerativni.Vanredne_i_stete;
import org.deklerativni.Vrsta;

public class UbaciUVrstu {

	// ubacivanje doznake....
	public static void doznaku(String sifraVrste, Doznaka doznaka,

	ArrayList<Vrsta> listaVrstaUOdsjeku) {

		Vrsta vrstaDrveta = new Vrsta(sifraVrste, doznaka);
		if (!listaVrstaUOdsjeku.contains(vrstaDrveta)) {
			listaVrstaUOdsjeku.add(vrstaDrveta);
		} 
		else {
			for (Vrsta vrsta : listaVrstaUOdsjeku) {
				if (vrsta.getNazivVrste().equals(sifraVrste)) {
					vrsta.setDoznaka(doznaka);
				}

			}
		}
	}

	// dodavanje sjece vrste u odsjeku...
	public static void sjecu(String uslov, String sifraVrste, Sjeca sjeca,
			ArrayList<Vrsta> listaVrstaUOdsjeku) {
		for (Vrsta vrsta : listaVrstaUOdsjeku) {
			if (vrsta.getNazivVrste().equals(sifraVrste)) {
				switch (uslov) {
				case "njega":
					vrsta.setNjega(sjeca);
					break;
				case "proreda":
					vrsta.setProreda(sjeca);
					break;
				case "redovna":
					vrsta.setRedovna(sjeca);
					break;
				case "vanredna":
					vrsta.setVanredne(sjeca);
					break;
				case "uzitak":
					vrsta.setUzici(sjeca);
					break;

				}

			}

		}
	}

	public static void defaultSjecu(String sifraVrste,
			ArrayList<Vrsta> listaVrstaUOdsjeku) {

		for (Vrsta vrsta : listaVrstaUOdsjeku) {
			if (vrsta.getNazivVrste().equals(sifraVrste)) {

				// napravio default konstruktore sa vrjednostima 0, te u koliko
				// atribut vrste SJECA je null, tj nije instanciran dodajemo
				// default rjednosti 0

				if (!(vrsta.getNjega() instanceof Njega)) {
					Sjeca njega = new Njega();
					vrsta.setNjega(njega);

				}
				if (!(vrsta.getProreda() instanceof Proreda)) {
					Proreda proreda = new Proreda();
					vrsta.setProreda(proreda);

				}
				if (!(vrsta.getRedovna() instanceof Redovna)) {
					Redovna redovna = new Redovna();
					vrsta.setRedovna(redovna);
				}
				if (!(vrsta.getVanredne() instanceof Vanredne_i_stete)) {
					Vanredne_i_stete van = new Vanredne_i_stete();
					vrsta.setVanredne(van);

				}
				if (!(vrsta.getUzici() instanceof Uzici)) {
					Sjeca uzici = new Uzici();
					vrsta.setUzici(uzici);

				}
				sumeBruto(vrsta);
				sumeNeto(vrsta);
				prelaz(vrsta);
			}
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
