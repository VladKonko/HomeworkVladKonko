import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class TrelloLoginHw extends TestBase  {



    @Test
    public void logInTest() throws InterruptedException {

        openSite("https://trello.com/");
        click(By.cssSelector("[href='/login']"));

        type(By.id("user"),"vlad.konko.fortest@gmail.com");

        Thread.sleep(5000);
        click(By.cssSelector("#login"));
        click(By.cssSelector("#login-submit"));
        type(By.cssSelector("#password"),"Trello778899");
        click(By.cssSelector("#login-submit"));

        driver.findElement(By.id("surface")).isDisplayed();






    }


}
