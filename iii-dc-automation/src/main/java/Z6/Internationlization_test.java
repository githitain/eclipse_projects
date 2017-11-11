package Z6;



import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Internationlization_test 
{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception 
  {
		System.setProperty("webdriver.firefox.marionette","D:\\Automation_Software\\Selenium Jars\\geckodriver.exe");
  
    driver = new FirefoxDriver();
    baseUrl = "http://dc-autonoida.iii.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testI18n() throws Exception {
    driver.get(baseUrl + "/iii/dc-noida/login/auth");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("noidaadmin");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("dcadmin");
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.xpath("//img[@alt='evaluation']")).click();
    //driver.findElement(By.cssSelector("span.innoText.innoTextParent")).click();
    
    //WebElement formElement = driver.findElement(By.name("something"));
    List<WebElement> allFormChildElements = driver.findElements(By.xpath("//*"));
    
    System.out.println("Size from evalution:" +allFormChildElements.size());
    
 for(WebElement item : allFormChildElements )
    {
        if(item.getTagName().equals("a")) 
        {
        	System.out.println("input tag value: " + item.getAttribute("text")); 
            switch(item.getAttribute("type")) 
            {
            case "text": 
                //specify text value
                break;
            case "checkbox":
                //check or uncheck
                break;
            //and so on
            }
        }
        else if(item.getTagName().equals("span")) 
        {
        	System.out.println("div span value: " + item.getAttribute("text")); 
        }  
    }
    
 
    
    List<WebElement> allspan= driver.findElements(By.xpath("//span"));
    
    System.out.println("Size from evalution:" +allspan.size());
    
  
    driver.findElement(By.xpath("//img[@alt='development']")).click();
  
    List<WebElement> allFormChildElements2 = driver.findElements(By.xpath("//*"));
    
    System.out.println("Size from development:" +allFormChildElements2.size());
    

   
    driver.findElement(By.xpath(".//*[@id='dashboardContent_development']/table/tbody/tr/td[2]/div/div[1]/ul[1]/li/ul/li/ul/li[1]/span[1]/a")).click();
    
    List<WebElement> allFormChildElements3 = driver.findElements(By.xpath("//*"));
    
    System.out.println("Size from report:" +allFormChildElements3.size());
    
    
    List<WebElement> allspan3= driver.findElements(By.xpath("//span"));
    
    System.out.println("Size from evalution:" +allspan3.size());
    
   
    
    Thread.sleep(3000);
    
    
    driver.findElement(By.linkText("Sign out")).click();

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
