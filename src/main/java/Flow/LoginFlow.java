package Flow;

import com.microsoft.playwright.Page;
import pages.LoginPage; // <-- This is the link that got broken!

public class LoginFlow {
    private Page page;
    private LoginPage loginPage;

    public LoginFlow(Page page) {
        this.page = page;
        this.loginPage = new LoginPage(page);
    }

    public void loginAsAdmin(String email, String password) {
        loginPage.navigateTo();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}