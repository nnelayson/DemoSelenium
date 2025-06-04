package part2.test.Login;

import org.testng.Assert;
import org.testng.annotations.Test;

import part2.base.BaseTest;


public class LoginTest extends BaseTest {

    
    @Test
    public void testLoginErrorMessage()  {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("xyz3400");
        loginPage.clickLogin();
        // Wait for the error message to appear
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface:"));
        Assert.assertTrue(actualMessage.contains("Username and password do not match any user in this service"));
        Assert.assertTrue(actualMessage.contains("Please try again."));
        Assert.assertTrue(actualMessage.contains("Username and password do not match any user in this service"));
        Assert.assertTrue(actualMessage.contains("Please try again."), "Error message is not displayed as expected.");  

    }
    @Test
    public void testLoginWithValidCredentials() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("inventory.html"), "Login failed, URL does not contain 'inventory.html'");

    
    }
    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("wrong_password");
        loginPage.clickLogin();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface:"));
        Assert.assertTrue(actualMessage.contains("Username and password do not match any user in this service"));
        Assert.assertTrue(actualMessage.contains("Please try again."), "Error message is not displayed as expected.");
    }
    @Test
    public void testLoginWithEmptyCredentials() {
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickLogin();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface:"));
        Assert.assertTrue(actualMessage.contains("Username is required"));
        Assert.assertTrue(actualMessage.contains("Password is required"), "Error message is not displayed as expected.");
    }
    @Test
    public void testLoginWithEmptyUsername() {
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface:"));
        Assert.assertTrue(actualMessage.contains("Username is required"), "Error message for empty username is not displayed as expected.");
    }
    @Test
    public void testLoginWithEmptyPassword() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLogin();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface:"));
        Assert.assertTrue(actualMessage.contains("Password is required"), "Error message for empty password is not displayed as expected.");
    }
    @Test
    public void testLoginWithLockedOutUser() {
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface:"));
        Assert.assertTrue(actualMessage.contains("Sorry, this user has been locked out."), "Error message for locked out user is not displayed as expected.");
    }
    @Test
    public void testLoginWithProblemUser() {
        loginPage.setUsername("problem_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("inventory.html"), "Login failed for problem user, URL does not contain 'inventory.html'");
        
    }
    
}
