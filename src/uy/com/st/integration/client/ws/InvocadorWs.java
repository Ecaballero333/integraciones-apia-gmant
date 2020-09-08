package uy.com.st.integration.client.ws;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.ws.axis.*;

public class InvocadorWs {

	private String endpoint;
	private String solicitud;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public InvocadorWs(String endpoint, String solicitud) {
		this.endpoint = endpoint;
		this.solicitud = solicitud;
	}
	
	public String invocarWs() throws MalformedURLException, ServiceException, RemoteException{
		String respuesta = "";
		try{
			WsGeneralServiceLocator localtor = new WsGeneralServiceLocator();
			localtor.setWsGeneralEndpointAddress(endpoint);
			WsGeneral ws = localtor.getWsGeneral();		
			ws.ejecutarOperacion(this.solicitud);
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Error al conectarse con el servicio web");
			throw e;
		}
		if(respuesta == null || respuesta.isEmpty()) {
			LOGGER.log(Level.WARNING, "Respuesta obtenida del servicio web vacía");
		} else {
			LOGGER.log(Level.INFO, "Respuesta obtenida del servicio web: " + respuesta);
		}
		return respuesta;
	}

}
