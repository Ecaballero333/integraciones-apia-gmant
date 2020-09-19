package uy.com.st.integration.client.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.logs.IntegracionesLogger;
import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;

public class ConsumoWsUtils {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	public static String generarSolicitudJson(String nombreOperacion, String version, String parametros){
		LOGGER.log(Level.INFO, "Nombre operación de la Solicitud: " + nombreOperacion + 
				"versión operación de la Solicitud: " + version + "parámetros de la Solicitud: " + parametros);
		Solicitud solicitud = new Solicitud();
		solicitud.setOperacion(nombreOperacion);
		solicitud.setVersion(version);
		solicitud.setParametros(parametros);
		String solicitudJson = getSolicitudJson(solicitud);
		return solicitudJson;
	}
	
	public static String obtenerDatosDeRespuestaJson(String respuestaJson) {
		LOGGER.log(Level.INFO, "respuestaJson: " + respuestaJson);
		String datos = "";
		try {
			Respuesta respuesta = generarObjetoRespuestaDeRespuestaJson(respuestaJson);
			datos = respuesta.getDatos();
			LOGGER.log(Level.INFO, "Datos obtenidos de la respuesta: " + datos);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener los datos de la respuestaJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
			datos ="ERROR_PROCESAMIENTO_RESPUESTA_JSON";
		}
		return datos;
	}
	
	public static String obtenerErroresDeRespuestaJson(String respuestaJson) {
		LOGGER.log(Level.INFO, "respuestaJson: " + respuestaJson);
		String errores = "";
		try {
			Respuesta respuesta = generarObjetoRespuestaDeRespuestaJson(respuestaJson);
			errores = respuesta.getErrores();
			LOGGER.log(Level.INFO, "Errores obtenidos de la respuesta: " + errores);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener los errores de la respuestaJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
			errores ="ERROR_PROCESAMIENTO_RESPUESTA_JSON";
		}
		return errores;
	}
	
	public static String getSolicitudJson(Solicitud solicitud) {
		LOGGER.log(Level.INFO, "Objeto solicitud: " + solicitud.toString());
		String solicitudJson = null;
		try {
			JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
			solicitudJson = jl.convertirObjetoAJson(solicitud);	
			LOGGER.log(Level.INFO, "SolicitudJson generada: " + solicitudJson);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la solicitudJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}
		return solicitudJson;
	}	
	
	public static Respuesta generarObjetoRespuestaDeRespuestaJson(String respuestaJson) {
		LOGGER.log(Level.INFO, "respuestaJson recibida: " + respuestaJson);
		Respuesta respuesta = null;
		try {
			JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
			respuesta = jl.convertirJsonAObjeto(respuestaJson, Respuesta.class);
			LOGGER.log(Level.INFO, "Objeto respuesta generado: " + respuesta.toString());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo convertir la respuestaJson a Objeto Respuesta");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}
		return respuesta;
	}
}
