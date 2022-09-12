package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;

import java.util.List;

public class WebstaurantHomePage extends TestBase {

    @FindBy(xpath="//div[@class='awesomplete']/input")
    WebElement searchBar;

    @FindBy(xpath = "//button[@value='Search']")
    WebElement searchBarButton;

    @FindBy(xpath = "//span[contains(text(),'Free Shipping & Net 30!')]")
    WebElement freeShippingLink;

    @FindBy(xpath = "//span[@class='whitespace-nowrap bg-white py-0 px-1 absolute text-gray-800']/span[text()='178ubb72shc']")
    WebElement orderNumber;

    @FindBy(xpath="//span[text()='Login to your']")
    WebElement loginButton;

    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="the_login_button")
    WebElement submitButton;

    public WebstaurantHomePage() {
        PageFactory.initElements(driver, this);
    }


//    public void getItems() {
//        List<WebElement> list = driver.findElements(By.id("ProductBoxContainer"));
//        int listCount = list.size();
//        for (int i = 1; i <= listCount; i++) {
//            String textItems = list.get(i).getText();
//            System.out.println(textItems);
//        }
//
//
//    }

    public void clickOnSearchBar() {
        TestUtil.switchToWindows();
        searchBar.click();
        searchBar.sendKeys("drink cooler");
        searchBarButton.click();
        TestUtil.scroll();

    }

    public void selectItem() {
        List<WebElement> list = driver.findElements(By.xpath("//input[@value='Add to Cart']"));
        List<WebElement> listOrders = driver.findElements(By.xpath("//span[@class='whitespace-nowrap bg-white py-0 px-1 absolute text-gray-800']"));

        int listCount = list.size();
        for (int i = 1; i <= listCount; i++) {
            String orderNumber=listOrders.get(i).getText();
            if(orderNumber.equalsIgnoreCase("#178HBB95HC")){
                list.get(i).click();
                break;
            }

        }


    }

    public LoginPage clickOnLoginButton(){
        loginButton.click();
        return new LoginPage();
    }
    public void enteringCredentials(String eml,String pass){
        emailField.sendKeys(eml);
        passwordField.sendKeys(pass);
        submitButton.click();
    }

}
