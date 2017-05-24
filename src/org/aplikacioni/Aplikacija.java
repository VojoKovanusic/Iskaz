package org.aplikacioni;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.operativni.ObradiOdjel;
import org.operativni.UbaciUVrstu;
import org.operativni.Validacija;

import com.mysql.fabric.xmlrpc.base.Array;

public class Aplikacija {

	public static void main(String[] args) throws SQLException {

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query q = session.createQuery("from Odjel");
		List<Odjel> odjeli = (List<Odjel>) q.list();
		
		
		session.getTransaction().commit();
		session.close();
		 
		
			for (Odjel odjel : odjeli) {
					System.out.println(odjel.getBrojOdjela()+":"+odjel.getListaOdsjeka().size());
					for (Odsjek odsjek :  odjel.getListaOdsjeka()) {
						odsjek.getListaVrsta().size();
						
					}
			}
	
 
	}

}
/*
 * Odjel odjel57 = new Odjel("98"); Doznaka doznaka1 = new Doznaka(200, 60, 70);
 * Doznaka doznaka2 = new Doznaka(150, 40, 50);
 * 
 * 
 * Redovna redovna = new Redovna(200, 45, 50); Njega njega = new Njega(450, 23,
 * 200); Njega njega1 = new Njega(250, 11, 234); Vanredne_i_stete van = new
 * Vanredne_i_stete(6, 3, 1);
 * 
 * Vrsta vrsta1 = new Vrsta("jela", doznaka1); vrsta1.setDoznaka(doznaka1);
 * vrsta1.setRedovna(redovna); vrsta1.setNjega(njega); vrsta1.setVanredne(van);
 * 
 * Vrsta vrsta2 = new Vrsta("smrca", doznaka2); vrsta2.setDoznaka(doznaka2);
 * vrsta2.setNjega(njega1);
 * 
 * Odsjek o1 = new Odsjek("02", 1212); Odsjek o2 = new Odsjek("01", 4200);
 * 
 * o1.getListaVrsta().add(vrsta1); o1.getListaVrsta().add(vrsta2);
 * 
 * odjel57.getListaOdsjeka().add(o1); odjel57.getListaOdsjeka().add(o2);
 * 
 * SessionFactory sf = new Configuration().configure() .buildSessionFactory();
 * Session session = sf.openSession(); session.beginTransaction();
 * session.save(odjel57); session.save(o1); session.save(o2);
 * session.save(doznaka1); session.save(doznaka2); session.save(vrsta1);
 * session.save(vrsta2); session.save(vrsta2); session.save(redovna);
 * session.save(njega); session.save(van); session.save(njega1);
 * 
 * session.getTransaction().commit(); session.close();
 * 
 * } Odjel odjOdjel_157 = new Odjel("156"); // listaOdjela.add(odjOdjel_157);
 * listaOdjela.add(odjeOdjel_57); // napavio odsjeke Odsjek odsjek01 = new
 * Odsjek("01", 1414, "111/16", "1/17"); Odsjek odsjek02 = new Odsjek("02",
 * 1122, "222/16", "2/17"); Odsjek odsjek03 = new Odsjek("03", 4141, "333/16",
 * "3/17"); Odsjek odsjek04 = new Odsjek("04", 1250, "444/16", "4/17"); //
 * napravi Arary liste vrsta u odsjeku,odnosno dohvati vec potencijalno //
 * postojece ArrayList<Vrsta> listaVrsta01 = odsjek01.getListaVrsteodsjek();
 * ArrayList<Vrsta> listaVrsta02 = odsjek02.getListaVrsteodsjek();
 * ArrayList<Vrsta> listaVrsta03 = odsjek03.getListaVrsteodsjek();
 * ArrayList<Vrsta> listaVrsta04 = odsjek04.getListaVrsteodsjek();
 * 
 * // napravi aktivnosti koje ce se stavljati unutar vrsta Sjeca proreda1 = new
 * Proreda(100, 45, 40); Sjeca uzitak = new Uzici(10, 50, 30); Sjeca njega1 =
 * new Njega(100, 500, 200); Doznaka doznaka1 = new Doznaka(1000, 50, 20); Sjeca
 * redovna1 = new Redovna(100, 300, 190); Vanredne_i_stete van = new
 * Vanredne_i_stete(50, 23, 23);
 * 
 * // druga tura Sjeca proreda2 = new Proreda(5, 5, 5); Sjeca njega2 = new
 * Njega(111, 1111, 111); Doznaka doznaka2 = new Doznaka(333, 55, 22); Sjeca
 * redovna2 = new Redovna(3, 3, 3);
 * 
 * // treca tura Sjeca proreda3 = new Proreda(3, 5, 40); Sjeca njega3 = new
 * Njega(3, 500, 200); Doznaka doznaka3 = new Doznaka(3, 50, 20); Sjeca redovna3
 * = new Redovna(3, 40, 19);
 * 
 * // u listu poubacivao sjece UbaciUVrstu.doznaku("21", doznaka1,
 * listaVrsta01); UbaciUVrstu.sjecu("njega", "21", njega1, listaVrsta01);
 * UbaciUVrstu.sjecu("proreda", "21", proreda1, listaVrsta01);
 * UbaciUVrstu.sjecu("uzitak", "21", uzitak, listaVrsta01);
 * UbaciUVrstu.sjecu("redovna", "21", redovna1, listaVrsta01);
 * UbaciUVrstu.sjecu("vanredna", "21", van, listaVrsta01);
 * UbaciUVrstu.defaultSjecu("21", listaVrsta01);
 * 
 * UbaciUVrstu.doznaku("42", doznaka2, listaVrsta01); UbaciUVrstu.sjecu("njega",
 * "42", njega2, listaVrsta01); UbaciUVrstu.sjecu("proreda", "42", proreda2,
 * listaVrsta01); UbaciUVrstu.sjecu("redovna", "42", redovna2, listaVrsta01);
 * UbaciUVrstu.defaultSjecu("42", listaVrsta01);
 * 
 * UbaciUVrstu.doznaku("21", doznaka1, listaVrsta02); UbaciUVrstu.sjecu("njega",
 * "21", njega1, listaVrsta02); UbaciUVrstu.sjecu("proreda", "21", proreda2,
 * listaVrsta02); UbaciUVrstu.sjecu("redovna", "21", redovna3, listaVrsta02);
 * UbaciUVrstu.defaultSjecu("21", listaVrsta02);
 * 
 * UbaciUVrstu.doznaku("42", doznaka3, listaVrsta02); UbaciUVrstu.sjecu("njega",
 * "42", njega3, listaVrsta02); UbaciUVrstu.sjecu("proreda", "42", proreda3,
 * listaVrsta02); UbaciUVrstu.sjecu("redovna", "42", redovna3, listaVrsta02);
 * UbaciUVrstu.defaultSjecu("42", listaVrsta02);
 * 
 * UbaciUVrstu.doznaku("25", doznaka1, listaVrsta03); UbaciUVrstu.sjecu("njega",
 * "25", njega1, listaVrsta03); UbaciUVrstu.sjecu("proreda", "25", proreda1,
 * listaVrsta03); UbaciUVrstu.sjecu("redovna", "25", redovna1, listaVrsta03);
 * UbaciUVrstu.defaultSjecu("25", listaVrsta03); UbaciUVrstu.doznaku("42",
 * doznaka3, listaVrsta04); UbaciUVrstu.sjecu("njega", "42", njega3,
 * listaVrsta04); UbaciUVrstu.sjecu("proreda", "42", proreda3, listaVrsta04);
 * UbaciUVrstu.sjecu("redovna", "42", redovna3, listaVrsta04);
 * 
 * UbaciUVrstu.defaultSjecu("42", listaVrsta02);
 * odsjek03.setListaVrsteodsjek(listaVrsta03);
 * odsjek04.setListaVrsteodsjek(listaVrsta04); ArrayList<Odsjek> odsjeciU_57 =
 * odjeOdjel_57.getListaOdsjeka(); ObradiOdjel.dodajOdsjek(odsjek03,
 * odsjeciU_57); ObradiOdjel.dodajOdsjek(odsjek04, odsjeciU_57);
 * 
 * // snimam lisu(sa izvrsenim aktivnostima) u odsjek
 * odsjek01.setListaVrsteodsjek(listaVrsta01);
 * odsjek02.setListaVrsteodsjek(listaVrsta02);
 * 
 * // pravim listu za odsjeke ArrayList<Odsjek> odsjeciU_157 =
 * odjOdjel_157.getListaOdsjeka(); // ubacujem listu odska u odjel
 * ObradiOdjel.dodajOdsjek(odsjek01, odsjeciU_157);
 * ObradiOdjel.dodajOdsjek(odsjek02, odsjeciU_157);
 * 
 * // System.out.println(odjOdjel_157); // System.out.println(odjeOdjel_57);
 * 
 * // Validacija.vrsteUOdsjeku("211", listaVrsta01); //
 * Validacija.odjelaUIskazu("156", listaOdjela);
 * 
 * System.out.println(listaOdjela);
 */

