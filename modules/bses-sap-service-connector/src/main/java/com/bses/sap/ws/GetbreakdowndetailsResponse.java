/**
 * GetbreakdowndetailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class GetbreakdowndetailsResponse  implements java.io.Serializable {
    private com.bses.sap.ws.GetbreakdowndetailsResponseGetbreakdowndetailsResult getbreakdowndetailsResult;

    public GetbreakdowndetailsResponse() {
    }

    public GetbreakdowndetailsResponse(
           com.bses.sap.ws.GetbreakdowndetailsResponseGetbreakdowndetailsResult getbreakdowndetailsResult) {
           this.getbreakdowndetailsResult = getbreakdowndetailsResult;
    }


    /**
     * Gets the getbreakdowndetailsResult value for this GetbreakdowndetailsResponse.
     * 
     * @return getbreakdowndetailsResult
     */
    public com.bses.sap.ws.GetbreakdowndetailsResponseGetbreakdowndetailsResult getGetbreakdowndetailsResult() {
        return getbreakdowndetailsResult;
    }


    /**
     * Sets the getbreakdowndetailsResult value for this GetbreakdowndetailsResponse.
     * 
     * @param getbreakdowndetailsResult
     */
    public void setGetbreakdowndetailsResult(com.bses.sap.ws.GetbreakdowndetailsResponseGetbreakdowndetailsResult getbreakdowndetailsResult) {
        this.getbreakdowndetailsResult = getbreakdowndetailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetbreakdowndetailsResponse)) return false;
        GetbreakdowndetailsResponse other = (GetbreakdowndetailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getbreakdowndetailsResult==null && other.getGetbreakdowndetailsResult()==null) || 
             (this.getbreakdowndetailsResult!=null &&
              this.getbreakdowndetailsResult.equals(other.getGetbreakdowndetailsResult())));
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
        if (getGetbreakdowndetailsResult() != null) {
            _hashCode += getGetbreakdowndetailsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetbreakdowndetailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getbreakdowndetailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getbreakdowndetailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getbreakdowndetailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>getbreakdowndetailsResponse>getbreakdowndetailsResult"));
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
