package uy.com.st.integration.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.client.utils.ConsumoWsUtils;

class ConsumoWsUtilsTest {
	
	@Test
	public void testObtenerDatosDeRespuestaJson() throws IOException {
		String respuestaJson =  "{\"datos\":\"<datos><dato1>sad</dato1><dato2>asd</dato2></datos>\",\"errores\":\"Not\"}";
		String datosRespuestaJson = ConsumoWsUtils.obtenerDatosDeRespuestaJson(respuestaJson);
		datosRespuestaJson = datosRespuestaJson.replace("\\u003c", "<");
		datosRespuestaJson = datosRespuestaJson.replace("\\u003e", ">");
		assertEquals("<datos><dato1>sad</dato1><dato2>asd</dato2></datos>", datosRespuestaJson);		
	}	

	@Test
	public void testObtenerErroresDeRespuestaJson() {
		String respuestaJson =  "{\"datos\":\"<datos><dato1>sad</dato1><dato2>asd</dato2></datos>\",\"errores\":\"Not\"}";
		String erroresRespuestaJson = ConsumoWsUtils.obtenerErroresDeRespuestaJson(respuestaJson);
		assertEquals("Not", erroresRespuestaJson);		
	}

	@Test
	public void testGenerarSolicitudJson() throws IOException {
		String nombreOperacion = "Operacion1";
		String version = "2.1>";
		String parametros = "<id><Tipo>1</id><zona>Centro</zona>";
		String solicitudJson = ConsumoWsUtils.generarSolicitudJson(nombreOperacion, version, parametros);
		solicitudJson = solicitudJson.replace("\\u003c", "<");
		solicitudJson = solicitudJson.replace("\\u003e", ">");
		JsonUtil<Map> ju = new JsonUtil<Map>();
		String parametrosObtenidosDelJson = (String)ju.obtenerValorDentroDeJson(solicitudJson,"parametros");
		assertEquals(parametrosObtenidosDelJson, parametros);
	}
	
}
