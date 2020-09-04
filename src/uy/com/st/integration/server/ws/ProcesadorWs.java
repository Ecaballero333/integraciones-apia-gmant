package uy.com.st.integration.server.ws;

import uy.com.st.integration.server.factory.IMantenimientoOperaciones;
import uy.com.st.integration.server.factory.ProcesadorOperaciones;

public class ProcesadorWs {
	
	private IMantenimientoOperaciones mantenimientoOperaciones;
	
	public ProcesadorWs(IMantenimientoOperaciones unMantenimientoOperaciones) {
		this.mantenimientoOperaciones = unMantenimientoOperaciones;
	}
	
	public String procesar(String solicitudJson) {
		ProcesadorOperaciones creadorOperacionesLogic = new ProcesadorOperaciones(solicitudJson, mantenimientoOperaciones);
		return creadorOperacionesLogic.ejecutarOperacion();
	}
	
}
