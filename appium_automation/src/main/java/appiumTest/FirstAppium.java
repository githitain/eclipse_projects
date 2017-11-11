package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirstAppium 
{
	public static AndroidDriver driver;
	//WebDriver driver
	
	public static void main(String args []) throws MalformedURLException
	{
	    DesiredCapabilities dc = new DesiredCapabilities();

	    dc.setCapability(CapabilityType.BROWSER_NAME,"");
	    dc.setCapability("deviceName", "ad-1");
	    dc.setCapability("platformVerison", "7.0");
	    dc.setCapability("platformName", "Android");
	    
	    dc.setCapability("appPackage", "io.selendroid.testapp");
	    dc.setCapability("appActivity", ".HomeScreenActivity");
	    
	    
	   /* dc.setCapability(MobileCapabilityType.APP, "com.andriod.calculator2.Calulator");
	    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "ad-1");
	    
	    dc.setCapability("BROWSER_NAME","Android");
	    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	    dc.setCapability(MobileCapabilityType.APP, "com.andriod.calculator2");
	    dc.setCapability(MobileCapabilityType.APP, "com.andriod.calculator2.Calulator");
	    dc.setCapability(MobileCapabilityType.DEVICE_NAME, "ad-1");*/
	    
	    //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	    
	    driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	    
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    System.out.println((driver.toString()));
	    
	}
}
