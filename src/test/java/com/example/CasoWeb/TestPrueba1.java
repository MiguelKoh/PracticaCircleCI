package com.example.CasoWeb;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Prueba1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  
  @Test
  public void testCoronavirus() throws Exception {
    driver.get("https://www.google.com/search?q=coronavirus&rlz=1C1NHXL_esMX912MX912&oq=coronavirus&aqs=chrome..69i57j35i39j0i402j0i512j0i131i433i512j69i65l3.6298j0j7&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//div[@id='kp-wp-tab-overview']/div[4]/div/div[2]/div/div/div/div/div/div/div/div/a/h3")).click();
  pause(3000);
  String titulo=driver.findElement(By.xpath("/html/head/title")).getText();
    String esperado="Coronavirus – gob.mx";
    //assertEquals(titulo,esperado);
    assertThat(esperado,is(driver.getTitle()));
  }
  
  
  
  private void pause(long mils) {
	  try {
	  Thread.sleep(mils);
	  }catch(Exception e) {
	  e.printStackTrace();
	  }
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
