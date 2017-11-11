package com.utilites;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.Reporter;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;




public class Logger 
{


		
		public static <T> void info(T message)
		{
		    write(LogStatuses.INFO,message);
	    }
	
		
		
		
		public static <T> void write(LogStatuses status, T message) 
		{
			write(status, message, true);
		}
	
		public static <T> void write(LogStatuses status, T message, Throwable e)
		{
			write(status, message, e, true);
		}
	
		public static void writeSOAPMessage(SOAPMessage message, String methodName, boolean printToConsole) throws IOException, SOAPException 
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			message.writeTo(out);
			String strMsg = new String(out.toByteArray());
			write(LogStatuses.INFO, String.format("Sending '%s' SOAP request: \n   %s", methodName, strMsg), printToConsole);
		}
	
		private static <T> void write(LogStatuses status, T message, Throwable e, boolean printToConsole) 
		{
			write(status, message, printToConsole);
			write(status, "<div class=\"stack-trace\">" + ExceptionUtils.getStackTrace(e) + "</div>", false);
			e.printStackTrace();
		}
	
		private static <T> void write(LogStatuses status, T message, boolean printToConsole) 
		{
			String reportMessage = String.format("%tT %1s %2s", Calendar.getInstance(), status.getStatusName(), message);
			Reporter.log(reportMessage, printToConsole);
			//Reporter.log("<br>", false);
		}
	
		public static void saveScreenshot(File screenshotFile) 
		{
			String fileName = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS").format(Calendar.getInstance().getTime());
			String fullFileName = String.format("../test-output/screenshots/%1s.png", fileName);
	
			File savedFile = new File(fullFileName);
	
			try 
			{
				FileUtils.copyFile(screenshotFile, savedFile);
			} 
			catch (IOException e) 
			{
				Logger.write(LogStatuses.ERR, "Error taking screenshot", e);
			}
	
			//TODO: determine current environment and automatically decide what screenshot path should be used
			//write(LogStatuses.INFO, "<a href=\" ..\\" + savedFile.getPath() + "\">Screenshot</a>", false);
			write(LogStatuses.INFO, "<a href=\"..\\..\\..\\..\\artifact" + savedFile.getPath().replace("..", "").replace("/", "\\") + "\">Screenshot</a>", false);
			System.out.println("Screenshot is saved: " + savedFile.getPath());
	
		}
}