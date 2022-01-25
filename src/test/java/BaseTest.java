import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import helpers.ConfigProperties;
import helpers.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected Browser browser;
    protected String testUrl = ConfigProperties.get("test_protocol") + ConfigProperties.get("steam_url");

    @BeforeMethod
    public void setUp() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(testUrl);
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }
}
