package SeleniumWrapperTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SeleniumTest {
    @BeforeClass
    public void testDriverOpen() {
        Configuration.browser = "chrome";
    }

    @Test
    public void testNavigation() {
        String expectedUrl = "https://www.google.com/";
        open(expectedUrl);

        String currentUrl = WebDriverRunner.url();
        Assert.assertEquals(currentUrl, expectedUrl);
    }
}