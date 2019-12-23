import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TelRanHW extends TestBase{


    @Test
public void Headers() throws InterruptedException {
        openSite("https://www.tel-ran.com/");
        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja0linkElement"));

              String main = read(By.xpath("//body//h1[1]"));
                 System.out.println("Заголовок главной страницы "+"'"+main+"'");
        Thread.sleep(5000);

        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja2linkElement"));

             String headAbUs = read(By.xpath("//div[@id='comp-k2d3m6ja1bg']//p[@id='comp-k2d3m6ja1label']"));
                System.out.println("Заголовок страницы О нас"+"'"+headAbUs+"'");
        Thread.sleep(5000);

        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja3linkElement"));

                String coursesHead = read(By.xpath("//div[@id='comp-k2lwlhsp']//h1[@class='font_0']"));
                     System.out.println("Заголовок страницы Курсы"+"'"+coursesHead+"'");



        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja4linkElement"));
                String employHead = read(By.xpath("//h1[@class='font_0']"));
                    System.out.println("Заголовок страницы Трудоустройство"+"'"+employHead+"'");


        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja4label"));
                String reviewHead = read(By.xpath("//div[@id='comp-k2yoaibp']//h1[@class='font_0']"));
                 System.out.println("Заголовок страницы Отзывы"+"'"+reviewHead+"'");


        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja5linkElement"));
                String blogHead = read(By.xpath("//div[@id='comp-k2yqvjis']//h1[@class='font_0']"));
                    System.out.println("Заголовок страницы Блог"+"'"+blogHead+"'");



        clickHeaderButton(By.cssSelector("#comp-k2d3m6ja6linkElement"));
                String contactHead = read(By.xpath("//div[@id='comp-k2ysntl7']//h1[@class='font_0']"));
                    System.out.println("Заголовок страницы Контакты"+"'"+contactHead+"'");




    }

    public String read(By locator) {
        return driver.findElement(locator).getText();
    }

    public void clickHeaderButton(By cssSelector) {
        driver.findElement(cssSelector).click();
    }


}
