package clark.qa.testcases;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WebstaurantHomePage;
import util.TestUtil;

public class LoginPageTest extends TestBase {
    TestUtil testUtil;
    HomePage homePage;
    WebstaurantHomePage webstaurantHomePage;
    String sheetName = "data";


    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
         testUtil=new TestUtil();
        homePage=new HomePage();
        webstaurantHomePage=new WebstaurantHomePage();
        webstaurantHomePage=homePage.clickOnDistribution();


    }
    @DataProvider
    public Object[][] getData() {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;


    }
    @Test(dataProvider ="getData")
    public void validateUserCanEnterCredentials(String email,String password){
        TestUtil.switchToWindows();
        webstaurantHomePage.clickOnLoginButton();
        webstaurantHomePage.enteringCredentials(email,password);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
