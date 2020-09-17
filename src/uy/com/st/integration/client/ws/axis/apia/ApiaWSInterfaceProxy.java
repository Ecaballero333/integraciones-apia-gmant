package uy.com.st.integration.client.ws.axis.apia;

public class ApiaWSInterfaceProxy implements uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface {
  private String _endpoint = null;
  private uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface apiaWSInterface = null;
  
  public ApiaWSInterfaceProxy() {
    _initApiaWSInterfaceProxy();
  }
  
  public ApiaWSInterfaceProxy(String endpoint) {
    _endpoint = endpoint;
    _initApiaWSInterfaceProxy();
  }
  
  private void _initApiaWSInterfaceProxy() {
    try {
      apiaWSInterface = (new uy.com.st.integration.client.ws.axis.apia.ApiaWSInterfaceServiceLocator()).getApiaWSws_operaciones();
      if (apiaWSInterface != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)apiaWSInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)apiaWSInterface)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (apiaWSInterface != null)
      ((javax.xml.rpc.Stub)apiaWSInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uy.com.st.integration.client.ws.axis.apia.ApiaWSInterface getApiaWSInterface() {
    if (apiaWSInterface == null)
      _initApiaWSInterfaceProxy();
    return apiaWSInterface;
  }
  
  public uy.com.st.integration.client.ws.axis.apia.ExecResultType ws_operaciones(uy.com.st.integration.client.ws.axis.apia.ApiaWSInputType apiaWSInput) throws java.rmi.RemoteException{
    if (apiaWSInterface == null)
      _initApiaWSInterfaceProxy();
    return apiaWSInterface.ws_operaciones(apiaWSInput);
  }
  
  
}