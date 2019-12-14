import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWiki {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){driver = new ChromeDriver();}

    @Test
    public void Login() throws InterruptedException {
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);
        driver.findElement(By.id("js-link-box-en")).click();
        driver.findElement(By.id("pt-login")).click();
        driver.findElement(By.name("wpName")).click();
        driver.findElement(By.name("wpName")).clear();
            driver.findElement(By.name("wpName")).click();
        driver.findElement(By.name("wpName")).sendKeys("KonkoVladik");
        driver.findElement(By.id("wpPassword1")).click();
        driver.findElement(By.id("wpPassword1")).clear();
        driver.findElement(By.id("wpPassword1")).sendKeys("wiki7777");
        driver.findElement(By.id("wpLoginAttempt")).click();
        //Thread.sleep(7000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}
