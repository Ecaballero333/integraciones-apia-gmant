package uy.com.st.integration.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.Test;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.utils.XmlUtil;
import uy.com.st.integration.test.vo.CorreoElectronico;
import uy.com.st.integration.test.vo.Elemento;
import uy.com.st.integration.test.vo.ListaElementos;
import uy.com.st.integration.client.utils.ConsumoWsUtils;

class XMLUtilsTest {
	
	@Test
	public void correoElectronicoAXml() throws IOException, JAXBException {
		CorreoElectronico ce = new CorreoElectronico();
		ce.setAsunto("Asunto");
		ce.setCorreoDestino("eduardocaballero333@gmail.com");
		ce.setTexto("Texto del mensaje");
		XmlUtil<CorreoElectronico> xmlutil = new XmlUtil<CorreoElectronico>();
		String correoXML = xmlutil.convertirObjetoAXML(ce);
		String esperado = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + 
				"<CorreoElectronico>" + 
				"    <correo-destino>eduardocaballero333@gmail.com</correo-destino>" + 
				"    <asunto>Asunto</asunto>" + 
				"    <texto>Texto del mensaje</texto>" + 
				"</CorreoElectronico>";
		assertEquals("","");	
	}
	
	@Test
	public void convertirXMLAObjeto() throws IOException {
		String elementosXML = this.getXmlElementos();
		XmlUtil<ListaElementos> xmlutil = new XmlUtil<ListaElementos>();
		ListaElementos ge = xmlutil.convertirXMLAObjeto(elementosXML, ListaElementos.class);
		assertEquals(3, ge.getElementos().size());	
	}
	
	@Test
	public void convertirObjeoAXML() throws IOException, JAXBException {
		XmlUtil<ListaElementos> xmlutil = new XmlUtil<ListaElementos>();
		ListaElementos gmantElementos = new ListaElementos();
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		Elemento e1 = new Elemento();
		e1.setCodigo("AAA");
		e1.setDepartamento("Dep 1");
		e1.setDescripcion("Descripcion 1");
		Elemento e2 = new Elemento();
		e2.setCodigo("BBB");
		e2.setDepartamento("Dep 2");
		e2.setDescripcion("Descripcion 2");
		Elemento e3 = new Elemento();
		e3.setCodigo("CCC");
		e3.setDepartamento("Dep 3");
		e3.setDescripcion("Descripcion 3");
		elementos.add(e1);
		elementos.add(e2);
		elementos.add(e3);
		gmantElementos.setElementos(elementos);	

		String resultado = xmlutil.convertirObjetoAXML(gmantElementos);
		String resultadoEsperado = this.getXmlElementosEsperado();
		assertEquals(resultadoEsperado, resultado);	
	}

	private String getXmlElementosEsperado() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + 
				"<G-Mant>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>AAA</ElementoCodigo>" + 
				"        <ElementoDescripcion>Descripcion 1</ElementoDescripcion>" + 
				"        <ElementoDepartamento>Dep 1</ElementoDepartamento>" + 
				"    </Elementos>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>BBB</ElementoCodigo>" + 
				"        <ElementoDescripcion>Descripcion 2</ElementoDescripcion>" + 
				"        <ElementoDepartamento>Dep 2</ElementoDepartamento>" + 
				"    </Elementos>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>CCC</ElementoCodigo>" + 
				"        <ElementoDescripcion>Descripcion 3</ElementoDescripcion>" + 
				"        <ElementoDepartamento>Dep 3</ElementoDepartamento>" + 
				"    </Elementos>" + 
				"</G-Mant>";
	}

	private String getXmlElementos() {
		return "<G-Mant><Elementos>" + 
				"	<ElementoCodigo>BO-000001</ElementoCodigo>" + 
				"	<ElementoDescripcion>BOMBA 000001</ElementoDescripcion>" + 
				"	<ElementoPadron/>" + 
				"	<ElementoDireccion/>" + 
				"	<ElementoDepartamento/>" + 
				"	<ElementoLocalidad/>" + 
				"	<ElementoNroLocal/>" + 
				"	<ElementoMarca/>" + 
				"	<ElementoModelo/>" + 
				"	<ElementoTipoCod>BO</ElementoTipoCod>" + 
				"	<ElementoNroSerie/>" + 
				"</Elementos>" + 
				"<Elementos>" + 
				"	<ElementoCodigo>BO-000002</ElementoCodigo>" + 
				"	<ElementoDescripcion>BOMBA 000002</ElementoDescripcion>" + 
				"	<ElementoPadron/>" + 
				"	<ElementoDireccion/>" + 
				"	<ElementoDepartamento/>" + 
				"	<ElementoLocalidad/>" + 
				"	<ElementoNroLocal/>" + 
				"	<ElementoMarca/>" + 
				"	<ElementoModelo/>" + 
				"	<ElementoTipoCod>BO</ElementoTipoCod>" + 
				"	<ElementoNroSerie/>" + 
				"</Elementos>" + 
				"<Elementos>" + 
				"	<ElementoCodigo>BR01</ElementoCodigo>" + 
				"	<ElementoDescripcion>EDIFICIO UNO</ElementoDescripcion>" + 
				"	<ElementoPadron/>" + 
				"	<ElementoDireccion/>" + 
				"	<ElementoDepartamento/>" + 
				"	<ElementoLocalidad/>" + 
				"	<ElementoNroLocal/>" + 
				"	<ElementoMarca/>" + 
				"	<ElementoModelo/>" + 
				"	<ElementoTipoCod>ED</ElementoTipoCod>" + 
				"	<ElementoNroSerie/>" + 
				"</Elementos></G-Mant>";		
	}		
}
