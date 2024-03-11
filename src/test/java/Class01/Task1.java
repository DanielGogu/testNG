package Class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {
    //test case 1
    public static WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void verifyTheLoginFunctionality(){
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn= driver.findElement(By.id("btnLogin"));
        loginBtn.click();
        System.out.println("u have logged in");
    }
    @Test
    public void invalidLogin(){
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admi");
        WebElement password= driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginBtn= driver.findElement(By.id("btnLogin"));
        loginBtn.click();
        System.out.println("u have not logged in");
    }



}
