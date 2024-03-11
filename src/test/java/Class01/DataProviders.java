package Class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviders {
    //Testcase
    /*
    verify the login functionality for wrong credentials with the correct error message
    {"Admin","12345","Invalid credential"},
    {"ABCD","Hum@nhrm123","Invalid credential"},
    {"Admin","","Password cannot be empty"},
    {"","Hum@nhrm123","Username cannot be empty"}
    */

    //DataProvider
    @DataProvider(name="cred")
    public Object[][] data(){
        Object[][] loginData={
                {"Admin","12345","Invalid credentials"},
                {"ABCD","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password is Empty"},
                {"","Hum@nhrm123","Username cannot be empty"}
        };
        return loginData;
    }
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void SetupBrowser(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(dataProvider = "cred")
    public void loginTest(String username,String pass,String Message){
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys(username);
        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys(pass);
        WebElement loginBtn= driver.findElement(By.id("btnLogin"));
        loginBtn.click();
        WebElement errorMsg= driver.findElement(By.id("spanMessage"));
        String actualError=errorMsg.getText();

        Assert.assertEquals(actualError,Message);


    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
