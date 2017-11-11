package com.setting;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//import org.apache.commons.io.IOUtils;

public class TestSettings
{

	public static final TestSettings Current = new TestSettings();
	
	private static final ThreadLocal<Boolean> logExceptions = new ThreadLocal<>();

	public synchronized static Boolean getLogExceptions()
	{
		if (logExceptions.get() == null) {
			logExceptions.set(true);
		}
		
		return logExceptions.get();
	}
	
	public synchronized static void setLogExceptions(boolean value)
	{
		logExceptions.set(value);
	}

	private final Properties prop = new Properties();
	
	private String propertyFile;

	private String sierraWebURL;
	private String sierraAdminWebURL;
	private String encoreWebURL;
	private String dcWebURL;
	private String webPacWebURL;
	private String appServerURL;

	private String driverPath;
	private int waitElementTimeout;
	private int waitFlagsTimeout;
	private Boolean repeatUIAction;

	private String browserType;
	private String browserName;
	
	private String testRailUrl;
	private String testRailUsername;
	private String testRailPassword;

	private Boolean useChainedProxy;
	private String chainedProxyHost;
	private int chainedProxyPort;

	private String sshUser;
	private String sshHost;
	private int sshPort;
	private String sshPass;

	private String testFilesFolder;

	private String tempFolder;

	private Boolean printSOAPMessage;

