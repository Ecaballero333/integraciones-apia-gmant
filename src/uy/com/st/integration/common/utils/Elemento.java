package uy.com.st.integration.common.utils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Elementos")
public class Elemento {
	//https://www.javatpoint.com/jaxb-unmarshalling-example
	private String codigo;
	
	private String descripcion;

	private String padron;

	private String direccion;

	private String departamento;

	private String localidad;

	private String local;

	private String marca;

	private String modelo;

	private String tipoCod;
	
	private String nroSerie;
	
	public Elemento() {}

	@XmlElement(name = "ElementoCodigo")
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@XmlElement(name = "ElementoDescripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@XmlElement(name = "ElementoPadron")
	public String getPadron() {
		return padron;
	}

	public void setPadron(String padron) {
		this.padron = padron;
	}

	@XmlElement(name = "ElementoDireccion")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@XmlElement(name = "ElementoDepartamento")

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@XmlElement(name = "ElementoLocalidad")
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@XmlElement(name = "ElementoNroLocal")
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@XmlElement(name = "ElementoMarca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@XmlElement(name = "ElementoModelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@XmlElement(name = "ElementoTipoCod")
	public String getTipoCod() {
		return tipoCod;
	}

	public void setTipoCod(String tipoCod) {
		this.tipoCod = tipoCod;
	}

	@XmlElement(name = "ElementoNroSerie")
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
				+ ", local=" + local + ", marca=" + marca + ", modelo=" + modelo + ", tipoCod=" + tipoCod
				+ ", nroSerie=" + nroSerie + "]";
	}
	
}
