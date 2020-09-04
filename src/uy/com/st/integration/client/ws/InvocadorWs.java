package uy.com.st.integration.client.ws;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.ws.axis.*;

public class InvocadorWs {

	private String endpoint;
	private String solicitud;
	
	public InvocadorWs(String endpoint, String solicitud) {
		this.endpoint = endpoint;
		this.solicitud = solicitud;
	}
	
	public String invocarWs() throws MalformedURLException, ServiceException, RemoteException{
		WsGeneralServiceLocator localtor = new WsGeneralServiceLocator();
		localtor.setWsGeneralEndpointAddress(endpoint);
		WsGeneral ws = localtor.getWsGeneral();
		String respuesta = ws.ejecutarOperacion(this.solicitud);
		return respuesta;
	}

}
