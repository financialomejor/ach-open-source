package com.financialomejor.dtos;

public class TransactionPaymentDTO {
	
	/**
	 * Method to be executed
	 */
	private String method;
	
	/**
	 * The trazability code to track the transaction
	 */
	private String trazabilityCode;
	
	/**
	 * URL of the entity
	 */
	private String entityUrl;
	
	/**
	 * Code of the bank selected by the user
	 */
	private String bankCode;
	
	/**
	 * The payment details
	 */
	private String paymentDescription;
	
	/**
	 * Invoice identification from the business
	 */
	private String ticketId;
	
	/**
	 * The transaction value including VAT
	 */
	private String amountValue;
	
	/**
	 * The VAT value
	 */
	private String vatValue;
	
	/**
	 * ISO code for currency
	 */
	private String currency;
	
	/**
	 * User type that is making the payment (persona jurídica / persona natural)
	 */
	private String userType;
	/**
	 * Reference 1 of the payment (User IP).
	 */
	private String referenceNumber1;
	/**
	 * Reference 2 of the payment (User document type).
	 */
	private String referenceNumber2;
	/**
	 * Reference 3 of the payment (User document number).
	 */
	private String referenceNumber3;
	/**
	 * Service code of the payment (FM or Bancatek)
	 */
	private String serviceCode;
	
	public TransactionPaymentDTO() {
		super();
	}
	
	public TransactionPaymentDTO(String method) {
		super();
		this.method = method;
	}
	
	public TransactionPaymentDTO(String method, String trazabilityCode) {
		super();
		this.method = method;
		this.trazabilityCode = trazabilityCode;
	}

	public TransactionPaymentDTO(String method, String trazabilityCode, String entityUrl, String bankCode,
			String paymentDescription, String ticketId, String amountValue, String vatValue, String currency,
			String userType, String referenceNumber1, String referenceNumber2, String referenceNumber3, String serviceCode) {
		super();
		this.method = method;
		this.trazabilityCode = trazabilityCode;
		this.entityUrl = entityUrl;
		this.bankCode = bankCode;
		this.paymentDescription = paymentDescription;
		this.ticketId = ticketId;
		this.amountValue = amountValue;
		this.vatValue = vatValue;
		this.currency = currency;
		this.userType = userType;
		this.referenceNumber1 = referenceNumber1;
		this.referenceNumber2 = referenceNumber2;
		this.referenceNumber3 = referenceNumber3;
		this.serviceCode = serviceCode;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTrazabilityCode() {
		return trazabilityCode;
	}

	public void setTrazabilityCode(String trazabilityCode) {
		this.trazabilityCode = trazabilityCode;
	}

	public String getEntityUrl() {
		return entityUrl;
	}

	public void setEntityUrl(String entityUrl) {
		this.entityUrl = entityUrl;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getAmountValue() {
		return amountValue;
	}

	public void setAmountValue(String amountValue) {
		this.amountValue = amountValue;
	}

	public String getVatValue() {
		return vatValue;
	}

	public void setVatValue(String vatValue) {
		this.vatValue = vatValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getReferenceNumber1() {
		return referenceNumber1;
	}

	public void setReferenceNumber1(String referenceNumber1) {
		this.referenceNumber1 = referenceNumber1;
	}

	public String getReferenceNumber2() {
		return referenceNumber2;
	}

	public void setReferenceNumber2(String referenceNumber2) {
		this.referenceNumber2 = referenceNumber2;
	}

	public String getReferenceNumber3() {
		return referenceNumber3;
	}

	public void setReferenceNumber3(String referenceNumber3) {
		this.referenceNumber3 = referenceNumber3;
	}
	
	@Override
	public String toString() {
		return method;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
}
