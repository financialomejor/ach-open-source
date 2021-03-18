package com.financialomejor.ach;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.financialomejor.dtos.TransactionPaymentDTO;
import com.financialomejor.exceptions.InternalServerErrorExceptionDTO;
import com.financialomejor.wss.MainServicesImplStub.CreateTransactionPaymentResponseInformationType;
import com.financialomejor.wss.MainServicesImplStub.FinalizeTransactionPaymentResponseInformationType;
import com.financialomejor.wss.MainServicesImplStub.GetBankListResponseInformationType;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationDetailedResponseBodyType;
import com.financialomejor.wss.MainServicesImplStub.GetTransactionInformationResponseBodyType;

@RestController
@EnableWebMvc
@RequestMapping("/ach")
public class FmAchServiceController {

	@RequestMapping("/test")
	public ResponseEntity home() {
		System.out.println("BASE PATH CALLED");
		InternalServerErrorExceptionDTO dto = new InternalServerErrorExceptionDTO("This is an example DTO", false);
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(dto);
	}


	@GetMapping("/bank-list")
	public ResponseEntity getBankList() {
		try {
			System.out.println("BANK LIST CALLED");
			ACHMainController mainController =  new ACHMainController();
			System.out.println("CONTROLLER INITIALIZED");
			GetBankListResponseInformationType[] result = mainController.getBankList();
			System.out.println("RESULT OBTAINED");
			return ResponseEntity.ok(result);
		}catch(Exception e){
			e.printStackTrace();
			InternalServerErrorExceptionDTO dto = new InternalServerErrorExceptionDTO(e.getMessage(), true);
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(dto);
		}
	}

	@PostMapping("/transaction-payment")
	public ResponseEntity createTransactionPayment(@RequestBody TransactionPaymentDTO transactionPayment){
		try {
			System.out.println("TRANSACTION PAYMENT CALLED");
			ACHMainController mainController =  new ACHMainController();
			CreateTransactionPaymentResponseInformationType result = mainController.createTransactionPayment(transactionPayment);
			return ResponseEntity.ok(result);
		}catch(Exception e){
			e.printStackTrace();
			InternalServerErrorExceptionDTO dto = new InternalServerErrorExceptionDTO(e.getMessage(), true);
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(dto);
		}
	}

	@GetMapping("/transaction-information")
	public ResponseEntity getTransactionInformation(@RequestParam String trazabilityCode) {
		try {
			System.out.println("TRANSACTION INFORMATION CALLED");
			ACHMainController mainController =  new ACHMainController();
			GetTransactionInformationResponseBodyType result = mainController.getTransactionInformation(trazabilityCode);
			return ResponseEntity.ok(result);
		}catch(Exception e){
			e.printStackTrace();
			InternalServerErrorExceptionDTO dto = new InternalServerErrorExceptionDTO(e.getMessage(), true);
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(dto);
		}
	}

	@PostMapping("/finalize-transaction")
	public ResponseEntity finalizeTransactionPayment(@RequestParam String trazabilityCode) {
		try {
			System.out.println("TRANSACTION FINALIZE CALLED");
			ACHMainController mainController =  new ACHMainController();
			FinalizeTransactionPaymentResponseInformationType result = mainController.finalizeTransactionPayment(trazabilityCode);
			return ResponseEntity.ok(result);
		}catch(Exception e){
			e.printStackTrace();
			InternalServerErrorExceptionDTO dto = new InternalServerErrorExceptionDTO(e.getMessage(), true);
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(dto);
		}
	}

	@GetMapping("/transaction-information/detail")
	public ResponseEntity getTransactionInformationDetail(@RequestParam String trazabilityCode) {
		try {
			System.out.println("TRANSACTION INFORMATION DETAIL CALLED");
			ACHMainController mainController =  new ACHMainController();
			GetTransactionInformationDetailedResponseBodyType result = mainController.getTransactionInformationDetailed(trazabilityCode);
			return ResponseEntity.ok(result);
		}catch(Exception e){
			e.printStackTrace();
			InternalServerErrorExceptionDTO dto = new InternalServerErrorExceptionDTO(e.getMessage(), true);
			return ResponseEntity.status(500).contentType(MediaType.APPLICATION_JSON).body(dto);
		}
	}
}
