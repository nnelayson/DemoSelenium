package part1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Optional but helpful
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // Proper cleanup
    }

    @Test
    public void testLoggingIntoApplication() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.tagName("button")).click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h6")));
        Assert.assertEquals(dashboardHeader.getText(), "Dashboard");

        WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p.oxd-userdropdown-name")));
        profileIcon.click();

        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed after login");
        logoutButton.click();

        wait.until(ExpectedConditions.urlContains("auth/login"));

        Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed(), "Username field is not displayed after logout.");
        Assert.assertTrue(driver.findElement(By.name("password")).isDisplayed(), "Password field is not displayed after logout.");
        System.out.println("User logged out successfully and redirected to the login page.");
    }
}
