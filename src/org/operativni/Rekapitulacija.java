package org.operativni;

import java.util.ArrayList;
import java.util.List;

import org.deklerativni.Njega;
import org.deklerativni.Odjel;
import org.deklerativni.Odsjek;
import org.deklerativni.Prelaz;
import org.deklerativni.Proreda;
import org.deklerativni.Redovna;
import org.deklerativni.Uzici;
import org.deklerativni.Vanredne_i_stete;
import org.deklerativni.Vrsta;

public class Rekapitulacija {

	public static void poVrstama_i_TipovimaSjeca(List<Odjel> odjeli) {

		// vrste koje cu puniti za ispis rekapituklacije
		List<Vrsta> vrsteIskaz = getSveVrste(odjeli);

		// vrste koje sam napunio praznim objektima Vrsta koje imaju sifre
		// potrebne u rekapitulaciji....
		ArrayList<Vrsta> vrsteRekapitulacija = getVrsteZaRekapitulaciju(odjeli);

		saberiSve(vrsteRekapitulacija, (ArrayList<Vrsta>) vrsteIskaz);

		// ispis prve rekapitulacije u iskazu
		ispisiRekapitulacijuPoVrstiSjece(vrsteRekapitulacija);
		ispisiPoVrstamaUkupnuSjecu(vrsteRekapitulacija);

	}

	private static void ispisiRekapitulacijuPoVrstiSjece(
			ArrayList<Vrsta> vrsteRekapitulacija) {
		for (Vrsta vrsta : vrsteRekapitulacija) {
			System.out.println("\n[" + vrsta.getNazivVrste()
					+ "] |REDOVNA: Bruto->" + vrsta.getRedovna().getBruto()
					+ " Oblo tex.->" + vrsta.getRedovna().getTehnika()
					+ " Ogrev->" + vrsta.getRedovna().getOgrev() + " "
					+ "| SLUCAJNI UZICI : Bruto->"
					+ vrsta.getUzici().getBruto() + " Oblo tex.->"
					+ vrsta.getUzici().getTehnika() + " Ogrev->"
					+ vrsta.getUzici().getOgrev() + "| POREDE: Bruto->"
					+ vrsta.getProreda().getBruto() + " Oblo tex.->"
					+ vrsta.getProreda().getTehnika() + " Ogrev->"
					+ vrsta.getProreda().getOgrev()
					+ "| VAN/SUM STETE: Bruto->"
					+ vrsta.getVanredne().getBruto() + " Oblo tex.->"
					+ vrsta.getVanredne().getTehnika() + " Ogrev->"
					+ vrsta.getVanredne().getOgrev() + "| NjEGA SUMA: Bruto->"
					+ vrsta.getNjega().getBruto() + " Oblo tex.->"
					+ vrsta.getNjega().getTehnika() + " Ogrev->"
					+ vrsta.getNjega().getOgrev());

		}
	}

	private static void ispisiPoVrstamaUkupnuSjecu(
			ArrayList<Vrsta> vrsteRekapitulacija) {
		for (Vrsta vrsta : vrsteRekapitulacija) {
			System.out.println("\n["
					+ vrsta.getNazivVrste()
					+ "] |Bruto->"
					+ (vrsta.getRedovna().getBruto()
							+ vrsta.getUzici().getBruto()
							+ vrsta.getProreda().getBruto()
							+ vrsta.getVanredne().getBruto() + vrsta.getNjega()
							.getBruto())
					+ " Oblo tex.->"
					+ (vrsta.getRedovna().getTehnika()
							+ vrsta.getUzici().getTehnika()
							+ vrsta.getProreda().getTehnika()
							+ +vrsta.getVanredne().getTehnika() + vrsta
							.getNjega().getTehnika())
					+ " Ogrev->"
					+ (vrsta.getRedovna().getOgrev()
							+ vrsta.getUzici().getOgrev()
							+ vrsta.getProreda().getOgrev()
							+ vrsta.getVanredne().getOgrev() + vrsta.getNjega()
							.getOgrev()));

		}
	}
//NIJE ZAVRSENO
	private static void ispisiPoVrstamaPrelaze(
			ArrayList<Vrsta> vrsteRekapitulacija)

