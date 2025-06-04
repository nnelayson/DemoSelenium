package part3_4.com.demoqa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.demoqa.pages.HomePage;
import com.seleniumdemo.BasePage;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    
    private WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;

    private String DEMOQA_URL = "https://demoqa.com";

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void LoadApplication() {
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver(); 
        homePage = new HomePage();
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
        // Close the browser after the test
      driver.quit();
        
    }


}
