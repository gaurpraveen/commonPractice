/**
 * 
 */
package com.assignement.merchantGuideToGalaxy.ProcessTransaction;

import java.util.Map;

import org.junit.Test;

import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;

/**
 * @author systems
 *
 */
public class ProcessInputTransactionTest {


	@Test
	public void testAssignementTransactionSuccess() {
		IProcessInputTransaction processInputTransaction = new ProcessAssignementTransactionImpl();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		String line = "glob is I";
		String key = "glob";
		String val = "I";
		processInputTransaction.processInputTransaction(line);
		String value = constantAssignments.get(key);
		assert(value.equalsIgnoreCase(val));
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAssignementTransactionException() {
		IProcessInputTransaction processInputTransaction = new ProcessAssignementTransactionImpl();
		String line = "Praveen gaur";
		processInputTransaction.processInputTransaction(line);
		
	}
	
	@Test
	public void testCreditTransactionSuccess() {
		IProcessInputTransaction processInputTransaction = new ProcessCreditTransactionImpl();
		Map<String, String> computedLiterals = TransactionDataStore.getComputedliterals();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		String line = "glob glob Silver is 34 Credits";
		String key = "Silver";
		String val = "17.0";
		constantAssignments.put("glob", "I");
		processInputTransaction.processInputTransaction(line);
		String value = computedLiterals.get(key);
		assert(value.equalsIgnoreCase(val));
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void testCreditTransactionException() {
		IProcessInputTransaction processInputTransaction = new ProcessCreditTransactionImpl();
		String line = "Praveen gaur";
		processInputTransaction.processInputTransaction(line);
		
	}

	@Test
	public void testHowManyQueryTransactionSuccess() {
		IProcessInputTransaction processInputTransaction = new ProcessTransactionHowManyCreditsQueryImpl();
		Map<String, String> computedLiterals = TransactionDataStore.getComputedliterals();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		String line = "how many Credits is glob prok Silver ?";
		constantAssignments.put("glob", "I");
		constantAssignments.put("prok", "V");
		computedLiterals.put("Silver", "34");
		String output = "glob prok Silver is 136 Credits";
		processInputTransaction.processInputTransaction(line);
		assert(TransactionDataStore.getOutput().contains(output));
	}
	@Test(expected = IndexOutOfBoundsException.class)
	public void testHowManyQueryTransactionError() {
		IProcessInputTransaction processInputTransaction = new ProcessTransactionHowManyCreditsQueryImpl();
		Map<String, String> computedLiterals = TransactionDataStore.getComputedliterals();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		String line = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		constantAssignments.put("glob", "I");
		constantAssignments.put("prok", "V");
		computedLiterals.put("Silver", "34");
		processInputTransaction.processInputTransaction(line);
	}
	
	
}
