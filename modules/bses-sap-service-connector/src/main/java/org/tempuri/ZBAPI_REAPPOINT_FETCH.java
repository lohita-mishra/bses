/**
 * ZBAPI_REAPPOINT_FETCH.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class ZBAPI_REAPPOINT_FETCH  implements java.io.Serializable {
    private java.lang.String strOrderNo;

    public ZBAPI_REAPPOINT_FETCH() {
    }

    public ZBAPI_REAPPOINT_FETCH(
           java.lang.String strOrderNo) {
           this.strOrderNo = strOrderNo;
    }


    /**
     * Gets the strOrderNo value for this ZBAPI_REAPPOINT_FETCH.
     * 
     * @return strOrderNo
     */
    public java.lang.String getStrOrderNo() {
        return strOrderNo;
    }


    /**
     * Sets the strOrderNo value for this ZBAPI_REAPPOINT_FETCH.
     * 
     * @param strOrderNo
     */
    public void setStrOrderNo(java.lang.String strOrderNo) {
        this.strOrderNo = strOrderNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZBAPI_REAPPOINT_FETCH)) return false;
        ZBAPI_REAPPOINT_FETCH other = (ZBAPI_REAPPOINT_FETCH) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.strOrderNo==null && other.getStrOrderNo()==null) || 
             (this.strOrderNo!=null &&
              this.strOrderNo.equals(other.getStrOrderNo())));
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
        if (getStrOrderNo() != null) {
            _hashCode += getStrOrderNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZBAPI_REAPPOINT_FETCH.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ZBAPI_REAPPOINT_FETCH"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strOrderNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "strOrderNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
