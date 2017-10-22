package com.assignement.merchantGuideToGalaxy.Processors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.assignement.merchantGuideToGalaxy.Exceptions.InputFilePathException;
import com.assignement.merchantGuideToGalaxy.ProcessTransaction.IProcessInputTransaction;
import com.assignement.merchantGuideToGalaxy.factory.TransactionFactory;
import com.assignement.merchantGuideToGalaxy.transactionData.TransactionDataStore;
import com.assignement.merchantGuideToGalaxy.transactionType.TransactionType;
import com.assignement.merchantGuideToGalaxy.util.LineFilter;
import com.assignement.merchantGuideToGalaxy.util.MerchantGuideConstants;

/**
 * @author Praveen gaur
 * This is generic Processor.
 * Determines the transaction type for each line from input file
 * and delegates the processing to appropriate processor.
 *
 */
public class Processor {
	
	IProcessInputTransaction processInputTransaction = null;
	private LineFilter lineFilter = new LineFilter();

	/**
	 * This method reads the input file from given path and process each line.
	 * @param filePath
	 * @throws InputFilePathException
	 * @throws IOException
	 */
	public void ProcessFile(String filePath) throws InputFilePathException, IOException {
		BufferedReader bufferedReader = null;
		if (filePath == null){
			throw new InputFilePathException();
		}
		
		FileReader fileReader = new FileReader(filePath);
		bufferedReader = new BufferedReader(fileReader);
		
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			processLine(line);
		}
		bufferedReader.close();
	}

	/**
	 * This method process input line and determines transaction type depicted from each line.
	 * If no valid type then output error message
	 * @param line
	 */
	public void processLine(String line) {
		
		//String arr[] = line.split("((?<=:)|(?=:))|( )");
		TransactionType lineType = this.lineFilter.getLineType(line);
		if (lineType == TransactionType.QUESTION_HOW_MUCH) {
			
				processInputTransaction = TransactionFactory.getTransactionInstance(MerchantGuideConstants.QUESTION_HOW_MUCH_TYPE);
				processInputTransaction.processInputTransaction(line);
		}
		else if (lineType == TransactionType.QUESTION_HOW_MANY) {
				processInputTransaction = TransactionFactory.getTransactionInstance(MerchantGuideConstants.QUESTION_HOW_MANY_TYPE);
				processInputTransaction.processInputTransaction(line);
		}
		else if (lineType == TransactionType.ASSIGNED) {
			processInputTransaction = TransactionFactory.getTransactionInstance(MerchantGuideConstants.ASSIGNED_TYPE);
			processInputTransaction.processInputTransaction(line);
		}
		else if(lineType == TransactionType.CREDITS) {
			processInputTransaction = TransactionFactory.getTransactionInstance(MerchantGuideConstants.CREDITS_TYPE);
			processInputTransaction.processInputTransaction(line);
		}
		else if(lineType == TransactionType.NO_MATCH) {
			TransactionDataStore.getOutput().add(MerchantGuideConstants.NO_IDEA);
		}

	}

}
