/**
 * Get_Sub_Division_detailsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_Sub_Division_detailsResponse  implements java.io.Serializable {
    private com.bses.sap.ws.Get_Sub_Division_detailsResponseGet_Sub_Division_detailsResult get_Sub_Division_detailsResult;

    public Get_Sub_Division_detailsResponse() {
    }

    public Get_Sub_Division_detailsResponse(
           com.bses.sap.ws.Get_Sub_Division_detailsResponseGet_Sub_Division_detailsResult get_Sub_Division_detailsResult) {
           this.get_Sub_Division_detailsResult = get_Sub_Division_detailsResult;
    }


    /**
     * Gets the get_Sub_Division_detailsResult value for this Get_Sub_Division_detailsResponse.
     * 
     * @return get_Sub_Division_detailsResult
     */
    public com.bses.sap.ws.Get_Sub_Division_detailsResponseGet_Sub_Division_detailsResult getGet_Sub_Division_detailsResult() {
        return get_Sub_Division_detailsResult;
    }


    /**
     * Sets the get_Sub_Division_detailsResult value for this Get_Sub_Division_detailsResponse.
     * 
     * @param get_Sub_Division_detailsResult
     */
    public void setGet_Sub_Division_detailsResult(com.bses.sap.ws.Get_Sub_Division_detailsResponseGet_Sub_Division_detailsResult get_Sub_Division_detailsResult) {
        this.get_Sub_Division_detailsResult = get_Sub_Division_detailsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Sub_Division_detailsResponse)) return false;
        Get_Sub_Division_detailsResponse other = (Get_Sub_Division_detailsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_Sub_Division_detailsResult==null && other.getGet_Sub_Division_detailsResult()==null) || 
             (this.get_Sub_Division_detailsResult!=null &&
              this.get_Sub_Division_detailsResult.equals(other.getGet_Sub_Division_detailsResult())));
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
        if (getGet_Sub_Division_detailsResult() != null) {
            _hashCode += getGet_Sub_Division_detailsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Sub_Division_detailsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_Sub_Division_detailsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_Sub_Division_detailsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Get_Sub_Division_detailsResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_Sub_Division_detailsResponse>Get_Sub_Division_detailsResult"));
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
