package uy.com.st.integration.client.factory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.ws.InvocadorWs;
import uy.com.st.integration.common.logs.IntegracionesLogger;
import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.*;

public class ProcesadorSolicitud {

	private String endpoint;
	private Solicitud solicitud;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public ProcesadorSolicitud(String endpoint, Solicitud solicitud) throws IOException {
		IntegracionesLogger.setup();
		LOGGER.log(Level.INFO, "Endpoint servicio web invocado " + endpoint);
		if(solicitud==null)
			throw new NullPointerException("Solicitud recibida null");
		LOGGER.log(Level.INFO, "Solicitud recibida: " + solicitud.toString());
		this.endpoint = endpoint;
		this.solicitud = solicitud;
	}
	
	public Respuesta invocarWs() throws MalformedURLException, RemoteException, ServiceException{
		Respuesta respuesta = null;
		try {
			String solicitudJson = crearSolicitudJson();
			InvocadorWs invocadorWs = new InvocadorWs(endpoint, solicitudJson);
			String respuestaJson = invocadorWs.invocarWs();
			respuesta = obtenerRespuestaJson(respuestaJson);
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}finally {
			LOGGER.log(Level.INFO, "Fin invocación Web Service " + IntegracionesLogger.getSeparador());
			IntegracionesLogger.liberarArchivoLog();
		}
		return respuesta;	
	}
	
	private String crearSolicitudJson() {
		try {
			JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
			String solicitudJson = jl.convertirObjetoAJson(this.solicitud);	
			LOGGER.log(Level.INFO, "Solicitud Json: " + solicitudJson);
			return solicitudJson;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo convertir Objeto Solicitud a SolicitudJSON");
			throw e;
		}
	}
	
	private static Respuesta obtenerRespuestaJson(String respuestaJson) {
		try {
			JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
			return (Respuesta) jl.convertirJsonAObjeto(respuestaJson, Respuesta.class);	
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo convertir Json a objeto Respuesta");
			throw e;
		}
	}

}
