/**
 * 
 */
package com.assignement.merchantGuideToGalaxy.intergalacticTransactions;

/**
 * @author Praveen Gaur
 * This is Enum to map roman numbers to corresponding decimal values
 *
 */
public enum RomanNumerals {
	I(1) , V(5), X(10), L(50), C(100), D(500), M(1000);
	private final int value;
	
	private RomanNumerals(int value){
		this.value=value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	public static int getValueFromRomanNumeralsChar(char RomanNumeralsChar)
	{
		int value = -1;
		
		switch(RomanNumeralsChar)
		{
			case 'I' : value = RomanNumerals.I.getValue();
						break;
			case 'V' : value = RomanNumerals.V.getValue();
						break;
			case 'X' : value = RomanNumerals.X.getValue();
						break;
			case 'L' : value = RomanNumerals.L.getValue();
						break;
			
			case 'C' : value = RomanNumerals.C.getValue();
						break;
			
			case 'D' : value = RomanNumerals.D.getValue();
						break;
			
			case 'M' : value = RomanNumerals.M.getValue();
						break;
			
		}
		
		return value;
	}
}
