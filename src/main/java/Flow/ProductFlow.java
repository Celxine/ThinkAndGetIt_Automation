package Flow;

import com.microsoft.playwright.Page;
import pages.HomePage;
import java.util.List;

public class ProductFlow {
    private Page page;
    private HomePage homePage;

    public ProductFlow(Page page) {
        this.page = page;
        this.homePage = new HomePage(page);
    }
    public List<String> sortProductsAndGetResults(String sortValue) {
        homePage.sortProductsByValue(sortValue);        page.waitForLoadState();
        page.waitForTimeout(5000);

        return homePage.getVisibleProductTitles();
    }
}