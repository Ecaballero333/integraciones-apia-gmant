package uy.com.st.integration.test.vo;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Elementos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Elemento {

	@XmlElement(name = "ElementoCodigo")
	private String codigo;

	@XmlElement(name = "ElementoDescripcion")
	private String descripcion;

	@XmlElement(name = "ElementoPadron")
	private String padron;

	@XmlElement(name = "ElementoDireccion")
	private String direccion;

	@XmlElement(name = "ElementoDepartamento")
	private String departamento;

	@XmlElement(name = "ElementoLocalidad")
	private String localidad;

	@XmlElement(name = "ElementoNroLocal")
	private String nroLocal;

	@XmlElement(name = "ElementoMarca")
	private String marca;

	@XmlElement(name = "ElementoModelo")
	private String modelo;

	@XmlElement(name = "ElementoTipoCod")
	private String tipoCod;

	@XmlElement(name = "ElementoNroSerie")
	private String nroSerie;
	
	public Elemento() {}

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

	public String getPadron() {
		return padron;
	}

	public void setPadron(String padron) {
		this.padron = padron;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNroLocal() {
		return nroLocal;
	}

	public void setNroLocal(String nroLocal) {
		this.nroLocal = nroLocal;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoCod() {
		return tipoCod;
	}

	public void setTipoCod(String tipoCod) {
		this.tipoCod = tipoCod;
	}

	public String getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(String nroSerie) {
		this.nroSerie = nroSerie;
	}

	@Override
	public String toString() {
		return "Elemento [codigo=" + codigo + ", descripcion=" + descripcion + ", padron=" + padron
				+ ", direccion=" + direccion + ", departamento=" + departamento + ", localidad=" + localidad
				+ ", nroLocal=" + nroLocal + ", marca=" + marca + ", modelo=" + modelo + ", tipoCod=" + tipoCod
				+ ", nroSerie=" + nroSerie + "]";
	}
	
}
