/**
 * Get_Area_Detailsmultiplebydiv.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_Area_Detailsmultiplebydiv  implements java.io.Serializable {
    private java.lang.String objectid;

    private java.lang.String division;

    public Get_Area_Detailsmultiplebydiv() {
    }

    public Get_Area_Detailsmultiplebydiv(
           java.lang.String objectid,
           java.lang.String division) {
           this.objectid = objectid;
           this.division = division;
    }


    /**
     * Gets the objectid value for this Get_Area_Detailsmultiplebydiv.
     * 
     * @return objectid
     */
    public java.lang.String getObjectid() {
        return objectid;
    }


    /**
     * Sets the objectid value for this Get_Area_Detailsmultiplebydiv.
     * 
     * @param objectid
     */
    public void setObjectid(java.lang.String objectid) {
        this.objectid = objectid;
    }


    /**
     * Gets the division value for this Get_Area_Detailsmultiplebydiv.
     * 
     * @return division
     */
    public java.lang.String getDivision() {
        return division;
    }


    /**
     * Sets the division value for this Get_Area_Detailsmultiplebydiv.
     * 
     * @param division
     */
    public void setDivision(java.lang.String division) {
        this.division = division;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_Area_Detailsmultiplebydiv)) return false;
        Get_Area_Detailsmultiplebydiv other = (Get_Area_Detailsmultiplebydiv) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectid==null && other.getObjectid()==null) || 
             (this.objectid!=null &&
              this.objectid.equals(other.getObjectid()))) &&
            ((this.division==null && other.getDivision()==null) || 
             (this.division!=null &&
              this.division.equals(other.getDivision())));
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
        if (getObjectid() != null) {
            _hashCode += getObjectid().hashCode();
        }
        if (getDivision() != null) {
            _hashCode += getDivision().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Get_Area_Detailsmultiplebydiv.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_Area_Detailsmultiplebydiv"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "objectid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("division");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "division"));
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
