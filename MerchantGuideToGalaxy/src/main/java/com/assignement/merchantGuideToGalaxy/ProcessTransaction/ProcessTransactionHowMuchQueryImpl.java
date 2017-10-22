package com.assignement.merchantGuideToGalaxy.ProcessTransaction;

import java.util.Map;

import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;
import com.assignement.merchantGuideToGalaxy.util.MerchantGuideConstants;
import com.assignement.merchantGuideToGalaxy.util.Utility;

/**
 * @author Praveen Gaur
 * Implementation class for transaction type of question.
 * eg. how much is pish tegj glob glob ?
 *
 */
public class ProcessTransactionHowMuchQueryImpl implements IProcessInputTransaction{

	@Override
	public void processInputTransaction(String line) {
		Map<String, String> computedLiterals = TransactionDataStore.getComputedliterals();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		
		//Break the how much question line based on "is" keyword
		// the second part will contain the identifiers whooose values are to determined
		
		String formatted = line.split("\\sis\\s")[1].trim();
		
		//Remove the question mark from the string
		formatted = formatted.replace("?","").trim();
		
		//Now since the string will contain only identifiers,break them into words by splitting through space
		String keys[] = formatted.split("\\s+");
		
		
		String romanResult="";
		String completeResult = null;
		boolean errorOccured = false;
		
		for(String key : keys)
		{
			//For each identifier gets its value
			String romanValue = constantAssignments.get(key);
			if(romanValue==null)
			{
				// This means that user has entered something thats not in the hash map
				completeResult = MerchantGuideConstants.NO_IDEA;
				errorOccured = true;
				break;
			}
			romanResult += romanValue;
		}
		
		if(!errorOccured)
		{
			romanResult = Utility.romanToDecimal(romanResult);
			completeResult = formatted+" is "+romanResult;
		}
			
		TransactionDataStore.getOutput().add(completeResult);
		
	}
		
	

}
