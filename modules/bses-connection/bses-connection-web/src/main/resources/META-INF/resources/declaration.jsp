<%@ include file="/init.jsp"%>


<div class="container-fluid bg-white shadow p-5 my-3">
	<div class="row">
		<div class="col-md-12">
			<h6 class="text-uppercase font-weight-bold text-center alert alert-secondary"><liferay-ui:message key="declaration-section-title" />SELF - DECLARATION FORM / UNDERTAKING</h6>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="termCondition border p-2">
				<p>
					I, <a id="firstName1" style="font-weight: bold;">__________</a>______________________<a id="fatherName1" style="font-weight: bold;">_______________</a>
					Resident of <a id="address1" style="font-weight: bold;">____________________________________________________________</a> (hereinafter
					referred to as "Applicant", which term shall mean and include executors, administrators, heirs, successors and assigns), do hereby swear and
					declare as under:
				</p>
				Or
				<p>
					The <a id="firmName1" style="font-weight: bold;">_____</a>, a company incorporated under the provisions of the Companies Act, 2013 or as amended,
					having its registered office at <a id="registeredOffice1" style="font-weight: bold;">_____</a> (hereinafter referred to as "Applicant", which
					expression shall, unless repugnant to the context or meaning thereof, include its successors and assigns), through its duly Authorized
					Representative Mr. <a id="authorizedSignature1" style="font-weight: bold;">_____</a> do hereby swear and declare as under:
				</p>
				Or
				<p>
					A Sole proprietorship/ a partnership firm having its office at <a id="address2" style="font-weight: bold;">_____</a> (hereinafter referred to as
					the applicant which unless the context otherwise provides includes its successors and assigns), through Mr. <a id="authorizedSignature2"
						style="font-weight: bold;">_____</a> , who is a partner or a duly authorized representative do hereby swear and declare as under:
				</p>

				<p>
					(a) THAT the Applicant is a lawful occupant/owner of the premises at <a id="address3" style="font-weight: bold;"></a> (hereinafter the
					"Premises"). The Applicant has requested BSES Rajdhani Power Ltd. to provide an electricity connection at the abovementioned premises in the
					Applicant's name under the consumer category mentioned in the Application Form.
				</p>
				<p>(b) The applicant has deposited the scan copy of all requisite documents as specified in the application form.</p>
				<p>(c) That the scan copies filed with the application form are made from the original by mechanical processes which in themselves ensure the
					accuracy of the copy and the applicant has himself compared the said scan copies with the original of said documents.</p>
				<p>(d) That the applicant is in possession of the original of all the documents as filed with the application and shall submit/produce (as the
					case may be) as and when demanded by BRPL.</p>
				<p>(e) That the certificates submitted by applicant with the application form have been issued by the respective authorities and the applicant
					has secured all those certificates in adherence of due process of law.</p>
				<p>(f) That the applicant confirms that in case any of the undertaking being found false or the documents as submitted by the applicant along
					with the application for electricity connection, being found forged, fabricated or secured in violation of the provisions of law or failure on
					the part of applicant in production of the original documents within the strict timeline as notified by BRPL, than irrespective to the fact,
					whether the applicant is guilty or not, BRPL shall be having full right to disconnect the said electricity connection, so released and the
					applicant shall, at all times, keep BRPL, its officers/Directors/employees indemnified from all losses/damages/penalties/liabilities associated
					with the installation of electricity connection, so released, based upon this instant undertaking and/or any other further breach by the
					applicant to the terms/conditions/Rules/Regulations etc. That I, the Applicant hereby agree and undertake :</p>

			</div>
		</div>
	</div>
</div>
<form role="form" class="CustomForm" id="checklistForm">
	<div class="container-fluid">
		<div class="row my-3">
			<div class="col-md-12">
				<%--<div class="form-check form-check-inline"> --%>
				<aui:input cssClass="mr-2" type="checkbox" name="selfDeclaration" value="1" label="declaration-check" >
					<aui:validator name="required"/>
				</aui:input>
				<%--</div> --%>
			</div>
		</div>
	</div>
</form>