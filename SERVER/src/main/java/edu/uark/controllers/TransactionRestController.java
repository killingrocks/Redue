package edu.uark.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.transactions.TransactionSaleSaveCommand;
import edu.uark.models.api.Transaction;


@RestController
@RequestMapping(value = "/transaction")
public class TransactionRestController {

	@RequestMapping(value = "/apiv0/sale", method =RequestMethod.PUT)
	public Transaction putTransaction (@RequestBody Transaction transaction){
		return (new TransactionSaleSaveCommand()).
				setApiTransaction(transaction).
				execute();
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
public String test(){
		return "successful test. (TransactionRestController)";
	}
}
