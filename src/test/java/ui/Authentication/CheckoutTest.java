package ui.Authentication;

import Flow.CartFlow;
import org.junit.jupiter.api.Test;
import ConfigProperties.Config;
import ui.UiBaseTest;

import ConfigProperties.Endpoints;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CheckoutTest extends UiBaseTest {

    @Test
    public void testCartTotalCalculationBug() {
        CartFlow cartFlow = new CartFlow(page);


        page.navigate(Config.UI_BASE_URL + Endpoints.UI_HOME);
        page.waitForLoadState();
        page.waitForTimeout(3000);

        String totalText = cartFlow.addItemAndGetTotal();
        System.out.println("Cart Total is displaying as: " + totalText);

        assertNotEquals("$0.00", totalText.trim(), "CRITICAL BUG: Cart total is calculating as $0.00!");
    }
}