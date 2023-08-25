package pageObjectModelPackage;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.CommonMethods;

public class POM03_cartPage extends CommonMethods {
    public POM03_cartPage(){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }
// Cart button
    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;
// check out button
    @FindBy(id = "checkout")
    public WebElement checkoutButton;
// Checkout information
    @FindBy(id = "first-name")  //First name
    public WebElement checkoutFirstNameTextField;

    @FindBy(id = "last-name")   //Last name
    public WebElement checkoutLastNameTextField;

    @FindBy(id = "postal-code") //Zip/Postal Code
    public WebElement checkoutZipCodeTextField;

    @FindBy(id = "continue")    //Continue Button
    public WebElement checkoutPageContinueButton;
// overview finish button
    @FindBy(id = "finish")
    public WebElement overviewPageFinishButton;

// Back to home/All product button
    @FindBy(id = "back-to-products")
    public WebElement backToHomePage;

    @Step("Click the cart button to checkout all selected product")
    public void clickCart(){
        cartButton.click();
    }
    @Step("Click checkout button for the next step")
    public void clickCheckout(){
        scrollToElement(checkoutButton);
        checkoutButton.click();
    }
    @Step("Fill information to shipping product")
    public void clickCheckoutInfoForm(String fName, String lName, String zipCode){
        sendText(checkoutFirstNameTextField, fName);
        sendText(checkoutLastNameTextField, lName);
        sendText(checkoutZipCodeTextField, zipCode);
        checkoutPageContinueButton.click();
    }
    @Step("Overview the product and click the finish button")
    public void clickFinishButton(){
        overviewPageFinishButton.click();
    }
    @Step("Go back to the home page and see the all product")
    public void clickBackHome(){
        backToHomePage.click();
    }

}
