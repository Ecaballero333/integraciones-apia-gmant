package uy.com.st.integration.test.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CorreoElectronico")
@XmlAccessorType(XmlAccessType.FIELD)
public class CorreoElectronico {
	
	@XmlElement(name = "destino")
	private String correoDestino;
	@XmlElement(name = "asunto")
	private String asunto;
	@XmlElement(name = "texto")
	private String texto;
	
	public CorreoElectronico() {}

	public String getCorreoDestino() {
		return correoDestino;
	}

	public void setCorreoDestino(String correoDestino) {
		this.correoDestino = correoDestino;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
