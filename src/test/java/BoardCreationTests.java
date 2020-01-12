import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            loginAcc();
        }
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        int actualRes = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("QA22MFC" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(10000);
        returnToHomePage();
        int expectedRes = getBoardsCount();
        Assert.assertEquals(actualRes + 1, expectedRes);

    }

         @AfterClass
    public void postActions() throws InterruptedException {
        int boardsCount = getBoardsCount();
        while (boardsCount > 4) {
            deleteBoard();
          //  returnToHomePage();
            boardsCount = getBoardsCount();

        }

    }

}