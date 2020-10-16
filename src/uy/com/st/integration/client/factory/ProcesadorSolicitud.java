package uy.com.st.integration.client.factory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.utils.ConsumoWsUtils;
import uy.com.st.integration.client.ws.IInvocadorWs;
import uy.com.st.integration.client.ws.InvocadorWsApia;
import uy.com.st.integration.client.ws.InvocadorWsGeneral;
import uy.com.st.integration.client.ws.InvocadorWsGmant;
import uy.com.st.integration.common.logs.IntegracionesLogger;
import uy.com.st.integration.common.vo.Respuesta;
import uy.com.st.integration.common.vo.Solicitud;

public class ProcesadorSolicitud {

	private String endpoint;
	private Solicitud solicitud;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public ProcesadorSolicitud(String endpoint, Solicitud solicitud, String nivelLog, String ubicacionLog) throws IOException {
		IntegracionesLogger.setup(nivelLog, ubicacionLog);
		LOGGER.log(Level.INFO, "Endpoint servicio web invocado " + endpoint);
		if(solicitud==null)
			throw new NullPointerException("Solicitud recibida null");
		LOGGER.log(Level.INFO, "Solicitud recibida: " + solicitud.toString());
		this.endpoint = endpoint;
		this.solicitud = solicitud;
	}
	
	public Respuesta invocarWs(ServicioPublicadoEn servicioPublicadoEn) throws MalformedURLException, RemoteException, ServiceException{
		Respuesta respuesta = null;
		try {
			String solicitudJson = ConsumoWsUtils.getSolicitudJson(solicitud);			
			IInvocadorWs invocadorWs = this.instanciarInvocadorWs(servicioPublicadoEn, solicitudJson);
			String respuestaJson = invocadorWs.invocarWs();
			respuesta = ConsumoWsUtils.generarObjetoRespuestaDeRespuestaJson(respuestaJson);
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}finally {
			LOGGER.log(Level.INFO, "Fin invocación Web Service " + IntegracionesLogger.getSeparador());
			IntegracionesLogger.liberarArchivoLog();
		}
		return respuesta;	
	}

	private IInvocadorWs instanciarInvocadorWs(ServicioPublicadoEn servicioPublicadoEn, String solicitudJson) {
		IInvocadorWs invocadorWs = null;
		switch (servicioPublicadoEn) {			
			case APIA:
				invocadorWs = new InvocadorWsApia(endpoint, solicitudJson);
				break;
			case GMANT:
				invocadorWs = new InvocadorWsGmant(endpoint, solicitudJson);
				break;
			case OTRO:
				invocadorWs = new InvocadorWsGeneral(endpoint, solicitudJson);
				break;
			default:
				break;
		}
		if(servicioPublicadoEn.equals(ServicioPublicadoEn.APIA)) {
			
		} else {
						
		}
		return invocadorWs;
	}
	
	public enum ServicioPublicadoEn
	{
	    APIA, GMANT, OTRO
	}
}

