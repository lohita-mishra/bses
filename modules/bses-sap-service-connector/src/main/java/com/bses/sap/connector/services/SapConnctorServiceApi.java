package com.bses.sap.connector.services;

import java.util.List;

import com.bses.sap.model.AdharUpdateRequest;
import com.bses.sap.model.AdharUpdateResponse;
import com.bses.sap.model.CSOrderStatusResponse;
import com.bses.sap.model.CmsDisplayBillWebRequest;
import com.bses.sap.model.CmsDisplayBillWebResponse;
import com.bses.sap.model.CmsISUCADisplayRequest;
import com.bses.sap.model.CmsISUCADisplayResponse;
import com.bses.sap.model.ComplaintRegistrationWebAreaDetailResponse;
import com.bses.sap.model.ComplaintRegistrationWebAreaRequest;
import com.bses.sap.model.ComplaintRegistrationWebAreaResponse;
import com.bses.sap.model.ComplaintRegistrationWebDetailResponse;
import com.bses.sap.model.ComplaintRegistrationWebRequest;
import com.bses.sap.model.ComplaintRegistrationWebResponse;
import com.bses.sap.model.ComplaintStatusRequest;
import com.bses.sap.model.ComplaintStatusResponse;
import com.bses.sap.model.DemandOnlineBillPdfResponse;
import com.bses.sap.model.DemandOnlineBillPdfResquest;
import com.bses.sap.model.DskAddUpdateConnectionRequest;
import com.bses.sap.model.DskAddUpdateConnectionResponse;
import com.bses.sap.model.DssISUCADisplayRequest;
import com.bses.sap.model.DssISUCADisplayResponse;
import com.bses.sap.model.DssWebLinkRequest;
import com.bses.sap.model.DssWebLinkResponse;
import com.bses.sap.model.ExemptMobileResponse;
import com.bses.sap.model.GetAreaDetailsCircleRequest;
import com.bses.sap.model.GetAreaDetailsCircleResponse;
import com.bses.sap.model.GetAreaDetailsRequest;
import com.bses.sap.model.GetAreaDetailsResponse;
import com.bses.sap.model.GetAreaFromDivisionRequest;
import com.bses.sap.model.GetAreaFromDivisionResponse;
import com.bses.sap.model.GetComplaintStatusRequest;
import com.bses.sap.model.GetComplaintStatusResponse;
import com.bses.sap.model.GetDivisionsFromCompanyRequest;
import com.bses.sap.model.GetDivisionsFromCompanyResponse;
import com.bses.sap.model.GetFaultCatResponse;
import com.bses.sap.model.GetFaultCategoriesWebRequest;
import com.bses.sap.model.GetFaultCategoriesWebResponse;
import com.bses.sap.model.GetFaultTypesFromCatRequest;
import com.bses.sap.model.GetFaultTypesFromCatResponse;
import com.bses.sap.model.GetSubFaultCategoryRequest;
import com.bses.sap.model.GetSubFaultCategoryResponse;
import com.bses.sap.model.ItDataTableResponse;
import com.bses.sap.model.IvrCreatesoISURequest;
import com.bses.sap.model.IvrCreatesoISUResponse;
import com.bses.sap.model.MDIResOrderResponse;
import com.bses.sap.model.OnlineBillPdfResponse;
import com.bses.sap.model.OnlineBillPdfResquest;
import com.bses.sap.model.PrepaidRtgsResponse;
import com.bses.sap.model.PrepaidRtgsSyrucOutResponse;
import com.bses.sap.model.RegisterWebComplaintRequest;
import com.bses.sap.model.RegisterWebComplaintResponse;
import com.bses.sap.model.UpdateTNORequest;
import com.bses.sap.model.UpdateTNOResponse;
import com.bses.sap.model.WebBillHisResponse;
import com.bses.sap.model.WebBillHistoryRequest;
import com.bses.sap.model.ZBapiCSMobileAppcntResponse;
import com.bses.sap.model.ZBapiCaDisplayWhatsApp;
import com.bses.sap.model.ZBapiFicaDemandRequest;
import com.bses.sap.model.ZBapiFicaDemandResponse;
import com.bses.sap.model.ZCalHighAvgMDIResponse;
import com.bses.sap.model.ZbapiCreateSOPostRequest;
import com.bses.sap.model.ZbapiCreateSOPostResponse;
import com.bses.sap.model.ZcsUpdatePersonalDetailsResponse;

public interface SapConnctorServiceApi {

	CmsISUCADisplayResponse getCmsISUCADisplay(CmsISUCADisplayRequest request);

	CmsDisplayBillWebResponse getDisplayBillWeb(CmsDisplayBillWebRequest request);

	IvrCreatesoISUResponse getIvrCreatesoISU(IvrCreatesoISURequest request);


