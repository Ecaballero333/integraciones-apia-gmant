package uy.com.st.integration.client.ws.axis.general;

public class WsGeneralProxy implements uy.com.st.integration.client.ws.axis.general.WsGeneral {
  private String _endpoint = null;
  private uy.com.st.integration.client.ws.axis.general.WsGeneral wsGeneral = null;
  
  public WsGeneralProxy() {
    _initWsGeneralProxy();
  }
  
  public WsGeneralProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsGeneralProxy();
  }
  
  private void _initWsGeneralProxy() {
    try {
      wsGeneral = (new uy.com.st.integration.client.ws.axis.general.WsGeneralServiceLocator()).getWsGeneral();
      if (wsGeneral != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsGeneral)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsGeneral)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsGeneral != null)
      ((javax.xml.rpc.Stub)wsGeneral)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uy.com.st.integration.client.ws.axis.general.WsGeneral getWsGeneral() {
    if (wsGeneral == null)
      _initWsGeneralProxy();
    return wsGeneral;
  }
  
  public java.lang.String ejecutarOperacion(java.lang.String solicitud) throws java.rmi.RemoteException{
    if (wsGeneral == null)
      _initWsGeneralProxy();
    return wsGeneral.ejecutarOperacion(solicitud);
  }
  
  
}