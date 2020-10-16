package uy.com.st.integration.test.vo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="TiposElementos")
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoElemento {

	@XmlElement(name = "TipoElementoCodigo")
	private String codigo;

	@XmlElement(name = "TipoElementoDescripcion")
	private String descripcion;

	@XmlElement(name = "TipoElementoCategoria")
	private String categoria;
	
	public TipoElemento() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "TipoElemento [codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + "]";
	}
	
}
