package Class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HardAssertions {
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(groups= {"regression","smoke"})
    public void verifyTheLoginFunctionality(){
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn= driver.findElement(By.id("btnLogin"));
        loginBtn.click();
        WebElement dashBoard=driver.findElement(By.xpath("//h1[text()='Dashboard']"));
        String actualText= dashBoard.getText();
        System.out.println(actualText);
        String expectedText="Dashboard";
        System.out.println(expectedText);
        Assert.assertEquals(actualText,expectedText);


        boolean stateOfdashBOardText=dashBoard.isDisplayed();
        Assert.assertTrue(stateOfdashBOardText);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
