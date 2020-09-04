package uy.com.st.integration.server.factory;

import java.util.Map;

import uy.com.st.integration.server.factory.Operacion;

public interface IMantenimientoOperaciones {
	void registrarOperaciones();
	Map<String, Operacion> obtenerTodasLasOperaciones();
}
