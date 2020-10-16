package uy.com.st.integration.server.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;
import uy.com.st.integration.server.utils.ProcesadorWsUtils;

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

	public void cargarRespuesta() {
		String datos = this.obtenerDatosRespuesta();
		this.respuesta.setDatos(datos);
		this.respuesta.setErrores(this.obtenerErroresRespuesta());
		LOGGER.log(Level.INFO, "Objeto Respuesta cargado en la Operacion " + respuesta.toString());
	}

	protected abstract String obtenerDatosRespuesta();		

	protected abstract String obtenerErroresRespuesta();
	
}
