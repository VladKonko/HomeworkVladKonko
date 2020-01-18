package com.telran.trello.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAcc();
        }
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int actualRes = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardForm("QA22MFC" + System.currentTimeMillis());
        app.getBoard().confirmBoardCreation();
        app.getSession().pause(10000);
        app.getHeader().returnToHomePage();
        int expectedRes = app.getBoard().getBoardsCount();
        Assert.assertEquals(actualRes + 1, expectedRes);

    }

         @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = app.getBoard().getBoardsCount();
        while (boardsCount > 4) {
            app.getBoard().deleteBoard();
          //  returnToHomePage();
            boardsCount = app.getBoard().getBoardsCount();

        }

    }

}