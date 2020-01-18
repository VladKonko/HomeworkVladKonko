package com.telran.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAcc();
        }
        if (!app.getBoard().isThereBoard()) {

            app.getBoard().createBoard();
        }

    }

    @Test
    public void testFirstBoardDeletion() throws InterruptedException {
        app.getBoard().openFirstBoard();
        app.getBoard().clickOpenMore();
        app.getBoard().startCloseBoard();
        app.getBoard().confirmCloseBoard();
        app.getBoard().permanentlyDeleteBoard();

    }

}
