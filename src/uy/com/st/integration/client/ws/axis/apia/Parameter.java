/**
 * Parameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.st.integration.client.ws.axis.apia;

public class Parameter  implements java.io.Serializable {
    private java.lang.String respuestaJson;

    public Parameter() {
    }

    public Parameter(
           java.lang.String respuestaJson) {
           this.respuestaJson = respuestaJson;
    }


    /**
     * Gets the respuestaJson value for this Parameter.
     * 
     * @return respuestaJson
     */
    public java.lang.String getRespuestaJson() {
        return respuestaJson;
    }


    /**
     * Sets the respuestaJson value for this Parameter.
     * 
     * @param respuestaJson
     */
    public void setRespuestaJson(java.lang.String respuestaJson) {
        this.respuestaJson = respuestaJson;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Parameter)) return false;
        Parameter other = (Parameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.respuestaJson==null && other.getRespuestaJson()==null) || 
             (this.respuestaJson!=null &&
              this.respuestaJson.equals(other.getRespuestaJson())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRespuestaJson() != null) {
            _hashCode += getRespuestaJson().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Parameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.apiasolutions.com/WebServices", "Parameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaJson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.apiasolutions.com/WebServices", "respuestaJson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
