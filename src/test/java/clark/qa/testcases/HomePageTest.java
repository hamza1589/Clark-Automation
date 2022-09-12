package clark.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase {
    HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage=new HomePage();

    }
    @Test(priority = 0)
    public void validateTitleHomePage(){
        String title=homePage.validateTitle();
        Assert.assertEquals(title,"Clark Associates Inc.");

    }
    @Test(priority = 1)
    public void validateClarkLogoHomePage(){
        boolean flag=homePage.validateClarkLogo();
        Assert.assertTrue(flag);
    }
    @Test(priority = 2)
    public void validateUserIsAbleToClickOnDistributionTab(){
        homePage.clickOnDistribution();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
