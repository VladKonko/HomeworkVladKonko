
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!isAvatarPresentOnHeader()) {
            loginAcc();
        }
        if (!isThereBoard()) {

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

    public boolean isThereBoard() {
        return getBoardsCount() > 1;
    }

}
