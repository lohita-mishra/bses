package com.bses.sap.ws;

public class ISUServiceSoapProxy implements com.bses.sap.ws.ISUServiceSoap {
  private String _endpoint = null;
  private com.bses.sap.ws.ISUServiceSoap iSUServiceSoap = null;
  
  public ISUServiceSoapProxy() {
    _initISUServiceSoapProxy();
  }
  
  public ISUServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initISUServiceSoapProxy();
  }
  
  private void _initISUServiceSoapProxy() {
    try {
      iSUServiceSoap = (new com.bses.sap.ws.ISUServiceLocator()).getISUServiceSoap();
      if (iSUServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iSUServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iSUServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iSUServiceSoap != null)
      ((javax.xml.rpc.Stub)iSUServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bses.sap.ws.ISUServiceSoap getISUServiceSoap() {
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap;
  }
  
  public com.bses.sap.ws.Z_BAPI_CMS_ISU_CA_DISPLAYResponseZ_BAPI_CMS_ISU_CA_DISPLAYResult z_BAPI_CMS_ISU_CA_DISPLAY(java.lang.String strCANumber, java.lang.String strSerialNumber, java.lang.String strConsumerNumber, java.lang.String strTelephoneNumber, java.lang.String strKNumber, java.lang.String strContractNumber) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_BAPI_CMS_ISU_CA_DISPLAY(strCANumber, strSerialNumber, strConsumerNumber, strTelephoneNumber, strKNumber, strContractNumber);
  }
  
  public com.bses.sap.ws.ZBAPI_IVR_CREATESO_ISUResponseZBAPI_IVR_CREATESO_ISUResult ZBAPI_IVR_CREATESO_ISU(java.lang.String strCANumber, java.lang.String strCACrn, java.lang.String strCAKNumber, java.lang.String strMeterNumber, java.lang.String strISUOrder, java.lang.String strComplaintType, java.lang.String strContractNumber, java.lang.String strTelephoneNo, java.lang.String strDescription) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_IVR_CREATESO_ISU(strCANumber, strCACrn, strCAKNumber, strMeterNumber, strISUOrder, strComplaintType, strContractNumber, strTelephoneNo, strDescription);
  }
  
  public com.bses.sap.ws.ZBAPI_CREATESO_POSTResponseZBAPI_CREATESO_POSTResult ZBAPI_CREATESO_POST(java.lang.String strPMAufart, java.lang.String strPlanPlant, java.lang.String strRegioGroup, java.lang.String strShortText, java.lang.String strILA, java.lang.String strMFText, java.lang.String strUserFieldCH20, java.lang.String strControkey, java.lang.String strSerialNumber, java.lang.String strComplaintGroup, java.lang.String strCANumber, java.lang.String strContract, java.lang.String strMFText1) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_CREATESO_POST(strPMAufart, strPlanPlant, strRegioGroup, strShortText, strILA, strMFText, strUserFieldCH20, strControkey, strSerialNumber, strComplaintGroup, strCANumber, strContract, strMFText1);
  }
  
  public com.bses.sap.ws.ZBAPI_CALERTResponseZBAPI_CALERTResult ZBAPI_CALERT(java.lang.String strCompanyCode, java.lang.String strDate, java.lang.String strDivision, java.lang.String strUnit) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_CALERT(strCompanyCode, strDate, strDivision, strUnit);
  }
  
  public com.bses.sap.ws.ZBAPI_ONLINE_BILL_PDFResponseZBAPI_ONLINE_BILL_PDFResult ZBAPI_ONLINE_BILL_PDF(java.lang.String strCANumber, java.lang.String strEBSKNO) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_ONLINE_BILL_PDF(strCANumber, strEBSKNO);
  }
  
  public com.bses.sap.ws.ZBAPI_DISPLAY_BILL_WEBResponseZBAPI_DISPLAY_BILL_WEBResult ZBAPI_DISPLAY_BILL_WEB(java.lang.String strCANumber, java.lang.String strBillMonth) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_DISPLAY_BILL_WEB(strCANumber, strBillMonth);
  }
  
  public com.bses.sap.ws.ZBAPI_DSS_SOResponseZBAPI_DSS_SOResult ZBAPI_DSS_SO(java.lang.String PARTNERCATEGORY, java.lang.String PARTNERTYPE, java.lang.String TITLE_KEY, java.lang.String FIRSTNAME, java.lang.String LASTNAME, java.lang.String MIDDLENAME, java.lang.String FATHERSNAME, java.lang.String HOUSE_NO, java.lang.String BUILDING, java.lang.String STR_SUPPL1, java.lang.String STR_SUPPL2, java.lang.String STR_SUPPL3, java.lang.String POSTL_COD1, java.lang.String CITY, java.lang.String e_MAIL, java.lang.String LANDLINE, java.lang.String MOBILE, java.lang.String FEMALE, java.lang.String MALE, java.lang.String JOBGR, java.lang.String LEGITTYPE, java.lang.String IDNUMBER, java.lang.String ORDER_TYPE, java.lang.String SHORTTEXT, java.lang.String PLANNINGPLANT, java.lang.String WORKCENTRE, java.lang.String SYSTEMCOND, java.lang.String PMACTIVITYTYPE, java.lang.String REQUESTNUM, java.lang.String NNUMBER, java.lang.String APPLIEDCAT, java.lang.String APPLIEDLOAD, java.lang.String CONNECTIONTYPE, java.lang.String ORDERID, java.lang.String FLAG) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_DSS_SO(PARTNERCATEGORY, PARTNERTYPE, TITLE_KEY, FIRSTNAME, LASTNAME, MIDDLENAME, FATHERSNAME, HOUSE_NO, BUILDING, STR_SUPPL1, STR_SUPPL2, STR_SUPPL3, POSTL_COD1, CITY, e_MAIL, LANDLINE, MOBILE, FEMALE, MALE, JOBGR, LEGITTYPE, IDNUMBER, ORDER_TYPE, SHORTTEXT, PLANNINGPLANT, WORKCENTRE, SYSTEMCOND, PMACTIVITYTYPE, REQUESTNUM, NNUMBER, APPLIEDCAT, APPLIEDLOAD, CONNECTIONTYPE, ORDERID, FLAG);
  }
  
  public com.bses.sap.ws.ZBAPI_DSS_SO_ECCResponseZBAPI_DSS_SO_ECCResult ZBAPI_DSS_SO_ECC(java.lang.String PARTNERCATEGORY, java.lang.String PARTNERTYPE, java.lang.String TITLE_KEY, java.lang.String FIRSTNAME, java.lang.String LASTNAME, java.lang.String MIDDLENAME, java.lang.String FATHERSNAME, java.lang.String HOUSE_NO, java.lang.String BUILDING, java.lang.String STR_SUPPL1, java.lang.String STR_SUPPL2, java.lang.String STR_SUPPL3, java.lang.String POSTL_COD1, java.lang.String CITY, java.lang.String e_MAIL, java.lang.String LANDLINE, java.lang.String MOBILE, java.lang.String FEMALE, java.lang.String MALE, java.lang.String JOBGR, java.lang.String IDTYPE, java.lang.String IDNUMBER, java.lang.String ORDER_TYPE, java.lang.String SHORTTEXT, java.lang.String PLANNINGPLANT, java.lang.String WORKCENTRE, java.lang.String SYSTEMCOND, java.lang.String PMACTIVITYTYPE, java.lang.String REQUESTNUM, java.lang.String NNUMBER, java.lang.String APPLIEDCAT, java.lang.String APPLIEDLOAD, java.lang.String CONNECTIONTYPE, java.lang.String ORDERID, java.lang.String FLAG) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_DSS_SO_ECC(PARTNERCATEGORY, PARTNERTYPE, TITLE_KEY, FIRSTNAME, LASTNAME, MIDDLENAME, FATHERSNAME, HOUSE_NO, BUILDING, STR_SUPPL1, STR_SUPPL2, STR_SUPPL3, POSTL_COD1, CITY, e_MAIL, LANDLINE, MOBILE, FEMALE, MALE, JOBGR, IDTYPE, IDNUMBER, ORDER_TYPE, SHORTTEXT, PLANNINGPLANT, WORKCENTRE, SYSTEMCOND, PMACTIVITYTYPE, REQUESTNUM, NNUMBER, APPLIEDCAT, APPLIEDLOAD, CONNECTIONTYPE, ORDERID, FLAG);
  }
  
  public com.bses.sap.ws.Z_BAPI_ZDSS_WEB_LINKResponseZ_BAPI_ZDSS_WEB_LINKResult z_BAPI_ZDSS_WEB_LINK(java.lang.String i_ILART, java.lang.String i_VKONT, java.lang.String i_VKONA, java.lang.String PARTNERCATEGORY, java.lang.String PARTNERTYPE, java.lang.String TITLE_KEY, java.lang.String FIRSTNAME, java.lang.String LASTNAME, java.lang.String MIDDLENAME, java.lang.String FATHERSNAME, java.lang.String HOUSE_NO, java.lang.String BUILDING, java.lang.String STR_SUPPL1, java.lang.String STR_SUPPL2, java.lang.String STR_SUPPL3, java.lang.String POSTL_COD1, java.lang.String CITY, java.lang.String e_MAIL, java.lang.String LANDLINE, java.lang.String MOBILE, java.lang.String FEMALE, java.lang.String MALE, java.lang.String JOBGR, java.lang.String IDTYPE, java.lang.String IDNUMBER, java.lang.String PLANNINGPLANT, java.lang.String WORKCENTRE, java.lang.String SYSTEMCOND, java.lang.String APPLIEDCAT, java.lang.String APPLIEDLOAD, java.lang.String APPLIEDLOADKVA, java.lang.String CONNECTIONTYPE, java.lang.String STATEMENT_CA, java.lang.String START_DATE, java.lang.String START_TIME, java.lang.String FINISH_DATE, java.lang.String FINISH_TIME, java.lang.String SORTFIELD, java.lang.String ABKRS) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_BAPI_ZDSS_WEB_LINK(i_ILART, i_VKONT, i_VKONA, PARTNERCATEGORY, PARTNERTYPE, TITLE_KEY, FIRSTNAME, LASTNAME, MIDDLENAME, FATHERSNAME, HOUSE_NO, BUILDING, STR_SUPPL1, STR_SUPPL2, STR_SUPPL3, POSTL_COD1, CITY, e_MAIL, LANDLINE, MOBILE, FEMALE, MALE, JOBGR, IDTYPE, IDNUMBER, PLANNINGPLANT, WORKCENTRE, SYSTEMCOND, APPLIEDCAT, APPLIEDLOAD, APPLIEDLOADKVA, CONNECTIONTYPE, STATEMENT_CA, START_DATE, START_TIME, FINISH_DATE, FINISH_TIME, SORTFIELD, ABKRS);
  }
  
  public com.bses.sap.ws.ZBAPI_ENFORCEMENTResponseZBAPI_ENFORCEMENTResult ZBAPI_ENFORCEMENT(java.lang.String strCANumber, java.lang.String strContract) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_ENFORCEMENT(strCANumber, strContract);
  }
  
  public com.bses.sap.ws.ZBI_WEBBILL_HISTResponseZBI_WEBBILL_HISTResult ZBI_WEBBILL_HIST(java.lang.String strCANumber, java.lang.String strBillMonth) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBI_WEBBILL_HIST(strCANumber, strBillMonth);
  }
  
  public com.bses.sap.ws.ZBAPI_BI_BAM09ResponseZBAPI_BI_BAM09Result ZBAPI_BI_BAM09(com.bses.sap.ws.ZBAPI_BI_BAM09DsInputTable dsInputTable) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_BI_BAM09(dsInputTable);
  }
  
  public com.bses.sap.ws.Z_BAPI_INPUT_ENF_BILLResponseZ_BAPI_INPUT_ENF_BILLResult z_BAPI_INPUT_ENF_BILL(java.lang.String new_Ca, java.lang.String old_Ca, java.lang.String theft_Type, java.lang.String zbill_Days, java.lang.String zbill_Type, java.lang.String zbilled_Ratcat, java.lang.String zcaseid, java.lang.String zcomp_Id, java.lang.String zconn_Load, java.lang.String zinsp_Date, java.lang.String zinsp_Mtrread, java.lang.String znew_Meterno, java.lang.String zold_Meterno, java.lang.String zphase, com.bses.sap.ws.Z_BAPI_INPUT_ENF_BILLDsInputTable dsInputTable) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_BAPI_INPUT_ENF_BILL(new_Ca, old_Ca, theft_Type, zbill_Days, zbill_Type, zbilled_Ratcat, zcaseid, zcomp_Id, zconn_Load, zinsp_Date, zinsp_Mtrread, znew_Meterno, zold_Meterno, zphase, dsInputTable);
  }
  
  public com.bses.sap.ws.Z_BAPI_INPUT_CP_DETAILSResponseZ_BAPI_INPUT_CP_DETAILSResult z_BAPI_INPUT_CP_DETAILS(java.lang.String new_Ca, java.lang.String old_Ca, java.lang.String theft_Type, java.lang.String zbilled_Ratcat, java.lang.String zbill_Days, java.lang.String zbill_Type, java.lang.String zcaseid, java.lang.String zcomp_Id, java.lang.String zconn_Load, java.lang.String zinsp_Date, java.lang.String zinsp_Mtrread, java.lang.String znew_Meterno, java.lang.String zold_Meterno, java.lang.String zphase, com.bses.sap.ws.Z_BAPI_INPUT_CP_DETAILSDsInputTable dsInputTable) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_BAPI_INPUT_CP_DETAILS(new_Ca, old_Ca, theft_Type, zbilled_Ratcat, zbill_Days, zbill_Type, zcaseid, zcomp_Id, zconn_Load, zinsp_Date, zinsp_Mtrread, znew_Meterno, zold_Meterno, zphase, dsInputTable);
  }
  
  public com.bses.sap.ws.Z_BAPI_DSS_ISU_CA_DISPLAYResponseZ_BAPI_DSS_ISU_CA_DISPLAYResult z_BAPI_DSS_ISU_CA_DISPLAY(java.lang.String strCANumber, java.lang.String strCRNNumber) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_BAPI_DSS_ISU_CA_DISPLAY(strCANumber, strCRNNumber);
  }
  
  public com.bses.sap.ws.ZBAPI_ZCS_CLI_WEBResponseZBAPI_ZCS_CLI_WEBResult ZBAPI_ZCS_CLI_WEB(java.lang.String strTelephoneNumber) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_ZCS_CLI_WEB(strTelephoneNumber);
  }
  
  public com.bses.sap.ws.Z_CSINT15ResponseZ_CSINT15Result z_CSINT15(java.lang.String i_ARBPL, java.lang.String i_AUFNR, java.lang.String i_CASEID, java.lang.String i_CDATE, java.lang.String i_CRN, java.lang.String i_DATE, java.lang.String i_FLAG, java.lang.String i_ILART, java.lang.String i_IWERK, java.lang.String i_POLENO, java.lang.String i_RESP_COMP_CODE, java.lang.String i_RUNAME, java.lang.String i_STANDARD_COMP_CODE, java.lang.String i_USERID, java.lang.String i_VKONT, java.lang.String BPCATEG, java.lang.String BPKIND, java.lang.String TITLE, java.lang.String NAME_FIRST, java.lang.String NAME_LAST, java.lang.String NAMEMIDDLE, java.lang.String NAME_LST2, java.lang.String HOUSE_NUM1, java.lang.String BUILDNGNAME, java.lang.String STR_SUPPL1, java.lang.String STR_SUPPL2, java.lang.String STR_SUPPL3, java.lang.String POST_CODE1, java.lang.String CITY1, java.lang.String EMAILADR, java.lang.String MOBILENO, java.lang.String LANDLINENO, java.lang.String XSEXF, java.lang.String XSEXM, java.lang.String JOBGR, java.lang.String LGTYP, java.lang.String LGNUM) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_CSINT15(i_ARBPL, i_AUFNR, i_CASEID, i_CDATE, i_CRN, i_DATE, i_FLAG, i_ILART, i_IWERK, i_POLENO, i_RESP_COMP_CODE, i_RUNAME, i_STANDARD_COMP_CODE, i_USERID, i_VKONT, BPCATEG, BPKIND, TITLE, NAME_FIRST, NAME_LAST, NAMEMIDDLE, NAME_LST2, HOUSE_NUM1, BUILDNGNAME, STR_SUPPL1, STR_SUPPL2, STR_SUPPL3, POST_CODE1, CITY1, EMAILADR, MOBILENO, LANDLINENO, XSEXF, XSEXM, JOBGR, LGTYP, LGNUM);
  }
  
  public com.bses.sap.ws.Z_BAPI_IVRSResponseZ_BAPI_IVRSResult z_BAPI_IVRS(java.lang.String strContractAccountNumber) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.z_BAPI_IVRS(strContractAccountNumber);
  }
  
  public com.bses.sap.ws.ZBAPI_DUNNING_LOCKResponseZBAPI_DUNNING_LOCKResult ZBAPI_DUNNING_LOCK(java.lang.String FDATE, java.lang.String FLAG, java.lang.String LOCKR, java.lang.String LOTYP, java.lang.String PROID, java.lang.String TDATE, java.lang.String VKONT) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_DUNNING_LOCK(FDATE, FLAG, LOCKR, LOTYP, PROID, TDATE, VKONT);
  }
  
  public com.bses.sap.ws.ZBAPIDOCLISTResponseZBAPIDOCLISTResult ZBAPIDOCLIST(java.lang.String strAufnr, java.lang.String strC_001, java.lang.String strC_002, java.lang.String strC_003, java.lang.String strC_004, java.lang.String strC_005, java.lang.String strC_007, java.lang.String strC_008, java.lang.String strC_009, java.lang.String strC_010, java.lang.String strC_011, java.lang.String strC_012, java.lang.String strC_013, java.lang.String strC_014, java.lang.String strC_015, java.lang.String strC_016, java.lang.String strC_017, java.lang.String strC_018, java.lang.String strC_019, java.lang.String strC_020, java.lang.String strC_021, java.lang.String strC_022, java.lang.String strC_023, java.lang.String strC_024, java.lang.String strC_025, java.lang.String strC_026, java.lang.String strC_027, java.lang.String strC_028, java.lang.String strC_029, java.lang.String strC_030, java.lang.String strC_031, java.lang.String strC_032, java.lang.String strC_033, java.lang.String strC_034, java.lang.String strC_035, java.lang.String strC_036, java.lang.String strC_037, java.lang.String strC_038, java.lang.String strC_039, java.lang.String strC_040, java.lang.String strC_041, java.lang.String strC_070, java.lang.String strR_Cdll, java.lang.String strR_Occ, java.lang.String strR_Own, java.lang.String strZ_Appltype) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPIDOCLIST(strAufnr, strC_001, strC_002, strC_003, strC_004, strC_005, strC_007, strC_008, strC_009, strC_010, strC_011, strC_012, strC_013, strC_014, strC_015, strC_016, strC_017, strC_018, strC_019, strC_020, strC_021, strC_022, strC_023, strC_024, strC_025, strC_026, strC_027, strC_028, strC_029, strC_030, strC_031, strC_032, strC_033, strC_034, strC_035, strC_036, strC_037, strC_038, strC_039, strC_040, strC_041, strC_070, strR_Cdll, strR_Occ, strR_Own, strZ_Appltype);
  }
  
  public com.bses.sap.ws.ZBAPI_BI_EMAIL_COUNTResponseZBAPI_BI_EMAIL_COUNTResult ZBAPI_BI_EMAIL_COUNT(java.lang.String strCRONAM, java.lang.String strOBJTP, java.lang.String strDateYYYYMMDD, java.lang.String strTime) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_BI_EMAIL_COUNT(strCRONAM, strOBJTP, strDateYYYYMMDD, strTime);
  }
  
  public com.bses.sap.ws.ZBAPI_TEAM_ALLOCATIONResponseZBAPI_TEAM_ALLOCATIONResult ZBAPI_TEAM_ALLOCATION(java.lang.String strIEMINumber, java.lang.String strILART, java.lang.String strDate, java.lang.String strTime) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_TEAM_ALLOCATION(strIEMINumber, strILART, strDate, strTime);
  }
  
  public com.bses.sap.ws.ZBAPI_DEMAND_NOTE_ONLINEResponseZBAPI_DEMAND_NOTE_ONLINEResult ZBAPI_DEMAND_NOTE_ONLINE(java.lang.String strOrder) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_DEMAND_NOTE_ONLINE(strOrder);
  }
  
  public com.bses.sap.ws.ZBAPI_EDISTRICTResponseZBAPI_EDISTRICTResult ZBAPI_EDISTRICT(java.lang.String strCANumber, java.lang.String strCRNNumber) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPI_EDISTRICT(strCANumber, strCRNNumber);
  }
  
  public com.bses.sap.ws.ZBAPIEBIZORDSTATUSResponseZBAPIEBIZORDSTATUSResult ZBAPIEBIZORDSTATUS(java.lang.String stOrderNumber) throws java.rmi.RemoteException{
    if (iSUServiceSoap == null)
      _initISUServiceSoapProxy();
    return iSUServiceSoap.ZBAPIEBIZORDSTATUS(stOrderNumber);
  }
  
  
}