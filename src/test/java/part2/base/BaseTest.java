package part2.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.base.BasePage;
import com.seleniumdemo.LoginPage;


public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected String Url = "https://www.saucedemo.com/";
    
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jayson\\FirstDemo\\main\\drivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(Url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();

        
       
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
