package org.baza;

import java.util.ArrayList;
import java.util.List;

import org.deklerativni.Odjel;
import org.deklerativni.Odsjek;
import org.deklerativni.Vrsta;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Baza {

	public static List<Odjel> dohvatiOdjele(SessionFactory sf) {
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Odjel");
		List<Odjel> odjeli = (List<Odjel>) q.list();

		for (Odjel odjel : odjeli) {
			for (Odsjek odsjek : odjel.getListaOdsjeka()) {
				for (Vrsta vrsta : odsjek.getListaVrsta()) {
					Hibernate.initialize(vrsta.getDoznaka());
					Hibernate.initialize(vrsta.getNjega());
					Hibernate.initialize(vrsta.getProreda());
					Hibernate.initialize(vrsta.getRedovna());
					Hibernate.initialize(vrsta.getUzici());
					Hibernate.initialize(vrsta.getVanredne());
				}
			}

		}
		session.getTransaction().commit();

		session.close();

		return odjeli;
	}

	public static void sacuvajPromjene(SessionFactory sf, List<Odjel> odjeli) {

		Session session = sf.openSession();
		session.beginTransaction();
		// kaskadno snimanje promjena
		for (Odjel odjel : odjeli) {

			session.save(odjel);
		}
		session.getTransaction().commit();
		session.close();
	}

	public static void ispisiIskaz(List<Odjel> odjeli) {
		for (Odjel odjel : odjeli) {
			System.out.println(odjel.getBrojOdjela());

			for (Odsjek odsjek : odjel.getListaOdsjeka()) {
				System.out.println(odsjek.getBrojOdsjeka());
				for (Vrsta vrsta : odsjek.getListaVrsta()) {
					System.out.println(vrsta.getNazivVrste());
				}
			}

		}
	}
}
