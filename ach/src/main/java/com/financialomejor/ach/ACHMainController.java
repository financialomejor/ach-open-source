package com.financialomejor.ach;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.databinding.types.NonNegativeInteger;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.apache.rampart.RampartMessageData;

import com.financialomejor.dtos.TransactionPaymentDTO;
import com.financialomejor.wss.MainServicesImplStub;
import com.financialomejor.wss.MainServicesImplStub.AlternatePartyIdentificationListType;
import com.financialomejor.wss.MainServicesImplStub.AlternatePartyIdentificationType;
import com.financialomejor.wss.MainServicesImplStub.AmountType;
import com.financialomejor.wss.MainServicesImplStub.CreateTransactionPayment;
import com.financialomejor.wss.MainServicesImplStub.CreateTransactionPaymentInformationType;
import com.financialomejor.wss.MainServicesImplStub.CreateTransactionPaymentResponse;
import com.financialomejor.wss.MainServicesImplStub.CreateTransactionPaymentResponseInformationType;
import com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPayment;
import com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPaymentInformationType;
import com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPaymentResponse;
import com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPaymentResponseInformationType;
import com.financialomejor.wss.MainServicesImplStub.GetBankList;
import com.financialomejor.wss.MainServicesImplStub.GetBankListResponseInformationType;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformation;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationBodyType;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationDetailed;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationDetailedBodyType;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationDetailedResponse;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationDetailedResponseBodyType;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationResponse;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationResponseBodyType;
import com.financialomejor.wss.MainServicesImplStub.GetbankListInformationType;
import com.financialomejor.wss.MainServicesImplStub.MessageHeader;
import com.financialomejor.wss.MainServicesImplStub.MessageHeaderType;
import com.financialomejor.wss.MainServicesImplStub.PartyIdentificationType;
import com.financialomejor.wss.MainServicesImplStub.PartyIdentificationTypeChoice_type0;
import com.financialomejor.wss.MainServicesImplStub.UserTypeListType;

public class ACHMainController {
	

	private String PSEURL = System.getenv("ACH_ENDPOINT") +"/PSEWebServices3/MainServices.asmx";
	private String PPE_CODE = System.getenv("ENTITY_CODE");

	private MainServicesImplStub stub;

