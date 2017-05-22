package org.deklerativni;

import java.util.ArrayList;
import java.util.Collection;

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
	private String brojOdjela;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "odsjeci")
	private Collection<Odsjek> listaOdsjeka = new ArrayList<>();

	public Odjel(String brojOdjela) {

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

	public String getBrojOdjela() {
		return brojOdjela;
	}

	public void setBrojOdjela(String brojOdjela) {
		this.brojOdjela = brojOdjela;
	}

	@Override
	public String toString() {
		return "Odjel [idOdjela=" + idOdjela + ", brojOdjela=" + brojOdjela
				+ ", listaOdsjeka=" + listaOdsjeka + "]";
	}

}
