package part2.test.Products;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.seleniumdemo.ProductsPage;

import part2.base.BaseTest;
public class ProductsTest extends BaseTest{
    @Test
    public void testProductsHeaderIsDisplayed() {
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isProductsHeaderDisplayed(),
            "\n Products Header Is Not Displayed \n");
    }
    
}
