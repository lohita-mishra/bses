/**
 * Get_Cable_sectionlt1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_Cable_sectionlt1  implements java.io.Serializable {
    private java.lang.String ltfdrID;

    public Get_Cable_sectionlt1() {
    }

    public Get_Cable_sectionlt1(
           java.lang.String ltfdrID) {
           this.ltfdrID = ltfdrID;
    }


    /**
     * Gets the ltfdrID value for this Get_Cable_sectionlt1.
     * 
     * @return ltfdrID
     */
    public java.lang.String getLtfdrID() {
        return ltfdrID;
    }


    /**
     * Sets the ltfdrID value for this Get_Cable_sectionlt1.
     * 
     * @param ltfdrID
     */
    public void setLtfdrID(java.lang.String ltfdrID) {
        this.ltfdrID = ltfdrID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Cable_sectionlt1)) return false;
        Get_Cable_sectionlt1 other = (Get_Cable_sectionlt1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ltfdrID==null && other.getLtfdrID()==null) || 
             (this.ltfdrID!=null &&
              this.ltfdrID.equals(other.getLtfdrID())));
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
        if (getLtfdrID() != null) {
            _hashCode += getLtfdrID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Cable_sectionlt1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_Cable_sectionlt1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltfdrID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ltfdrID"));
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
