package org.deklerativni;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "odjeli")
public class Odjel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idOdjela;
	private int brojOdjela;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL ) 
	@JoinTable(name = "odsjeci")
	private Collection<Odsjek> listaOdsjeka = new ArrayList<>();

	public Odjel(int brojOdjela) {

		this.brojOdjela = brojOdjela;

	}

	public Odjel() {

	}

	public Collection<Odsjek> getListaOdsjeka() {
		return listaOdsjeka;
	}

	public void setListaOdsjeka(Collection<Odsjek> listaOdsjeka) {
		this.listaOdsjeka = listaOdsjeka;
	}

	public void setId(int brojOdjela) {
		this.idOdjela = brojOdjela;
	}

	public int getBrojOdjela() {
		return brojOdjela;
	}

	public void setBrojOdjela(int brojOdjela) {
		this.brojOdjela = brojOdjela;
	}

	@Override
	public String toString() {
		return "Broj odjela=" + brojOdjela
				+ "Odsjeci;" + listaOdsjeka + "]";
	}

}
