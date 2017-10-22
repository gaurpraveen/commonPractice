package com.assignement.merchantGuideToGalaxy.transactionType;

/**
 * @author Praveen Gaur
 * Enum for Transaction types
 *
 */
public enum TransactionType {
	ASSIGNED("ASSIGNED") , CREDITS("CREDITS"), QUESTION_HOW_MUCH("QUESTION_HOW_MUCH"), 
	QUESTION_HOW_MANY("QUESTION_HOW_MANY"),NO_MATCH("NO_MATCH");
	private final String type;
	
	private TransactionType(String type){
		this.type=type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
}
