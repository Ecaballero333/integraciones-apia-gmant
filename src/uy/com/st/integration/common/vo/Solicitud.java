package uy.com.st.integration.common.vo;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
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

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Solicitud [uuid=" + uuid + ", timeStamp=" + timeStamp + ", operacion=" + operacion + ", version="
				+ version + ", parametros=" + (parametros != null ? toString(parametros.entrySet(), maxLen) : null)
				+ "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
