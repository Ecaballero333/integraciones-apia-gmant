/**
 * WsGeneralServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.st.integration.client.ws.axis.general;

public class WsGeneralServiceLocator extends org.apache.axis.client.Service implements uy.com.st.integration.client.ws.axis.general.WsGeneralService {

    public WsGeneralServiceLocator() {
    }


    public WsGeneralServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsGeneralServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WsGeneral
    private java.lang.String WsGeneral_address = "http://localhost:8081/ServiciosOperaciones/services/WsGeneral";

    public java.lang.String getWsGeneralAddress() {
        return WsGeneral_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WsGeneralWSDDServiceName = "WsGeneral";

    public java.lang.String getWsGeneralWSDDServiceName() {
        return WsGeneralWSDDServiceName;
    }

    public void setWsGeneralWSDDServiceName(java.lang.String name) {
        WsGeneralWSDDServiceName = name;
    }

    public uy.com.st.integration.client.ws.axis.general.WsGeneral getWsGeneral() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsGeneral_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsGeneral(endpoint);
    }

    public uy.com.st.integration.client.ws.axis.general.WsGeneral getWsGeneral(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uy.com.st.integration.client.ws.axis.general.WsGeneralSoapBindingStub _stub = new uy.com.st.integration.client.ws.axis.general.WsGeneralSoapBindingStub(portAddress, this);
            _stub.setPortName(getWsGeneralWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWsGeneralEndpointAddress(java.lang.String address) {
        WsGeneral_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uy.com.st.integration.client.ws.axis.general.WsGeneral.class.isAssignableFrom(serviceEndpointInterface)) {
                uy.com.st.integration.client.ws.axis.general.WsGeneralSoapBindingStub _stub = new uy.com.st.integration.client.ws.axis.general.WsGeneralSoapBindingStub(new java.net.URL(WsGeneral_address), this);
                _stub.setPortName(getWsGeneralWSDDServiceName());
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
        if ("WsGeneral".equals(inputPortName)) {
            return getWsGeneral();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.integration.st.com.uy", "WsGeneralService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.integration.st.com.uy", "WsGeneral"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WsGeneral".equals(portName)) {
            setWsGeneralEndpointAddress(address);
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
