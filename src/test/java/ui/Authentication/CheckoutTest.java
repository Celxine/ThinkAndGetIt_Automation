package ui.Authentication;

import Flow.CartFlow;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CheckoutTest {
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
    public void testCartTotalCalculationBug() {
        CartFlow cartFlow = new CartFlow(page);

        page.navigate("https://think-and-get-it-frontend.onrender.com/home");
        page.waitForLoadState();
        page.waitForTimeout(3000);

        String totalText = cartFlow.addItemAndGetTotal();
        System.out.println("Cart Total is displaying as: " + totalText);

        assertNotEquals("$0.00", totalText.trim(), "CRITICAL BUG: Cart total is calculating as $0.00!");
    }
}