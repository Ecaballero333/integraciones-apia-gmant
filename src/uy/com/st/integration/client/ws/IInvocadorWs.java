package uy.com.st.integration.client.ws;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public interface IInvocadorWs {
	String invocarWs() throws MalformedURLException, ServiceException, RemoteException;
}
