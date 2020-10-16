/**
 * GmantapiawsExecuteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.st.integration.client.ws.axis.gmant;

public class GmantapiawsExecuteResponse  implements java.io.Serializable {
    private java.lang.String parametro_out;

    public GmantapiawsExecuteResponse() {
    }

    public GmantapiawsExecuteResponse(
           java.lang.String parametro_out) {
           this.parametro_out = parametro_out;
    }


    /**
     * Gets the parametro_out value for this GmantapiawsExecuteResponse.
     * 
     * @return parametro_out
     */
    public java.lang.String getParametro_out() {
        return parametro_out;
    }


    /**
     * Sets the parametro_out value for this GmantapiawsExecuteResponse.
     * 
     * @param parametro_out
     */
    public void setParametro_out(java.lang.String parametro_out) {
        this.parametro_out = parametro_out;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GmantapiawsExecuteResponse)) return false;
        GmantapiawsExecuteResponse other = (GmantapiawsExecuteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parametro_out==null && other.getParametro_out()==null) || 
             (this.parametro_out!=null &&
              this.parametro_out.equals(other.getParametro_out())));
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
        if (getParametro_out() != null) {
            _hashCode += getParametro_out().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GmantapiawsExecuteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("gmant", ">gmantapiaws.ExecuteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametro_out");
        elemField.setXmlName(new javax.xml.namespace.QName("gmant", "Parametro_out"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
