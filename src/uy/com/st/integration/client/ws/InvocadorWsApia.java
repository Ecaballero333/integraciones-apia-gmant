package uy.com.st.integration.client.ws;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.ws.axis.apia.ApiaWSInputType;
import uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface;
import uy.com.st.integration.client.ws.axis.apia.ApiaWSInterfaceServiceLocator;
import uy.com.st.integration.client.ws.axis.apia.ExecResultType;

public class InvocadorWsApia implements IInvocadorWs{

	private String endpoint;
	private String solicitudJson;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public InvocadorWsApia(String endpoint, String solicitud) {
		this.endpoint = endpoint;
		this.solicitudJson = solicitud;
	}
	
	public String invocarWs() throws MalformedURLException, ServiceException, RemoteException{
		String respuesta = "";
		try{
			ApiaWSInterfaceServiceLocator localtor = new ApiaWSInterfaceServiceLocator();
			localtor.setApiaWSws_operacionesEndpointAddress(endpoint);
			ApiaWSInterface ws = localtor.getApiaWSws_operaciones();		
			ExecResultType ert = ws.ws_operaciones(new ApiaWSInputType(this.solicitudJson));
			respuesta = ert.getParameters().getRespuestaJson();
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
