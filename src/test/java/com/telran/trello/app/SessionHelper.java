package com.telran.trello.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {

        click(By.cssSelector("[href='/login']"));
    }

    public boolean isAvatarPresentOnHeader() {
        return isElementPresent
                (By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void loginAcc() throws InterruptedException {
        clickLoginLink();

        type(By.id("user"), "vlad.konko.fortest@gmail.com");

        fillLoginForm("vlad.konko.fortest@gmail.com", "Trello778899");
        pause(20000);
    }

    public void fillLoginForm(String user, String pwd) throws InterruptedException {
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

    public void logout() {
        clickOnAvatar();
        clickLogoutButton();
    }
}
