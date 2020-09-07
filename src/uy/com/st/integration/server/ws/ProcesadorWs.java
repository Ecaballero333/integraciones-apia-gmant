package uy.com.st.integration.server.ws;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import uy.com.st.integration.common.logs.IntegracionesLogger;
import uy.com.st.integration.server.factory.IMantenimientoOperaciones;
import uy.com.st.integration.server.factory.ProcesadorOperaciones;

public class ProcesadorWs {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private IMantenimientoOperaciones mantenimientoOperaciones;
	
	public ProcesadorWs(IMantenimientoOperaciones unMantenimientoOperaciones) throws IOException {		
		this.mantenimientoOperaciones = unMantenimientoOperaciones;
		IntegracionesLogger.setup();
	}
	
	public String procesar(String solicitudJson) {
		String respuesta = "";
		LOGGER.log(Level.INFO, "SolicitudJson recibida: " + solicitudJson);
		try {
			ProcesadorOperaciones creadorOperacionesLogic = new ProcesadorOperaciones(solicitudJson, mantenimientoOperaciones);			
			respuesta = creadorOperacionesLogic.ejecutarOperacion();
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			LOGGER.log(Level.SEVERE, IntegracionesLogger.getStackTrace(e));
		}finally {
			LOGGER.log(Level.INFO, "Fin Solicitud " + IntegracionesLogger.getSeparador());
		}
		LOGGER.log(Level.INFO, "respuesta: " + respuesta);
		return respuesta;
	}
	
}
