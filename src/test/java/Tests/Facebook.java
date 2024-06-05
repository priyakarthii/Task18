package Tests;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Facebook extends MainChromeDriver {

    @Test
public void test()
    {
      chromeDriver.get("https://www.facebook.com/");
      if (chromeDriver.getTitle().contains("Facebook"))
        {
            System.out.println("Successfully navigated to Facebook");
        }
      else {
          System.out.println("Navigation to Facebook homepage failed");
          chromeDriver.quit();
          return;
      }

        //Click on the "Create new account" button

       WebElement createbutton = chromeDriver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
      createbutton.click();
        //Enter first name as "Test" and last name as "User"
        WebElement firstname = chromeDriver.findElement(By.name("firstname"));
        firstname.sendKeys("Text");
        WebElement Secondname = chromeDriver.findElement(By.name("lastname"));
        Secondname.sendKeys("User");
//Enter Email Id and password
        WebElement enterEmailField = chromeDriver.findElement(By.xpath("//input[@name='reg_email__']"));
        enterEmailField.sendKeys("testuser@test.com");
        WebElement reenterEmailField  = chromeDriver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        reenterEmailField .sendKeys("testuser@test.com");
        WebElement passWord = chromeDriver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        passWord.sendKeys("StrongPassword123!");

        // Select the date of birth
        Select dayDropdown = new Select(chromeDriver.findElement(By.id("day")));
        dayDropdown.selectByVisibleText("11");

        Select monthDropdown = new Select(chromeDriver.findElement(By.id("month")));
        monthDropdown.selectByVisibleText("May");

        Select yearDropdown = new Select(chromeDriver.findElement(By.id("year")));
        yearDropdown.selectByVisibleText("1985");

        try {
            Thread.sleep(1000);  // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Select the gender

        WebElement genderradiobutton = chromeDriver.findElement(By.xpath("//input[@value='1']"));
genderradiobutton.click();

     //click submit button
        WebElement submit = chromeDriver.findElement(By.xpath("//button[@name='websubmit']"));
        submit.click();


    }




}
