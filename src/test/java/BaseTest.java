import org.apiguardian.api.API;
import org.example.Utils.WebApp;
import org.example.webdrivermanager.LocalWebDriver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.time.LocalTime;

//import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.platform.commons.JUnitException;

import static org.apiguardian.api.API.Status.STABLE;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;

//@ExtendWith(MyParameterResolver.class)
//@API(status = API.Status.STABLE,since = "5.0")
@ExtendWith(MyParameterResolver.class)
class BaseTest {
    protected WebApp webApp;

    @BeforeAll
    public void beforeEach() {
        webApp = new WebApp();
    }


    @BeforeEach
    public void beforeAll() {
        webApp.openBrowser();
    }


    @AfterEach
    public void tearDown(ExtensionContext extensionContext) {
        if (System.getProperty("take.screenshots.enabled").equalsIgnoreCase("true")) {
            Method testMethod = extensionContext.getRequiredTestMethod();
            boolean testFailed = extensionContext.getExecutionException().isPresent();
            if (testFailed) {
                webApp.takeScreenshot(testMethod.getDeclaringClass().getSimpleName(), testMethod.getName(), LocalTime.now());
            }
        }
        webApp.quit();
    }

}

