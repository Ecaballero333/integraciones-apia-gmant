package uy.com.st.integration.server.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.logs.IntegracionesLogger;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;
import uy.com.st.integration.server.utils.ProcesadorWsUtils;

public class ProcesadorOperaciones {
	
	private String solicitudJson;
	private IMantenimientoOperaciones mantenimientoOperaciones;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public ProcesadorOperaciones(String unaSolicitudJson, IMantenimientoOperaciones unMantenimientoOperaciones) {
		this.solicitudJson = unaSolicitudJson;
		this.mantenimientoOperaciones = unMantenimientoOperaciones;
	}	

	public String ejecutarOperacion() {
		Respuesta respuesta = new Respuesta();
		Solicitud solicitud = ProcesadorWsUtils.generarObjetoSolicitudDeSolicitudJson(this.solicitudJson);
		try {	
			this.validarSolicitud(solicitud);
			Operacion operacion = obtenerOperacion(solicitud.getOperacion(), solicitud.getVersion());
			operacion.setSolcitud(solicitud);		
			operacion.cargarRespuesta();
			respuesta = operacion.getRespuesta();
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
			respuesta.setErrores(e.getMessage());
		}
		String respuestaJson = this.generarRespuestaJson(solicitud, respuesta);
		return respuestaJson;
	}
	
	private String generarRespuestaJson(Solicitud solicitud, Respuesta respuesta) {
		if(solicitud != null) {
			respuesta.setTimeStampSolicitud(solicitud.getTimeStamp());
			respuesta.setUuidSolicitud(solicitud.getUuid());
		}
		String respuestaJson = ProcesadorWsUtils.getRespuestaJson(respuesta);
		return respuestaJson;		
	}

	private void validarSolicitud(Solicitud solicitud) {
		if(solicitud == null) 
			throw new NullPointerException("Error: No se pudo convertir la SolicitudJSON a Objeto Solicitud");
		if(solicitud.getOperacion() == null || solicitud.getOperacion().isEmpty()) {
			throw new NullPointerException("Error: No se recibió nombre de operación");
		}
		if(solicitud.getVersion() == null || solicitud.getVersion().isEmpty()) {
			throw new NullPointerException("Error: No se recibió versión de operación");
		}
	}

	private Operacion obtenerOperacion(String nombreOperacion, String versionOperacion) {
		LOGGER.log(Level.INFO, "nombreOperacion: " + nombreOperacion);
		LOGGER.log(Level.INFO, "versionOperacion: " + versionOperacion);		
		String operacionYVersion = nombreOperacion + ":" + versionOperacion;
		Operacion operacion = mantenimientoOperaciones.obtenerTodasLasOperaciones().get(operacionYVersion);
		if(operacion == null) {
			throw new NullPointerException("Error: No se pudo obtener la operación con nombre:versión: " + operacionYVersion);
		}
		return operacion;
	}
	
}
