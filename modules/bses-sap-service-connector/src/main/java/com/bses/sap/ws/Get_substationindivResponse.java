/**
 * Get_substationindivResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_substationindivResponse  implements java.io.Serializable {
    private com.bses.sap.ws.Get_substationindivResponseGet_substationindivResult get_substationindivResult;

    public Get_substationindivResponse() {
    }

    public Get_substationindivResponse(
           com.bses.sap.ws.Get_substationindivResponseGet_substationindivResult get_substationindivResult) {
           this.get_substationindivResult = get_substationindivResult;
    }


    /**
     * Gets the get_substationindivResult value for this Get_substationindivResponse.
     * 
     * @return get_substationindivResult
     */
    public com.bses.sap.ws.Get_substationindivResponseGet_substationindivResult getGet_substationindivResult() {
        return get_substationindivResult;
    }


    /**
     * Sets the get_substationindivResult value for this Get_substationindivResponse.
     * 
     * @param get_substationindivResult
     */
    public void setGet_substationindivResult(com.bses.sap.ws.Get_substationindivResponseGet_substationindivResult get_substationindivResult) {
        this.get_substationindivResult = get_substationindivResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_substationindivResponse)) return false;
        Get_substationindivResponse other = (Get_substationindivResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_substationindivResult==null && other.getGet_substationindivResult()==null) || 
             (this.get_substationindivResult!=null &&
              this.get_substationindivResult.equals(other.getGet_substationindivResult())));
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
        if (getGet_substationindivResult() != null) {
            _hashCode += getGet_substationindivResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_substationindivResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_substationindivResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_substationindivResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Get_substationindivResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_substationindivResponse>Get_substationindivResult"));
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
