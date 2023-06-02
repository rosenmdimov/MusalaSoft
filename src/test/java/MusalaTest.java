import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MusalaTest extends BaseTest {

    @Test
    @DisplayName("The First Test")
    public void newPageVisited() {
        webApp.homePage().goToHome();
    }


}
