package ui.ProductBrowsing;

import Flow.ProductFlow;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FilterTest {
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
     page.setDefaultTimeout(60000);
    }

    @AfterEach
    void closeContext() {
        page.close();
    }
    @Test
    public void testSortByMostPopularUpdatesResults() {
        ProductFlow productFlow = new ProductFlow(page);

              page.navigate("https://think-and-get-it-frontend.onrender.com/products");
        page.waitForLoadState();
        page.waitForTimeout(3000);

        List<String> defaultProducts = productFlow.sortProductsAndGetResults("newest");
        System.out.println("Default First Product: " + defaultProducts.get(0));

        List<String> popularProducts = productFlow.sortProductsAndGetResults("popular");
        System.out.println("Popular First Product: " + popularProducts.get(0));

        assertNotEquals(defaultProducts.get(0), popularProducts.get(0), "CRITICAL BUG: Sorting by Popular did not change the product order!");
    }
}
//Browser opens visibly
//-Every action moves slowly
//-Element gets highlighted
//-Page scrolls to the element
//-Click happens after delay
//-Browser stays open after execution