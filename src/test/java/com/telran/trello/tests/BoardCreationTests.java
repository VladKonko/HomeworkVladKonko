package com.telran.trello.tests;

import com.telran.trello.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
@DataProvider
public Iterator<Object[]> validBoards() throws IOException {

    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boardsData.csv")));
    {
       String line = reader.readLine();


        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{new BoardData().setBoardName(split[0])});
            line = reader.readLine();
        }



        return list.iterator();
    }
}

    @BeforeMethod
    public void preconditions () throws InterruptedException {
        if (!app.getSession().isAvatarPresentOnHeader()) {
            app.getSession().loginAcc();
        }
    }
    //@Test(dataProvider = "validBoards")
    //public void testBoardCreationFromHeaderFromCSV (BoardData board) throws InterruptedException {
   //     int actualRes = app.getBoard().getBoardsCount();
     //   app.getHeader().clickOnPlusButton();
      //  app.getBoard().selectCreateBoardFromDropDown();
      //  app.getBoard().fillBoardForm(board);
      //  app.getBoard().confirmBoardCreation();
       // app.getSession().pause(10000);
       // app.getHeader().returnToHomePage();
       // int expectedRes = app.getBoard().getBoardsCount();
      //  Assert.assertEquals(actualRes + 1, expectedRes);

   // }
    @Test
    public void testBoardCreationFromHeader () throws InterruptedException {
        int actualRes = app.getBoard().getBoardsCount();
        app.getHeader().clickOnPlusButton();
        app.getBoard().selectCreateBoardFromDropDown();
        app.getBoard().fillBoardForm(new BoardData().setBoardName("QA22MFC" + System.currentTimeMillis()));
        app.getBoard().confirmBoardCreation();
        app.getSession().pause(10000);
        app.getHeader().returnToHomePage();
        int expectedRes = app.getBoard().getBoardsCount();
        Assert.assertEquals(actualRes + 1, expectedRes);

    }

    @AfterClass
    public void postActions () throws InterruptedException {
        int boardsCount = app.getBoard().getBoardsCount();
        while (boardsCount > 4) {
            app.getBoard().pause(4000);
            app.getBoard().deleteBoard();
            //  returnToHomePage();
            boardsCount = app.getBoard().getBoardsCount();

        }

    }

}