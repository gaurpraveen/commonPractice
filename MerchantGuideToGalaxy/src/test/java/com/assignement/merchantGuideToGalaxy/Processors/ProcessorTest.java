package com.assignement.merchantGuideToGalaxy.Processors;

import java.util.Map;

import org.junit.Test;

import com.assignement.merchantGuideToGalaxy.ProcessTransaction.IProcessInputTransaction;
import com.assignement.merchantGuideToGalaxy.ProcessTransaction.ProcessAssignementTransactionImpl;
import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;

public class ProcessorTest {

	@Test
	public void processLineAssignmentS() {
		Processor processor = new Processor();
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		String line = "glob is I";
		String key = "glob";
		String val = "I";
		processor.processLine(line);
		String value = constantAssignments.get(key);
		assert(value.equalsIgnoreCase(val));
		
	}
	
	@Test
	public void processLineNoMatch() {
		Processor processor = new Processor();
		String line = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		String val = "I have no idea what you are talking about";
		processor.processLine(line);
		
		assert(TransactionDataStore.getOutput().contains(val));
		
	}
}
