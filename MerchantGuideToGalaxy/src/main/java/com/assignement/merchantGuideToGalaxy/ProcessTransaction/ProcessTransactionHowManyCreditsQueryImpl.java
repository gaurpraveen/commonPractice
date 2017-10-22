package com.assignement.merchantGuideToGalaxy.ProcessTransaction;

import java.util.Map;
import java.util.Stack;

import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;
import com.assignement.merchantGuideToGalaxy.util.MerchantGuideConstants;
import com.assignement.merchantGuideToGalaxy.util.Utility;

/**
 * @author Praveen Gaur
 * Implementation class for transaction type of question.
 * eg. how many Credits is glob prok Silver ?
 *
 */
public class ProcessTransactionHowManyCreditsQueryImpl implements IProcessInputTransaction{

	@Override
	public void processInputTransaction(String line) {
		Map<String, String> computedLiterals = TransactionDataStore.getComputedliterals();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		//Remove the unwanted words like "is" and "?"
		String formatted = line.split("(\\sis\\s)")[1];
		
		formatted = formatted.replace("?","").trim();
		
		// search for all numerals for their values to compute the result
		String[] keys = formatted.split("\\s");
		
		boolean found = false;
		String roman = "";
		Stack<Float> cvalues = new Stack<Float>();
		String outputResult = null;
		
		for(String key : keys) {
			found = false;
			
			String romanValue = constantAssignments.get(key);
			if(romanValue!=null)
			{
				roman += romanValue;
				found = true;
			}
			
			String computedValue = computedLiterals.get(key);
			if(!found && computedValue!=null) {
				cvalues.push(Float.parseFloat(computedValue));
				found = true;
			}
			if(!found)
			{
				outputResult = MerchantGuideConstants.NO_IDEA;
				
				break;
			}
		}
		if(found)
		{
			float res=1;
			for(int i =0;i<cvalues.size();i++)
			res *= cvalues.get(i);
				
			int finalres= (int) res;
			if(roman.length()>0)
			finalres = (int)(Integer.parseInt(Utility.romanToDecimal(roman))*res);
			outputResult = formatted +" is "+ finalres +" Credits";
		}
		TransactionDataStore.getOutput().add(outputResult);
	}

}
