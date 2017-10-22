package com.assignement.merchantGuideToGalaxy.ProcessOutput;

import java.util.List;

import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;

/**
 * @author Praveen gaur
 * This class is responsible to loop through output array and display output
 *
 */
public class ProcessOutputImpl implements IProcessOutput{

	
	@Override
	public void processOutput() {
		List<String> output = TransactionDataStore.getOutput();
		output.forEach(System.out::println);
		
	}

}
