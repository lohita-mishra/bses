/**
 * Get_CMS_MISResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_CMS_MISResponse  implements java.io.Serializable {
    private com.bses.sap.ws.Get_CMS_MISResponseGet_CMS_MISResult get_CMS_MISResult;

    public Get_CMS_MISResponse() {
    }

    public Get_CMS_MISResponse(
           com.bses.sap.ws.Get_CMS_MISResponseGet_CMS_MISResult get_CMS_MISResult) {
           this.get_CMS_MISResult = get_CMS_MISResult;
    }


    /**
     * Gets the get_CMS_MISResult value for this Get_CMS_MISResponse.
     * 
     * @return get_CMS_MISResult
     */
    public com.bses.sap.ws.Get_CMS_MISResponseGet_CMS_MISResult getGet_CMS_MISResult() {
        return get_CMS_MISResult;
    }


    /**
     * Sets the get_CMS_MISResult value for this Get_CMS_MISResponse.
     * 
     * @param get_CMS_MISResult
     */
    public void setGet_CMS_MISResult(com.bses.sap.ws.Get_CMS_MISResponseGet_CMS_MISResult get_CMS_MISResult) {
        this.get_CMS_MISResult = get_CMS_MISResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_CMS_MISResponse)) return false;
        Get_CMS_MISResponse other = (Get_CMS_MISResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_CMS_MISResult==null && other.getGet_CMS_MISResult()==null) || 
             (this.get_CMS_MISResult!=null &&
              this.get_CMS_MISResult.equals(other.getGet_CMS_MISResult())));
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
        if (getGet_CMS_MISResult() != null) {
            _hashCode += getGet_CMS_MISResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_CMS_MISResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">get_CMS_MISResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_CMS_MISResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "get_CMS_MISResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>get_CMS_MISResponse>get_CMS_MISResult"));
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
