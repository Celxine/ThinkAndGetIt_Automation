package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private final String emailInput = "input[type='email']";
    private final String passwordInput = "input[type='password']";
    private final String loginButton = "button:has-text('Sign in')";
    public LoginPage(Page page) {
        this.page = page;
    }
    public void navigateTo() {
        page.navigate("https://think-and-get-it-frontend.onrender.com/login");
    }

    public void enterEmail(String email) {
        page.fill(emailInput, email);
    }

    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }

    public void clickLogin() {
        page.click(loginButton);
    }
}