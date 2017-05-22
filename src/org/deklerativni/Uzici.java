package org.deklerativni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Uzici extends Sjeca {
 
 
	public Uzici() {
		super();
	 
	}

	public Uzici(int bruto, int ogrev, int tehnika) {
		super(bruto, ogrev, tehnika);
	 
	}

	@Override
	public String toString() {
		return "[bruto:" + getBruto() + " ogrev:" + getOgrev() + " tehnika"
				+ getTehnika() + "]";
	}
}

