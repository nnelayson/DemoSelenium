package com.seleniumdemo;
import org.openqa.selenium.By;

import com.base.BasePage;

 

public class LoginPage extends BasePage {

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("#login_button_container h3");

    public void setUsername(String user) {
        set(username, user);
    }
    
    public void setPassword(String pass) {
        set(password, pass);
    }
    public ProductsPage clickLogin() {
        click(loginButton);
        return new ProductsPage();
    }
    public ProductsPage login(String user, String pass) {
        setUsername(user);
        setPassword(pass);
        return clickLogin();
        
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }
}
