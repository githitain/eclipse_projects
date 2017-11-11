package com.dc.connectivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;




public class exlReader 
{
	private FileInputStream stream;
	private String RepositoryFile;
	static String  sheetName = "element";
	private static Properties propertyFile = new Properties();
	static Map<String,Map> mastersheet = new HashMap<>();
	static String key, locator, locatorvalue;
	private static boolean loaded = false; 
	
	//load_Propertyload_Property lp;
	
	
	public static void main (String args[])
	{
		exlReader lE=new exlReader();
		//load_Property lp=new load_Property();
		System.out.println(getbjectLocator("DC","username_inputbox")); 
		System.out.println(getbjectLocator("DC","username_inputbox")); 
		//System.out.println(getbjectLocator("SBI","Cop_log_select"));
	}
	
	public exlReader()
	{
		System.out.println("Excel loading time-constrcutor");
		load();
	}
	
	 public static void readExcelData(FileInputStream fis) 
	 {
		
		 System.out.println("loading excel file-readExcelData");
			try
			{
			
			/*File myFile = new File(PFile_Parsar.getOR("OR"));
			FileInputStream fis = new FileInputStream(myFile);
			*/
			
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			int numberOfSheets = myWorkBook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheets; i++) 
			{

				Map<String,objectRepMapExl> map = new HashMap<>();
				Sheet sheet = myWorkBook.getSheetAt(i);
				sheetName = myWorkBook.getSheetName(i);
				Iterator<Row> rowIterator = sheet.iterator();

				while (rowIterator.hasNext()) {

					 key = "";
	            	 locator = "";
	            	 locatorvalue="";

					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (key.equalsIgnoreCase("")) {
								key = cell.getStringCellValue().trim();
							}
							else if (locator.equalsIgnoreCase("")) {
								locator = cell.getStringCellValue().trim();
							}
							else if(locatorvalue.equalsIgnoreCase("")){
								locatorvalue = cell.getStringCellValue().trim();
								
								}
	    					else{
	    						System.out.println(cell.getStringCellValue());
	    					}
	    					break;
	    					case Cell.CELL_TYPE_NUMERIC:
	    						String nvalue=String.valueOf(cell.getNumericCellValue());
	    						locatorvalue=nvalue.replaceAll("(?<=^\\d+)\\.0*$", "");
	    						map.put(key,new objectRepMapExl(locator, locatorvalue));
	    							}
	    					} 
					map.put(key,new objectRepMapExl(locator, locatorvalue));
							}
				mastersheet.put(sheetName, map);
				}
			fis.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	 }
	 
	 
	 public static  By getbjectLocator(String Sheetname, String Key)
		{
		
		//	System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+ Sheetname+":::::::::::::::::::::::::::::::::::"+Key );
			String stepType;
			String stepValue;
			
			Map<String,objectRepMapExl> m=mastersheet.get(Sheetname);
			//System.out.println("Size :"+m.values());
			//System.out.println("Size :"+m.size());
			objectRepMapExl o= m.get(Key);
			stepType=o.getLocator();
			//System.out.println("stepType::::::::::::::::::::::::::"+stepType);
			
			stepValue=o.getLocatorvalue();
			//System.out.println("stepValue::::::::::::::::::::::::::"+stepValue);
			//String locatorProperty = propertyFile.getProperty(locatorName);
				//		System.out.println(locatorProperty.toString());
		//	String locatorType = locatorProperty.split(":")[0];
			//String locatorValue = locatorProperty.split(":")[1];
	 
			By locator = null;
			switch(stepType)
			{
			case "id":
				locator = By.id(stepValue);
				break;
			case "name":
				locator = By.name(stepValue);
				break;
			case "cssSelector":
				locator = By.cssSelector(stepValue);
				break;
			case "linkText":
				locator = By.linkText(stepValue);
				break;
			case "partialLinkText":
				locator = By.partialLinkText(stepValue);
				break;
			case "tagName":
				locator = By.tagName(stepValue);
				break;
			case "xpath":
				locator = By.xpath(stepValue);
				break;
			}
			//System.out.println(locator);
			return locator;
			
		}
	 
	
	public void load()
	{
		try
		{
			//System.out.println(ToolVariables.basePath+"/"+TestSuiteHandler.objectRepopath);
			FileInputStream in = new FileInputStream(proReader.getString("OR"));
			//FileInputStream in = new FileInputStream("D://Existing_Framework//DC_BDD_7-17-2017//Resources//Demo.xlsx");

			
		//	FileInputStream in = new FileInputStream(new File("D://ObjectRepoForWebpac.xlsx"));
			readExcelData(in);
			}
		catch(Exception e)
			{
				System.out.println("Please provide object repository file");
				e.printStackTrace();
				
			}
	}

}