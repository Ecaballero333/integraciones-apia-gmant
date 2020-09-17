/**
 * ApiaWSInterfaceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.st.integration.client.ws.axis.apia;

public class ApiaWSInterfaceServiceLocator extends org.apache.axis.client.Service implements uy.com.st.integration.client.ws.axis.apia.ApiaWSInterfaceService {

    public ApiaWSInterfaceServiceLocator() {
    }


    public ApiaWSInterfaceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ApiaWSInterfaceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ApiaWSws_operaciones
    private java.lang.String ApiaWSws_operaciones_address = "http://apiabroubpms-dev-brouubpms-dev.apps.domst.st.net/Apia/services/ApiaWSws_operaciones";

    public java.lang.String getApiaWSws_operacionesAddress() {
        return ApiaWSws_operaciones_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ApiaWSws_operacionesWSDDServiceName = "ApiaWSws_operaciones";

    public java.lang.String getApiaWSws_operacionesWSDDServiceName() {
        return ApiaWSws_operacionesWSDDServiceName;
    }

    public void setApiaWSws_operacionesWSDDServiceName(java.lang.String name) {
        ApiaWSws_operacionesWSDDServiceName = name;
    }

    public uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface getApiaWSws_operaciones() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ApiaWSws_operaciones_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getApiaWSws_operaciones(endpoint);
    }

    public uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface getApiaWSws_operaciones(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uy.com.st.integration.client.ws.axis.apia.ApiaWSws_operacionesSoapBindingStub _stub = new uy.com.st.integration.client.ws.axis.apia.ApiaWSws_operacionesSoapBindingStub(portAddress, this);
            _stub.setPortName(getApiaWSws_operacionesWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setApiaWSws_operacionesEndpointAddress(java.lang.String address) {
        ApiaWSws_operaciones_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                uy.com.st.integration.client.ws.axis.apia.ApiaWSws_operacionesSoapBindingStub _stub = new uy.com.st.integration.client.ws.axis.apia.ApiaWSws_operacionesSoapBindingStub(new java.net.URL(ApiaWSws_operaciones_address), this);
                _stub.setPortName(getApiaWSws_operacionesWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ApiaWSws_operaciones".equals(inputPortName)) {
            return getApiaWSws_operaciones();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.apiasolutions.com/WebServices", "ApiaWSInterfaceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.apiasolutions.com/WebServices", "ApiaWSws_operaciones"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ApiaWSws_operaciones".equals(portName)) {
            setApiaWSws_operacionesEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
