package com.telran.trello.tests;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TrelloLoginHw extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().logout();


        }

    }



    @Test
    public void logInTest() throws InterruptedException {
    //loginAcc();


        app.getSession().click(By.cssSelector("[href='/login']"));

        app.getSession().type(By.id("user"), "vlad.konko.fortest@gmail.com");

        Thread.sleep(5000);
        app.getSession().click(By.cssSelector("#login"));
        app.getSession().click(By.cssSelector("#login-submit"));

        app.getSession().type(By.cssSelector("#password"), "Trello778899");
        app.getSession().click(By.cssSelector("#login-submit"));


        app.driver.findElement(By.id("surface")).isDisplayed();


    }


}