	public TestSettings() 
	{
		
		propertyFile = ((propertyFile = System.getenv("PROPERTY_FILE")) != null) ?
		propertyFile : "test.properties";
		InputStream input = getClass().getClassLoader().getResourceAsStream(propertyFile);
		
		
		try
		{
			prop.load(input);
			
			System.out.println(propertyFile);

			sierraWebURL = ((sierraWebURL = System.getenv("SIERRA_WEB_URL")) != null) ?
					sierraWebURL : prop.getProperty("SierraWebURL");
			
			encoreWebURL = ((encoreWebURL = System.getenv("ENCORE_WEB_URL")) != null) ?
					encoreWebURL : prop.getProperty("EncoreWebURL");
			
			dcWebURL = ((dcWebURL = System.getenv("DC_WEB_URL")) != null) ?
					dcWebURL : prop.getProperty("DCWebURL");
			
			
			appServerURL = ((appServerURL = System.getenv("APP_SERVER_URL")) != null) ?
					appServerURL : prop.getProperty("AppServerURL");
			sierraAdminWebURL = ((sierraAdminWebURL = System.getenv("SIERRA_ADMIN_WEB_URL")) != null) ?
					sierraAdminWebURL : prop.getProperty("SierraAdminWebURL");
			driverPath = ((driverPath = System.getenv("DRIVER_PATH")) != null) ?
					driverPath : prop.getProperty("DriverPath");
			String waitElementTimeoutStr = ((waitElementTimeoutStr = System.getenv("WAIT_ELEMENT_TIMEOUT")) != null) ?
					waitElementTimeoutStr : prop.getProperty("WaitElementTimeout");
			waitElementTimeout = Integer.parseInt(waitElementTimeoutStr);

			String waitFlagsTimeoutStr = ((waitFlagsTimeoutStr = System.getenv("WAIT_FLAGS_TIMEOUT")) != null) ?
					waitFlagsTimeoutStr : prop.getProperty("WaitFlagsTimeout");
			waitFlagsTimeout = Integer.parseInt(waitFlagsTimeoutStr);

			String repeatUIActionStr = prop.getProperty("RepeatUIAction");
			repeatUIAction = repeatUIActionStr == null || Boolean.parseBoolean(repeatUIActionStr);

			browserName = ((browserName = System.getenv("BROWSER_NAME")) != null) ?
					browserName : prop.getProperty("BrowserName");
			browserType = ((browserType = System.getenv("BROWSER_TYPE")) != null) ?
					browserType : prop.getProperty("BrowserType");

			testRailUrl = ((testRailUrl = System.getenv("TESTRAIL_URL")) != null) ?
					testRailUrl : prop.getProperty("TestRailUrl");
			testRailUsername = ((testRailUsername = System.getenv("TESTRAIL_USERNAME")) != null) ?
					testRailUsername : prop.getProperty("TestRailUsername");
			testRailPassword = ((testRailPassword = System.getenv("TESTRAIL_PASSWORD")) != null) ?
					testRailPassword : prop.getProperty("TestRailPassword");

			String useChainedProxyStr = ((useChainedProxyStr = System.getenv("USE_CHAINED_PROXY")) != null) ?
					useChainedProxyStr : prop.getProperty("UseChainedProxy");
			useChainedProxy = Boolean.parseBoolean(prop.getProperty(useChainedProxyStr));
			chainedProxyHost = ((chainedProxyHost = System.getenv("CHAINED_PROXY_HOST")) != null) ?
					chainedProxyHost : prop.getProperty("ChainedProxyHost");
			String chainedProxyPortStr = ((chainedProxyPortStr = System.getenv("CHAINED_PROXY_PORT")) != null) ?
					chainedProxyPortStr : prop.getProperty("ChainedProxyPort");
			chainedProxyPort = Integer.parseInt(chainedProxyPortStr);

			sshHost = ((sshHost = System.getenv("SSH_HOST")) != null) ?
					sshHost : prop.getProperty("SSHHost");

			sshUser = prop.getProperty("SSHUser");
			sshPort = Integer.parseInt(prop.getProperty("SSHPort"));
			sshPass = prop.getProperty("SSHPassword");
			testFilesFolder = prop.getProperty("TestFilesFolder");

			tempFolder = ((tempFolder = System.getenv("TEMP_FOLDER")) != null) ?
					tempFolder : prop.getProperty("TempFolder");

			if (tempFolder != null) {
				File tempFolderFile = new File(((tempFolder = System.getenv("TEMP_FOLDER")) != null) ?
						tempFolder : prop.getProperty("TempFolder"));
				tempFolder = tempFolderFile.getAbsolutePath();
			}

			String printSOAPMessageStr = ((printSOAPMessageStr = System.getenv("PRINT_SOAP_MESSAGE")) != null) ?
					printSOAPMessageStr : prop.getProperty("PrintSOAPMessage");
			printSOAPMessage = Boolean.parseBoolean(printSOAPMessageStr);
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
		
	//################# Common section #################
	public String getSierraWebURL()
	{
		return sierraWebURL;
	}
	
	public String getDCWebURL()
	{
		return dcWebURL;
	}

	public String getSierraAdminWebURL() {
		return sierraAdminWebURL;
	}

	public String getEncoreWebURL(){
		return encoreWebURL;
	}

	public String getAppServerURL() {
		return appServerURL;
	}

	public String getWebPacWebURL() {
		return webPacWebURL;
	}
	
	public String getDriverPath(){
		return driverPath;
	}
	
	public int getWaitElementTimeout(){
		return waitElementTimeout;
	}

	public int getWaitFlagsTimeout(){
		return waitFlagsTimeout;
	}

	public boolean getRepeatUIAction() {
		return repeatUIAction;
	}
	
	public String getBrowserName(){
		return browserName;
	}
	
	public String getBrowserType(){
		return browserType;
	}

	//################## BrowserMob Proxy Settings #################
	public Boolean getUseChainedProxy(){
		return useChainedProxy;
	}

	public String getChainedProxyHost(){
		return chainedProxyHost;
	}

	public int getChainedProxyPort(){
		return chainedProxyPort;
	}

	//################# TestRail section #################
	public String getTestRailUrl() {
		return testRailUrl;
	}

	public String getTestRailUsername() {
		return testRailUsername;
	}

	public String getTestRailPassword() {
		return testRailPassword;
	}

	//################# SSHClient section #################
	public String getSshUser() 
	{ return sshUser; 
	}

	public String getSshHost() { return sshHost; }

	public int getSshPort() { return sshPort; }

	public String getSshPass() { return sshPass; }
	public String getTestFilesFolder() {
		return testFilesFolder;
	}

	public String getTempFolder() {
		return tempFolder;
	}

	public Boolean getPrintSOAPMessage() {
		return printSOAPMessage;
	}

}
