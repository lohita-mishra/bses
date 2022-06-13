/**
 * Get_EHV11Status_list.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class Get_EHV11Status_list  implements java.io.Serializable {
    private java.lang.String gridid;

    private java.lang.String[] ptcd;

    private java.lang.String feederkv;

    private java.lang.String[] feederid;

    public Get_EHV11Status_list() {
    }

    public Get_EHV11Status_list(
           java.lang.String gridid,
           java.lang.String[] ptcd,
           java.lang.String feederkv,
           java.lang.String[] feederid) {
           this.gridid = gridid;
           this.ptcd = ptcd;
           this.feederkv = feederkv;
           this.feederid = feederid;
    }


    /**
     * Gets the gridid value for this Get_EHV11Status_list.
     * 
     * @return gridid
     */
    public java.lang.String getGridid() {
        return gridid;
    }


    /**
     * Sets the gridid value for this Get_EHV11Status_list.
     * 
     * @param gridid
     */
    public void setGridid(java.lang.String gridid) {
        this.gridid = gridid;
    }


    /**
     * Gets the ptcd value for this Get_EHV11Status_list.
     * 
     * @return ptcd
     */
    public java.lang.String[] getPtcd() {
        return ptcd;
    }


    /**
     * Sets the ptcd value for this Get_EHV11Status_list.
     * 
     * @param ptcd
     */
    public void setPtcd(java.lang.String[] ptcd) {
        this.ptcd = ptcd;
    }


    /**
     * Gets the feederkv value for this Get_EHV11Status_list.
     * 
     * @return feederkv
     */
    public java.lang.String getFeederkv() {
        return feederkv;
    }


    /**
     * Sets the feederkv value for this Get_EHV11Status_list.
     * 
     * @param feederkv
     */
    public void setFeederkv(java.lang.String feederkv) {
        this.feederkv = feederkv;
    }


    /**
     * Gets the feederid value for this Get_EHV11Status_list.
     * 
     * @return feederid
     */
    public java.lang.String[] getFeederid() {
        return feederid;
    }


    /**
     * Sets the feederid value for this Get_EHV11Status_list.
     * 
     * @param feederid
     */
    public void setFeederid(java.lang.String[] feederid) {
        this.feederid = feederid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Get_EHV11Status_list)) return false;
        Get_EHV11Status_list other = (Get_EHV11Status_list) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.gridid==null && other.getGridid()==null) || 
             (this.gridid!=null &&
              this.gridid.equals(other.getGridid()))) &&
            ((this.ptcd==null && other.getPtcd()==null) || 
             (this.ptcd!=null &&
              java.util.Arrays.equals(this.ptcd, other.getPtcd()))) &&
            ((this.feederkv==null && other.getFeederkv()==null) || 
             (this.feederkv!=null &&
              this.feederkv.equals(other.getFeederkv()))) &&
            ((this.feederid==null && other.getFeederid()==null) || 
             (this.feederid!=null &&
              java.util.Arrays.equals(this.feederid, other.getFeederid())));
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
        if (getGridid() != null) {
            _hashCode += getGridid().hashCode();
        }
        if (getPtcd() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPtcd());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPtcd(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFeederkv() != null) {
            _hashCode += getFeederkv().hashCode();
        }
        if (getFeederid() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFeederid());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFeederid(), i);
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
        new org.apache.axis.description.TypeDesc(Get_EHV11Status_list.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Get_EHV11status_list"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gridid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "gridid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ptcd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ptcd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feederkv");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "feederkv"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feederid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "feederid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://tempuri.org/", "string"));
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
