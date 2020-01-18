package com.telran.trello.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
        BoardHelper board;
        HeaderHelper header;
        SessionHelper session;
        TeamHelper team;

    public void init() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        openSite("https://www.trello.com/");

        session = new SessionHelper(driver);
        board = new BoardHelper(driver);
        header = new HeaderHelper(driver);
        team = new TeamHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public BoardHelper getBoard() {
        return board;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public SessionHelper getSession() {
        return session;
    }

    public TeamHelper getTeam() {
        return team;
    }
}
