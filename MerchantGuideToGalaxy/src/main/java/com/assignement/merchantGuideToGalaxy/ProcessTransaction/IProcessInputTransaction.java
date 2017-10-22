/**
 * 
 */
package com.assignement.merchantGuideToGalaxy.ProcessTransaction;

/**
 * @author Praveen gaur
 * processes the inputs.
 * glob is I
 * prok is V
 * pish is X
 * glob glob Silver is 34 Credits
 * how much is pish tegj glob glob ?
 *
 */
public interface IProcessInputTransaction {

	/**
	 * This method is specific to type of transaction.
	 * process the input line and derives type of transaction.
	 * @param line
	 * 
	 */
	public void processInputTransaction(String line);
}
