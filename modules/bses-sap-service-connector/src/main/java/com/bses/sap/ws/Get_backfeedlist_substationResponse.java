/**
 * Get_backfeedlist_substationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_backfeedlist_substationResponse  implements java.io.Serializable {
    private com.bses.sap.ws.Get_backfeedlist_substationResponseGet_backfeedlist_substationResult get_backfeedlist_substationResult;

    public Get_backfeedlist_substationResponse() {
    }

    public Get_backfeedlist_substationResponse(
           com.bses.sap.ws.Get_backfeedlist_substationResponseGet_backfeedlist_substationResult get_backfeedlist_substationResult) {
           this.get_backfeedlist_substationResult = get_backfeedlist_substationResult;
    }


    /**
     * Gets the get_backfeedlist_substationResult value for this Get_backfeedlist_substationResponse.
     * 
     * @return get_backfeedlist_substationResult
     */
    public com.bses.sap.ws.Get_backfeedlist_substationResponseGet_backfeedlist_substationResult getGet_backfeedlist_substationResult() {
        return get_backfeedlist_substationResult;
    }


    /**
     * Sets the get_backfeedlist_substationResult value for this Get_backfeedlist_substationResponse.
     * 
     * @param get_backfeedlist_substationResult
     */
    public void setGet_backfeedlist_substationResult(com.bses.sap.ws.Get_backfeedlist_substationResponseGet_backfeedlist_substationResult get_backfeedlist_substationResult) {
        this.get_backfeedlist_substationResult = get_backfeedlist_substationResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_backfeedlist_substationResponse)) return false;
        Get_backfeedlist_substationResponse other = (Get_backfeedlist_substationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_backfeedlist_substationResult==null && other.getGet_backfeedlist_substationResult()==null) || 
             (this.get_backfeedlist_substationResult!=null &&
              this.get_backfeedlist_substationResult.equals(other.getGet_backfeedlist_substationResult())));
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
        if (getGet_backfeedlist_substationResult() != null) {
            _hashCode += getGet_backfeedlist_substationResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_backfeedlist_substationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_backfeedlist_substationResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_backfeedlist_substationResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Get_backfeedlist_substationResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_backfeedlist_substationResponse>Get_backfeedlist_substationResult"));
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
