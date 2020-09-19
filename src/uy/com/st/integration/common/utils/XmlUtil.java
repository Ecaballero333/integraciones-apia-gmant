package uy.com.st.integration.common.utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.rpc.ServiceException;

public class XmlUtil<T> {
	//https://howtodoinjava.com/java/serialization/xmlencoder-and-xmldecoder-example/
	public static void main(String[] args) throws ServiceException {
		/*Empleado e1 = new Empleado("Juan Perez",50,new Date());
		Empleado e2 = new Empleado("Eduardo Caballero",30,new Date(1990,01,26));
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(e1);
		empleados.add(e2);		
		Empresa empresa = new Empresa("St Consultores", empleados);
		XmlUtil<Empresa> xmlutil = new XmlUtil<Empresa>();
		String xml = xmlutil.convertirObjeoAXML(empresa);
		System.out.println(xml);
		Empresa empresaResult = xmlutil.convertirXMLAObjeto(xml);
		System.out.println("empresaResult.toString " + empresaResult.toString());
		for (Empleado empleado : empresaResult.getEmpleados()) {
			System.out.println(empleado.toString());
		}	*/	
		
		String elementosXML = "<Elementos> " + 
				"		<ElementoCodigo>ABE0000001</ElementoCodigo> " + 
				"		<ElementoDescripcion>PUERTA MADERA</ElementoDescripcion> " + 
				"		<ElementoPadron/> " + 
				"		<ElementoDireccion/> " + 
				"		<ElementoDepartamento/> " + 
				"		<ElementoLocalidad/> " + 
				"		<ElementoNroLocal/> " + 
				"		<ElementoMarca>Sin Definir</ElementoMarca> " + 
				"		<ElementoModelo>Sin Definir</ElementoModelo> " + 
				"		<ElementoTipoCod>ABE</ElementoTipoCod> " + 
				"		<ElementoNroSerie/> " + 
				"	</Elementos>";		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Elemento.class);  
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(elementosXML);
			Elemento e = (Elemento) jaxbUnmarshaller.unmarshal(reader);
			reader.close();
			System.out.println(e);
		}catch(JAXBException ex) {
			ex.printStackTrace();
		}
	}
	
    public String convertirObjeoAXML(T objetoXML) {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    XMLEncoder xmlEncoder = new XMLEncoder(baos);
	    xmlEncoder.writeObject(objetoXML);
	    xmlEncoder.close();
	    return new String(baos.toByteArray());
	}

    public T convertirXMLAObjeto(String objetoXML) {
	    XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(objetoXML.getBytes()));
	    T obj = (T) xmlDecoder.readObject();
	    xmlDecoder.close();
	    return obj;
	}
}
