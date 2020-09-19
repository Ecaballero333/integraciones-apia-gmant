package uy.com.st.integration.server.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.vo.Solicitud;
import uy.com.st.integration.server.utils.ProcesadorWsUtils;

public class ProcesadorOperaciones {
	
	private String solicitudJson;
	private IMantenimientoOperaciones mantenimientoOperaciones;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public ProcesadorOperaciones(String unaSolicitudJson, IMantenimientoOperaciones unMantenimientoOperaciones) {
		this.solicitudJson = unaSolicitudJson;
		this.mantenimientoOperaciones = unMantenimientoOperaciones;
	}	

	public String ejecutarOperacion() {
		Solicitud solicitud = ProcesadorWsUtils.generarObjetoSolicitudDeSolicitudJson(this.solicitudJson);	
		if(solicitud == null) 
			throw new NullPointerException("No se pudo convertir la SolicitudJSON a Objeto Solicitud");
		Operacion operacion = obtenerOperacion(solicitud.getOperacion());
		operacion.setSolcitud(solicitud);		
		return operacion.ejecutar();
	}
	
	private Operacion obtenerOperacion(String nombreOperacion) {
		LOGGER.log(Level.INFO, "nombreOperacion: " + nombreOperacion);
		if(nombreOperacion == null || nombreOperacion.isEmpty()) {
			throw new NullPointerException("No se recibió nombre de operación");
		}
		Operacion operacion = mantenimientoOperaciones.obtenerTodasLasOperaciones().get(nombreOperacion);
		if(operacion == null) {
			throw new NullPointerException("No se pudo obtener la operación con nombre: " + nombreOperacion);
		}
		return operacion;
	}
	
}
