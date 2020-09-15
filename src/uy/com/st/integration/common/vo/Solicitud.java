package uy.com.st.integration.common.vo;

import java.util.Date;
import java.util.UUID;

public class Solicitud {
	
	private UUID uuid;
	private long timeStamp;
	private String operacion;
	private String version;
	private String parametros;
	
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	@Override
	public String toString() {
		return "Solicitud [uuid=" + uuid + ", timeStamp=" + timeStamp + ", operacion=" + operacion + ", version="
				+ version + ", parametros=" + parametros + "]";
	}	

}
