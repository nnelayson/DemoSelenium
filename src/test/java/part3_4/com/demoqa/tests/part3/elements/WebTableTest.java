package part3_4.com.demoqa.tests.part3.elements;

import org.testng.Assert;
import org.testng.annotations.Test;

import part3_4.com.demoqa.base.BaseTest;



public class WebTableTest extends BaseTest{

    @Test
    public void testWebTable() {

        String email = "kierra@example.com";
        String expectedAge = "34";

        var WebTablePage = homePage.goToElements().goToWebTables();
        WebTablePage.clickEdit(email);
        WebTablePage.setAge("34");
        WebTablePage.clickSubmit();
        String actualAge = WebTablePage.getTablePage(email);
        Assert.assertEquals(actualAge, expectedAge,
            "\n Actual & Expected Ages Do Not Match \n");

    
    }

}
