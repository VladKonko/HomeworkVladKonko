import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
   protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @AfterSuite
    public void tearDown() {

        driver.quit();
    }
    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }
    public void clickLoginLink() {

        click(By.cssSelector("[href='/login']"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }





    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }




    protected void loginAcc() throws InterruptedException {
        clickLoginLink();

        type(By.id("user"), "vlad.konko.fortest@gmail.com");

        fillLoginForm("vlad.konko.fortest@gmail.com", "Trello778899");
        pause(20000);
    }

    public void fillLoginForm(String user,String pwd) throws InterruptedException {
        type(By.id("user"), user);
        pause(5000);
        click(By.id("login"));
        click(By.id("login-submit"));
        type(By.id("password"), pwd);
        click(By.id("login-submit"));
    }

    public void clickLogoutButton() {
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }
    public void logout() {
        clickOnAvatar();
        clickLogoutButton();
    }
}