package pages;

import com.microsoft.playwright.Page;
import java.util.List;

public class HomePage {
    private Page page;

     private final String bagsFilterButton = "button:has-text('Bags & Luggage')";
    private final String productTitles = "a.card-hover";
    private final String sortDropdown = "select.input";

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickBagsAndLuggageFilter() {
        page.locator(bagsFilterButton).click();
    }

    public List<String> getVisibleProductTitles() {

        page.waitForSelector(productTitles);

        return page.locator(productTitles).allInnerTexts();
    }

    public void sortProductsByValue(String sortValue) {
        page.selectOption(sortDropdown, sortValue);
    }
}