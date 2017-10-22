package com.assignement.merchantGuideToGalaxy.ProcessTransaction;

import java.util.Map;

import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;

/**
 * @author Praveen Gaur
 * implementation class for Transaction type of ASSIGNEMENT.
 * eg. glob is I
 *
 */
public class ProcessAssignementTransactionImpl implements IProcessInputTransaction {

	@Override
	public void processInputTransaction(String line) {
		String[] splited = line.trim().split("\\s+");
		Map<String, String> constantAssignments = TransactionDataStore.getConstantassignments();
		constantAssignments.put(splited[0], splited[2]);
	}

}
