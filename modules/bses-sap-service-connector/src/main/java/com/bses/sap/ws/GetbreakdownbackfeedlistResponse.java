/**
 * GetbreakdownbackfeedlistResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class GetbreakdownbackfeedlistResponse  implements java.io.Serializable {
    private com.bses.sap.ws.GetbreakdownbackfeedlistResponseGetbreakdownbackfeedlistResult getbreakdownbackfeedlistResult;

    public GetbreakdownbackfeedlistResponse() {
    }

    public GetbreakdownbackfeedlistResponse(
           com.bses.sap.ws.GetbreakdownbackfeedlistResponseGetbreakdownbackfeedlistResult getbreakdownbackfeedlistResult) {
           this.getbreakdownbackfeedlistResult = getbreakdownbackfeedlistResult;
    }


    /**
     * Gets the getbreakdownbackfeedlistResult value for this GetbreakdownbackfeedlistResponse.
     * 
     * @return getbreakdownbackfeedlistResult
     */
    public com.bses.sap.ws.GetbreakdownbackfeedlistResponseGetbreakdownbackfeedlistResult getGetbreakdownbackfeedlistResult() {
        return getbreakdownbackfeedlistResult;
    }


    /**
     * Sets the getbreakdownbackfeedlistResult value for this GetbreakdownbackfeedlistResponse.
     * 
     * @param getbreakdownbackfeedlistResult
     */
    public void setGetbreakdownbackfeedlistResult(com.bses.sap.ws.GetbreakdownbackfeedlistResponseGetbreakdownbackfeedlistResult getbreakdownbackfeedlistResult) {
        this.getbreakdownbackfeedlistResult = getbreakdownbackfeedlistResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetbreakdownbackfeedlistResponse)) return false;
        GetbreakdownbackfeedlistResponse other = (GetbreakdownbackfeedlistResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getbreakdownbackfeedlistResult==null && other.getGetbreakdownbackfeedlistResult()==null) || 
             (this.getbreakdownbackfeedlistResult!=null &&
              this.getbreakdownbackfeedlistResult.equals(other.getGetbreakdownbackfeedlistResult())));
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
        if (getGetbreakdownbackfeedlistResult() != null) {
            _hashCode += getGetbreakdownbackfeedlistResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetbreakdownbackfeedlistResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getbreakdownbackfeedlistResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getbreakdownbackfeedlistResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getbreakdownbackfeedlistResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>getbreakdownbackfeedlistResponse>getbreakdownbackfeedlistResult"));
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
