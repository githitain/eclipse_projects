package main.tests.execution;

import java.lang.reflect.Method;

import main.file.handling.exlReader;
import main.file.handling.proReader;
import main.flags.Flags;
import main.sessions.Project;
import main.sessions.SessionsManager;
import main.utils.Logger;
import main.utils.LogStatuses;
import main.utils.StaticWait;

import org.openqa.selenium.Alert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import main.utils.TestRunSuffix;

public  class BasicSuite 
{

		@BeforeMethod(alwaysRun = true)
		public void beforeMethod(Method method)
		//public void beforeMethod()
		//public void beforeMethod()
		{
			//Method method = null;
			
			System.out.println("Step-7-BasicSuite-beforeMethod");
			
			
			TestRunSuffix.refresh();
			System.out.println("BasicSuite-beforeMethod-03");
			Logger.write(LogStatuses.INFO, "########################################################################");
			
			Logger.write(LogStatuses.INFO, "Starting test " + method.getName());
			
			
		}
	
		@AfterMethod(alwaysRun = true)
		public void afterMethod(ITestResult result)
		//public void afterMethod()
		{
			System.out.println("Step-8-BasicSuite-afterMethod");
			//ITestResult result = null;
			System.out.println("BasicSuite-afterMethod-04");
			Reporter.setCurrentTestResult(result);
	
			SessionsManager.getAllSessions().forEach(browserSession ->
			{
				try {
					Alert alert;
					do {
						alert = browserSession.getBrowser().getDriver().switchTo().alert();
						String text = alert.getText();
						alert.accept();
						Logger.write(LogStatuses.ERR, "Alert appears: " + text);
						StaticWait.forSeconds(2);
					} while (alert != null);
	
				} catch (Exception e) {
					Logger.write(LogStatuses.INFO, e.getMessage());
				}
			});
	
	
			if (!result.isSuccess()) {
				SessionsManager.takeScreenshotsFromAllSessions();
			}
	
			Logger.write(LogStatuses.INFO, result.getName() + " test is ended");
			Logger.write(LogStatuses.INFO, "########################################################################");
	
			StaticWait.forSeconds(1);
	
			SessionsManager.getAllSessions().forEach(browserSession ->
			{
				//browserSession.getProject()
				//if(!browserSession.getProject().equals(Project.ENCORE)) {
				if(!browserSession.getProject().equals(browserSession.getProject())) 
				//if(!browserSession.getProject().equals(Project.DC)) {
				
					{
					try 
					{
						browserSession.logout();
						System.out.println("this is current session:" + browserSession.getProject() );
					} catch (Exception e) 
					{
						Logger.write(LogStatuses.DEBUG, "Exception while logging out");
						System.out.println("this is current session:" + browserSession.getProject() );

					}
				}
			});
			Flags.BUFFER_LOCKED.setValue(false);
			SessionsManager.closeAllSessions();
		}
}