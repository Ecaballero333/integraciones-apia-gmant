package uy.com.st.integration.common.utils;

import java.util.Map;

import com.google.gson.Gson;

public class JsonUtil<T> {

	private Gson gson;
	
	public JsonUtil(){
		gson = new Gson();
	}
	
	public String convertirObjetoAJson(T objeto) {		
		return gson.toJson(objeto);
	}
	
	public T convertirJsonAObjeto(String json,final Class<T> dataClass) {
		return (T) gson.fromJson(json, dataClass);
	}
	
	public Object obtenerValorDentroDeJson(String textoJson, String claveABuscar) {
		JsonUtil<Map> ju = new JsonUtil<Map>();
		Map<String,String> map = ju.convertirJsonAObjeto(textoJson, Map.class);
		Object valor = map.get(claveABuscar);
		return valor;
	}
}
