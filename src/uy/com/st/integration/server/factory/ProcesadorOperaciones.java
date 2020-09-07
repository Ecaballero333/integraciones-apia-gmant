package uy.com.st.integration.server.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.vo.Solicitud;

public class ProcesadorOperaciones {
	
	private String solicitudJson;
	private IMantenimientoOperaciones mantenimientoOperaciones;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
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
		if(nombreOperacion == null || nombreOperacion.isEmpty()) {
			throw new NullPointerException("No se recibió nombre de operación");
		}
		Operacion operacion = mantenimientoOperaciones.obtenerTodasLasOperaciones().get(nombreOperacion);
		if(operacion == null) {
			throw new NullPointerException("No se pudo obtener la operación con nombre: " + nombreOperacion);
		}
		return operacion;
	}
	
	private static Solicitud obtenerSolicitud(String solicitudJson) {
		Solicitud solicitud = null;
		try {
			JsonUtil<Solicitud> jl = new JsonUtil<Solicitud>();
			solicitud = jl.convertirJsonAObjeto(solicitudJson, Solicitud.class);
			LOGGER.log(Level.INFO, "Se obtiene Objeto solicitud " + solicitud.toString());
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "No se pudo convertir SoicitudJSON a Objeto Solicitud");
			throw e;
		}
		return solicitud;
	}
	
}
