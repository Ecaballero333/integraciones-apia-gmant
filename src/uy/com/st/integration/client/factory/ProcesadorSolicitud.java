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
	
	/**
	 * 
	 * @param servicioPublicadoEnApia: true indica que el servicio que se va a invocar está publicado en Apia, false indica que el servicio que se va a invocar es el general
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws ServiceException
	 */
	public Respuesta invocarWs(boolean servicioPublicadoEnApia) throws MalformedURLException, RemoteException, ServiceException{
		Respuesta respuesta = null;
		try {
			String solicitudJson = ConsumoWsUtils.getSolicitudJson(solicitud);			
			IInvocadorWs invocadorWs = this.instanciarInvocadorWs(servicioPublicadoEnApia, solicitudJson);
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

	private IInvocadorWs instanciarInvocadorWs(boolean servicioPublicadoEnApia, String solicitudJson) {
		IInvocadorWs invocadorWs = null;
		if(servicioPublicadoEnApia) {
			invocadorWs = new InvocadorWsApia(endpoint, solicitudJson);
		} else {
			invocadorWs = new InvocadorWsGeneral(endpoint, solicitudJson);			
		}
		return invocadorWs;
	}
}
