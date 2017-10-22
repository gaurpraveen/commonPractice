/**
 * 
 */
package com.assignement.merchantGuideToGalaxy.transactionData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Praveen Gaur
 * Data Store for input, processed values and output
 *
 */
public class TransactionDataStore {
	
	
	private TransactionDataStore() {
		
	}
	
	private static  Map<String, String> constantAssignments = new HashMap<String,String>();
	private static  Map<String, String> computedLiterals = new HashMap<String,String>();
	private static List<String> output = new ArrayList<String>();
	
	public static List<String> getOutput() {
		return output;
	}
	
	public static Map<String, String> getConstantassignments() {
		return constantAssignments;
	}
	public static Map<String, String> getComputedliterals() {
		return computedLiterals;
	}

	

}
