/**
 * Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult  implements java.io.Serializable, org.apache.axis.encoding.AnyContentType {
    private org.apache.axis.message.MessageElement [] _any;

    public Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult() {
    }

    public Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult(
           org.apache.axis.message.MessageElement [] _any) {
           this._any = _any;
    }


    /**
     * Gets the _any value for this Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult.
     * 
     * @return _any
     */
    public org.apache.axis.message.MessageElement [] get_any() {
        return _any;
    }


    /**
     * Sets the _any value for this Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult.
     * 
     * @param _any
     */
    public void set_any(org.apache.axis.message.MessageElement [] _any) {
        this._any = _any;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult)) return false;
        Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult other = (Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._any==null && other.get_any()==null) || 
             (this._any!=null &&
              java.util.Arrays.equals(this._any, other.get_any())));
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
        if (get_any() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_any());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_any(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Z_BAPI_ZDSS_WEB_LINKResponse>Z_BAPI_ZDSS_WEB_LINKResult"));
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