	OnlineBillPdfResponse getOnlineBillPdf(OnlineBillPdfResquest request);
	
	OnlineBillPdfResponse getOnlineBillPdfFromInvoice(OnlineBillPdfResquest request);
	
	List<WebBillHisResponse> getWebBillHistory(WebBillHistoryRequest request);


	GetFaultCatResponse getFaultCategory();
		
	GetSubFaultCategoryResponse getSubFaultCatResponse(GetSubFaultCategoryRequest request);
	
	GetAreaDetailsResponse getAreaDetailsResponse(GetAreaDetailsRequest request);
	
	GetAreaDetailsCircleResponse getAreaDetailsCircleResponse(GetAreaDetailsCircleRequest request);
	
	ComplaintRegistrationWebAreaResponse getComplaintRegistrationWebAreaResponse(ComplaintRegistrationWebAreaRequest request); 
	
	ComplaintRegistrationWebResponse getComplaintRegistrationWebResponse(ComplaintRegistrationWebRequest request);
	
	UpdateTNOResponse addZBapiUpdateInfo(UpdateTNORequest updateTNORequest);
	

    AdharUpdateResponse updateAdharNoInSAP(AdharUpdateRequest request);

	GetFaultCategoriesWebResponse  getFaultCategoriesWeb(GetFaultCategoriesWebRequest getFaultCategoriesWebRequest);
	
	GetFaultTypesFromCatResponse getFaultTypesFromCat(GetFaultTypesFromCatRequest getFaultTypesFromCatRequest );
	
	GetDivisionsFromCompanyResponse getDivisionsFromCompany(GetDivisionsFromCompanyRequest getDivisionsFromCompanyRequest);
	
	GetAreaFromDivisionResponse getAreaFromDivisionResponse(GetAreaFromDivisionRequest getAreaFromDivisionRequest);
	
	RegisterWebComplaintResponse registerWebComplaintResponse(RegisterWebComplaintRequest registerWebComplaintRequest);
	
	//Add Update Connection
	DskAddUpdateConnectionResponse addUpdateConnection(DskAddUpdateConnectionRequest dskAddUpdateConnectionRequest);
	
	//Add getDetails ZBapiFICA Bill details by order number
	ZBapiFicaDemandResponse getBillDetailsByOrderNo(ZBapiFicaDemandRequest request);

	ComplaintStatusResponse getComplaintStatus(ComplaintStatusRequest request);
	
	GetComplaintStatusResponse getComplaintStatusResponse(GetComplaintStatusRequest request); 
	
	DemandOnlineBillPdfResponse getDemandNoteOnlinePDF(DemandOnlineBillPdfResquest orderNumber);
	
	DssISUCADisplayResponse getDssISUCADisplay(DssISUCADisplayRequest request);
	
	//add Z_BAPI_ZDSS_WEB_LINK services
	DssWebLinkResponse addZ_BAPI_ZDSS_WEB_LINK(DssWebLinkRequest request);
	
	ZbapiCreateSOPostResponse myAccountComplaintRegistration(ZbapiCreateSOPostRequest request);
	
	ExemptMobileResponse getZBAPI_EXEMPT_MOBILE(String mobileNo);
	
	ZBapiCSMobileAppcntResponse getZBAPI_CS_MOBILE_APPCNT(String mobileNo, String pmActivity, String priod, String VAPLZ);
	
	List<ItDataTableResponse> getZBAPI_CNT_APP_DETAIL_MOB(String orderType, String divCode, String appointStartDate, String appointTime, String recCount);
	
	MDIResOrderResponse getZBAPI_MDI_RES_ORDER(String ca);
	
	CSOrderStatusResponse getZBAPI_CS_ORD_STAT(String applicationNo);
	
	ZCalHighAvgMDIResponse getZBAPI_ZCAL_HIGH_AVG_MDI(String ca, String date, String load);
	
	ZcsUpdatePersonalDetailsResponse getZCSUPDAT_PERSONAL_DETAILS(String bpNo,  String whatsappNo);
	
	PrepaidRtgsResponse getZBAPI_PREPAID_RTGS(String company, String contractAccount, String accountType, String amount, String flag);

	GetAreaDetailsResponse getAreaJson(GetAreaDetailsRequest request);

	GetAreaDetailsCircleResponse getAreaData(GetAreaDetailsCircleRequest id);

	ComplaintRegistrationWebAreaDetailResponse getComplaintRegistrationWebArea(ComplaintRegistrationWebAreaRequest request);

	ComplaintRegistrationWebDetailResponse getComplaintRegistrationWeb(ComplaintRegistrationWebRequest request);

	ZBapiCaDisplayWhatsApp getZ_BAPI_CA_DISPLAY_WHATSAPP(String caNo);

}
