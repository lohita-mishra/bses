/**
 * GetfeedernameResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class GetfeedernameResponse  implements java.io.Serializable {
    private com.bses.sap.ws.GetfeedernameResponseGetfeedernameResult getfeedernameResult;

    public GetfeedernameResponse() {
    }

    public GetfeedernameResponse(
           com.bses.sap.ws.GetfeedernameResponseGetfeedernameResult getfeedernameResult) {
           this.getfeedernameResult = getfeedernameResult;
    }


    /**
     * Gets the getfeedernameResult value for this GetfeedernameResponse.
     * 
     * @return getfeedernameResult
     */
    public com.bses.sap.ws.GetfeedernameResponseGetfeedernameResult getGetfeedernameResult() {
        return getfeedernameResult;
    }


    /**
     * Sets the getfeedernameResult value for this GetfeedernameResponse.
     * 
     * @param getfeedernameResult
     */
    public void setGetfeedernameResult(com.bses.sap.ws.GetfeedernameResponseGetfeedernameResult getfeedernameResult) {
        this.getfeedernameResult = getfeedernameResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetfeedernameResponse)) return false;
        GetfeedernameResponse other = (GetfeedernameResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getfeedernameResult==null && other.getGetfeedernameResult()==null) || 
             (this.getfeedernameResult!=null &&
              this.getfeedernameResult.equals(other.getGetfeedernameResult())));
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
        if (getGetfeedernameResult() != null) {
            _hashCode += getGetfeedernameResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetfeedernameResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getfeedernameResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getfeedernameResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getfeedernameResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>getfeedernameResponse>getfeedernameResult"));
        elemField.setMinOccurs(0);
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
