package uy.com.st.integration.server.factory;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Solicitud;
import uy.com.st.integration.server.factory.IMantenimientoOperaciones;
import uy.com.st.integration.server.factory.Operacion;

public class ProcesadorOperaciones {
	
	private String solicitudJson;
	private IMantenimientoOperaciones mantenimientoOperaciones;
	
	public ProcesadorOperaciones(String unaSolicitudJson, IMantenimientoOperaciones unMantenimientoOperaciones) {
		this.solicitudJson = unaSolicitudJson;
		this.mantenimientoOperaciones = unMantenimientoOperaciones;
	}	

	public String ejecutarOperacion() {
		Solicitud solicitud = obtenerSolicitud(this.solicitudJson);
		Operacion operacion = obtenerOperacion(solicitud.getOperacion());
		operacion.setSolcitud(solicitud);		
		return operacion.ejecutar();
	}
	
	private Operacion obtenerOperacion(String nombreOperacion) {
		return mantenimientoOperaciones.obtenerTodasLasOperaciones().get(nombreOperacion);
	}
	
	private static Solicitud obtenerSolicitud(String solicitudJson) {
		JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
		return (Solicitud) jl.convertirJsonAObjeto(solicitudJson, Solicitud.class);	
	}
	
}
