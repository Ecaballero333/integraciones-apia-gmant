package uy.com.st.integration.client.factory;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import uy.com.st.integration.client.ws.InvocadorWs;
import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.*;

public class ProcesadorSolicitud {

	private String endpoint;
	private Solicitud solicitud;
	
	public ProcesadorSolicitud(String endpoint, Solicitud solicitud) {
		this.endpoint = endpoint;
		this.solicitud = solicitud;
	}
	
	public Respuesta invocarWs() throws MalformedURLException, RemoteException, ServiceException{
		String solicitudJson = crearSolicitudJson();
		InvocadorWs invocadorWs = new InvocadorWs(endpoint, solicitudJson);
		String respuestaJson = invocadorWs.invocarWs();
		return obtenerRespuestaJson(respuestaJson);		
	}
	
	private String crearSolicitudJson() {
		JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
		return jl.convertirObjetoAJson(this.solicitud);	
	}
	
	private static Respuesta obtenerRespuestaJson(String respuestaJson) {

		JsonUtil<Respuesta> jl = new JsonUtil<Respuesta>();
		return (Respuesta) jl.convertirJsonAObjeto(respuestaJson, Respuesta.class);	
	}

}
