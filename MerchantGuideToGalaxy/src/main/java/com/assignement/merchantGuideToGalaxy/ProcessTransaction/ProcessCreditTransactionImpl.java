package com.assignement.merchantGuideToGalaxy.ProcessTransaction;

import java.util.Map;

import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;
import com.assignement.merchantGuideToGalaxy.util.Utility;

/**
 * @author Praveen Gaur
 * Implementation class for transaction type of Credit.
 * eg. glob glob Silver is 34 Credits
 *
 */
public class ProcessCreditTransactionImpl implements IProcessInputTransaction{

	@Override
	public void processInputTransaction(String line) {
		Map<String, String> computedLiterals = TransactionDataStore.getComputedliterals();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		//Remove the unwanted words like "is" and "credits"
		String formatted = line.replaceAll("(is\\s+)|([c|C]redits\\s*)","").trim();
		
		//Split the remaining based on space
		String[] keys = formatted.split("\\s");
		
		//concatenate all keys to form roman number except the second last and last one. because the second last one is to be computed.
		// The last one is the value itself
		// get the value for that roman number
		
		String toBeComputed = keys[keys.length-2];
		float value = Float.parseFloat(keys[keys.length-1]);
		//concatenate remaining initial strings
		
		
		String roman="";
		for(int i=0;i<keys.length-2;i++)
		{
			roman += constantAssignments.get(keys[i]);
		}
		
		int romanNumber = Integer.parseInt(Utility.romanToDecimal(roman));
		float credit = (float)(value/romanNumber);
		
				
		computedLiterals.put(toBeComputed, credit+"");
	}

}
