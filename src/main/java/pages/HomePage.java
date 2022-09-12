package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(css=".nav-logo")
    WebElement clarkLogo;

    @FindBy(css="#headlessui-menu-button-2")
    WebElement distributionTab;

    @FindBy(css="#headlessui-menu-item-12")
    WebElement webstauantStoreTab;

    @FindBy(xpath = "//div[@class='w-full text-center pt-32 pb-10 lg:py-24 px-5']/a[1]")
    WebElement webstauantStoreLink;


    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String validateTitle(){
        return driver.getTitle();
    }

    public boolean validateClarkLogo(){
        return clarkLogo.isDisplayed();
    }

    public WebstaurantHomePage clickOnDistribution(){
        distributionTab.click();
        webstauantStoreTab.click();
        webstauantStoreLink.click();
        return  new WebstaurantHomePage();

    }




}
