package com.assignement.merchantGuideToGalaxy.application;

import com.assignement.merchantGuideToGalaxy.ProcessOutput.IProcessOutput;
import com.assignement.merchantGuideToGalaxy.ProcessOutput.ProcessOutputImpl;
import com.assignement.merchantGuideToGalaxy.Processors.Processor;

/**
 * Application Driver Class.
 * Accepts input file path as args[]
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//String filePath = "C:\\Dev\\commonPractice\\MerchantGuideToGalaxy\\Input.txt";
    	String filePath = null;
		if (args.length != 0)
			filePath = args[0];
		try{
			Processor processor = new Processor();
			IProcessOutput output = new ProcessOutputImpl();
			processor.ProcessFile(filePath);
			output.processOutput();
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Oops !! File Not Found ");
		}
    }
}
