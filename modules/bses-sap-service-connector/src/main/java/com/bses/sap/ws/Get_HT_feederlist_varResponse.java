/**
 * Get_HT_feederlist_varResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_HT_feederlist_varResponse  implements java.io.Serializable {
    private com.bses.sap.ws.Get_HT_feederlist_varResponseGet_HT_feederlist_varResult get_HT_feederlist_varResult;

    public Get_HT_feederlist_varResponse() {
    }

    public Get_HT_feederlist_varResponse(
           com.bses.sap.ws.Get_HT_feederlist_varResponseGet_HT_feederlist_varResult get_HT_feederlist_varResult) {
           this.get_HT_feederlist_varResult = get_HT_feederlist_varResult;
    }


    /**
     * Gets the get_HT_feederlist_varResult value for this Get_HT_feederlist_varResponse.
     * 
     * @return get_HT_feederlist_varResult
     */
    public com.bses.sap.ws.Get_HT_feederlist_varResponseGet_HT_feederlist_varResult getGet_HT_feederlist_varResult() {
        return get_HT_feederlist_varResult;
    }


    /**
     * Sets the get_HT_feederlist_varResult value for this Get_HT_feederlist_varResponse.
     * 
     * @param get_HT_feederlist_varResult
     */
    public void setGet_HT_feederlist_varResult(com.bses.sap.ws.Get_HT_feederlist_varResponseGet_HT_feederlist_varResult get_HT_feederlist_varResult) {
        this.get_HT_feederlist_varResult = get_HT_feederlist_varResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_HT_feederlist_varResponse)) return false;
        Get_HT_feederlist_varResponse other = (Get_HT_feederlist_varResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.get_HT_feederlist_varResult==null && other.getGet_HT_feederlist_varResult()==null) || 
             (this.get_HT_feederlist_varResult!=null &&
              this.get_HT_feederlist_varResult.equals(other.getGet_HT_feederlist_varResult())));
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
        if (getGet_HT_feederlist_varResult() != null) {
            _hashCode += getGet_HT_feederlist_varResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_HT_feederlist_varResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_HT_feederlist_varResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("get_HT_feederlist_varResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Get_HT_feederlist_varResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Get_HT_feederlist_varResponse>Get_HT_feederlist_varResult"));
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
