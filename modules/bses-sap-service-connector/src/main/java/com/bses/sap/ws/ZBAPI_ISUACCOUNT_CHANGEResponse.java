/**
 * ZBAPI_ISUACCOUNT_CHANGEResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class ZBAPI_ISUACCOUNT_CHANGEResponse  implements java.io.Serializable {
    private com.bses.sap.ws.ZBAPI_ISUACCOUNT_CHANGEResponseZBAPI_ISUACCOUNT_CHANGEResult ZBAPI_ISUACCOUNT_CHANGEResult;

    public ZBAPI_ISUACCOUNT_CHANGEResponse() {
    }

    public ZBAPI_ISUACCOUNT_CHANGEResponse(
           com.bses.sap.ws.ZBAPI_ISUACCOUNT_CHANGEResponseZBAPI_ISUACCOUNT_CHANGEResult ZBAPI_ISUACCOUNT_CHANGEResult) {
           this.ZBAPI_ISUACCOUNT_CHANGEResult = ZBAPI_ISUACCOUNT_CHANGEResult;
    }


    /**
     * Gets the ZBAPI_ISUACCOUNT_CHANGEResult value for this ZBAPI_ISUACCOUNT_CHANGEResponse.
     * 
     * @return ZBAPI_ISUACCOUNT_CHANGEResult
     */
    public com.bses.sap.ws.ZBAPI_ISUACCOUNT_CHANGEResponseZBAPI_ISUACCOUNT_CHANGEResult getZBAPI_ISUACCOUNT_CHANGEResult() {
        return ZBAPI_ISUACCOUNT_CHANGEResult;
    }


    /**
     * Sets the ZBAPI_ISUACCOUNT_CHANGEResult value for this ZBAPI_ISUACCOUNT_CHANGEResponse.
     * 
     * @param ZBAPI_ISUACCOUNT_CHANGEResult
     */
    public void setZBAPI_ISUACCOUNT_CHANGEResult(com.bses.sap.ws.ZBAPI_ISUACCOUNT_CHANGEResponseZBAPI_ISUACCOUNT_CHANGEResult ZBAPI_ISUACCOUNT_CHANGEResult) {
        this.ZBAPI_ISUACCOUNT_CHANGEResult = ZBAPI_ISUACCOUNT_CHANGEResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZBAPI_ISUACCOUNT_CHANGEResponse)) return false;
        ZBAPI_ISUACCOUNT_CHANGEResponse other = (ZBAPI_ISUACCOUNT_CHANGEResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ZBAPI_ISUACCOUNT_CHANGEResult==null && other.getZBAPI_ISUACCOUNT_CHANGEResult()==null) || 
             (this.ZBAPI_ISUACCOUNT_CHANGEResult!=null &&
              this.ZBAPI_ISUACCOUNT_CHANGEResult.equals(other.getZBAPI_ISUACCOUNT_CHANGEResult())));
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
        if (getZBAPI_ISUACCOUNT_CHANGEResult() != null) {
            _hashCode += getZBAPI_ISUACCOUNT_CHANGEResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZBAPI_ISUACCOUNT_CHANGEResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ZBAPI_ISUACCOUNT_CHANGEResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ZBAPI_ISUACCOUNT_CHANGEResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ZBAPI_ISUACCOUNT_CHANGEResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ZBAPI_ISUACCOUNT_CHANGEResponse>ZBAPI_ISUACCOUNT_CHANGEResult"));
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
