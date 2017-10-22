package com.assignement.merchantGuideToGalaxy.factory;

import com.assignement.merchantGuideToGalaxy.ProcessTransaction.IProcessInputTransaction;
import com.assignement.merchantGuideToGalaxy.ProcessTransaction.ProcessAssignementTransactionImpl;
import com.assignement.merchantGuideToGalaxy.ProcessTransaction.ProcessCreditTransactionImpl;
import com.assignement.merchantGuideToGalaxy.ProcessTransaction.ProcessTransactionHowManyCreditsQueryImpl;
import com.assignement.merchantGuideToGalaxy.ProcessTransaction.ProcessTransactionHowMuchQueryImpl;

/**
 * @author Praveen gaur
 * Factory class to return appropriate ProcessInputTransaction,
 * depending on type of transaction
 *
 */
public  class TransactionFactory {
	private static ProcessAssignementTransactionImpl processAssignementTransaction = new ProcessAssignementTransactionImpl();
	private static ProcessCreditTransactionImpl processCreditTransaction = new ProcessCreditTransactionImpl();
	private static ProcessTransactionHowMuchQueryImpl processTransactionHowMuchQuery = new ProcessTransactionHowMuchQueryImpl();
	private static ProcessTransactionHowManyCreditsQueryImpl processTransactionHowManyCreditsQuery = new ProcessTransactionHowManyCreditsQueryImpl();
	
	/**
	 * This function identifies type and return instance of appropriate ProcessInputTransaction.
	 * @param type
	 * @return
	 */
	public static IProcessInputTransaction getTransactionInstance(String type) {
		IProcessInputTransaction processInputTransaction = null;
		switch(type)
		{
		case "ASSIGNED" : 		 
			processInputTransaction = processAssignementTransaction;
			break;
		case "CREDITS" :			 
			processInputTransaction = processCreditTransaction;
			break;
		case "QUESTION_HOW_MUCH" : 
			processInputTransaction = processTransactionHowMuchQuery;
			break;
		case "QUESTION_HOW_MANY" :
			processInputTransaction = processTransactionHowManyCreditsQuery;
			break;
			
		}
		return processInputTransaction;
				
	}
}
