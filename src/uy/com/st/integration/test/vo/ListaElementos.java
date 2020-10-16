package uy.com.st.integration.test.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="G-Mant")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaElementos {
	
	@XmlElement(name = "Elementos")
	private ArrayList<Elemento> elementos;
	
	public ListaElementos() {}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<Elemento> elementos) {
		this.elementos = elementos;
	}

	@Override
	public String toString() {
		String elementosString = "";
		for (Elemento elemento : this.elementos) {
			elementosString += elemento.toString() + "\r\n";
		}
		return elementosString;
	}

}
