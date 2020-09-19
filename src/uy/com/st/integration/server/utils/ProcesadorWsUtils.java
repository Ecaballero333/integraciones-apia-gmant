package uy.com.st.integration.server.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.logs.IntegracionesLogger;
import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;

public class ProcesadorWsUtils {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static String obtenerNombreOperacionDeSolicitudJson(String solicitudJson) {
		LOGGER.log(Level.INFO, "solicitudJson: " + solicitudJson);
		String nombreOperacion = "";
		try {
			Solicitud solicitud = generarObjetoSolicitudDeSolicitudJson(solicitudJson);
			nombreOperacion = solicitud.getOperacion();
			LOGGER.log(Level.INFO, "Nombre de operación obtenida: " + nombreOperacion);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la operación de la solicitudJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
			nombreOperacion ="ERROR_PROCESAMIENTO_SOLICITUD_JSON";
		}
		return nombreOperacion;
	}
	
	public static String obtenerVersionOperacionDeSolicitudJson(String solicitudJson) {
		LOGGER.log(Level.INFO, "solicitudJson: " + solicitudJson);
		String version = "";
		try {
			Solicitud solicitud = generarObjetoSolicitudDeSolicitudJson(solicitudJson);
			version = solicitud.getVersion();
			LOGGER.log(Level.INFO, "Versión obtenida: " + version);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la versión de operación de la solicitudJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
			version ="ERROR_PROCESAMIENTO_SOLICITUD_JSON";
		}
		return version;
	}
	
	public static String obtenerParametrosDeSolicitudJson(String solicitudJson) {
		LOGGER.log(Level.INFO, "solicitudJson: " + solicitudJson);
		String parametros = "";
		try {
			Solicitud solicitud = generarObjetoSolicitudDeSolicitudJson(solicitudJson);
			parametros = solicitud.getParametros();
			LOGGER.log(Level.INFO, "Parámetros obtenidos: " + parametros);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener los parametros de la solicitudJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
			parametros ="ERROR_PROCESAMIENTO_SOLICITUD_JSON";
		}
		return parametros;
	}

	public static String generarRespuestaJson(String datos, String errores) {
		LOGGER.log(Level.INFO, "Datos de respuesta: " + datos + ", Errores de respuesta: " + errores);
		Respuesta respuesta = new Respuesta();
		respuesta.setDatos(datos);
		respuesta.setErrores(errores);
		String respuestaJson = getRespuestaJson(respuesta);
		return respuestaJson;
	}
	
	public static String getRespuestaJson(Respuesta respuesta) {
		LOGGER.log(Level.INFO, "Respuesta a convertir en Json " + respuesta.toString());
		String respuestaJson = null;
		try {
			JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
			respuestaJson = jl.convertirObjetoAJson(respuesta);
			LOGGER.log(Level.INFO, "RespuestaJson generada: " + respuestaJson);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la respuestaJson");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}
		return respuestaJson;
	}	
	
	public static Solicitud generarObjetoSolicitudDeSolicitudJson(String solicitudJson) {
		LOGGER.log(Level.INFO, "solicitudJson: " + solicitudJson);
		Solicitud solicitud = null;
		try {
			JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
			solicitud = jl.convertirJsonAObjeto(solicitudJson, Solicitud.class);
			LOGGER.log(Level.INFO, "Se obtiene el Objeto solicitud " + solicitud.toString());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo convertir la SolicitudJSON a Objeto Solicitud");
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}
		return solicitud;
	}
}
