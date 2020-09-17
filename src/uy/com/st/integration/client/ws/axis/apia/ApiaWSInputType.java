/**
 * ApiaWSInputType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.st.integration.client.ws.axis.apia;

public class ApiaWSInputType  extends uy.com.st.integration.client.ws.axis.apia.AbstractApiaWSInputType  implements java.io.Serializable {
    private java.lang.String b_solicitudJson;

    public ApiaWSInputType() {
    }

    public ApiaWSInputType(
           java.lang.String b_solicitudJson) {
        this.b_solicitudJson = b_solicitudJson;
    }


    /**
     * Gets the b_solicitudJson value for this ApiaWSInputType.
     * 
     * @return b_solicitudJson
     */
    public java.lang.String getB_solicitudJson() {
        return b_solicitudJson;
    }


    /**
     * Sets the b_solicitudJson value for this ApiaWSInputType.
     * 
     * @param b_solicitudJson
     */
    public void setB_solicitudJson(java.lang.String b_solicitudJson) {
        this.b_solicitudJson = b_solicitudJson;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApiaWSInputType)) return false;
        ApiaWSInputType other = (ApiaWSInputType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.b_solicitudJson==null && other.getB_solicitudJson()==null) || 
             (this.b_solicitudJson!=null &&
              this.b_solicitudJson.equals(other.getB_solicitudJson())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getB_solicitudJson() != null) {
            _hashCode += getB_solicitudJson().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApiaWSInputType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.apiasolutions.com/WebServices", "ApiaWSInputType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("b_solicitudJson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.apiasolutions.com/WebServices", "B_solicitudJson"));
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
