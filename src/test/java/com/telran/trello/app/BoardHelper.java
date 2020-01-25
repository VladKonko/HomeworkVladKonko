package com.telran.trello.app;

import com.telran.trello.model.BoardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
HeaderHelper header = new HeaderHelper(driver);

    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public int getBoardsCount() {

        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));

    }

    public void fillBoardForm(BoardData boardData) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"),
                boardData.getBoardName());
        click(By.cssSelector("[name=down]"));
        click(By.xpath("//*[contains(text(),'Без команды')]"));
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//span[@name='board']/..//p"));

    }

    public void clickOpenMore() {
        click(By.cssSelector(".js-open-more"));

    }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void startCloseBoard() throws InterruptedException {
        pause(5000);
        click(By.cssSelector(".js-close-board"));
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[type='submit']"));
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirmCloseBoard();
    }

    public void deleteBoard() throws InterruptedException {
        openFirstBoard();
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        permanentlyDeleteBoard();
       header.returnToHomePage();
    }

    public void createBoard() throws InterruptedException {
        header.clickOnPlusButton();
       selectCreateBoardFromDropDown();
       fillBoardForm(new BoardData().setBoardName("qa22" + System.currentTimeMillis()));
        confirmBoardCreation();
        pause(10000);
        header.returnToHomePage();
    }

    public boolean isThereBoard() {
        return getBoardsCount() > 1;
    }
}
