/**
 * GetFaultCatResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class GetFaultCatResponse  implements java.io.Serializable {
    private com.bses.sap.ws.GetFaultCatResponseGetFaultCatResult getFaultCatResult;

    public GetFaultCatResponse() {
    }

    public GetFaultCatResponse(
           com.bses.sap.ws.GetFaultCatResponseGetFaultCatResult getFaultCatResult) {
           this.getFaultCatResult = getFaultCatResult;
    }


    /**
     * Gets the getFaultCatResult value for this GetFaultCatResponse.
     * 
     * @return getFaultCatResult
     */
    public com.bses.sap.ws.GetFaultCatResponseGetFaultCatResult getGetFaultCatResult() {
        return getFaultCatResult;
    }


    /**
     * Sets the getFaultCatResult value for this GetFaultCatResponse.
     * 
     * @param getFaultCatResult
     */
    public void setGetFaultCatResult(com.bses.sap.ws.GetFaultCatResponseGetFaultCatResult getFaultCatResult) {
        this.getFaultCatResult = getFaultCatResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetFaultCatResponse)) return false;
        GetFaultCatResponse other = (GetFaultCatResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getFaultCatResult==null && other.getGetFaultCatResult()==null) || 
             (this.getFaultCatResult!=null &&
              this.getFaultCatResult.equals(other.getGetFaultCatResult())));
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
        if (getGetFaultCatResult() != null) {
            _hashCode += getGetFaultCatResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetFaultCatResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetFaultCatResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getFaultCatResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetFaultCatResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetFaultCatResponse>GetFaultCatResult"));
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
