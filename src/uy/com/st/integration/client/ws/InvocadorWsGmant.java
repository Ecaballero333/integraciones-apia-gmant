package uy.com.st.integration.client.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.ws.axis.gmant.*;

public class InvocadorWsGmant implements IInvocadorWs{

	private String endpoint;
	private String solicitudJson;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public InvocadorWsGmant(String endpoint, String solicitud) {
		this.endpoint = endpoint;
		this.solicitudJson = solicitud;
	}
	
	public String invocarWs() throws MalformedURLException, ServiceException, RemoteException{
		String respuesta = "";
		try{
			GmantapiawsExecute parameters = new GmantapiawsExecute();
			parameters.setParametro_in(this.solicitudJson);
			URL url = new URL(endpoint);
			GmantapiawsLocator locator = new GmantapiawsLocator();
			GmantapiawsSoapPort port = locator.getgmantapiawsSoapPort(url);
			GmantapiawsExecuteResponse response = port.execute(parameters);
			respuesta = response.getParametro_out();
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
