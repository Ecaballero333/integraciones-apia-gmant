package uy.com.st.integration.client.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;

public class ConsumoWsUtils {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	public static String generarSolicitudJson(String nombreOperacion, String version, String parametros) throws IOException {
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
		try {
			Respuesta respuesta = generarObjetoRespuestaDeRespuestaJson(respuestaJson);
			String datos = respuesta.getDatos();
			LOGGER.log(Level.INFO, "Datos obtenidos de la respuesta: " + datos);
			return datos;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener los datos de la respuestaJson");
			throw e;
		}
	}
	
	public static String obtenerErroresDeRespuestaJson(String respuestaJson) {
		LOGGER.log(Level.INFO, "respuestaJson: " + respuestaJson);
		try {
			Respuesta respuesta = generarObjetoRespuestaDeRespuestaJson(respuestaJson);
			String errores = respuesta.getErrores();
			LOGGER.log(Level.INFO, "Errores obtenidos de la respuesta: " + errores);
			return errores;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener los errores de la respuestaJson");
			throw e;
		}
	}
	
	public static String getSolicitudJson(Solicitud solicitud) {
		LOGGER.log(Level.INFO, "Objeto solicitud: " + solicitud.toString());
		try {
			JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
			String solicitudJson = jl.convertirObjetoAJson(solicitud);	
			LOGGER.log(Level.INFO, "SolicitudJson generada: " + solicitudJson);
			return solicitudJson;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo obtener la solicitudJson");
			throw e;
		}
	}	
	
	public static Respuesta generarObjetoRespuestaDeRespuestaJson(String respuestaJson) {
		LOGGER.log(Level.INFO, "respuestaJson recibida: " + respuestaJson);
		try {
			JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
			Respuesta respuesta = jl.convertirJsonAObjeto(respuestaJson, Respuesta.class);
			LOGGER.log(Level.INFO, "Objeto respuesta generado: " + respuesta.toString());
			return respuesta;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo convertir la respuestaJson a Objeto Respuesta");
			throw e;
		}
	}
}
