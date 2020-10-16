package uy.com.st.integration.test.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="G-Mant")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaTiposElementos {
	
	@XmlElement(name = "TiposElementos")
	private ArrayList<TipoElemento> tiposElementos;

	public ArrayList<TipoElemento> getTiposElementos() {
		return tiposElementos;
	}

	public void setTiposElementos(ArrayList<TipoElemento> tiposElementos) {
		this.tiposElementos = tiposElementos;
	}

	public ListaTiposElementos() {}

	@Override
	public String toString() {
		String tiposElementoString = "";
		for (TipoElemento tipoElemento : this.tiposElementos) {
			tiposElementoString += tipoElemento.toString() + "\r\n";
		}
		return tiposElementoString;
	}
}
