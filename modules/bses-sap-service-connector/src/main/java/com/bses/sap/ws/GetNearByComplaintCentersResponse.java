/**
 * GetNearByComplaintCentersResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class GetNearByComplaintCentersResponse  implements java.io.Serializable {
    private com.bses.sap.ws.GetNearByComplaintCentersResponseGetNearByComplaintCentersResult getNearByComplaintCentersResult;

    public GetNearByComplaintCentersResponse() {
    }

    public GetNearByComplaintCentersResponse(
           com.bses.sap.ws.GetNearByComplaintCentersResponseGetNearByComplaintCentersResult getNearByComplaintCentersResult) {
           this.getNearByComplaintCentersResult = getNearByComplaintCentersResult;
    }


    /**
     * Gets the getNearByComplaintCentersResult value for this GetNearByComplaintCentersResponse.
     * 
     * @return getNearByComplaintCentersResult
     */
    public com.bses.sap.ws.GetNearByComplaintCentersResponseGetNearByComplaintCentersResult getGetNearByComplaintCentersResult() {
        return getNearByComplaintCentersResult;
    }


    /**
     * Sets the getNearByComplaintCentersResult value for this GetNearByComplaintCentersResponse.
     * 
     * @param getNearByComplaintCentersResult
     */
    public void setGetNearByComplaintCentersResult(com.bses.sap.ws.GetNearByComplaintCentersResponseGetNearByComplaintCentersResult getNearByComplaintCentersResult) {
        this.getNearByComplaintCentersResult = getNearByComplaintCentersResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNearByComplaintCentersResponse)) return false;
        GetNearByComplaintCentersResponse other = (GetNearByComplaintCentersResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getNearByComplaintCentersResult==null && other.getGetNearByComplaintCentersResult()==null) || 
             (this.getNearByComplaintCentersResult!=null &&
              this.getNearByComplaintCentersResult.equals(other.getGetNearByComplaintCentersResult())));
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
        if (getGetNearByComplaintCentersResult() != null) {
            _hashCode += getGetNearByComplaintCentersResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetNearByComplaintCentersResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetNearByComplaintCentersResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getNearByComplaintCentersResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetNearByComplaintCentersResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>GetNearByComplaintCentersResponse>GetNearByComplaintCentersResult"));
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
