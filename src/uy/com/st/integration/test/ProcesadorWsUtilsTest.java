package uy.com.st.integration.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.server.utils.ProcesadorWsUtils;

class ProcesadorWsUtilsTest {

	@Test
	public void testObtenerNombreOperacionDeSolicitudJson() {
		String solicitudJson =  "{\"operacion\":\"Opr1\", \"version\":1.0, \"parametros\":'{\"id\":1,\"region\":\"centro\"}'}";
		String nombreOperacion = ProcesadorWsUtils.obtenerNombreOperacionDeSolicitudJson(solicitudJson);
		assertEquals("Opr1", nombreOperacion);
		
	}
	
	@Test
	public void testObtenerVersionOperacionDeSolicitudJson() {
		String solicitudJson =  "{\"operacion\":\"Opr1\", \"version\":1.0, \"parametros\":'{\"id\":1,\"region\":\"centro\"}'}";
		String versionOperacion = ProcesadorWsUtils.obtenerVersionOperacionDeSolicitudJson(solicitudJson);
		assertEquals("1.0", versionOperacion);
	}
	
	@Test
	public void testObtenerParametrosDeSolicitudJson() {
		String solicitudJson =  "{\"operacion\":\"Opr1\", \"version\":1.0, \"parametros\":'{\"id\":1,\"region\":\"centro\"}'}";
		String parametros = ProcesadorWsUtils.obtenerParametrosDeSolicitudJson(solicitudJson);
		assertEquals("{\"id\":1,\"region\":\"centro\"}", parametros);
	}
	
	@Test
	public void testObtenerRegionParametrosDeSolicitudJson() {
		String solicitudJson =  "{\"operacion\":\"Opr1\", \"version\":1.0, \"parametros\":'{\"id\":1,\"region\":\"centro\"}'}";
		String parametros = ProcesadorWsUtils.obtenerParametrosDeSolicitudJson(solicitudJson);
		JsonUtil<Map> ju = new JsonUtil<Map>();
		String region = (String)ju.obtenerValorDentroDeJson(parametros,"region");
		assertEquals("centro", region);
	}

	@Test
	public void testGenerarRespuestaJson() {
		String datos = "<edificios><Id>1</Id></edificios>";
		String errores = "<errores><Tipo>1</Tipo><Valor>2</Tipo></errores>";
		String respuestaJson = ProcesadorWsUtils.generarRespuestaJson(datos, errores);
		respuestaJson = respuestaJson.replace("\\u003c", "<");
		respuestaJson = respuestaJson.replace("\\u003e", ">");
		String respuestaEsperada = "{\"datos\":\"<edificios><Id>1</Id></edificios>\",\"errores\":\"<errores><Tipo>1</Tipo><Valor>2</Tipo></errores>\",\"timeStampSolicitud\":0}";
		assertEquals(respuestaEsperada, respuestaJson);
	}
	
}
