package ui.Authentication;

import Flow.LoginFlow;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginTest {
    static Playwright playwright;
    static Browser browser;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
              browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        page = browser.newPage();
    }

    @AfterEach
    void closeContext() {
        page.close();
    }

    @Test
    void testAdminLoginSuccessfully() {

        LoginFlow loginFlow = new LoginFlow(page);

        loginFlow.loginAsAdmin("admin1@thinkandgetit.com", "Admin@123456");


        page.waitForTimeout(3000);
        assertFalse(page.url().endsWith("/login"), "URL should change after successful login");

        System.out.println("Login successful! Current URL: " + page.url());
    }
}