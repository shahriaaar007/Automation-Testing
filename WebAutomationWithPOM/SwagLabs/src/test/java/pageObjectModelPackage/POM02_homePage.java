package pageObjectModelPackage;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.CommonMethods;

public class POM02_homePage extends CommonMethods {
    public POM02_homePage(){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select")
    public  WebElement filterButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement sliderCrossButton;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    public WebElement aTozFilteredFirstProduct;

    @FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    public WebElement zToaFilteredFirstProduct;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    public WebElement lowToHighFilteredFirstProduct;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[1]")
    public WebElement highToLowFilteredFirstProduct;

    @Step("Purchase by filtering Name(A-Z, Z-A) and Price(High-Low, Low-High)")
    public void purchaseProductAtoZ(){
        filterButton.click();
        selectitem(filterButton, "az");
        aTozFilteredFirstProduct.click();
    }
    public void purchaseProductZtoA(){
        filterButton.click();
        selectitem(filterButton, "za");
        zToaFilteredFirstProduct.click();
    }

    public void purchaseProductLowtoHigh(){
        filterButton.click();
        selectitem(filterButton, "lohi");
        lowToHighFilteredFirstProduct.click();
    }
    public void purchaseProductHightoLow(){
        filterButton.click();
        selectitem(filterButton, "hilo");
        highToLowFilteredFirstProduct.click();
    }

    @Step("Perform logout")
    public void logout(){
        menuButton.click();
        logoutButton.click();
    }
}
