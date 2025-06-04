package part1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to EdgeDriver
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jayson\\FirstDemo\\main\\drivers\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
      //  driver.quit();
        
        }
    

    @Test
   public void testLoggingIntoApplication() throws InterruptedException {
    Thread.sleep(2000);
    WebElement username = driver.findElement(By.name("username"));
    username.sendKeys("Admin");

    var password = driver.findElement(By.name("password"));
    password.sendKeys("admin123");

    driver.findElement(By.tagName("button")).click();
    Thread.sleep(2000);
    String actualResult = driver.findElement(By.tagName("h6")).getText();
    String expectedResult = "Dashboard";
    Assert.assertEquals(actualResult, expectedResult);

    // Click the user dropdown/profile icon
WebElement profileIcon = driver.findElement(By.cssSelector("p.oxd-userdropdown-name"));
profileIcon.click();
Thread.sleep(1000); // Small wait to let dropdown appear

// Now locate and click the logout link
WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed after login");
logoutButton.click();
Thread.sleep(2000);

// Verify that the user is logged out by checking the login page title or URL
    String currentUrl = driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("auth/login"), "User is not logged out, still on the dashboard page.");
    String pageTitle = driver.getTitle();
    Assert.assertEquals(pageTitle, "OrangeHRM", "Page title is not as expected after logout.");
    Assert.assertTrue(driver.findElement(By.name("username")).isDisplayed(), "Username field is not displayed after logout.");
    Assert.assertTrue(driver.findElement(By.name("password")).isDisplayed(), "Password field is not displayed after logout.");
    System.out.println("User logged out successfully and redirected to the login page.");       

        

    

    


    }
}

