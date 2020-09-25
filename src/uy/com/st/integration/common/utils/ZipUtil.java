package uy.com.st.integration.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtil {
	
	public static String comprimirTexto(String texto) throws IOException{
		 if (texto == null || texto.isEmpty()) { 
             return texto; 
         } 
         System.out.println("String length : " + texto.length()); 
         ByteArrayOutputStream out = new ByteArrayOutputStream(); 
         GZIPOutputStream gzip = new GZIPOutputStream(out); 
         gzip.write(texto.getBytes()); 
         gzip.close(); 
         String outStr = new String(Base64.getEncoder().encode(out.toByteArray()));
         return outStr; 
	}	
	
	public static String descomprimirTexto(String textoComprimido) throws IOException{  
		if (textoComprimido == null || textoComprimido.isEmpty()) { 
            return textoComprimido; 
         } 
         GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(textoComprimido))); 
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         byte[] buffer = new byte[256];
         int n;
         while ((n = gis.read(buffer)) >= 0) {
             out.write(buffer, 0, n);
         }
         String textoDescomprimido = new String(out.toByteArray()); 
         return textoDescomprimido;
	}
	
}
