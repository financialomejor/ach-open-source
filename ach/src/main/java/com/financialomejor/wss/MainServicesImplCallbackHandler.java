/**
 * MainServicesImplCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package com.financialomejor.wss;


/**
 *  MainServicesImplCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class MainServicesImplCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public MainServicesImplCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public MainServicesImplCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for createTransactionPaymentMultiCredit method
     * override this method for handling normal response from createTransactionPaymentMultiCredit operation
     */
    public void receiveResultcreateTransactionPaymentMultiCredit(
        com.financialomejor.wss.MainServicesImplStub.CreateTransactionPaymentMultiCreditResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createTransactionPaymentMultiCredit operation
     */
    public void receiveErrorcreateTransactionPaymentMultiCredit(
        java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for finalizeTransactionPayment method
     * override this method for handling normal response from finalizeTransactionPayment operation
     */
    public void receiveResultfinalizeTransactionPayment(
        com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPaymentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from finalizeTransactionPayment operation
     */
    public void receiveErrorfinalizeTransactionPayment(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for authorizeTransactionPayment method
     * override this method for handling normal response from authorizeTransactionPayment operation
     */
    public void receiveResultauthorizeTransactionPayment(
        com.financialomejor.wss.MainServicesImplStub.AuthorizeTransactionPaymentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from authorizeTransactionPayment operation
     */
    public void receiveErrorauthorizeTransactionPayment(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for confirmTransactionPayment2 method
     * override this method for handling normal response from confirmTransactionPayment2 operation
     */
    public void receiveResultconfirmTransactionPayment2(
        com.financialomejor.wss.MainServicesImplStub.ConfirmTransactionPayment2Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from confirmTransactionPayment2 operation
     */
    public void receiveErrorconfirmTransactionPayment2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for confirmTransactionPaymentFD method
     * override this method for handling normal response from confirmTransactionPaymentFD operation
     */
    public void receiveResultconfirmTransactionPaymentFD(
        com.financialomejor.wss.MainServicesImplStub.ConfirmTransactionPaymentFDResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from confirmTransactionPaymentFD operation
     */
    public void receiveErrorconfirmTransactionPaymentFD(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getTransactionInformationDetailed method
     * override this method for handling normal response from getTransactionInformationDetailed operation
     */
    public void receiveResultgetTransactionInformationDetailed(
        com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationDetailedResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTransactionInformationDetailed operation
     */
    public void receiveErrorgetTransactionInformationDetailed(
        java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getTransactionInformation method
     * override this method for handling normal response from getTransactionInformation operation
     */
    public void receiveResultgetTransactionInformation(
        com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTransactionInformation operation
     */
    public void receiveErrorgetTransactionInformation(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for createTransactionPayment method
     * override this method for handling normal response from createTransactionPayment operation
     */
    public void receiveResultcreateTransactionPayment(
        com.financialomejor.wss.MainServicesImplStub.CreateTransactionPaymentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from createTransactionPayment operation
     */
    public void receiveErrorcreateTransactionPayment(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getTransactionStatistics method
     * override this method for handling normal response from getTransactionStatistics operation
     */
    public void receiveResultgetTransactionStatistics(
        com.financialomejor.wss.MainServicesImplStub.GetTransactionStatisticsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTransactionStatistics operation
     */
    public void receiveErrorgetTransactionStatistics(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for confirmTransactionPaymentFD2 method
     * override this method for handling normal response from confirmTransactionPaymentFD2 operation
     */
    public void receiveResultconfirmTransactionPaymentFD2(
        com.financialomejor.wss.MainServicesImplStub.ConfirmTransactionPaymentFD2Response result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from confirmTransactionPaymentFD2 operation
     */
    public void receiveErrorconfirmTransactionPaymentFD2(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for confirmTransactionPayment method
     * override this method for handling normal response from confirmTransactionPayment operation
     */
    public void receiveResultconfirmTransactionPayment(
        com.financialomejor.wss.MainServicesImplStub.ConfirmTransactionPaymentResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from confirmTransactionPayment operation
     */
    public void receiveErrorconfirmTransactionPayment(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getConciliationFile method
     * override this method for handling normal response from getConciliationFile operation
     */
    public void receiveResultgetConciliationFile(
        com.financialomejor.wss.MainServicesImplStub.GetConciliationFileResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getConciliationFile operation
     */
    public void receiveErrorgetConciliationFile(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for finalizeTransactionPaymentWithAuthorizationCode method
     * override this method for handling normal response from finalizeTransactionPaymentWithAuthorizationCode operation
     */
    public void receiveResultfinalizeTransactionPaymentWithAuthorizationCode(
        com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPaymentWithAuthorizationCodeResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from finalizeTransactionPaymentWithAuthorizationCode operation
     */
    public void receiveErrorfinalizeTransactionPaymentWithAuthorizationCode(
        java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getTransactionTotals method
     * override this method for handling normal response from getTransactionTotals operation
     */
    public void receiveResultgetTransactionTotals(
        com.financialomejor.wss.MainServicesImplStub.GetTransactionTotalsResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTransactionTotals operation
     */
    public void receiveErrorgetTransactionTotals(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getBankList method
     * override this method for handling normal response from getBankList operation
     */
    public void receiveResultgetBankList(
        com.financialomejor.wss.MainServicesImplStub.GetBankListResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getBankList operation
     */
    public void receiveErrorgetBankList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getFilesACH method
     * override this method for handling normal response from getFilesACH operation
     */
    public void receiveResultgetFilesACH(
        com.financialomejor.wss.MainServicesImplStub.GetFilesACHResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getFilesACH operation
     */
    public void receiveErrorgetFilesACH(java.lang.Exception e) {
    }
}
