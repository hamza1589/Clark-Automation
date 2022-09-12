package clark.qa.testcases;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WebstaurantHomePage;

public class WebStaurantHomePageTest extends TestBase {
    HomePage homePage;
    WebstaurantHomePage webstaurantHomePage;

    public WebStaurantHomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        webstaurantHomePage = new WebstaurantHomePage();
        webstaurantHomePage = homePage.clickOnDistribution();


    }

    @Test(priority = 1)
    public void getListOfAllItems() {
        webstaurantHomePage.clickOnSearchBar();
        webstaurantHomePage.selectItem();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
