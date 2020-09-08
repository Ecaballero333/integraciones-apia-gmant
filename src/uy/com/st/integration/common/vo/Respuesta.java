package uy.com.st.integration.common.vo;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class Respuesta {
	
	private String datos;
	private Map<String,String> errores;
	private UUID uuidSolicitud;
	private long timeStampSolicitud;
	
	public String getDatos() {
		return datos;
	}
	public void setDatos(String datos) {
		this.datos = datos;
	}
	public Map<String, String> getErrores() {
		return errores;
	}
	public void setErrores(Map<String, String> errores) {
		this.errores = errores;
	}
	public UUID getUuidSolicitud() {
		return uuidSolicitud;
	}
	public void setUuidSolicitud(UUID uuidSolicitud) {
		this.uuidSolicitud = uuidSolicitud;
	}
	public long getTimeStampSolicitud() {
		return timeStampSolicitud;
	}
	public void setTimeStampSolicitud(long timeStampSolicitud) {
		this.timeStampSolicitud = timeStampSolicitud;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "Respuesta [datos=" + datos + ", errores="
				+ (errores != null ? toString(errores.entrySet(), maxLen) : null) + ", uuidSolicitud=" + uuidSolicitud
				+ ", timeStampSolicitud=" + timeStampSolicitud + "]";
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
