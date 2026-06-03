package pages;

import com.microsoft.playwright.Page;

public class CartPage {
    private Page page;
    private final String addToCartButton = "button:has-text('Add to cart')";
     private final String cartTotalText = "div:has-text('Total') >> nth=-1";

    public CartPage(Page page) {
        this.page = page;
    }

    public void clickAddToCart() {
        page.click(addToCartButton);
    }

    public String getCartTotal() {
        return page.innerText(cartTotalText);
    }
}