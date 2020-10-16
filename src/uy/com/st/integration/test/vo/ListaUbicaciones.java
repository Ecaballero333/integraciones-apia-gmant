package uy.com.st.integration.test.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="G-Mant")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaUbicaciones {
	
	@XmlElement(name = "Ubicacion")
	private ArrayList<Ubicacion> ubicaciones;

	public ArrayList<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(ArrayList<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public ListaUbicaciones() {}
	
	@Override
	public String toString() {
		String ubicacionesString = "";
		for (Ubicacion ubicacion : this.ubicaciones) {
			ubicacionesString += ubicacion.toString() + "\r\n";
		}
		return ubicacionesString;
	}
	
	
}
