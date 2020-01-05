import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase{

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            loginAcc();
        }
        if(!isThereBoard()){

            createBoard();
    }

    }
    @Test
    public void testFirstBoardDeletion() throws InterruptedException {
        openFirstBoard();
        clickOpenMore();
        startCloseBoard();
        confirmCloseBoard();
        permanentlyDeleteBoard();
    }

    public void clickOpenMore() {
        click(By.cssSelector(".js-open-more"));

    }

    public void openFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public boolean isThereBoard() {
        return getBoardsCount()>1;
    }

   public void createBoard() throws InterruptedException {
        clickOnPlusButton();
        selectCreateBoardFromDropDown();
        fillBoardForm("QA22MFC" + System.currentTimeMillis());
        confirmBoardCreation();
        pause(10000);
        returnToHomePage();
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

}
