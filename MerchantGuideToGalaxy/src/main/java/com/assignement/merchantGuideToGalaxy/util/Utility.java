package com.assignement.merchantGuideToGalaxy.util;

import com.assignement.merchantGuideToGalaxy.intergalacticTransactions.RomanNumerals;

/**
 * @author Praveen Gaur
 * Utility methods
 *
 */
public class Utility {

	/**Utility methos to convert roman numerals to decimal
	 * @param roman
	 * @return
	 */
	public static String romanToDecimal(String roman)
	{
		String result="";
		//First validate result is 1 if success
		switch(validateRomanNumber(roman))
		{
			case 1 :  result = convert(roman);
					  break;
				
			default : result = MerchantGuideConstants.INVALID_ROMAN_STRING;
		}
		
		return result;
	}
	
	/**Utility to validate if number is roman
	 * @param roman
	 * @return
	 */
	private static int validateRomanNumber(String roman)
	{
		int result = 0;
		//Match with regex
		if(roman.matches(MerchantGuideConstants.romanNumberValidator))
		{
			result = 1;
		}
		
		return result;
	}
	
	/**Converts roman to decimal
	 * @param roman
	 * @return
	 */
	private static String convert(String roman)
	{
		int decimal = 0;
        int lastNumber = 0;
        
		for(int i=roman.length()-1;i>=0;i--)
		{
			char ch = roman.charAt(i);
			//fetch from Roman numerals enum. Check if need to subtract or addup the subsequent charcters
			decimal = CheckRoman(RomanNumerals.getValueFromRomanNumeralsChar(ch), lastNumber, decimal);
            lastNumber = RomanNumerals.getValueFromRomanNumeralsChar(ch);
		}
		
		return decimal+"";
		
	}
/**
 * Rule for addition or subtraction of roman number to form decimal
 * @param TotalDecimal
 * @param LastRomanLetter
 * @param LastDecimal
 * @return
 */
private static int CheckRoman(int TotalDecimal, int LastRomanLetter, int LastDecimal){
		
        if (LastRomanLetter > TotalDecimal) {
            return LastDecimal - TotalDecimal;
        } else {
            return LastDecimal + TotalDecimal;
        }
        
    }
}
