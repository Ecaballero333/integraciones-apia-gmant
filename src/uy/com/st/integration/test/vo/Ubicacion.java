package uy.com.st.integration.test.vo;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Ubicacion")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ubicacion {

	@XmlElement(name = "Posicion1")
	private String posicion1;
	
	@XmlElement(name = "Posicion2")
	private String posicion2;

	@XmlElement(name = "Posicion3")
	private String posicion3;

	@XmlElement(name = "Posicion4")
	private String posicion4;

	@XmlElement(name = "Posicion5")
	private String posicion5;

	@XmlElement(name = "Posicion6")
	private String posicion6;

	@XmlElement(name = "Posicion7")
	private String posicion7;
	
	public Ubicacion() {}

	public String getPosicion1() {
		return posicion1;
	}

	public void setPosicion1(String posicion1) {
		this.posicion1 = posicion1;
	}

	public String getPosicion2() {
		return posicion2;
	}

	public void setPosicion2(String posicion2) {
		this.posicion2 = posicion2;
	}

	public String getPosicion3() {
		return posicion3;
	}

	public void setPosicion3(String posicion3) {
		this.posicion3 = posicion3;
	}

	public String getPosicion4() {
		return posicion4;
	}

	public void setPosicion4(String posicion4) {
		this.posicion4 = posicion4;
	}

	public String getPosicion5() {
		return posicion5;
	}

	public void setPosicion5(String posicion5) {
		this.posicion5 = posicion5;
	}

	public String getPosicion6() {
		return posicion6;
	}

	public void setPosicion6(String posicion6) {
		this.posicion6 = posicion6;
	}

	public String getPosicion7() {
		return posicion7;
	}

	public void setPosicion7(String posicion7) {
		this.posicion7 = posicion7;
	}

	
	public ArrayList<String> getPosicionesOrdenadas(){
		ArrayList<String> posiciones = new ArrayList<String>();
		if(posicion1!=null && !posicion1.isEmpty()) {
			posiciones.add(posicion1);
		}
		if(posicion2!=null && !posicion2.isEmpty()) {
			posiciones.add(posicion2);
		}
		if(posicion3!=null && !posicion3.isEmpty()) {
			posiciones.add(posicion3);
		}
		if(posicion4!=null && !posicion4.isEmpty()) {
			posiciones.add(posicion4);
		}
		if(posicion5!=null && !posicion5.isEmpty()) {
			posiciones.add(posicion5);
		}
		if(posicion6!=null && !posicion6.isEmpty()) {
			posiciones.add(posicion6);
		}
		if(posicion7!=null && !posicion7.isEmpty()) {
			posiciones.add(posicion7);
		}
		return posiciones;
	}

	@Override
	public String toString() {
		return "Ubicacion [posicion1=" + posicion1 + ", posicion2=" + posicion2 + ", posicion3=" + posicion3
				+ ", posicion4=" + posicion4 + ", posicion5=" + posicion5 + ", posicion6=" + posicion6 + ", posicion7="
				+ posicion7 + "]";
	}

	
	
}
