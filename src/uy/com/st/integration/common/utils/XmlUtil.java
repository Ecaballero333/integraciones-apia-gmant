package uy.com.st.integration.common.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil<T> {
		
    public String convertirObjetoAXML(T objetoXML) throws JAXBException {
    	JAXBContext jaxbContext = JAXBContext.newInstance(objetoXML.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();     
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);        
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(objetoXML,sw);        
        String xml = sw.toString();
        return xml;
	}

	public T convertirXMLAObjeto(String objetoXML, final Class<T> dataClass) {
    	StringReader reader = null;
    	T objeto = null;
    	try {
			JAXBContext jaxbContext = JAXBContext.newInstance(dataClass);  
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			reader = new StringReader(objetoXML);
			objeto = (T) jaxbUnmarshaller.unmarshal(reader);
		}catch(JAXBException ex) {
			ex.printStackTrace();
		} finally {
			reader.close();
		}
		return objeto;
	}
}
