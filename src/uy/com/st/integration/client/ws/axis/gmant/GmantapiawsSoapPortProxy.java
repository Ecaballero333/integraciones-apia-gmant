package uy.com.st.integration.client.ws.axis.gmant;

public class GmantapiawsSoapPortProxy implements uy.com.st.integration.client.ws.axis.gmant.GmantapiawsSoapPort {
  private String _endpoint = null;
  private uy.com.st.integration.client.ws.axis.gmant.GmantapiawsSoapPort gmantapiawsSoapPort = null;
  
  public GmantapiawsSoapPortProxy() {
    _initGmantapiawsSoapPortProxy();
  }
  
  public GmantapiawsSoapPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initGmantapiawsSoapPortProxy();
  }
  
  private void _initGmantapiawsSoapPortProxy() {
    try {
      gmantapiawsSoapPort = (new uy.com.st.integration.client.ws.axis.gmant.GmantapiawsLocator()).getgmantapiawsSoapPort();
      if (gmantapiawsSoapPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)gmantapiawsSoapPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)gmantapiawsSoapPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (gmantapiawsSoapPort != null)
      ((javax.xml.rpc.Stub)gmantapiawsSoapPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uy.com.st.integration.client.ws.axis.gmant.GmantapiawsSoapPort getGmantapiawsSoapPort() {
    if (gmantapiawsSoapPort == null)
      _initGmantapiawsSoapPortProxy();
    return gmantapiawsSoapPort;
  }
  
  public uy.com.st.integration.client.ws.axis.gmant.GmantapiawsExecuteResponse execute(uy.com.st.integration.client.ws.axis.gmant.GmantapiawsExecute parameters) throws java.rmi.RemoteException{
    if (gmantapiawsSoapPort == null)
      _initGmantapiawsSoapPortProxy();
    return gmantapiawsSoapPort.execute(parameters);
  }
  
  
}