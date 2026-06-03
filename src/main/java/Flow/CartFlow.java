package Flow;

import com.microsoft.playwright.Page;
import pages.CartPage;

public class CartFlow {
    private Page page;
    private CartPage cartPage;

    public CartFlow(Page page) {
        this.page = page;
        this.cartPage = new CartPage(page);
    }


    public String addItemAndGetTotal() {
        cartPage.clickAddToCart();
        page.waitForTimeout(2000);
        return cartPage.getCartTotal();
    }
}