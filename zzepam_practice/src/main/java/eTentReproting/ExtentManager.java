package eTentReproting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager 
{
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;
	public static String filePath = "./extentreport.html";
	
	
	public static ExtentReports GetExtent()
	{
		if (extent != null)
                    return extent; //avoid creating new instance of html file
                extent = new ExtentReports();		
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	public static ExtentHtmlReporter getHtmlReporter() 
	{
	
        htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.loadXMLConfig("./report_config.xml");
		
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
		
        htmlReporter.config().setDocumentTitle("QAV automation report");
        htmlReporter.config().setReportName("Regression cycle");
        return htmlReporter;
	}
	
	public static ExtentTest createTest(String name, String description)
	{
		test = extent.createTest(name, description);
		return test;
	}
}
