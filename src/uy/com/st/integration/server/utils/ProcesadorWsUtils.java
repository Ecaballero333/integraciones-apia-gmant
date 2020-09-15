package uy.com.st.integration.server.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

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
			return nombreOperacion;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la operación de la solicitudJson");
			throw e;
		}
	}
	
	public static String obtenerVersionOperacionDeSolicitudJson(String solicitudJson) {
		LOGGER.log(Level.INFO, "solicitudJson: " + solicitudJson);
		try {
			Solicitud solicitud = generarObjetoSolicitudDeSolicitudJson(solicitudJson);
			String version = solicitud.getVersion();
			LOGGER.log(Level.INFO, "Versión obtenida: " + version);
			return version;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la versión de operación de la solicitudJson");
			throw e;
		}
	}
	
	public static String obtenerParametrosDeSolicitudJson(String solicitudJson) {
		LOGGER.log(Level.INFO, "solicitudJson: " + solicitudJson);
		try {
			Solicitud solicitud = generarObjetoSolicitudDeSolicitudJson(solicitudJson);
			String parametros = solicitud.getParametros();
			LOGGER.log(Level.INFO, "Parámetros obtenidos: " + parametros);
			return parametros;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener los parametros de la solicitudJson");
			throw e;
		}
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
		try {
			JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
			String respuestaJson = jl.convertirObjetoAJson(respuesta);
			LOGGER.log(Level.INFO, "RespuestaJson generada: " + respuestaJson);
			return respuestaJson;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la respuestaJson");
			throw e;
		}
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
			throw e;
		}
		return solicitud;
	}
}
