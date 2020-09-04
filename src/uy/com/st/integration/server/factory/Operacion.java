package uy.com.st.integration.server.factory;

import java.util.Map;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;

public abstract class Operacion {
	protected String nombreOperacion;
	protected Solicitud solicitud;
	private Respuesta respuesta;
	
	public Operacion() {
		this.setNombreOperacion();
		this.respuesta = new Respuesta();
	}

	public String getNombreOperacion() {
		return nombreOperacion;
	}
	
	public abstract void setNombreOperacion();
	
	public Solicitud getSolcitud() {
		return this.solicitud;
	}	
	
	public void setSolcitud(Solicitud unaSolicitud) {
		this.solicitud = unaSolicitud;
	}
		
	public Respuesta getRespuesta() {
		return this.respuesta;
	}
	
	public String ejecutar() {
		this.cargarRespuesta();
		return this.obtenerRespuestaJson();
	}

	private void cargarRespuesta() {
		this.respuesta.setTimeStampSolicitud(this.solicitud.getTimeStamp());
		this.respuesta.setUuidSolicitud(this.solicitud.getUuid());
		this.respuesta.setDatos(this.obtenerDatosRespuesta());
		this.respuesta.setErrores(this.obtenerErroresRespuesta());
	}

	protected abstract String obtenerDatosRespuesta();		

	protected abstract Map<String, String> obtenerErroresRespuesta();

	private String obtenerRespuestaJson() {
		JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
		return jl.convertirObjetoAJson(this.respuesta);	
	}
	
}
