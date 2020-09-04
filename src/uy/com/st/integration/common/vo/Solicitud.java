package uy.com.st.integration.common.vo;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Solicitud {
	
	private UUID uuid;
	private long timeStamp;
	private String operacion;
	private Double version;
	private Map<String,String> parametros;
	
	public Solicitud() {
		this.uuid = UUID.randomUUID();
		this.timeStamp = new Date().getTime();
	}	
	
	public UUID getUuid() {
		return uuid;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double version) {
		this.version = version;
	}
	public Map<String,String> getParametros() {
		return parametros;
	}
	public void setParametros(Map<String,String> parametros) {
		this.parametros = parametros;
	}

}
