package com.telran.trello.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase {


    public HeaderHelper(WebDriver driver) {
        super(driver);
    }
    public void clickOnPlusButton() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));

    }
    public void returnToHomePage() {
        click(By.name("house"));
        click(By.name("house"));
    }
}
