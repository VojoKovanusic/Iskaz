package org.aplikacioni;

import java.util.List;

import org.deklerativni.Odjel;
import org.deklerativni.Odsjek;
import org.deklerativni.Vrsta;

public class Meni {
	public static void ispisGlavnuPonudu() {
		System.out
				.println("_______________________________________________\n1-UNOS NOVOG ODJELA\n"
						+ "\nUPISIVANJE U VEC POSTOJECI ODJEL:"
						+ "\n2-odsjek"
						+ "\n3-"
						+ "vrstu"
						+ "\n4-sjecu"
						+ "\n5-doznaku\n"

						+ "\nEDITOVANJE:"
						+ "\n6-odjela"
						+ "\n7-odsjeka"
						+ "\n8-vrste"
						+ "\n9-sjece"
						+ "\n10-doznake\n"
						+ "\n12-UBACIVANJE PRELAZA OD PROSLE GODINE"
						+ "\n\n13-ISPIS ISKAZA\n"
						+ "_______________________________________________");
	}

	public static void ispisSve(List<Odjel>odjeli){
		for (Odjel odjel : odjeli) {
			System.out.println("Broj odjela: "+odjel.getBrojOdjela());
			for (Odsjek odsjek : odjel.getListaOdsjeka()) {
				System.out.println("Broj odsjeka:"+odsjek.getBrojOdsjeka()+" GK "+odsjek.getGK());
				for (Vrsta vrsta : odsjek.getListaVrsta()) {
					System.out.println(vrsta.toString());
					
				}
				
			}
			
		}
	}

}
