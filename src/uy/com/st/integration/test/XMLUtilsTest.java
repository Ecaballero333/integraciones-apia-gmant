package uy.com.st.integration.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.Test;

import uy.com.st.integration.common.utils.JsonUtil;
import uy.com.st.integration.common.utils.XmlUtil;
import uy.com.st.integration.test.vo.Elemento;
import uy.com.st.integration.test.vo.GmantElementos;
import uy.com.st.integration.client.utils.ConsumoWsUtils;

class XMLUtilsTest {
	
	@Test
	public void convertirXMLAObjeto() throws IOException {
		String elementosXML = this.getXmlElementos();
		XmlUtil<GmantElementos> xmlutil = new XmlUtil<GmantElementos>();
		GmantElementos ge = xmlutil.convertirXMLAObjeto(elementosXML, GmantElementos.class);
		assertEquals(7, ge.getElementos().size());	
	}
	
	@Test
	public void convertirObjeoAXML() throws IOException, JAXBException {
		XmlUtil<GmantElementos> xmlutil = new XmlUtil<GmantElementos>();
		GmantElementos gmantElementos = new GmantElementos();
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
		Elemento e4 = new Elemento();
		e4.setCodigo("DDD");
		e4.setDepartamento("Dep 4");
		e4.setDescripcion("Descripcion 4");
		Elemento e5 = new Elemento();
		e5.setCodigo("EEE");	
		e5.setDepartamento("Dep 5");
		e5.setDescripcion("Descripcion 5");	
		elementos.add(e1);
		elementos.add(e2);
		elementos.add(e3);
		elementos.add(e4);
		elementos.add(e5);		
		gmantElementos.setElementos(elementos);	

		String resultado = xmlutil.convertirObjeoAXML(gmantElementos);
		String resultadoEsperado = this.getXmlElementosEsperado();
		assertEquals(resultadoEsperado, resultado);	
	}

	private String getXmlElementosEsperado() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + 
				"<G-Mant>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>AAA</ElementoCodigo>" + 
				"        <ElementoDepartamento>Dep 1</ElementoDepartamento>" + 
				"        <ElementoDescripcion>Descripcion 1</ElementoDescripcion>" + 
				"    </Elementos>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>BBB</ElementoCodigo>" + 
				"        <ElementoDepartamento>Dep 2</ElementoDepartamento>" + 
				"        <ElementoDescripcion>Descripcion 2</ElementoDescripcion>" + 
				"    </Elementos>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>CCC</ElementoCodigo>" + 
				"        <ElementoDepartamento>Dep 3</ElementoDepartamento>" + 
				"        <ElementoDescripcion>Descripcion 3</ElementoDescripcion>" + 
				"    </Elementos>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>DDD</ElementoCodigo>" + 
				"        <ElementoDepartamento>Dep 4</ElementoDepartamento>" + 
				"        <ElementoDescripcion>Descripcion 4</ElementoDescripcion>" + 
				"    </Elementos>" + 
				"    <Elementos>" + 
				"        <ElementoCodigo>EEE</ElementoCodigo>" + 
				"        <ElementoDepartamento>Dep 5</ElementoDepartamento>" + 
				"        <ElementoDescripcion>Descripcion 5</ElementoDescripcion>" + 
				"    </Elementos>" + 
				"</G-Mant>";
	}

	private String getXmlElementos() {
		return "<G-Mant>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000001</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA MADERA</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000002</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA MADERA</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000003</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA MADERA</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000004</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA MADERA</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000005</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA CF</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000006</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA ALUMINIO</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"	<Elementos>" + 
				"		<ElementoCodigo>ABE0000007</ElementoCodigo>" + 
				"		<ElementoDescripcion>PUERTA HIERRO</ElementoDescripcion>" + 
				"		<ElementoPadron/>" + 
				"		<ElementoDireccion/>" + 
				"		<ElementoDepartamento/>" + 
				"		<ElementoLocalidad/>" + 
				"		<ElementoNroLocal/>" + 
				"		<ElementoMarca>Sin Definir</ElementoMarca>" + 
				"		<ElementoModelo>Sin Definir</ElementoModelo>" + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod>" + 
				"		<ElementoNroSerie/>" + 
				"	</Elementos>" + 
				"</G-Mant>";		
	}		
}
