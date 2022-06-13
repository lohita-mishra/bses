/**
 * RegisterSmartAppComplaint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bses.sap.ws;

public class RegisterSmartAppComplaint  implements java.io.Serializable {
    private java.lang.String key;

    private java.lang.String CA;

    private java.lang.String phone;

    private java.lang.String faultCategory;

    private java.lang.String subFaultType;

    private java.lang.String callerName;

    private java.lang.String address;

    private java.lang.String email;

    private java.lang.String remarks;

    public RegisterSmartAppComplaint() {
    }

    public RegisterSmartAppComplaint(
           java.lang.String key,
           java.lang.String CA,
           java.lang.String phone,
           java.lang.String faultCategory,
           java.lang.String subFaultType,
           java.lang.String callerName,
           java.lang.String address,
           java.lang.String email,
           java.lang.String remarks) {
           this.key = key;
           this.CA = CA;
           this.phone = phone;
           this.faultCategory = faultCategory;
           this.subFaultType = subFaultType;
           this.callerName = callerName;
           this.address = address;
           this.email = email;
           this.remarks = remarks;
    }


    /**
     * Gets the key value for this RegisterSmartAppComplaint.
     * 
     * @return key
     */
    public java.lang.String getKey() {
        return key;
    }


    /**
     * Sets the key value for this RegisterSmartAppComplaint.
     * 
     * @param key
     */
    public void setKey(java.lang.String key) {
        this.key = key;
    }


    /**
     * Gets the CA value for this RegisterSmartAppComplaint.
     * 
     * @return CA
     */
    public java.lang.String getCA() {
        return CA;
    }


    /**
     * Sets the CA value for this RegisterSmartAppComplaint.
     * 
     * @param CA
     */
    public void setCA(java.lang.String CA) {
        this.CA = CA;
    }


    /**
     * Gets the phone value for this RegisterSmartAppComplaint.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this RegisterSmartAppComplaint.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the faultCategory value for this RegisterSmartAppComplaint.
     * 
     * @return faultCategory
     */
    public java.lang.String getFaultCategory() {
        return faultCategory;
    }


    /**
     * Sets the faultCategory value for this RegisterSmartAppComplaint.
     * 
     * @param faultCategory
     */
    public void setFaultCategory(java.lang.String faultCategory) {
        this.faultCategory = faultCategory;
    }


    /**
     * Gets the subFaultType value for this RegisterSmartAppComplaint.
     * 
     * @return subFaultType
     */
    public java.lang.String getSubFaultType() {
        return subFaultType;
    }


    /**
     * Sets the subFaultType value for this RegisterSmartAppComplaint.
     * 
     * @param subFaultType
     */
    public void setSubFaultType(java.lang.String subFaultType) {
        this.subFaultType = subFaultType;
    }


    /**
     * Gets the callerName value for this RegisterSmartAppComplaint.
     * 
     * @return callerName
     */
    public java.lang.String getCallerName() {
        return callerName;
    }


    /**
     * Sets the callerName value for this RegisterSmartAppComplaint.
     * 
     * @param callerName
     */
    public void setCallerName(java.lang.String callerName) {
        this.callerName = callerName;
    }


    /**
     * Gets the address value for this RegisterSmartAppComplaint.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this RegisterSmartAppComplaint.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the email value for this RegisterSmartAppComplaint.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this RegisterSmartAppComplaint.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the remarks value for this RegisterSmartAppComplaint.
     * 
     * @return remarks
     */
    public java.lang.String getRemarks() {
        return remarks;
    }


    /**
     * Sets the remarks value for this RegisterSmartAppComplaint.
     * 
     * @param remarks
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegisterSmartAppComplaint)) return false;
        RegisterSmartAppComplaint other = (RegisterSmartAppComplaint) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey()))) &&
            ((this.CA==null && other.getCA()==null) || 
             (this.CA!=null &&
              this.CA.equals(other.getCA()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.faultCategory==null && other.getFaultCategory()==null) || 
             (this.faultCategory!=null &&
              this.faultCategory.equals(other.getFaultCategory()))) &&
            ((this.subFaultType==null && other.getSubFaultType()==null) || 
             (this.subFaultType!=null &&
              this.subFaultType.equals(other.getSubFaultType()))) &&
            ((this.callerName==null && other.getCallerName()==null) || 
             (this.callerName!=null &&
              this.callerName.equals(other.getCallerName()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.remarks==null && other.getRemarks()==null) || 
             (this.remarks!=null &&
              this.remarks.equals(other.getRemarks())));
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
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        if (getCA() != null) {
            _hashCode += getCA().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getFaultCategory() != null) {
            _hashCode += getFaultCategory().hashCode();
        }
        if (getSubFaultType() != null) {
            _hashCode += getSubFaultType().hashCode();
        }
        if (getCallerName() != null) {
            _hashCode += getCallerName().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getRemarks() != null) {
            _hashCode += getRemarks().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegisterSmartAppComplaint.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">RegisterSmartAppComplaint"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("faultCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "FaultCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subFaultType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SubFaultType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("callerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CallerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remarks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Remarks"));
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
