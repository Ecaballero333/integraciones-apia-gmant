package uy.com.st.integration.server.factory;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;

public abstract class Operacion {
	protected String nombreOperacion;
	protected Solicitud solicitud;
	private Respuesta respuesta;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
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
		String datos = this.obtenerDatosRespuesta();
		if(datos == null || datos.isEmpty()) {
			throw new NullPointerException("No se cargaron datos para la respuesta en la implementación de la operación");
		}
		this.respuesta.setDatos(datos);
		this.respuesta.setErrores(this.obtenerErroresRespuesta());
		LOGGER.log(Level.INFO, "Objeto Respuesta cargado en la Operacion " + respuesta.toString());
	}

	protected abstract String obtenerDatosRespuesta();		

	protected abstract Map<String, String> obtenerErroresRespuesta();

	private String obtenerRespuestaJson() {
		JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
		return jl.convertirObjetoAJson(this.respuesta);	
	}
	
}
