package com.assignement.merchantGuideToGalaxy.util;

import com.assignement.merchantGuideToGalaxy.transactionType.TransactionType;

/**
 * @author Praveen Gaur
 * Filter utility to filter each line of file in accord with regex pattern.
 * Decide Transaction type
 *
 */
public class LineFilter {
	
	/**
	 * @author Praveen Gaur
	 * Inner class to enable filter simultaneously
	 *
	 */
	public class Filter
	{
		private TransactionType type;
		private String pattern;
		public Filter(TransactionType type,String pattern)
		{
			this.type = type;
			this.pattern = pattern;
		}
		
		public String getPattern()
		{
			return this.pattern;
					
		}
		
		public TransactionType getType()
		{
			return this.type;
		}
	}

	//regex pattern
	public static String patternAssigned = "^([A-Za-z]+) is ([I|V|X|L|C|D|M])$";
	public static String patternCredits = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
	public static String patternHowMuch = "^how much is (([A-Za-z\\s])+)\\?$";
	public static String patternHowMany= "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";
	private Filter[] filter;
	
	public LineFilter()
	{
		this.filter = new Filter[4];
		this.filter[0] = new Filter(TransactionType.ASSIGNED, patternAssigned);
		this.filter[1] = new Filter(TransactionType.CREDITS, patternCredits);
		this.filter[2] = new Filter(TransactionType.QUESTION_HOW_MUCH, patternHowMuch);
		this.filter[3] = new Filter(TransactionType.QUESTION_HOW_MANY, patternHowMany);
	}
	
	/**This method gives line type in terms of transaction
	 * @param line
	 * @return
	 */
	public TransactionType getLineType(String line)
	{
		line = line.trim();
		TransactionType result = TransactionType.NO_MATCH;
		
		boolean matched = false;
			
		for(int i =0;i<filter.length && !matched ;i++)
		{
			if( line.matches(filter[i].getPattern()) )
			{
				matched = true;
				result = filter[i].getType();
			}
			
		}
		
		return result;
		
	}
}
