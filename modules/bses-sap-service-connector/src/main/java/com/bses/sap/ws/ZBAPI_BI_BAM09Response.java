/**
 * ZBAPI_BI_BAM09Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class ZBAPI_BI_BAM09Response  implements java.io.Serializable {
    private com.bses.sap.ws.ZBAPI_BI_BAM09ResponseZBAPI_BI_BAM09Result ZBAPI_BI_BAM09Result;

    public ZBAPI_BI_BAM09Response() {
    }

    public ZBAPI_BI_BAM09Response(
           com.bses.sap.ws.ZBAPI_BI_BAM09ResponseZBAPI_BI_BAM09Result ZBAPI_BI_BAM09Result) {
           this.ZBAPI_BI_BAM09Result = ZBAPI_BI_BAM09Result;
    }


    /**
     * Gets the ZBAPI_BI_BAM09Result value for this ZBAPI_BI_BAM09Response.
     * 
     * @return ZBAPI_BI_BAM09Result
     */
    public com.bses.sap.ws.ZBAPI_BI_BAM09ResponseZBAPI_BI_BAM09Result getZBAPI_BI_BAM09Result() {
        return ZBAPI_BI_BAM09Result;
    }


    /**
     * Sets the ZBAPI_BI_BAM09Result value for this ZBAPI_BI_BAM09Response.
     * 
     * @param ZBAPI_BI_BAM09Result
     */
    public void setZBAPI_BI_BAM09Result(com.bses.sap.ws.ZBAPI_BI_BAM09ResponseZBAPI_BI_BAM09Result ZBAPI_BI_BAM09Result) {
        this.ZBAPI_BI_BAM09Result = ZBAPI_BI_BAM09Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ZBAPI_BI_BAM09Response)) return false;
        ZBAPI_BI_BAM09Response other = (ZBAPI_BI_BAM09Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ZBAPI_BI_BAM09Result==null && other.getZBAPI_BI_BAM09Result()==null) || 
             (this.ZBAPI_BI_BAM09Result!=null &&
              this.ZBAPI_BI_BAM09Result.equals(other.getZBAPI_BI_BAM09Result())));
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
        if (getZBAPI_BI_BAM09Result() != null) {
            _hashCode += getZBAPI_BI_BAM09Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ZBAPI_BI_BAM09Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ZBAPI_BI_BAM09Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ZBAPI_BI_BAM09Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ZBAPI_BI_BAM09Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>ZBAPI_BI_BAM09Response>ZBAPI_BI_BAM09Result"));
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