	{
		for (Vrsta vrsta : vrsteRekapitulacija) {
			System.out.println("\n[" + vrsta.getNazivVrste() + "]"
					+ vrsta.getNeposjecenoBruto());
		}
	}

	private static ArrayList<Vrsta> getVrsteZaRekapitulaciju(List<Odjel> odjeli) {
		ArrayList<Vrsta> vrsteRek = new ArrayList<Vrsta>();

		ArrayList<String> sifre = sveSifre(odjeli);
		for (int i = 0; i < sifre.size(); i++) {
			Vrsta vrsta = new Vrsta(sifre.get(i));
			vrsta.setNjega(new Njega(0, 0, 0));
			vrsta.setVanredne(new Vanredne_i_stete(0, 0, 0));
			vrsta.setProreda(new Proreda(0, 0, 0));
			vrsta.setUzici(new Uzici(0, 0, 0));
			vrsta.setRedovna(new Redovna(0, 0, 0));

			vrsteRek.add(vrsta);
		}
		return vrsteRek;
	}

	// kupi sve vrste iz iskaza i stavlja u listu
	public static List<Vrsta> getSveVrste(List<Odjel> odjeli) {
		List<Vrsta> vrste = new ArrayList<Vrsta>();

		for (Odjel odjel : odjeli) {
			for (Odsjek odsjek : odjel.getListaOdsjeka()) {
				for (Vrsta vrsta : odsjek.getListaVrsta()) {
					vrste.add(vrsta);
				}

			}

		}
		return vrste;
	}

	private static void saberiSve(ArrayList<Vrsta> vrsteRek,
			ArrayList<Vrsta> vrsteIskaz) {
		for (Vrsta vrsta : vrsteIskaz) {
			saberiVrstu(vrsteRek, vrsta);

		}
	}

	private static void saberiVrstu(ArrayList<Vrsta> vrsteRek, Vrsta vrstaIskaz) {

		for (Vrsta rekapitulacija : vrsteRek) {

			if (vrstaIskaz.getNazivVrste().equals(
					rekapitulacija.getNazivVrste())) {

				if (vrstaIskaz.getNjega() instanceof Njega)
					rekapitulacija.getNjega()
							.rekapitulacijaSjecePoVrstama_i_sjeci(
									vrstaIskaz.getNjega());
				if (vrstaIskaz.getVanredne() instanceof Vanredne_i_stete)
					rekapitulacija.getVanredne()
							.rekapitulacijaSjecePoVrstama_i_sjeci(
									vrstaIskaz.getVanredne());
				if (vrstaIskaz.getProreda() instanceof Proreda)
					rekapitulacija.getProreda()
							.rekapitulacijaSjecePoVrstama_i_sjeci(
									vrstaIskaz.getProreda());
				if (vrstaIskaz.getUzici() instanceof Uzici)
					rekapitulacija.getUzici()
							.rekapitulacijaSjecePoVrstama_i_sjeci(
									vrstaIskaz.getUzici());
				if (vrstaIskaz.getRedovna() instanceof Redovna)
					rekapitulacija.getRedovna()
							.rekapitulacijaSjecePoVrstama_i_sjeci(
									vrstaIskaz.getRedovna());
			}
		}

	}

	private static ArrayList<Prelaz> getOvogodisnjiPrelaze(List<Odjel> odjeli) {
		ArrayList<Prelaz> prelazi = new ArrayList<>();

		// dobijam listu svih upotrebljenih sifri u iskazu
		ArrayList<String> sifre = sveSifre(odjeli);

		for (int i = 0; i < sifre.size(); i++) {
			Prelaz vrsta = new Prelaz(sifre.get(i));
			prelazi.add(vrsta);
		}
		return prelazi;
	}

	// vraca mi listu sifri-vrsta koje su koristene
	private static ArrayList<String> sveSifre(List<Odjel> odjeli) {
		ArrayList<String> sifre = new ArrayList<String>();
		for (Odjel odjel : odjeli) {
			for (Odsjek odsjek : odjel.getListaOdsjeka()) {
				for (Vrsta vrsta : odsjek.getListaVrsta()) {
					if (!sifre.contains(vrsta.getNazivVrste()))
						sifre.add(vrsta.getNazivVrste());
				}
			}
		}

		sifre.add("Cet");
		sifre.add("Lis");
		sifre.add("C+L");
		return sifre;
	}

}
