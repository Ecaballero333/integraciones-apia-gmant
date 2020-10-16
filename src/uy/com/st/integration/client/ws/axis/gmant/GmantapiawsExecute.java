/**
 * GmantapiawsExecute.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.st.integration.client.ws.axis.gmant;

public class GmantapiawsExecute  implements java.io.Serializable {
    private java.lang.String parametro_in;

    public GmantapiawsExecute() {
    }

    public GmantapiawsExecute(
           java.lang.String parametro_in) {
           this.parametro_in = parametro_in;
    }


    /**
     * Gets the parametro_in value for this GmantapiawsExecute.
     * 
     * @return parametro_in
     */
    public java.lang.String getParametro_in() {
        return parametro_in;
    }


    /**
     * Sets the parametro_in value for this GmantapiawsExecute.
     * 
     * @param parametro_in
     */
    public void setParametro_in(java.lang.String parametro_in) {
        this.parametro_in = parametro_in;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GmantapiawsExecute)) return false;
        GmantapiawsExecute other = (GmantapiawsExecute) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parametro_in==null && other.getParametro_in()==null) || 
             (this.parametro_in!=null &&
              this.parametro_in.equals(other.getParametro_in())));
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
        if (getParametro_in() != null) {
            _hashCode += getParametro_in().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GmantapiawsExecute.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("gmant", ">gmantapiaws.Execute"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametro_in");
        elemField.setXmlName(new javax.xml.namespace.QName("gmant", "Parametro_in"));
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