	public ACHMainController() {
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			System.out.println(classloader.getResource("").getPath());
			ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(classloader.getResource("").getPath(),
					classloader.getResource("axis2.xml").getPath());
			System.out.println(classloader.getResource("axis2.xml").getPath());
			stub = new MainServicesImplStub(ctx, PSEURL);
			ServiceClient client = stub._getServiceClient();
			Options options = client.getOptions();

			options.setUserName("admin");
			options.setPassword("axis2");
			System.out.println(classloader.getResource("policies.xml").getPath());
			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY, loadPolicy(classloader.getResource("policies.xml").getPath()));
			client.engageModule("rampart");
		} catch (AxisFault err) {
			err.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static Policy loadPolicy(String path) throws Exception {
		InputStream resource = new FileInputStream(path);
		StAXOMBuilder builder = new StAXOMBuilder(resource);
		return PolicyEngine.getPolicy(builder.getDocumentElement());
	}

	private static MainServicesImplStub.MessageHeader createHeader() {
		MessageHeader h = new MessageHeader();
		MessageHeaderType header = new MessageHeaderType();

		PartyIdentificationType party = new PartyIdentificationType();
		PartyIdentificationTypeChoice_type0 p = new PartyIdentificationTypeChoice_type0();
		p.setGln(new NonNegativeInteger("123"));
		AlternatePartyIdentificationType type = new AlternatePartyIdentificationType();
		type.setString("abc");
		type.setType(AlternatePartyIdentificationListType.BUYER_ASSIGNED);
		p.setAlternatePartyIdentification(type);
		party.setPartyIdentificationTypeChoice_type0(p);
		party.setAdditionalPartyIdentification(new AlternatePartyIdentificationType[0]);
		header.setTo(party);
		header.setFrom(party);
		header.setRepresentingParty(party);

		h.setMessageHeader(header);

		return h;
	}

	public MainServicesImplStub.GetBankListResponseInformationType[] getBankList() throws Exception {
		GetBankList request = new GetBankList();
		GetbankListInformationType gbl_request = new GetbankListInformationType();
		gbl_request.setEntityCode(PPE_CODE);
		request.setGetBankListInformation(gbl_request);

		MainServicesImplStub.GetBankListResponse gbl_response = stub.getBankList(request, createHeader());
		MainServicesImplStub.GetBankListResponseInformationType[] gblrit = gbl_response
				.getGetBankListResponseInformation();

		return gblrit;
	}

	public CreateTransactionPaymentResponseInformationType createTransactionPayment(
			TransactionPaymentDTO transactionPayment) throws Exception {
		CreateTransactionPayment request = new CreateTransactionPayment();
		CreateTransactionPaymentInformationType ctp_request = new CreateTransactionPaymentInformationType();
		ctp_request.setEntityCode(PPE_CODE);
		ctp_request.setEntityurl(transactionPayment.getEntityUrl());
		ctp_request.setFinancialInstitutionCode(transactionPayment.getBankCode());
		ctp_request.setPaymentDescription(transactionPayment.getPaymentDescription());
		ctp_request.setServiceCode(transactionPayment.getServiceCode());
		
		TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));

		Calendar cSchedStartCal = Calendar.getInstance();
		cSchedStartCal.setTimeZone(TimeZone.getTimeZone("America/Bogota"));

		int year = cSchedStartCal.get(Calendar.YEAR);
		int month = cSchedStartCal.get(Calendar.MONTH)+1;
		int day = cSchedStartCal.get(Calendar.DAY_OF_MONTH);
		int hour = cSchedStartCal.get(Calendar.HOUR_OF_DAY);
		int minutes = cSchedStartCal.get(Calendar.MINUTE);
		int seconds = cSchedStartCal.get(Calendar.SECOND);
		String dateString = "" + year + "-" +  (month<10?"0":"")+ month + "-"+(day<10?"0":"") + day + " " + (hour<10?"0":"") + hour + ":" + (minutes<10?"0":"") + minutes + ":" + (seconds<10?"0":"") +seconds + " -05:00";
		System.out.println("La fechirri: " + dateString);  
		
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss X");  
		Date nuevaDate = date.parse(dateString);
		Date date2 = Calendar.getInstance().getTime();
		System.out.println("Date to string: " + nuevaDate.toString()); 
		System.out.println("Date2 to string: " + date2.toString()); 
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");  
		//String strDate = dateFormat.format(date);  
		//System.out.println("Converted String: " + strDate);  

		ctp_request.setSoliciteDate(nuevaDate);
		ctp_request.setTicketId(new NonNegativeInteger(transactionPayment.getTicketId()));
		AmountType amount = new AmountType();
		amount.setCurrencyISOcode(transactionPayment.getCurrency());
		amount.setDecimal(new BigDecimal(transactionPayment.getAmountValue()));
		ctp_request.setTransactionValue(amount);
		AmountType vat = new AmountType();
		vat.setDecimal(new BigDecimal(transactionPayment.getVatValue()));
		vat.setCurrencyISOcode(transactionPayment.getCurrency());
		ctp_request.setVatValue(vat);
		ctp_request.setUserType(
				transactionPayment.getUserType().equals("0") ? UserTypeListType.value1 : UserTypeListType.value2);
		String[] numbers = { 
				transactionPayment.getReferenceNumber1(), 
				transactionPayment.getReferenceNumber2(), 
				transactionPayment.getReferenceNumber3()};
		ctp_request.setReferenceNumber(numbers);
		request.setCreateTransactionPaymentInformation(ctp_request);
		CreateTransactionPaymentResponse response = stub.createTransactionPayment(request, createHeader());
		CreateTransactionPaymentResponseInformationType ctp_response = response
				.getCreateTransactionPaymentResponseInformation();

		System.out.println("ReturnCode= " + ctp_response.getReturnCode());
		System.out.println("CreateTransactionPayment called");

		return ctp_response;
	}

	public GetTransactionInformationResponseBodyType getTransactionInformation(String trazabilityCode)
			throws Exception {
		GetTransactionInformation request = new GetTransactionInformation();
		GetTransactionInformationBodyType gti_request = new GetTransactionInformationBodyType();
		gti_request.setEntityCode(PPE_CODE);
		gti_request.setTrazabilityCode(trazabilityCode);
		request.setGetTransactionInformationBody(gti_request);
		GetTransactionInformationResponse response = stub.getTransactionInformation(request, createHeader());
		GetTransactionInformationResponseBodyType gti_response = response.getGetTransactionInformationResponseBody();

		System.out.println("ReturnCode= " + gti_response.getReturnCode());

		System.out.println("GetTransactionInformation called");
		return gti_response;
	}

	public FinalizeTransactionPaymentResponseInformationType finalizeTransactionPayment(String trazabilityCode)
			throws Exception {
		FinalizeTransactionPayment request = new FinalizeTransactionPayment();
		FinalizeTransactionPaymentInformationType ftp_request = new FinalizeTransactionPaymentInformationType();
		ftp_request.setEntityCode(PPE_CODE);
		ftp_request.setTrazabilityCode(trazabilityCode);
		request.setFinalizeTransactionPaymentInformation(ftp_request);
		FinalizeTransactionPaymentResponse response = stub.finalizeTransactionPayment(request, createHeader());
		FinalizeTransactionPaymentResponseInformationType ftp_response = response
				.getFinalizeTransactionPaymentResponseInformation();

		System.out.println("ReturnCode= " + ftp_response.getReturnCode());

		System.out.println("FinalizeTransactionPayment called");
		return ftp_response;
	}

	public GetTransactionInformationDetailedResponseBodyType getTransactionInformationDetailed(String trazabilityCode) throws Exception {
		GetTransactionInformationDetailed request = new GetTransactionInformationDetailed();
		GetTransactionInformationDetailedBodyType gti_request = new GetTransactionInformationDetailedBodyType();
		gti_request.setEntityCode(PPE_CODE);
		gti_request.setTrazabilityCode(trazabilityCode);
		request.setGetTransactionInformationDetailedBody(gti_request);
		GetTransactionInformationDetailedResponse response = stub
				.getTransactionInformationDetailed(request, createHeader());
		GetTransactionInformationDetailedResponseBodyType gti_response = response
				.getGetTransactionInformationDetailedResponseBody();

		System.out.println("ReturnCode= " + gti_response.getReturnCode());

		System.out.println("GetTransactionInformationDetailed called");

		return gti_response;
	}
}
